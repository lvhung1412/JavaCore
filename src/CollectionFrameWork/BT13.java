package CollectionFrameWork;

import java.util.HashSet;
import java.util.Scanner;

public class BT13 {
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> numbers = new HashSet<>();
        for(int i =0; i< n; i++){
            System.out.println("Nhập vào phần tử thứ "+ (i+1) + " : ");
            arr[i] = sc.nextInt();
            numbers.add(arr[i]);
        }
    }
}
