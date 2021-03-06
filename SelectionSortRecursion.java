public class SelectionSortRecursion {

    public static void selectionSortRecursion(int nums[]) {
        int start = 0;
        mainLogic(nums, start);
    }


    public static void mainLogic(int nums[], int start) {
        if (start >= nums.length) {
            return;
        }

        int run = start + 1;
        int max = start;

        max = getMaxNums(nums, max, run);
        swap(nums, start, max);
        mainLogic(nums, start + 1);
    }

    public static int getMaxNums(int nums[], int max, int run) {
        if (run >= nums.length) {
            return max;
        }
        if (nums[run] > nums[max]) {
            max = run;
        }
        return getMaxNums(nums, max, run + 1);
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
        //int nums[] = {99, 3, 10, 8, 120};
        selectionSortRecursion(nums);
        System.out.println("ζεΊη΅ζ");
        printArray(nums);
        System.out.println();
    }

}
