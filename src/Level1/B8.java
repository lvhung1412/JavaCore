package Level1;

import java.util.Scanner;

public class B8 {
    public static void main(String[] args) {
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
        }

        for(int i = 0; i < n-1 ;i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Trung vị của mảng đã nhập là: ");
        if(n % 2 == 0) {
            System.out.println((arr[n/2] + arr[n/2 - 1]) / 2);
        } else {
            System.out.println(arr[n/2]);
        }
    }
}
