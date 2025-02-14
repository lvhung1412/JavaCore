package CollectionFrameWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BT7 {
    public static void main(String[] args) {
        Map<String, List<Double>> listStudent = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên sinh viên " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("Nhập số lượng điểm của " + name + ": ");
            int numScores = sc.nextInt();
            
            List<Double> scores = new ArrayList<>();
            System.out.println("Nhập " + numScores + " điểm:");
            for (int j = 0; j < numScores; j++) {
                scores.add(sc.nextDouble());
            }
            sc.nextLine();

            listStudent.put(name, scores);
        }

        for(Map.Entry<String, List<Double>> entry : listStudent.entrySet()){
            List<Double> scores = entry.getValue();
            Double sumScore = 0.0;
            for(Double score : scores){
                sumScore+= score;
            }
            System.out.println("Sinh viên "+ entry.getKey()+" có điểm trung bình là: "+ sumScore/scores.size());
        }
    
    
    }
}
