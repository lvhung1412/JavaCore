package CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BT4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử: ");
        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for(int i =0; i< n; i++){
            System.out.print("Nhập phần tử thứ "+ i+" : ");
            numbers.add(sc.nextInt());
        }

        System.out.println("Danh sách ban đầu là: ");
        numbers.forEach(s -> {System.out.print(s+" ");});

        Collections.sort(numbers);
        System.out.println("\nDanh sách tăng dần là: ");
        numbers.forEach(s -> {System.out.print(s+" ");});

        Collections.sort(numbers, Comparator.comparingInt(Integer:: intValue).reversed());
        System.out.println("\nDanh sách giảm dần là: ");
        numbers.forEach(s -> {System.out.print(s+" ");});
        
    }
}
