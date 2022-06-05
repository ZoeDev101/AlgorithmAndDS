import java.beans.IntrospectionException;
import java.lang.reflect.Array;

public class ArrayImpl {

    private Integer[] array;
    private Integer i_end; //最後一個元素的index

    public ArrayImpl(int size) {
        array = new Integer[size];
        i_end = -1; // 因array的index是從0開始,所以-1表示Array為空
    }

    public void addByIndex(int i_add, int val) {
        if (i_end + 1 == array.length) expandSpace(); //如果加入i_end會大於陣列長度＋1，需要增加陣列大小
        if (i_add > i_end + 1 || i_add < 0) return; //不合理情形：如果插入的位置大於最後一個元素的index表示加入的位置不是最後一個元素的下一個而是下下個
        for (int i = i_end; i >= i_add; i--) { //當 i >= i_add 表示還在要插入的 index 右邊
            array[i + 1] = array[i];
            array[i] = null;
        }
        array[i_add] = val;
        i_end++;
    }

    public void addByValue(int val) {
        addByIndex(i_end + 1, val);
    }

    private void expandSpace() {
        Integer array_new[] = new Integer[array.length * 2];
        int count = 0;
        for (int x : array) {
            array_new[count] = x;
            count++;
        }
        this.array = array_new;
    }

    public Integer searchByIndex(int index) {
        if (index > i_end + 1 || index < 0) return null; //不合理情形
        return array[index];
    }

    public Integer searchByValue(int val) {
        for (int i = 0; i <= i_end; i++) {
            if (array[i] == val) {
                return array[i];
            }
        }
        return null;
    }

    public void removeByIndex(int index) {
        if (index > i_end + 1 || index < 0) return; //不合理情形
        for (int i = index; i <= i_end; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        i_end--;
    }

    public void removeByValue(int val) {
        for (int i = 0; i <= i_end; i++) {
            if (array[i] == val) {
                System.out.println("remove index: " + i);
                removeByIndex(i);
            }
        }
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    public static void main(String[] args) {

        /** initialize **/
        ArrayImpl testArray = new ArrayImpl(5);

        testArray.addByValue(5);
        testArray.addByValue(98);
        testArray.addByValue(2);
        testArray.addByValue(3);
        testArray.addByValue(79);
        System.out.println("初始陣列值");
        testArray.printArray();
        System.out.println();

        /** add by value O(1) + expand O(n) 導致最後時間複雜度等於O(n) **/
        System.out.println("尋找元素 44");
        testArray.searchByValue(44);
        System.out.println(testArray.searchByValue(44));

        System.out.println("尋找元素 79");
        testArray.searchByValue(79);
        System.out.println(testArray.searchByValue(79));

        /** add by index O(n) **/
        int i_add = 1;
        testArray.addByIndex(i_add, 50);
        System.out.println("在 index=1的位址加入資料50");
        testArray.printArray();
        System.out.println();

        testArray.addByValue(87);
        System.out.println("加入元素 87");
        testArray.printArray();
        System.out.println();

        /** search by value O(n) **/
        Integer val001 = testArray.searchByValue(2882);
        System.out.println("搜尋元素 2882");
        if (val001 == null) {
            System.out.print("不存在此資料！");
        } else {
            System.out.print(val001);
        }
        System.out.println();

        /** search by index O(1) **/
        System.out.println("搜尋 index = 4 的元素 ");
        Integer val002 = testArray.searchByIndex(4);
        if (val002 == null) {
            System.out.print("不存在此資料！");
        } else {
            System.out.print(val002);
        }
        System.out.println();

        /** remove by value O(n) **/
        System.out.println("刪除元素 = 2 的值 ");
        testArray.removeByValue(2);
        testArray.printArray();
        System.out.println();

        /** remove by index O(n) **/
        int i_remove = 2;
        System.out.println("刪除index = 2 的值 ");
        testArray.removeByIndex(i_remove);
        testArray.printArray();
        System.out.println();

    }
}
