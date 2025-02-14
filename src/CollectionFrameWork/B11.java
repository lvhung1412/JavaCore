package CollectionFrameWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B11 {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n===== TỪ ĐIỂN ĐƠN GIẢN =====");
            System.out.println("1. Thêm từ mới");
            System.out.println("2. Tra cứu từ");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập từ mới: ");
                    String word = scanner.nextLine();
                    if (dictionary.containsKey(word)) {
                        System.out.println("Từ này đã tồn tại!");
                    } else {
                        System.out.print("Nhập định nghĩa: ");
                        String definition = scanner.nextLine();
                        dictionary.put(word, definition);
                        System.out.println("Thêm thành công!");
                    }
                    break;
                    
                case 2:
                    System.out.print("Nhập từ cần tra cứu: ");
                    String searchWord = scanner.nextLine();
                    if (dictionary.containsKey(searchWord)) {
                        System.out.println("Định nghĩa: " + dictionary.get(searchWord));
                    } else {
                        System.out.println("Không tìm thấy từ này!");
                    }
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Vui lòng chọn số từ 1 đến 5!");
            }
        }
    }
}
