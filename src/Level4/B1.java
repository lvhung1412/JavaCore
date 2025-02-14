package Level4;

import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        System.out.println("Nhập số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = 0; i< n-1; i++){
            for(int j = 0; j< n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;
                }
            }
        }
        System.out.println("Số bước cần để sắp xếp là: "+ count);
    }
}
