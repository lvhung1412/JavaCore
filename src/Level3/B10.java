package Level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B10 {
    public static int getNumberOfDistinctCharacter(String s){
        Set<Character> set = new HashSet<>();
        for(int i =0; i< s.length(); i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println("Nhập số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = new String[n];

        System.out.println("Nhập các chuỗi:");
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }

        Arrays.sort(s, (str1, str2) -> {
            int distinct1 = getNumberOfDistinctCharacter(str1);
            int distinct2 = getNumberOfDistinctCharacter(str2);
            if (distinct1 != distinct2) {
                return Integer.compare(distinct1, distinct2);
            }
            if (str1.length() != str2.length()){
                return Integer.compare(str2.length(), str1.length());
            }
            return str1.compareTo(str2);
        });

        System.out.println("Danh sách sau khi sắp xếp:");
        System.out.println(Arrays.toString(s));
    }
}
