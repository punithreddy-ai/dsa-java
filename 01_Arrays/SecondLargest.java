public class SecondLargest {
    public static int findSecondLargest (int[] arr) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++){
            if (arr[i]>max){
                second=max;
                max=arr[i];
            }
            else if (arr[i] > second && arr[i] != max){
                second=arr[i];
            }
        }
        if(second==Integer.MIN_VALUE){
            System.out.println("N0 second largest element exists.");
            return -1;
        }
        return second;
    }

    public static void main(String[] args){
        int[] arr = {12, 45, 7, 83, 23, 56};
        System.out.println("Second Largest Element:"+findSecondLargest(arr)); //56

        int[] arr2 = {5, 5, 5};
        System.out.println("Second Largest Element:"+findSecondLargest(arr2)); // No second largest element exists.
    }
}