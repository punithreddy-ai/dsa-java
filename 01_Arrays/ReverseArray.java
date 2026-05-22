public class ReverseArray {
    public static void reverse(int[] arr) {
        int left=0;
        int right= arr.length - 1;
         while (left<right){
            //swap arr[left] and arr[right]
            int temp =arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++; // move left fordward
            right--; //move right backward
         }
    }
    public static void main(String[] args){
        int[] arr ={10,30,50,70,90,120};
        System.out.println("Original: ");
        for (int x:arr) System.out.print(x+ " ");
        reverse(arr);
        System.out.println("\nReversed: ");
        for (int x:arr) System.out.print(x+" ");
    }
}
