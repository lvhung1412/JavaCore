package Level1;

import java.util.Scanner;

public class B7 {
    public static void main(String[] args) {
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }

        for(int i = 0; i < n-1 ;i++){
            for(int j = i+1; j < n; j++){
                if(arr[i].compareTo(arr[j]) > 0){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Mảng sau khi sắp xếp tăng dần: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
