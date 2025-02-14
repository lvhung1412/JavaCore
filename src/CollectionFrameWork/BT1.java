package CollectionFrameWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Nhập vào số lượng phần tử của array list: ");
        int n = sc.nextInt();
        for(int i =0; i< n; i++){
            numbers.add(sc.nextInt());
        }

        System.out.println("Nhập phần tử muốn thêm: ");
        int addNum = sc.nextInt();
        numbers.add(addNum);

        System.out.println("Các phần tử trong list là: ");
        for(Integer num: numbers){
            System.out.print(num+" ");
        }

        int sum = 0;
        for(Integer num: numbers){
            sum+=num;
        }
        System.out.println("\nTổng các phần tử trong ArrayList là: "+ sum);


        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Phần tử lớn nhất trong ArrayList là: " + max);
        System.out.println("Phần tử nhỏ nhất trong ArrayList là: " + min);

        System.out.println("Nhập phần tử cần xóa: ");
        int numDel = sc.nextInt();
        if(numbers.remove(Integer.valueOf(numDel))){
            System.out.println("Đã xóa phần tử "+ numDel);
        } else{
            System.out.println("Không tồn tại phần tử "+ numDel+ " trong ArrayList");
        }

        System.out.println("Nhập phần tử bạn muốn kiểm tra: ");
        int numCheck = sc.nextInt();
        System.out.println("Phần tử "+ numCheck+" tồn tại trong ArrayList: " +numbers.contains(numCheck));
    }
}
