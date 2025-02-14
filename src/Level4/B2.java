package Level4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2 {
    public static int countDistinctSubsequences(int[] arr, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1); // với target = 0 => 1 cách là không chọn
        for(int i: arr){
            // tạo bản sao của dp
            Map<Integer, Integer> newDp = new HashMap<>(dp);
            // duyệt qua các phần tử đã có trong dp
            for(Map.Entry<Integer, Integer> entry : dp.entrySet()){
                // tổng hiện tại
                int currentSum = entry.getKey();
                // số cách tạo ra tổng hiện tại
                int count = entry.getValue();
                // tổng mới
                int newSum = currentSum + i;

                System.out.println(currentSum + " - "+ count+ " - "+ newSum);
                // nếu sum không vượt quá target, cập nhật số cách tạo ra newSum vào newDp
                if(newSum <= target){
                    newDp.put(newSum, newDp.getOrDefault(newSum, 0) + count);
                }
            }
            System.out.println();
            // cập nhật lại dp
            dp = newDp;
        }
        // nếu có target trong dp thì trả về value, không thì trả về 0
        return dp.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        System.out.println("Nhập số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Nhập target value: ");
        int target = sc.nextInt();

        System.out.println("Số cặp phần tử có tổng bằng target là: "+ countDistinctSubsequences(arr, target));
    }
}
