package Level1;

import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        System.out.println("Nhập vào số lượng chuỗi của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập chuỗi thứ " + i + ": ");
            arr[i] = sc.nextLine();
        }
        String minString = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i].length() < minString.length()) {
                minString = arr[i];
            }
        }
        System.out.println("Chuỗi có độ dài nhỏ nhất trong mảng là: " + minString);
    }
}
