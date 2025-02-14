package Level2;

import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {
        System.out.println("Nhập số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0 && arr[i] % 5 == 0){
                sum += arr[i];
            }
        }
        System.out.println("Tổng các phần tử chia hết cho 3 và 5 là: " + sum);
    }
}
