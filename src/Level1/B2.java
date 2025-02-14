package Level1;

import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Chuỗi vừa nhập là: " + str+ " có độ dài là: " + str.length());
    }
}
