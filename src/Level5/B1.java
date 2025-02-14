package Level5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class B1 {

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


    public static void main(String[] args) {
        //5.1
        Integer[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverses(arr)));


        //5.2
        String[] arrString = {"a", "b", "c", "d"};
        System.out.println(Arrays.deepToString(chunk(arrString, 2))); // [[a, b], [c, d]]
        System.out.println(Arrays.deepToString(chunk(arrString, 3)));


        //5.3
        Integer[] arrIniq = {1, 2, 3, 2, 4};
        System.out.println(Arrays.toString(uniq(arrIniq)));

        //5.4
        List<Map<String, Integer>> objList = Arrays.asList(
            Map.of("x", 1, "y", 2),
            Map.of("x", 2, "y", 1),
            Map.of("y", 2, "x", 1)
        );
        System.out.println("Unique Objects: " + uniqObjects(objList));


        //5.5
        List<Map<String, Integer>> objList2 = Arrays.asList(
            Map.of("a", 1, "b", 2),
            Map.of("a", 1, "b", 3),
            Map.of("a", 2, "b", 2)
        );
        
        System.out.println("Grouped by 'a': " + groupBy(objList2, "a"));
        System.out.println("Grouped by 'b': " + groupBy(objList2, "b"));

    }
}
