package array;

import java.util.LinkedList;

/**
 * @author Jin Xiaofeng
 */
public class ListProblem {
    //TODO 增加单元测试
    private ListNode head = null;

    /**
     * 增加一个节点，到末尾
     * @param x
     */
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


    /**
     * 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，
     * 你将只被给定要求被删除的节点。
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     * 示例 1:
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，
     * 该链表应变为 4 -> 1 -> 9.
     *
     * 示例 2:
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，
     * 该链表应变为 4 -> 5 -> 9.
     * @param node
     */
    public void deleteNode(ListNode node) {
        //将node下一个节点的val赋值给node。再将node.next指向
        //下下一个。实现删除该节点的功能。
        node.val=node.next.val;
        node.next=node.next.next;
    }

    /**
     * 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * 说明：
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     * @param head
     * @param n
     * @return
     */
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

    /**
     * 反转链表
     * 反转一个单链表。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode nextNode = curr.next;
            curr.next=prev;
            prev= curr;
            curr = nextNode;
        }
        return prev;
    }

    /**
     * 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;

        while (l1!=null&&l2!=null){
            ListNode append;
            if (l1.val < l2.val) {
                append=l1;
                l1=l1.next;
            }else{
                append=l2;
                l2=l2.next;
            }
            if (head == null) {
                head=append;
                curr=append;
            }else{
                curr.next=append;
                curr= curr.next;
            }
        }
        if (l1 != null && l2 == null) {
            if (head == null) {
                head=l1;
            }else{
                curr.next=l1;
            }
        } else if (l1 == null && l2 != null) {
            if (head == null) {
                head=l2;
            }else{
                curr.next=l2;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListProblem lp = new ListProblem();
        lp.add(1);
        lp.add(2);
        lp.add(3);

        ListProblem lp2 = new ListProblem();
        lp2.add(1);
        lp2.add(3);
        lp2.add(5);

        ListProblem r = new ListProblem();
        r.head=r.mergeTwoLists(lp.head,lp2.head);
        System.out.println(r);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
