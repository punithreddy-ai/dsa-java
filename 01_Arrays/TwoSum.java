import java.util.HashMap;

public class TwoSum{
    public static int[] twoSum (int[] arr , int target){
        HashMap< Integer, Integer>map = new HashMap<>();
        //map stores = value -> index

        for (int i=0; i<arr.length; i++){
            int complement = target-arr[i]; // what we need

            if(map.containsKey(complement)){
                //found it! return both indices
                return new int[]{map.get(complement),i};
            }
             //not sound yet,store current number
            map.put(arr[i], i);
        }
        return new int[]{-1, -1}; //no pair found
    }

    public static void main(String[] args){
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);
        System.out.println("Indices: [" + result[0] + "," + result[1] + "]");
        //output: Indices:[0, 1] because arr[0]+arr[1]=2+7=9
    }
}