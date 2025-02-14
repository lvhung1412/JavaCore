package Level4;

import java.util.Arrays;
import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.println("Nhập phần tử thứ "+ i +" : ");
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println("Tích 3 phần tử bất kỳ lớn nhất là: "+ Math.max(arr[n - 1] * arr[n - 2] * arr[n - 3], 
        arr[0] * arr[1] * arr[n - 1]));
    }
}
