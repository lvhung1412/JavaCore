import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionFramework {

    // bài 1
    public static void b1(){
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
        sc.close();
    }

    // bài 2
    public static void b2(){
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
        sc.close();
    }

    // bài 3
    public static void b3(){
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
        sc.close();
    }

    // bài 4
    public static void b4(){
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
        sc.close();
    }

    // bài 5
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
    public static void b5() {
        int[] result = twoSum(new int[]{2,7,11,15}, 9);
        for(int i: result){
            System.out.print(i+" ");
        }
    }

    // bài 6
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
    public static void b6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        List<Integer> prices = new ArrayList<>();
        for(int i =0; i< n; i++){
            System.out.println("Nhập giá ngày thứ "+ (i+1)+ " : ");
            prices.add(sc.nextInt());
        }

        System.out.println("Max profit: "+ maxProfit(prices));
        sc.close();
    }

    // bài 7
    public static void b7(){
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
        sc.close();
    }

    // bài 8
    public static void b8(){
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
        // String resultInforDelete = listProduct.getOrDefault(idFind, null);
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
        sc.close();
    }

    // bài 9
    public static void b9(){
        System.out.println("Nhập đoạn văn bản");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = text.split("\\s+");

        Map<String,Integer> wordCountMap = new HashMap<>();
        for(String word : words){
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nSố lần xuất hiện của từng từ:");
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        sc.close();
    }

    // bài 10
    public static void b10(){
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
        scanner.close();
    }

    // bài 11
    public static void b11(){
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

    // bài 12
    static class Product{
        public String name;
        public String id;
        public Double price;
        public Date dateOfManufacture;

        public Product(String name, String id, Double price, Date dateOfManufacture) {
            this.name = name;
            this.id = id;
            this.price = price;
            this.dateOfManufacture = dateOfManufacture;
        }

        @Override
        public String toString() {
            return "Product [name=" + name + ", id=" + id + ", price=" + price + ", dateOfManufacture="
                    + dateOfManufacture + "]";
        }
    }

    public static void sortByName(List<Product> products){
        Collections.sort(products, Comparator.comparing(p -> p.name));
    }

    public static void sortByPrice(List<Product> products){
        Collections.sort(products, Comparator.comparingDouble(p->p.price));
    }

    public static void sortByDateOfManufacture(List<Product> products){
        Collections.sort(products, Comparator.comparing(p-> p.dateOfManufacture));
    }

    public static void sortByPriceAndDateOfManufacture(List<Product> products){
        Collections.sort(products, Comparator
            .comparing((Product p) -> p.price)
            .thenComparing((Product p) -> p.dateOfManufacture));
    }

    public static void b12() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", "1", 1200.0, Date.valueOf("2000-11-11")));
        products.add(new Product("Smartphone","2", 800.0, Date.valueOf("2001-12-12")));
        products.add(new Product("Iphone","4", 900.0, Date.valueOf("2003-12-10")));
        products.add(new Product("Android","3", 1100.0, Date.valueOf("2000-09-09")));

        System.out.println("Ban đầu: ");
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Name: ");
        sortByName(products);
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Price: ");
        sortByPrice(products);
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Date: ");
        sortByDateOfManufacture(products);
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Price and Date: ");
        sortByPriceAndDateOfManufacture(products);
        for(Product product: products){
            System.out.println(product);
        }
    }

    // bài 13
    public static void b13(){
        System.out.println("Nhập số lượng phần tử n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> numbers = new HashSet<>();
        for(int i =0; i< n; i++){
            System.out.println("Nhập vào phần tử thứ "+ (i+1) + " : ");
            arr[i] = sc.nextInt();
        }
        
        HashSet<Integer> duplicateSet = new HashSet<>();
        for(int item : arr){
            if(!numbers.add(item)){
                duplicateSet.add(item);
            }
        }

        if (duplicateSet.isEmpty()) {
            System.out.println("Không có phần tử trùng lặp trong mảng.");
        } else {
            System.out.println("Các phần tử trùng lặp trong mảng là: " + duplicateSet);
        }

        sc.close();
    }

    // bài 14
    public static void b14(){
        System.out.println("Nhập số lượng phần tử của tập thứ nhất: ");
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        int n = sc.nextInt();
        for(int i =0; i < n; i++){
            System.out.print("Nhập vào phần tử thứ "+ i +" : ");
            set1.add(sc.nextInt());
        }

        System.out.println("Nhập số lượng phần tử của tập thứ nhất: ");
        int m = sc.nextInt();
        for(int i =0; i < m; i++){
            System.out.print("Nhập vào phần tử thứ "+ i +" : ");
            set2.add(sc.nextInt());
        }

        set1.retainAll(set2);
        System.out.println("Các phần tử trùng nhau là");
        System.out.print(set1);

        sc.close();
    }

    // bài 15
    public static void b15(){
        System.out.println("Nhập số lượng phần tử của tập thứ nhất: ");
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        int n = sc.nextInt();
        for(int i =0; i < n; i++){
            System.out.print("Nhập vào phần tử thứ "+ i +" : ");
            set1.add(sc.nextInt());
        }

        System.out.println("Nhập số lượng phần tử của tập thứ nhất: ");
        int m = sc.nextInt();
        for(int i =0; i < m; i++){
            System.out.print("Nhập vào phần tử thứ "+ i +" : ");
            set2.add(sc.nextInt());
        }

        set1.addAll(set2);
        System.out.println("Hợp của 2 tập hợp là");
        System.out.print(set1);

        sc.close();
    }

    // bài 16
    public static void b16() {
        System.out.println("Nhập số lượng phần tử của tập: ");
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<>();


        int n = sc.nextInt();
        for(int i =0; i < n; i++){
            System.out.print("Nhập vào phần tử thứ "+ i +" : ");
            set.add(sc.nextInt());
        }

        int maxValue = Collections.max(set);
        int minvalue = Collections.min(set);
        
        System.out.println("Max là: "+ maxValue);
        System.out.println("Min là "+ minvalue);

        sc.close();
    }

    // bài 17
    public static void b17(){
        Scanner scanner = new Scanner(System.in);
        HashSet<String> stringSet = new HashSet<>();

        System.out.print("Nhập số lượng chuỗi: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập các chuỗi:");
        for (int i = 0; i < n; i++) {
            System.out.print("Chuỗi thứ " + (i + 1) + ": ");
            stringSet.add(scanner.nextLine());
        }

        System.out.println("\nCác chuỗi duy nhất trong HashSet:");
        for (String str : stringSet) {
            System.out.println(str);
        }

        scanner.close();
    }

    // bài 18
    public static void b18() {
        System.out.println("Nhập số lượng phần tử: ");
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<>();


        int n = sc.nextInt();
        for(int i =0; i < n; i++){
            System.out.print("Nhập vào phần tử thứ "+ i +" : ");
            set.add(sc.nextInt());
        }

        System.out.println("Số lượng phần tử là "+ set.size());

        sc.close();
    }

}
