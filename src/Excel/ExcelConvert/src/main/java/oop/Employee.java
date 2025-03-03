package oop;

import java.text.DecimalFormat;
import java.util.*;

public class Employee {
    private String employeeId;
    private String employeeName;
    private List<WorkDay> workDays;
    private double totalSalary;

    // Constructor
    public Employee(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.workDays = new ArrayList<>();
        this.totalSalary = 0.0;
    }

    // Getter và Setter
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<WorkDay> getWorkDays() {
        return workDays;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setWorkDay(ArrayList<WorkDay> days){
        this.workDays = days;
    }

    // Thêm một ngày làm việc
    public void addWorkDay(WorkDay workDay) {
        workDays.add(workDay);
    }

    // Tính toán tổng lương
    public void calculateSalary() {
        totalSalary = 0.0;
        for (WorkDay workDay : workDays) {
            for (HashMap.Entry<WorkShift, Double> entry : workDay.getWorkShifts().entrySet()) {
                WorkShift shift = entry.getKey();
                double hours = entry.getValue();
                totalSalary += shift.getSalary() * hours;
            }
        }
    }

    public void printWorkDetails() {
        DecimalFormat df = new DecimalFormat("#");
        System.out.println("\n==================================================================================================");
        System.out.printf("Employee: %s - %s%n", employeeId, employeeName);
        System.out.println("==========================================================");
    
        double totalTimeWorkingInMonth = 0.0;
        double totalSalaryInMonth = 0.0;
        boolean hasWorkedInAnyDay = false;
    
        // Header của bảng
        System.out.printf("%-17s | %-50s | %-10s | %-12s%n", "Date", "Shifts", "Hours", "Total (VND)");
        System.out.println("--------------------------------------------------------------------");
    
        for (WorkDay workDay : workDays) {
            double totalTimeInDay = 0.0;
            double totalMoneyInDay = 0.0;
            boolean hasWorked = false;
            String formattedDate = workDay.getDate(); // Ngày làm việc
           // System.out.println(formattedDate);
    
            // Danh sách lưu các ca làm việc trong ngày
            List<String> shiftsInDay = new ArrayList<>();
    
            for (Map.Entry<WorkShift, Double> entry : workDay.getWorkShifts().entrySet()) {
                WorkShift shift = entry.getKey();
                double hours = entry.getValue();
    
                if (hours > 0) {
                    hasWorked = true;
                    totalTimeInDay += hours;
                    totalTimeWorkingInMonth += hours;
    
                    double moneyEarned = shift.getSalary() * hours;
                    totalMoneyInDay += moneyEarned;
                    totalSalaryInMonth += moneyEarned;
    
                    // Thêm tên ca + số giờ vào danh sách
                    shiftsInDay.add(shift.getShiftName() + " (" + hours + "h)");
                }
            }
    
            if (hasWorked) {
                hasWorkedInAnyDay = true;
                // In ra thông tin gộp chung trong ngày
                System.out.printf("%-17s | %-50s | %-10.1f | %-12s%n",
                        formattedDate, String.join(", ", shiftsInDay), totalTimeInDay, df.format(totalMoneyInDay));
            }
        }
    
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-70s | %-10.1f | %-12s%n", "TOTAL", totalTimeWorkingInMonth, df.format(totalSalaryInMonth));
        System.out.println("==========================================================\n");

        if (!hasWorkedInAnyDay) {
            System.out.println("    No work days for this employee.");
        }
    }
    

}
