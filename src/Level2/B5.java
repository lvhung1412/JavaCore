package Level2;

import java.util.Scanner;

public class B5 {
    public static int maxSum(int[] arr) {
        int max_so_far = arr[0];
        int curr_max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    public static void main(String[] args) {
        System.out.println("Nhập số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Tổng lớn nhất của dãy con liên tục là: " + maxSum(arr));
    }
}
