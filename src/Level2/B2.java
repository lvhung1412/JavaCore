package Level2;

import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + ": ");
            arr[i] = sc.nextLine();
        }
        String longestWord = "";
        String[] word;
        for (int i = 0; i < n; i++) {
            word = arr[i].split(" ");
            for (int j = 0; j < word.length; j++) {
                if (word[j].length() > longestWord.length()) {
                    longestWord = word[j];
                }
            }
        }
        System.out.println("Từ dài nhất trong mảng là: " + longestWord);
    }
}
