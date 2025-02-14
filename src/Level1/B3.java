package Level1;

import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        System.out.println("Nhập vào 1 số:");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        System.out.println("Bình phương của số vừa nhập là: " + Math.pow(a, 2));
    }
}
