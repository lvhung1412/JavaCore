package CollectionFrameWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BT8 {
    public static void main(String[] args) {
        Map<String, String> listProduct = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng sản phẩm: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i< n; i++){
            System.out.println("Sản phẩm thứ "+ i);
            System.out.println("Nhập mã sản phẩm: ");
            String id = sc.nextLine();
            System.out.println("Nhập thông tin sản phẩm: ");
            String information = sc.nextLine();
            listProduct.put(id, information);
        }

        System.out.println("Danh sách sản phẩm");
        for(Map.Entry<String,String> entry : listProduct.entrySet()){
            System.out.println("Id: "+ entry.getKey()+"\t"+ entry.getValue());
        }

        System.out.println("Nhập mã sản phẩm muốn tìm: ");
        String idFind = sc.nextLine();
        String resultInfor = listProduct.getOrDefault(idFind, null);
        if(resultInfor != null){
            System.out.println("Thông tin sản phẩm có mã "+ idFind +" là: " +resultInfor);
        } else{
            System.out.println("Không có sản phẩm có mã "+ idFind);
        }

        System.out.println("Nhập mã sản phẩm muốn xóa: ");
        String idDelete = sc.nextLine();
        String resultInforDelete = listProduct.getOrDefault(idFind, null);
        if(resultInfor != null){
            listProduct.remove(idDelete);
            System.out.println("Đã xóa sản phẩm có mã "+ idFind);
        } else{
            System.out.println("Không có sản phẩm có mã "+ idFind);
        }

        System.out.println("Nhập thông tin sản phẩm muốn cập nhật.");
        System.out.println("Nhập mã sản phẩm: ");
        String idUpdate = sc.nextLine();
        System.out.println("Nhập thông tin mới: ");
        String inforUpdate = sc.nextLine();
        String resultUpdate = listProduct.replace(idUpdate, inforUpdate);
        if(resultUpdate == null){
            System.out.println("Không có sản phẩm có mã là "+ idUpdate);
        } else{
            System.out.println("Đã cập nhật thông tin thành công");
        }
    }
}
