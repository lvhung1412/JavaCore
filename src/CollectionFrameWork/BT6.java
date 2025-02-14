package CollectionFrameWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BT6 {
    public static int maxProfit(List<Integer> prices) {
        int buy = prices.get(0);
        int profit = 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < buy) {
                buy = prices.get(i);
            } else if (prices.get(i) - buy > profit) {
                profit = prices.get(i) - buy;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        List<Integer> prices = new ArrayList<>();
        for(int i =0; i< n; i++){
            System.out.println("Nhập giá ngày thứ "+ (i+1)+ " : ");
            prices.add(sc.nextInt());
        }

        System.out.println("Max profit: "+ maxProfit(prices));
    }
}
