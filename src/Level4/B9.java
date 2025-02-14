package Level4;

import java.util.Scanner;

public class B9 {
    public static int getLongestIncreasingSubOfNumbers(int[] arr){
        int count = 1;
        int maxCount = 1;
        for(int  i =1; i< arr.length; i++){
            if(arr[i] - arr[i-1] == 1){
                count++;
            } else{
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }
    public static void main(String[] args) {
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            System.out.println("Nhập vào phần tử thứ "+ i +" : ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Mảng con tăng 1 dài nhất là: " + getLongestIncreasingSubOfNumbers(arr));
    }
}
