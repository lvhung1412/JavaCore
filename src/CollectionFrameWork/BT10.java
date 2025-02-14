package CollectionFrameWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BT10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();

        List<Double> scores = new ArrayList<>();
        HashMap<Double, Integer> scoreCount = new HashMap<>();

        System.out.println("Nhập điểm số của từng sinh viên:");
        for (int i = 0; i < n; i++) {
            System.out.print("Sinh viên " + (i + 1) + ": ");
            double score = scanner.nextDouble();
            scores.add(score);
            scoreCount.put(score, scoreCount.getOrDefault(score, 0) + 1);
        }

        int countHigh = 0, countMedium = 0, countFail = 0;
        for (double score : scores) {
            if (score >= 8.0) countHigh++;
            else if (score >= 5.0) countMedium++;
            else countFail++;
        }

        // Hiển thị kết quả
        System.out.println("\nPhân phối điểm số:");
        for (Map.Entry<Double, Integer> entry : scoreCount.entrySet()) {
            System.out.println("Điểm " + entry.getKey() + ": " + entry.getValue() + " sinh viên");
        }

        System.out.println("\nThống kê:");
        System.out.println("Số lượng sinh viên giỏi (>= 8.0): " + countHigh);
        System.out.println("Số lượng sinh viên trung bình (5.0 - 7.9): " + countMedium);
        System.out.println("Số lượng sinh viên trượt (< 5.0): " + countFail);
    }
}
