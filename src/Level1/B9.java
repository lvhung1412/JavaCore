package Level1;

import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        System.out.println("Nhập vào chuỗi s: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        System.out.println("Số lượng từ trong chuỗi: " + arr.length);
    }
}
