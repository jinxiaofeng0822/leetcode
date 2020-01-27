package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mathProblem {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        HashMap<Integer,String> map = new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");

        for (int i = 1; i <= n; i++) {
            String str="";
            for (Integer key:map.keySet()){
                if(i%key==0){
                    str+=map.get(key);
                }
            }
            if("".equals(str)){
                ans.add(String.valueOf(i));
            }else{
                ans.add(str);
            }
        }
        return ans;
    }
}
