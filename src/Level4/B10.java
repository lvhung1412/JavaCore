package Level4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B10 {
    public static int getOverlap(String s1, String s2, int k) {
        int maxOverlap = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        
        for (int i = 0; i <= len1 - k; i++) {
            for (int j = 0; j <= len2 - k; j++) {
                int count = 0;
                while (i + count < len1 && j + count < len2 && s1.charAt(i + count) == s2.charAt(j + count)) {
                    count++;
                    if (count >= k) {
                        maxOverlap = Math.max(maxOverlap, count);
                    }
                }
            }
        }
        return maxOverlap;
    }

    public static String[] findLargestOverlapPair(List<String> strings, int k) {
        int maxOverlap = 0;
        String str1 = "", str2 = "";
        
        // duyệt từng cặp chuỗi trong danh sách
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                int overlap = getOverlap(strings.get(i), strings.get(j), k);
                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    str1 = strings.get(i);
                    str2 = strings.get(j);
                }
            }
        }
        return new String[]{str1, str2};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng chuỗi: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập chuỗi thứ " + (i + 1) + ": ");
            strings.add(scanner.nextLine());
        }
        
        System.out.print("Nhập vào số lượng ký tự tối thiểu k: ");
        int k = scanner.nextInt();
        
        String[] result = findLargestOverlapPair(strings, k);
        
        if (!result[0].isEmpty() && !result[1].isEmpty()) {
            System.out.println("Hai chuỗi có phần giao nhau dài nhất: " + result[0] + " và " + result[1]);
        } else {
            System.out.println("Không có cặp chuỗi nào có phần giao nhau dài ít nhất " + k + " ký tự.");
        }
    }
}
