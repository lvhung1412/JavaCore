package Level4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B7 {
    public static int getNumberCharacter(String s){
        HashSet<Character> setCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                setCharacters.add(c);
            }
        }
        return setCharacters.size();
    }
    public static void main(String[] args) {
        System.out.println("Nhập vào số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] arrStrings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào chuỗi thứ " + (i + 1) + ": ");
            arrStrings[i] = sc.nextLine();
        }

        Arrays.sort(arrStrings, (s1, s2) -> {
            int count1 = getNumberCharacter(s1);
            int count2 = getNumberCharacter(s2);

            if (count1 != count2) {
                return Integer.compare(count2, count1); 
            }
            return s1.compareTo(s2);
        });

        for(String s: arrStrings){
            System.out.println(s+" ");
        }
        
    }
}
