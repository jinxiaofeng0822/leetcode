package array;

import java.util.LinkedList;

/**
 * @author Jin Xiaofeng
 */
public class ListProblem {
    private ListNode head = null;

    public void add(int x){
        ListNode newNode = new ListNode(x);
        if (head == null) {
            head=newNode;
            return;
        }
        ListNode temp = head;
        ListNode lastNode = null;
        while (temp != null) {
            lastNode=temp;
            temp=temp.next;
        }
        lastNode.next=newNode;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "空列表";
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("第一个节点，值"+head.val+"。");
            int i=2;
            ListNode nextNode = head.next;
            while (nextNode!=null){
                sb.append("第"+i+"个节点，值"+nextNode.val+"。");
                i++;
                nextNode=nextNode.next;
            }
            return sb.toString();
        }
    }



    public void deleteNode(ListNode node) {
        //将node下一个节点的val赋值给node。再将node.next指向
        //下下一个。实现删除该节点的功能。
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=1;
        ListNode node = head;
        while (node.next!=null) {
            i++;
            node=node.next;
        }

        if (i == 1) {
            return null;
        }
        node=head;
        if(n==1){
            for (int j=0; j < i-2; j++) {
                node=node.next;
            }
            node.next=null;
            return head;
        }

        if(i==n){
            head=node.next;
            return head;
        }

        for (int j=0; j < i-n-1; j++) {
            node=node.next;
        }

        node.next=node.next.next;
        return head;
    }

    public static void main(String[] args) {
        LinkedList<String> o = new LinkedList<>();
        o.add("s");
        ListProblem lp = new ListProblem();
        System.out.println(lp.toString());
        lp.add(1);
        System.out.println(lp.toString());
        lp.add(2);
        System.out.println(lp.toString());
        lp.add(3);
        System.out.println(lp.toString());
        lp.add(4);
        System.out.println(lp.toString());
        lp.add(5);
        System.out.println(lp.toString());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
