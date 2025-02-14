package CollectionFrameWork;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BT2 {
    public static void main(String[] args) {
        Set<String> nameOfNation = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng tên các quốc gia: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên các quốc gia.");
        for(int i =0; i < n; i++){
            System.out.println("Nhập tên quốc gia thứ "+ i +" : ");
            nameOfNation.add(sc.nextLine());
        }

        System.out.println("Danh sách tên các quốc gia đã thêm vào là: ");
        for(String s: nameOfNation){
            System.out.print(s+ "\t");
        }

        System.out.println("Nhập tên quốc gia muốn kiểm tra: ");
        String nameCheck = sc.nextLine();
        if(nameOfNation.contains(nameCheck)){
            System.out.println(nameCheck+" có tồn tại trong danh sách");
        } else{
            System.out.println("Không tồn tại tên "+ nameCheck +" trong danh sách");
        }     
        
        System.out.println("\nNhập tên quốc gia muốn xóa: ");
        String nameDel = sc.nextLine();
        if(nameOfNation.remove(nameDel)){
            System.out.println("Đã xóa "+ nameDel+" thành công");
        } else{
            System.out.println("Không tồn tại tên "+ nameDel+" trong danh sách");
        }

        System.out.println("Số lượng các quốc gia có trong HashSet là "+ nameOfNation.size());

    }
}
