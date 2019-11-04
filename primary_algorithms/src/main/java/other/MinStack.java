package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jin Xiaofeng
 */
public class MinStack {
    int minNum= Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();
    public MinStack() {

    }

    public void push(int x) {
        if (x <= minNum) {
            minNum=x;
        }
        list.add(x);
    }

    public void pop() {
        if(list.size()>0){
            int i=list.remove(list.size()-1);
            if(i==minNum){
                minNum=Integer.MAX_VALUE;
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j)<=minNum){
                        minNum=list.get(j);
                    }
                }
            }
        }
    }

    public int top() {
        if(list.size()>0){
            return list.get(list.size()-1);
        }else{
            return 0;
        }
    }

    public int getMin() {
        return minNum;
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        System.out.println(m.getMin());
        m.pop();
        m.top();
        System.out.println(m.getMin());
    }
}
