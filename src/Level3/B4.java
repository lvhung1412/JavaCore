package Level3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B4 {
    public static int maxOverlap(String s, String t){
        List<Character> s1 = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> t1 = t.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        int count = 0;
        for(int i =0 ; i < s1.size(); i++){
            for(int j = 0; j < t1.size(); j++){
                //System.out.println(s1.get(i) + " " + t1.get(j));
                if(s1.get(i).equals(t1.get(j)) && s1.get(i) != ' '){
                    s1.set(i, ' ');
                    t1.set(j, ' ');
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Nhập số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập chuỗi thứ " + (i + 1) + ": ");
            arr[i] = sc.next();
        }
        int max = -1;
        int index1 = 0, index2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(max < maxOverlap(arr[i], arr[j])){
                    max = maxOverlap(arr[i], arr[j]);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println("Hai chuỗi trùng lặp nhiều nhất là: " + arr[index1] + " và " + arr[index2]);
    }
}
