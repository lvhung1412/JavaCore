package Level1;

import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextDouble();
        }

        double max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng là: " + max);

    }
}
