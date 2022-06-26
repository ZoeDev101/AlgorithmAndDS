public class InsertionSortRecursion {

    public static void InsertionSortRecursion(int nums[]) {
        int start = 0;
        mainLogic(nums,start);
    }

    public static void mainLogic(int nums[],int start){
        int run = start - 1;
        if (start >= nums.length ){
            return;
        }
        chgNums(nums,run);
        mainLogic(nums,start+1);
    }

    public static void chgNums(int nums[],int run){
        if(run < 0 ){
            return;
        }
        if(nums[run+1] > nums[run]){
            swap(nums, run + 1, run);
        } else { //當發現左邊數字比較大時可以馬上離開迴圈
            return;
        }
        chgNums(nums,run-1);
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

    public static void main(String args[]){
        int[] nums = {8, 2, 6, 4, 10};
        InsertionSortRecursion(nums);
        System.out.println("排序後結果為：");
        printArray(nums);

    }
}
