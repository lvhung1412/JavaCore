package oop;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HTLComputer\\OneDrive - University of transport and Communication\\Tài liệu\\BangCong.xlsx";
        ExcelReader excelReader = new ExcelReader();
        Workbook workbook = excelReader.openFile(filePath);
        List<Employee> employees = excelReader.readEmployeesFromExcel(workbook);
        DecimalFormat df = new DecimalFormat("#.##");

        for (Employee employee : employees) {
            employee.printWorkDetails();
            System.out.println("Tổng tiền của nhân viên là: "+df.format(employee.getTotalSalary())+" so với trong file là: "+ df.format(excelReader.getTongLuong(workbook).get(employee.getEmployeeId())));
        }
    }
}
