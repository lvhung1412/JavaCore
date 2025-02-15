import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class JavaCore1 {

    public static void level1B1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất: ");
        int a = sc.nextInt();
        System.out.println("Nhập số thứ hai: ");
        int b = sc.nextInt();
        System.out.println("Tổng của 2 số là: " + (a + b));
        sc.close();
    }

    public static void level1B2(){
        System.out.println("Nhập chuỗi: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Chuỗi vừa nhập là: " + str+ " có độ dài là: " + str.length());
        sc.close();
    }

    public static void level1B3(){
        System.out.println("Nhập vào 1 số:");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        System.out.println("Bình phương của số vừa nhập là: " + Math.pow(a, 2));
        sc.close();
    }

    public static void level1B4(){
        System.out.println("Nhập số lượng phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextDouble();
        }

        double max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng là: " + max);
        sc.close();
    }

    public static void level1B5(){
        System.out.println("Nhập vào số lượng chuỗi của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập chuỗi thứ " + i + ": ");
            arr[i] = sc.nextLine();
        }
        String minString = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i].length() < minString.length()) {
                minString = arr[i];
            }
        }
        System.out.println("Chuỗi có độ dài nhỏ nhất trong mảng là: " + minString);
        sc.close();
    }

    public static void level1B6(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
        }

        for(int i = 0; i < n-1 ;i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp tăng dần: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    public static void level1B7(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }

        for(int i = 0; i < n-1 ;i++){
            for(int j = i+1; j < n; j++){
                if(arr[i].compareTo(arr[j]) > 0){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Mảng sau khi sắp xếp tăng dần: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    public static void level1B8(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
        }

        for(int i = 0; i < n-1 ;i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Trung vị của mảng đã nhập là: ");
        if(n % 2 == 0) {
            System.out.println((arr[n/2] + arr[n/2 - 1]) / 2);
        } else {
            System.out.println(arr[n/2]);
        }
        sc.close();
    }

    public static void level1B9(){
        System.out.println("Nhập vào chuỗi s: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        System.out.println("Số lượng từ trong chuỗi: " + arr.length);
        sc.close();
    }

    public static void level1B10(){
        System.out.println("Nhập vào số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập vào chuỗi thứ " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i].contains("a")){
                count++;
            }
        }
        System.out.println("Số lượng chuỗi có chứa ký tự 'a': " + count);
        sc.close();
    }

    // LEVEL2
    public static void level2B1(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }
        System.out.println("Phần tử lớn thứ 2 trong mảng là: " + secondMax);
        sc.close();
    }

    // bài 2.2
    public static void level2B2(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + ": ");
            arr[i] = sc.nextLine();
        }
        String longestWord = "";
        String[] word;
        for (int i = 0; i < n; i++) {
            word = arr[i].split(" ");
            for (int j = 0; j < word.length; j++) {
                if (word[j].length() > longestWord.length()) {
                    longestWord = word[j];
                }
            }
        }
        System.out.println("Từ dài nhất trong mảng là: " + longestWord);
        sc.close();
    }

    // Bài 2.3
    public static String maxCommStr(String s1, String s2){
        String longestSubstring  = "";
        int m = s1.length();
        int n = s2.length();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                String temp = "";
                int x = i;
                int y = j;

                while (x < m && y < n && s1.charAt(x) == s2.charAt(y)) {
                    temp+=s1.charAt(x);
                    x++;
                    y++;
                }

                if (temp.length() > longestSubstring.length()) {
                    longestSubstring = temp.toString();
                }
            }
        }
        return longestSubstring;
    }
    public static void level2B3(){
        System.out.println("Nhập vào chuỗi thứ nhất: ");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        System.out.println("Nhập vào chuỗi thứ hai: ");
        String s2 = sc.nextLine();
        System.out.println("Chuỗi con chung dài nhất là: " + maxCommStr(s1, s2));
        sc.close();
    }

    // bài 2.4
    public static void level2B4(){
        System.out.println("Nhập số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] % 3 == 0 && arr[i] % 5 == 0){
                sum += arr[i];
            }
        }
        System.out.println("Tổng các phần tử chia hết cho 3 và 5 là: " + sum);
        sc.close();
    }

    // bài 2.5
    public static int maxSum(int[] arr) {
        int max_so_far = arr[0];
        int curr_max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    public static void level2B5(){
        System.out.println("Nhập số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Tổng lớn nhất của dãy con liên tục là: " + maxSum(arr));
        sc.close();
    }

    // LEVEL 3
    public static void level3B1(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num > min) {
                secondMin = num;
            }
        }
        System.out.println("Phần tử nhỏ thứ 2 trong mảng là: " + secondMin);
        sc.close();
    }

    // bài 3.2
    public static void level3B2(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Khoảng lớn nhất là: " + (max-min));
        sc.close();
    }

    // bài 3.3
    public static void level3B3(){
        System.out.println("Nhập vào số nguyên dương n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + ":");
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        int maxLIS = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            // xét tất cả các phần tử phía trước arr[i]: 0 -> i-1
            for (int j = 0; j < i; j++) {
                 if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        System.out.println("Độ dài dãy con tăng dài nhất là: " + maxLIS);
        sc.close();
    }

    // bài 3.4
    public static int maxOverlap(String s, String t){
        List<Character> s1 = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> t1 = t.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        int count = 0;
        for(int i =0 ; i < s1.size(); i++){
            for(int j = 0; j < t1.size(); j++){
                //System.out.println(s1.get(i) + " " + t1.get(j));
                if(s1.get(i).equals(t1.get(j)) && s1.get(i) != ' '){
                    s1.set(i, ' ');
                    t1.set(j, ' ');
                    count++;
                }
            }
        }
        return count;
    }
    public static void level3B4(){
        System.out.println("Nhập số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập chuỗi thứ " + (i + 1) + ": ");
            arr[i] = sc.next();
        }
        int max = -1;
        int index1 = 0, index2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(max < maxOverlap(arr[i], arr[j])){
                    max = maxOverlap(arr[i], arr[j]);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println("Hai chuỗi trùng lặp nhiều nhất là: " + arr[index1] + " và " + arr[index2]);
        sc.close();
    }
    
    // bài 3.5
    public static void level3B5(){
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập vào dãy số: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int smallest = 1;  // số nguyên dương nhỏ nhất
        // duyệt các phần tử trong mảng
        for(int i : arr){
            // nếu phần tử hiện tại nhỏ hơn hoặc bằng số nguyên dương nhỏ nhất
            if(i <= smallest){
                smallest += i;
            }else{
                break;
            }
        }
        System.out.println("Số nguyên dương nhỏ nhất không thể tạo thành từ các phần tử trong dãy là: " + smallest);
        sc.close();
    }

    // BÀI 3.7
    public static void level3B7(){
        System.out.println("Nhập số lượng phần tử của mảng 1: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + " của mảng 1: ");
            arr1[i] = sc.nextInt();
        }

        System.out.println("Nhập số lượng phần tử của mảng 2: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập phần tử thứ " + i + " của mảng 2: ");
            arr2[i] = sc.nextInt();
        }

        int[] arr3 = new int[n + m];
        for(int i = 0; i < n; i++) {
            arr3[i] = arr1[i];
        }
        for(int i =n; i < n + m; i++) {
            arr3[i] = arr2[i - n];
        }
        Arrays.sort(arr3);
        System.out.println("Trung vị của mảng sau là: ");
        n = n + m;
        if(n % 2 == 0) {
            System.out.println((double)(arr3[n/2] + arr3[n/2 - 1]) / 2);
        } else {
            System.out.println(arr3[n/2]);
        }
        sc.close();
    }

    // bài 3.10
    public static int getNumberOfDistinctCharacter(String s){
        Set<Character> set = new HashSet<>();
        for(int i =0; i< s.length(); i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }
    public static void level3B10(){
        System.out.println("Nhập số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = new String[n];

        System.out.println("Nhập các chuỗi:");
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }

        Arrays.sort(s, (str1, str2) -> {
            int distinct1 = getNumberOfDistinctCharacter(str1);
            int distinct2 = getNumberOfDistinctCharacter(str2);
            if (distinct1 != distinct2) {
                return Integer.compare(distinct1, distinct2);
            }
            if (str1.length() != str2.length()){
                return Integer.compare(str2.length(), str1.length());
            }
            return str1.compareTo(str2);
        });

        System.out.println("Danh sách sau khi sắp xếp:");
        System.out.println(Arrays.toString(s));
        sc.close();
    }

    // LEVEL 4
    public static void level4B1(){
        System.out.println("Nhập số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = 0; i< n-1; i++){
            for(int j = 0; j< n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;
                }
            }
        }
        System.out.println("Số bước cần để sắp xếp là: "+ count);
        sc.close();
    }

    // bài 4.2
    public static int countSubsetsWithSum(int[] arr, int target) {
        List<List<Integer>> validSubsets = new ArrayList<>();
        findSubsets(arr, target, 0, new ArrayList<>(), validSubsets);
        return validSubsets.size();
    }
    private static void findSubsets(int[] arr, int target, int index, List<Integer> currentSubset, List<List<Integer>> validSubsets) {
        // Tính tổng của tập con hiện tại
        int sum = currentSubset.stream().mapToInt(Integer::intValue).sum();
        
        // Nếu tổng bằng target và có ít nhất 2 phần tử thì lưu lại
        if (sum == target && currentSubset.size() > 1) {
            validSubsets.add(new ArrayList<>(currentSubset));
        }
        
        // Nếu tổng đã vượt target thì không xét tiếp
        if (sum >= target) return;

        // Duyệt qua từng phần tử tiếp theo
        for (int i = index; i < arr.length; i++) {
            currentSubset.add(arr[i]);
            findSubsets(arr, target, i + 1, currentSubset, validSubsets);
            currentSubset.remove(currentSubset.size() - 1); // Loại bỏ phần tử cuối để thử tổ hợp khác
        }
    }
    public static void level4B2(){
        Scanner sc = new Scanner(System.in);
        
        // Nhập mảng
        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Nhập target value: ");
        int target = sc.nextInt();

        int result = countSubsetsWithSum(arr, target);
        System.out.println("Số tập con có tổng bằng target là: " + result);
        sc.close();
    }

    // bài 4.3
    public static String maxCommStrB3(String s1, String s2){
        String longestSubstring  = "";
        int m = s1.length();
        int n = s2.length();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                String temp = "";
                int x = i;
                int y = j;

                while (x < m && y < n && s1.charAt(x) == s2.charAt(y)) {
                    temp+=s1.charAt(x);
                    x++;
                    y++;
                }

                if (temp.length() > longestSubstring.length()) {
                    longestSubstring = temp.toString();
                }
            }
        }
        return longestSubstring;
    }
    public static void level4B3(){
        System.out.println("Nhập vào số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i< n; i++){
            System.out.println("Nhập chuỗi thứ "+ i +": ");
            arr[i] = sc.nextLine();
        }

        String s = arr[0];
        String result = "";
        for(int i = 0; i< n ;i++){
            result = maxCommStrB3(s, arr[i]);
            s = result;
        }
        System.out.println(result.length());
        sc.close();
    }

    // bài 4.6
    public static void level4B6(){
        System.out.println("Nhập số lượng phần tử: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.println("Nhập phần tử thứ "+ i +" : ");
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println("Tích 3 phần tử bất kỳ lớn nhất là: "+ Math.max(arr[n - 1] * arr[n - 2] * arr[n - 3], 
        arr[0] * arr[1] * arr[n - 1]));
        sc.close();
    }

    // bài 4.7
    public static int getNumberCharacter(String s){
        HashSet<Character> setCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                setCharacters.add(c);
            }
        }
        return setCharacters.size();
    }
    public static void level4b7() {
        System.out.println("Nhập vào số lượng chuỗi: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] arrStrings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào chuỗi thứ " + (i + 1) + ": ");
            arrStrings[i] = sc.nextLine();
        }

        Arrays.sort(arrStrings, (s1, s2) -> {
            int count1 = getNumberCharacter(s1);
            int count2 = getNumberCharacter(s2);

            if (count1 != count2) {
                return Integer.compare(count2, count1); 
            }
            return s1.compareTo(s2);
        });

        for(String s: arrStrings){
            System.out.println(s+" ");
        }
        sc.close();
    }

    // bài 4.9
    public static int getLongestIncreasingSubOfNumbers(int[] arr){
        int count = 1;
        int maxCount = 1;
        for(int  i =1; i< arr.length; i++){
            if(arr[i] - arr[i-1] == 1){
                count++;
            } else{
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }
    public static void level4B9() {
        System.out.println("Nhập vào số nguyên dương n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            System.out.println("Nhập vào phần tử thứ "+ i +" : ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Mảng con tăng 1 dài nhất là: " + getLongestIncreasingSubOfNumbers(arr));
        sc.close();
    }

    // bài 4.10
    public static int getOverlap(String s1, String s2, int k) {
        int maxOverlap = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        
        for (int i = 0; i <= len1 - k; i++) {
            for (int j = 0; j <= len2 - k; j++) {
                int count = 0;
                while (i + count < len1 && j + count < len2 && s1.charAt(i + count) == s2.charAt(j + count)) {
                    count++;
                    if (count >= k) {
                        maxOverlap = Math.max(maxOverlap, count);
                    }
                }
            }
        }
        return maxOverlap;
    }
    public static String[] findLargestOverlapPair(List<String> strings, int k) {
        int maxOverlap = 0;
        String str1 = "", str2 = "";
        
        // duyệt từng cặp chuỗi trong danh sách
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                int overlap = getOverlap(strings.get(i), strings.get(j), k);
                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    str1 = strings.get(i);
                    str2 = strings.get(j);
                }
            }
        }
        return new String[]{str1, str2};
    }
    public static void level4B10() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng chuỗi: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập chuỗi thứ " + (i + 1) + ": ");
            strings.add(scanner.nextLine());
        }
        
        System.out.print("Nhập vào số lượng ký tự tối thiểu k: ");
        int k = scanner.nextInt();
        
        String[] result = findLargestOverlapPair(strings, k);
        
        if (!result[0].isEmpty() && !result[1].isEmpty()) {
            System.out.println("Hai chuỗi có phần giao nhau dài nhất: " + result[0] + " và " + result[1]);
        } else {
            System.out.println("Không có cặp chuỗi nào có phần giao nhau dài ít nhất " + k + " ký tự.");
        }
        scanner.close();
    }

    //LEVEL 5
    //5.1
    public static Object[] reverses (Object[] arr){
        int n = arr.length;
        Object[] reversesArr = new Object[n];
        for(int i = (n - 1); i >= 0; i--){
            reversesArr[n - 1 -i] = arr[i];
        }
        return reversesArr;
    }

    //5.2
    public static Object[][] chunk(Object[] arr, int size) {
        int numChunks = (int) Math.ceil((double) arr.length / size); 
        Object[][] result = new String[numChunks][]; 

        for (int i = 0; i < numChunks; i++) {
            int start = i * size;
            int end = Math.min(start + size, arr.length);
            result[i] = Arrays.copyOfRange(arr, start, end);
        }

        return result;
    }

    //5.3
    public static Object[] uniq(Object[] arr){
        int n = arr.length;
        Object[] uniqObjects = new Object[n];
        int size = 0;
        for(int i = 0; i< n ;i++){
            boolean isDuplicate = false;
            for(int j = 0; j< size ; j++){
                if (arr[i].equals(uniqObjects[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqObjects[size++] = arr[i];
            }
        }
        return Arrays.copyOf(uniqObjects, size);
    }

    // uniq: Loại bỏ các phần tử trùng trong mảng
    // public static <T> List<T> uniq(List<T> list) {
    //     return new ArrayList<>(new LinkedHashSet<>(list));
    // }

    //5.4
    // uniq ArrayObject: Loại bỏ các phần tử trùng trong danh sách đối tượng
    public static List<Map<String, Integer>> uniqObjects(List<Map<String, Integer>> list) {
        Set<Map<String, Integer>> seen = new LinkedHashSet<>(list);
        return new ArrayList<>(seen);
    }

    //5.5
    // groupBy: Nhóm các đối tượng trong danh sách theo một trường chỉ định
    public static Map<Integer, List<Map<String, Integer>>> groupBy(List<Map<String, Integer>> list, String key) {
        return list.stream()
                .filter(map -> map.containsKey(key))
                .collect(Collectors.groupingBy(map -> map.get(key)));
    }

    //5.6
    public static String trimAll(String s){
        return s.trim().replaceAll("\\s+", " ");
    }

    //5.7
    // mapKey: Sắp xếp danh sách đối tượng theo thứ tự khóa cho trước
    public static List<Map<String, Integer>> mapKey(List<String> keys, List<Map<String, Integer>> collections) {
        return collections.stream().map(map -> {
            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (String key : keys) {
                if (map.containsKey(key)) {
                    sortedMap.put(key, map.get(key));
                }
            }
            return sortedMap;
        }).collect(Collectors.toList());
    }

    //5.8
    public static List<Map<String, Integer>> switchOrder(List<Map<String,Integer>> list, int id, int numberOfOrder){
        // sắp xếp theo order
        list.sort(Comparator.comparingInt(map -> map.get("order")));

        // tìm kiếm
        Map<String, Integer> target = list.stream()
            .filter(map -> map.get("id") == id)
            .findFirst()
            .orElse(null);

        // không có thì trả về list ban đầu
        if(target == null) return list;

        // xóa cái cũ và thêm cái mới
        list.remove(target);
        list.add(numberOfOrder, target);

        // cập nhật lại order
        for(int i = 0; i< list.size(); i++){
            list.get(i).put("order",i);
        }
        return list;
    }

    //5.9
    public static Map<String, Integer> sumAll(List<Map<String, Object>> list){
        Map<String, Integer> map = new HashMap<>();
        for(Map<String, Object> item : list){
            for(Map.Entry<String, Object> entry: item.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();

                int valueInteger = (value instanceof Number) ? ((Number) value).intValue(): 
                                    (value instanceof String) ? Integer.parseInt(value.toString()) : 0;

                map.put(key, map.getOrDefault(key, 0) + valueInteger);
            }
        }
        return map;
    }

    // 5.10
    public static void processTemplate(String fileInput, String fileOutput, Map<String,String> params) throws IOException{
        // đọc nội dung file template
        String content = new String (Files.readAllBytes(Paths.get(fileInput)));

        // thay thế
        for(Map.Entry<String, String> entry : params.entrySet()){
            String regex = "\\{\\{" + entry.getKey() +"\\}\\}";
            content = content.replaceAll(regex, Matcher.quoteReplacement(entry.getValue()));
        }

        //ghi file
        Files.write(Paths.get(fileOutput), content.getBytes());

    }

    public static void level5B10() {
        try {
            String inputFile = "src/input1.txt"; 
            String outputFile = "src/output1.txt"; 

            Map<String, String> params = new HashMap<>();
            params.put("name", "Jonny");

            processTemplate(inputFile, outputFile, params);
            System.out.println("File processed successfully: " + outputFile);


            String inputFileHtml = "src/input2.html"; 
            String outputFileHtml = "src/output2.html"; 

            Map<String, String> paramsHtml = new HashMap<>();
            paramsHtml.put("title", "Search of skill");
            paramsHtml.put("pageTitle", "Home page");
            paramsHtml.put("content", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab, consectetur");

            processTemplate(inputFileHtml, outputFileHtml, paramsHtml);
            System.out.println("File processed successfully: " + outputFileHtml);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //run
    }
}
