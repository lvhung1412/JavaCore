package Level3;

import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        System.out.println("Nhập vào số nguyên dương n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + ":");
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        int maxLIS = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            // xét tất cả các phần tử phía trước arr[i]: 0 -> i-1
            for (int j = 0; j < i; j++) {
                 if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        System.out.println("Độ dài dãy con tăng dài nhất là: " + maxLIS);
    }
}
