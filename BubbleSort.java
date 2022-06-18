public class BubbleSort {


    public static void bubbleSortImpl(int[] nums){

        for (int round=0; round<=nums.length;round++){
            int len = nums.length - round; //因爲每一論都會確認一個數字，所以不用每一次都要跑到底
            for(int i=1;i< len;i++){ // 將i設為1，目的在於從這開始檢驗，i如果已超過就不用繼續往下
                if(nums[i-1] > nums[i]){
                    swap(nums,i-1,i);
                }
            }
            System.out.print("第"+round+"輪 ");
            printArray(nums);
            System.out.println();
        }
    }

    private static void swap(int[] nums, int leftNum, int rightNum) {
        int tmp = nums[leftNum];
        nums[leftNum] = nums[rightNum];
        nums[rightNum] = tmp;
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String args[]){
        int array[] = {8,2,6,10,4};
        bubbleSortImpl(array);
    }
}
