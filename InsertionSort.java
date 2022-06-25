public class InsertionSort {

    public static void insertionSortImpl(int[] nums){

        for (int start = 0;start<nums.length;start++){
            for (int run = start -1;run>=0;run--){ //如減1後沒有大於等於0,表只剩下1個沒得比較
                if(nums[run+1] > nums[run]){
                    swap(nums,run+1,run);
                }
                else{ //當發現左邊數字比較大時可以馬上離開迴圈
                   break;
                }
            }
        }
    }

    private static void swap(int[] nums, int run_left, int run_right) {
        int tmp = nums[run_left];
        nums[run_left] = nums[run_right];
        nums[run_right] = tmp;
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main (String args[]){

        int[] nums = {8,2,6,4,10};
        insertionSortImpl(nums);

        System.out.println("排序後結果為：");
        printArray(nums);

    }
}
