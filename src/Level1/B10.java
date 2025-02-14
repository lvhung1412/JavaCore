package Level1;

import java.util.Scanner;

public class B10 {
    public static void main(String[] args) {
        System.out.println("Nhập vào số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập vào chuỗi thứ " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i].contains("a")){
                count++;
            }
        }
        System.out.println("Số lượng chuỗi có chứa ký tự 'a': " + count);
    }
}
