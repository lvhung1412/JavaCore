package Level4;

import java.util.Scanner;

public class B3 {
    public static String maxCommStr(String s1, String s2){
        String longestSubstring  = "";
        int m = s1.length();
        int n = s2.length();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                String temp = "";
                int x = i;
                int y = j;

                while (x < m && y < n && s1.charAt(x) == s2.charAt(y)) {
                    temp+=s1.charAt(x);
                    x++;
                    y++;
                }

                if (temp.length() > longestSubstring.length()) {
                    longestSubstring = temp.toString();
                }
            }
        }
        return longestSubstring;
    }
    public static void main(String[] args) {
        System.out.println("Nhập vào số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i< n; i++){
            System.out.println("Nhập chuỗi thứ "+ i +": ");
            arr[i] = sc.nextLine();
        }

        String s = arr[0];
        String result = "";
        for(int i = 0; i< n ;i++){
            result = maxCommStr(s, arr[i]);
            s = result;
        }
        System.out.println(result.length());
    }
}
