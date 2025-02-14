package Level3;

import java.util.Arrays;
import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập vào dãy số: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int smallest = 1;  // số nguyên dương nhỏ nhất
        // duyệt các phần tử trong mảng
        for(int i : arr){
            // nếu phần tử hiện tại nhỏ hơn hoặc bằng số nguyên dương nhỏ nhất
            if(i <= smallest){
                smallest += i;
            }else{
                break;
            }
        }
        System.out.println("Số nguyên dương nhỏ nhất không thể tạo thành từ các phần tử trong dãy là: " + smallest);
    }    
}
