public class List_Impl {

    static class Node {
        Integer val;
        Node next; //指出下一個node的位置

        public Node (int val){
            this.val = val;
        }
    }

    private Node start; // 指出開始位置
    private Node end; // 指出結束位置

    public List_Impl(){};

    public void add(int val){
        if(start == null){
            start = new Node(val);
            end = start;
        }
        else{
            end.next = new Node(val);
            end = end.next;
        }
    }

    public Integer search(int val){

        if(start == null) return null;

        Node node = start; // 從開頭開始跑
        while (true){

            if(node == null) break;

            if(node.val == val){
                return node.val;
            }
            node = node.next; // 每一次會等於下一個
        }
        return null;
    }

    public void remove(int val){

        // step1 search

        Node node = start;
        Node preNode = null; // 紀錄目標點的上一個位置
        Node targetNode = null; // 紀錄找到的目標節點

        while (true){

            if (node == null) break;

            if (node.val == val){
                targetNode = node;
                break;
            }

            preNode = node; //再變成下一節點時先保留下來
            node = node.next;
        }

        // step2 delete

        if (targetNode == null) return; // list 沒有這個值

        if (targetNode == start){
            start = start.next;
        }
        else{
            preNode.next = targetNode.next;
        }
    }


    public void printList() {
        Node node = start;
        while (true){
            if(node == null) break;
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String args[]){

        //Initialize
        List_Impl list = new List_Impl();

        /** add O(1) - start **/
        list.add(9);

        /** add O(1) **/
        list.add(11);
        list.add(2);
        list.add(98);
        list.add(35);
        System.out.println("新增資料到List");
        list.printList();
        System.out.println();

        /** search O(n) **/
        System.out.println("搜尋 98");
        Integer val = list.search(98);
        System.out.println(val);

        /** search O(n) **/
        System.out.println("搜尋 156");
        Integer val2 = list.search(156);
        System.out.println(val2);

        /** remove O(n) **/
        System.out.println("刪除 2");
        list.remove(2);
        list.printList();
        System.out.println();

        System.out.println("刪除 9");
        list.remove(9); // remove start
        list.printList();
        System.out.println();


        System.out.println("刪除 35");
        list.remove(35); // remove end
        list.printList();
        System.out.println();

    }
}
