package stackPackage;

import java.util.ArrayDeque;

public class rough {
    public static void main(String[] args){
        int[] arr = {2,4,7,5,1};

        ReactangleAreaSuperOptimised.fun1(arr);

    }
}




class ReactangleAreaSuperOptimised{
    static void fun1(int[] arr){
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        int res = 0;
        int area = 0;

        for(int i =0; i<arr.length;i++){
            if(st.isEmpty()==true){
                st.push(i);
                continue;
            }
            while(st.isEmpty()==false){
                int peekIdx = st.peek();
                int peek = arr[peekIdx];
                if(peek>=arr[i]){
                    st.pop();
                    if(st.isEmpty()==true){
                        area = peek * i;
                    }else{
                        area = peek * (i-st.peek()-1);
                    }
                    res = Math.max(res,area);
                }else{
                    st.push(i);
                }
            }
            st.push(i);
        }

        // It is very imp , follow striver video to under stand this
        if(st.isEmpty()==false){
            int pop = st.pop();
            if(st.isEmpty()==true){
                area = arr[pop] * arr.length;
                res = Math.max(area, res);
            }else{
                area = arr[pop] * (arr.length-st.peek()-1);
                res = Math.max(res,area);
            }
        }


        System.out.println(res);

    }
}






























