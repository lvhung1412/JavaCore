package oop;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelReader {
    public Workbook openFile(String filePath) {
        FileInputStream file = null;
        Workbook workbook;
        try {
            file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            return workbook;
        } catch (IOException e) {
            System.out.println("Lỗi khi mở file: " + e.getMessage());
        } finally {
            try {
                if (file != null) file.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng file: " + e.getMessage());
            }
        }
        return null;
    }

    public List<Employee> readEmployeesFromExcel(Workbook workbook) {
        if (workbook == null) {
            return Collections.emptyList();
        }

        List<Employee> employees = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0); // Đọc sheet đầu tiên
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        // Đọc thông tin ca làm việc
        List<WorkShift> workShifts = new ArrayList<>();
        List<String> nameWorkShift = new ArrayList<>();

        // Đọc tiền lương ca làm việc
        for(int rowIndex = 6 ; rowIndex <= sheet.getLastRowNum(); rowIndex++){
            workShifts = new ArrayList<>();
            Row row = sheet.getRow(rowIndex);
            String index = String.valueOf(row.getCell(1));
            if(index.trim().isEmpty()) break;
            for(int colindex = 3; colindex <= 15; colindex++){
                String valueString = getCellValue(row.getCell(colindex), evaluator);
                Double value = 0.0;
                if(!valueString.isEmpty()){
                    value = Double.parseDouble(valueString);
                }
                Row rowName = sheet.getRow(5);
                String name = String.valueOf(rowName.getCell(colindex));
                //System.out.println(name);
                if(name.isEmpty()) continue;
                if(!name.equals("$") ){
                    nameWorkShift.add(name);
                    //System.out.println(name);
                }
                else{
                    for(String s: nameWorkShift){
                        //System.out.println(s+" " + value);
                        workShifts.add(new WorkShift(s, value));
                    }
                    nameWorkShift = new ArrayList<>();
                }
            }
            String employeeId = getCellValue(row.getCell(1), evaluator);
            if (employeeId.trim().isEmpty()) break;
            Employee employee = new Employee(employeeId, getCellValue(row.getCell(2), evaluator));

            // Đọc thông tin ngày làm việc
            List<String> workDates = getWorkDates(sheet, evaluator);
            int maxCol = Math.min(row.getLastCellNum(), workDates.size() + 17);
            ArrayList<WorkDay> days = new ArrayList<>();
            LinkedHashMap<String, WorkDay> workDayMap = new LinkedHashMap<>(); 

            for (int colIndex = 17; colIndex < maxCol; colIndex++) {
                String shiftName = getCellValue(sheet.getRow(5).getCell(colIndex), evaluator);
                String hoursString = getCellValue(row.getCell(colIndex), evaluator);
                double hours = 0.0;
                
                if (!hoursString.isEmpty() && !hoursString.equals("-")) {
                    try {
                        hours = Double.parseDouble(hoursString);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi khi chuyển đổi giờ làm việc: " + hoursString);
                    }
                }

                Double salary = 0.0;
                for (WorkShift shift : workShifts) {
                    if (shift.getShiftName().equals(shiftName)) {
                        salary = shift.getSalary();
                        break;
                    }
                }

                String workDate = workDates.get(colIndex - 17);
                // Kiểm tra xem ngày đã tồn tại trong danh sách chưa
                WorkDay workDay = workDayMap.get(workDate);
                if (workDay == null) {
                    workDay = new WorkDay(workDate); // Nếu chưa có, tạo mới
                    workDayMap.put(workDate, workDay);
                }
                // Thêm ca làm việc vào ngày đó
                workDay.addWorkShift(new WorkShift(shiftName, salary), hours);
            }

            // Chuyển HashMap thành danh sách WorkDay
            days.addAll(workDayMap.values());
            employee.setWorkDay(days);
            employee.calculateSalary();
            employees.add(employee);

        }
        return employees;
    }

    private List<String> getWorkDates(Sheet sheet, FormulaEvaluator evaluator) {
        Row row = sheet.getRow(3);
        List<String> ngayCong = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>(); // Lưu số lần xuất hiện của từng ngày
    
        for (int colIndex = 17; colIndex < row.getLastCellNum(); colIndex++) {
            Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String cellValue = "";
            int colSpan = 1;
    
            // Kiểm tra xem ô có thuộc vùng gộp không
            CellRangeAddress mergedRegion = getMergedRegion(sheet, cell);
            
            if (mergedRegion != null) {
                if (mergedRegion.isInRange(cell.getRowIndex(), cell.getColumnIndex())) {
                    colSpan = mergedRegion.getLastColumn() - mergedRegion.getFirstColumn() + 1; // Số cột bị gộp
                    //  System.out.print(colSpan);
                }
                // Nếu ô thuộc vùng gộp, lấy giá trị từ ô đầu tiên của vùng gộp
                Row firstRow = sheet.getRow(mergedRegion.getFirstRow());
                Cell firstCell = firstRow.getCell(mergedRegion.getFirstColumn());
                cellValue = getCellValue(firstCell, evaluator);
                cellValue = cellValue.replaceAll("\\.0$", "");
                if(countMap.containsKey(cellValue)){
                    cellValue+=" ofNextMonth";
                    //System.out.print("cell value: "+cellValue);
                }
                countMap.put(cellValue,1);

                for(int i = 0; i< colSpan; i++){
                    ngayCong.add(cellValue);
                }
                colIndex+= colSpan - 1;
                //System.out.println(" : "+cellValue);
            } else {
                cellValue = getCellValue(cell, evaluator);
            }
        }
        return ngayCong;
    }
        

    // Phương thức kiểm tra xem ô có thuộc vùng gộp không
    private CellRangeAddress getMergedRegion(Sheet sheet, Cell cell) {
        for (CellRangeAddress mergedRegion : sheet.getMergedRegions()) {
            if (mergedRegion.isInRange(cell.getRowIndex(), cell.getColumnIndex())) {
                return mergedRegion;
            }
        }
        return null;
    }

    private static String getCellValue(Cell cell, FormulaEvaluator evaluator) {
        if (cell == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    yield dateFormat.format(date);
                }
                yield String.valueOf(cell.getNumericCellValue()); // Nếu là ngày tháng
            }
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> String.valueOf(evaluator.evaluate(cell).getNumberValue()); // Lấy giá trị thực của công thức
            case BLANK -> "";
            default -> "UNKNOWN";
        };
    }

    public LinkedHashMap<String, Double> getTongLuong(Workbook workbook){
        LinkedHashMap<String, Double> totalSalary = new LinkedHashMap<>();
        Sheet sheet = workbook.getSheetAt(0);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        for(int rowIndex = 6; rowIndex <= sheet.getLastRowNum(); rowIndex++){
            Row row = sheet.getRow(rowIndex);
            String manv = String.valueOf(row.getCell(1));
            double salary;

            if(!manv.trim().isEmpty()){
//                    DecimalFormat df = new DecimalFormat("#");
                String salaryString = getCellValue(row.getCell(16), evaluator);
                salary =  Double.parseDouble(salaryString);
                //System.out.println(df.format(salary));
                totalSalary.put(manv, salary);
            }
        }
        return totalSalary;
    }
}