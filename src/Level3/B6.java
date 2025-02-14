package Level3;

import java.util.Arrays;
import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử của mảng 1: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + " của mảng 1: ");
            arr1[i] = sc.nextInt();
        }

        System.out.println("Nhập số lượng phần tử của mảng 2: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập phần tử thứ " + i + " của mảng 2: ");
            arr2[i] = sc.nextInt();
        }

        int[] arr3 = new int[n + m];
        for(int i = 0; i < n; i++) {
            arr3[i] = arr1[i];
        }
        for(int i =n; i < n + m; i++) {
            arr3[i] = arr2[i - n];
        }
        Arrays.sort(arr3);
        System.out.println("Trung vị của mảng sau là: ");
        n = n + m;
        if(n % 2 == 0) {
            System.out.println((double)(arr3[n/2] + arr3[n/2 - 1]) / 2);
        } else {
            System.out.println(arr3[n/2]);
        }
    }
}
