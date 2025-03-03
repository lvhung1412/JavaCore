package oop;

public class WorkShift {
    private String shiftName;
    private double salary;

    // Constructor
    public WorkShift(String shiftName, double salary) {
        this.shiftName = shiftName;
        this.salary = salary;
    }

    public WorkShift(){}

    // Getter và Setter
    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}