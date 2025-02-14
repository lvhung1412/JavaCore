package Level5;

import java.util.Arrays;

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
    }
}
