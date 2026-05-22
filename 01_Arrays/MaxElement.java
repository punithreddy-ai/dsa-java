public class MaxElement {
    public static int findMax (int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if (arr[i]>max) {
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {12, 45, 7, 83, 23, 56};
        System.out.println("Maximum Element:"+findMax(arr));
    }
}