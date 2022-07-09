
public class StackImpl {

    //以Array 實作 stack
    Integer array[];
    Integer stack[];
    Integer top = null; //指出最上層的index

    public StackImpl(Integer array[]) {
        this.array = array;
    }

    public void buildStack() {
        this.stack = new Integer[this.array.length]; //針對stack進行初始化
        for (int i = 0; i < this.array.length; i++) {
            push(array[i]);
        }
    }

    private void push(Integer val) {

        if (size() == this.stack.length) {
            expandSpace();
        }

        if (size() == 0) {
            top = 0;
        } else {
            top++;
        }
        stack[top] = val;
    }

    public Integer pop() {
        if (size() == 0) {
            return null;
        }
        Integer popVal = stack[top];
        stack[top] = null; //取出後需清值

        if (size() == 1) { //當剩下1個項目取出後top為null
            top = null;
        } else {
            top--;
        }
        return popVal;

    }


    private void expandSpace() {
        Integer newStack[] = new Integer[stack.length * 2];
        for (int i = 0 ;i<stack.length;i++) {
            newStack[i] = stack[i];
        }
        this.stack = newStack; //將指標指向新的stack
    }

    private int size() {
        if (top == null) {
            return 0;
        }
        return top + 1;
    }

    public static void main(String args[]) {
        Integer nums[] = {1, 2, 3, 4, 5};
        StackImpl stack = new StackImpl(nums);
        stack.buildStack();

        System.out.println("Stack");
        Integer val = stack.pop();
        System.out.println(val);
        val = stack.pop();
        System.out.println(val);
        val = stack.pop();
        System.out.println(val);
        val = stack.pop();
        System.out.println(val);
        val = stack.pop();
        System.out.println(val);
        val = stack.pop();
        System.out.println(val); // 當stack為空回傳null

        System.out.println("=====================================================");

        Integer nums2[] = {5, 9, 8, 7, 2};
        StackImpl stack2 = new StackImpl(nums2);
        stack2.buildStack();

        stack2.push(3);
        System.out.printf("驗證 expandSpace(),stack大小為：%d%n",stack2.stack.length);
        System.out.println("Stack2");
        Integer val2 = stack2.pop();
        System.out.println(val2);
        val2 = stack2.pop();
        System.out.println(val2);
        val2 = stack2.pop();
        System.out.println(val2);
        val2 = stack2.pop();
        System.out.println(val2);
        val2 = stack2.pop();
        System.out.println(val2);
        val2 = stack2.pop();
        System.out.println(val2);
        val2 = stack2.pop();
        System.out.println(val2);

    }
}



