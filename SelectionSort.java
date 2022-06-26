public class SelectionSort {

    public static void selectionSort(int nums[]) {
        for (int start = 0; start < nums.length; start++) {
            int max = start;
            for (int run = start + 1; run < nums.length; run++) { // 利用 run = start + 1確保有2個以上可以進行比較
                if (nums[run] > nums[max]) {
                    max = run;
                }
            }
            swap(nums, start, max);
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

    public static void main(String args[]) {
        int nums[] = {8, 2, 6, 10, 4};
        selectionSort(nums);
        System.out.println("排序結果");
        printArray(nums);
        System.out.println();
    }
}
