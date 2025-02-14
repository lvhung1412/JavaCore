package CollectionFrameWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BT3 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng người: ");
        int n = sc.nextInt();
        sc.nextLine();

        String name = "";
        Integer age;
        for(int i = 0; i < n; i++){
            System.out.println("Nhập thông tin người thứ "+ i+" : ");
            System.out.println("Nhập tên: ");
            name = sc.nextLine();
            System.out.println("Nhập tuổi: ");
            age = sc.nextInt();
            sc.nextLine();
            hashMap.put(name, age);
        }

        System.out.println("Danh sách tên tất cả mọi người là: ");
        for(String nameOfPerson : hashMap.keySet()){
            System.out.print(nameOfPerson+"\t");
        }

        System.out.println("\nNhập tên người muốn tìm: ");
        String nameFind = sc.nextLine();
        int numCheck = hashMap.getOrDefault(nameFind, -1);
        if(numCheck >= 0){
            System.out.println("Người "+ nameFind+" có tuổi là: "+ numCheck);
        } else{
            System.out.println("Không có người "+ numCheck+" trong danh sách");
        }

        System.out.println("Nhập tên người muốn xóa: ");
        String nameDel = sc.nextLine();
        numCheck = hashMap.getOrDefault(nameFind, -1);
        if(numCheck >= 0){
            hashMap.remove(nameDel);
            System.out.println("Đã xóa "+ nameFind);
        } else{
            System.out.println("Không có người "+ numCheck+" trong danh sách");
        }

        System.out.println("Nhập thông tin người muốn kiểm tra");
        System.out.print("Nhập tên: ");
        String nameCheck = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        Integer ageCheck = sc.nextInt();
        numCheck = hashMap.getOrDefault(nameCheck, -1);
        if(numCheck == ageCheck){
            System.out.println("Có tồn tại người trên trong danh sách");
        }else{
            System.out.println("Không tồn tại người trên trong danh sách");
        }

    }
}
