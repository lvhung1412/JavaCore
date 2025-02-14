package Level1;

import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất: ");
        int a = sc.nextInt();
        System.out.println("Nhập số thứ hai: ");
        int b = sc.nextInt();
        System.out.println("Tổng của 2 số là: " + (a + b));
        sc.close();
    }
}
