public class BubbleSoreRecursion {


    public static void bubbleSortRecursion(int nums[]) {
        int round = 0;
        mainLogic(nums, round);
    }

    public static void mainLogic(int nums[], int round) {
        int i = 1;
        int len = nums.length - round;

        if (round >= nums.length) {
            return;
        }
        changNums(nums, len, i);
        mainLogic(nums, round + 1);
    }

    public static void changNums(int nums[], int len, int i) {
        if (i >= len) {
            return;
        }

        if (nums[i - 1] > nums[i]) {
            swap(nums, i - 1, i);
        }

        changNums(nums, len, i + 1);
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
        bubbleSortRecursion(nums);
        System.out.println("排序結果為");
        printArray(nums);
        System.out.println();
    }
}
