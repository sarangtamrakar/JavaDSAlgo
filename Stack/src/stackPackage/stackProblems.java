package stackPackage;

import java.util.ArrayDeque;

class A1TwoStackInArray {
    int[] arr;
    int cap;
    int top1;
    int top2;
    int size1;
    int size2;

    A1TwoStackInArray(int capacity) {
        cap = capacity;
        arr = new int[cap];
        top1 = -1;
        top2 = cap;

    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
            size1++;
        }
    }

    public void push2(int x) {
        if (top2 > top1 + 1) {
            top2--;
            arr[top2] = x;
            size2++;
        }
    }


    public int pop1() {
        if (top1 >= 0) {
            int val = arr[top1];
            top1--;
            size1--;
            return val;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int pop2() {
        if (top2 < cap) {
            int val = arr[top2];
            top2++;
            size2--;
            return val;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}



// **************** A2 as k stack in one arr





class A3StockSpanProblem{
    static int[] NaiveApproach(int[] arr){
        // O(N2) solution
        int n = arr.length;
        int[] res = new int[n];
        for(int i= 0 ; i<n;i++){
            int count = 1;
            for(int j = i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    count++;
                }else{
                    break;
                }
            }
            res[i] = count;
        }
        return res;
    }


    static void OptmisedSolution(int[] arr){
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        int n  = arr.length;
        for(int i = 0; i<n;i++){
            int val = arr[i];
            int count = 1;
            if(st.isEmpty()){
                System.out.println(count);
                st.push(val);
                continue;
            }

            boolean isGreater = false;
            while(st.isEmpty()==false) {
                int peak = st.peek();
                if (peak < val) {
                    count++;
                    st.pop();
                } else {
                    System.out.println(count);
                    isGreater = true;
                    break;
                }
            }
            if(isGreater==false){
                System.out.println(count);
            }
            st.push(val);
        }
    }
}



class A4PreviousGreaterElement{
    static void NaiveApproch(int[] arr){

        for(int i = 0 ; i<arr.length;i++){
            boolean isPresent = false;
            for(int j =i-1;j>=0;j--){
                if(arr[j]>arr[i]){
                    System.out.println(arr[j]);
                    isPresent = true;
                    break;
                }
            }
            if(isPresent==false) {
                System.out.println(-1);
            }
        }
    }


    static void OptmisedSolutionUsingStack(int[] arr){
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        int n = arr.length;
        for(int i = 0 ; i<n;i++){
            int val = arr[i];
            if(st.isEmpty()){
                st.push(val);
                System.out.println(-1);
                continue;
            }
            // if not empty iterate through the stack
            boolean isGreater = false;
            while(st.isEmpty()==false){
                int peak = st.peek();
                if(peak>val){
                    System.out.println(peak);
                    st.push(val);
                    isGreater = true;
                    break;
                }else{
                    st.pop();
                }
            }
            if(isGreater==false){
                System.out.println(-1);
                st.push(val);
            }
        }
    }
}



class A5PreviousGreaterElement{
    static void OptmisedSolution(int[] arr){
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        int n = arr.length;
        for(int i = n-1 ; i>=0;i--){     // only change is her in Next Greater element & Previous greater element problem
            int val = arr[i];
            if(st.isEmpty()){
                st.push(val);
                System.out.println(-1);
                continue;
            }
            // if not empty iterate through the stack
            boolean isGreater = false;
            while(st.isEmpty()==false){
                int peak = st.peek();
                if(peak>val){
                    System.out.println(peak);
                    st.push(val);
                    isGreater = true;
                    break;
                }else{
                    st.pop();
                }
            }
            if(isGreater==false){
                System.out.println(-1);
                st.push(val);

            }
        }
    }
}



class A6LargestRectangleInHistogramNaive{

    static int NaiveApproach(int[] arr){
        int n  = arr.length;
        int res = 0;
        for(int i = 0; i<n;i++){

            int val = arr[i];

            // go to left side
            for(int j = i-1;j>=0;j--){
                if(arr[j]>=arr[i]){
                    val = val + arr[i];
                }else{
                    break;
                }
            }

            // go to right side
            for(int k = i+1;k<n;k++){
                if(arr[k]>=arr[i]){
                    val +=arr[i];
                }else{
                    break;
                }
            }
            res = Math.max(res,val);
        }
        return res;
    }

    static int OptimisedSolution(int[] arr){
        int[] ps = new int[arr.length];
        int[] ns = new int[arr.length];

        ArrayDeque<Integer> st = new ArrayDeque<Integer>();

        // for ps  , iterate from left to right
        for(int i = 0 ; i<arr.length;i++) {

            if (st.isEmpty() == true) {
                st.push(i);
                ps[i] = -1;
                continue;  // Continue is very IMP
            }
            boolean isSmallPresent = false;
            while (st.isEmpty() == false) {
                int valIdx = st.peek();
                int val = arr[valIdx];
                if (val >= arr[i]) {
                    st.pop();
                } else {
                    isSmallPresent = true;
                    ps[i] = valIdx;
                    break;
                }
            }

            if (isSmallPresent == false) {
                ps[i] = -1;
            }
            st.push(i);
        }


        // ******* stack should be empty before startting for next samll
        st.clear();

        // for ns  , iterate from right to left
        for(int i = arr.length-1 ; i>=0;i--){

            if(st.isEmpty()){
                st.push(i);
                ns[i] = arr.length;
                continue;   // ******** continue is very IMP
            }
            boolean isSmallPresent = false;
            while(st.isEmpty()==false){
                int valIdx = st.peek();
                int val = arr[valIdx];
                if(val>=arr[i]){
                    st.pop();
                }else{
                    isSmallPresent = true;
                    ns[i] = valIdx;
                    break;
                }
            }

            if(isSmallPresent==false){
                ns[i] = arr.length;
            }
            st.push(i);
        }


        // Find lagest are using NextSmall & PreviousSmall index
        // (ns-ps+1)
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            int area = (ns[i] - ps[i] -1) * arr[i];
            res = Math.max(area,res);
        }
        return res;
    }
}


class A7getMinimumInStackNaive{
    // Get min should be in O(1) time & O(N) aux space
    ArrayDeque<Integer> st = new ArrayDeque<Integer>();
    ArrayDeque<Integer> auxSt = new ArrayDeque<Integer>();

    public void push(int x){
        st.push(x);
        if(auxSt.isEmpty()==true){
            auxSt.push(x);
        }else{
            if(x<=auxSt.peek()){
                auxSt.push(x);
            }
        }
    }


    public int pop(){
        int val = st.pop();
        if(val==auxSt.peek()){
            auxSt.pop();
        }
        return val;
    }

    public int getMin(){
        if(auxSt.isEmpty()==false) {
            return auxSt.peek();
        }else{
            return Integer.MIN_VALUE;
        }
    }
}




class A7getMinimumInStackOptmised{
    // considering all elements are positive
    ArrayDeque<Integer> stack;
    int min;
    A7getMinimumInStackOptmised(){
        stack = new ArrayDeque<Integer>();
        int min = 0;
    }

    public void push(int x){
        if(min==0){
            min = x;
            stack.push(x);
            return;
        }

        // if x>= we will only push , don't update the min
        if(x>=min){
            stack.push(x);
        }else{
            stack.push(x-min);
            min = x;
        }
    }

    public int GetMin(){
        return min;
    }


    public int pop(){
        if(stack.isEmpty()==true){
            return Integer.MIN_VALUE;

        }
        int val = stack.pop();
        if(val<0){             // that a tricky part, under it twice or thrice
            int ans = min;
            min = min - val;
            return ans;
        }else{
            return val;
        }
    }

}





public class stackProblems {
    public static void main(String[] args) {
        int[] arr = {6,2,5,4,1,5,6};


        A7getMinimumInStackOptmised Obj = new A7getMinimumInStackOptmised();
        Obj.push(11);
        Obj.push(9);
        Obj.push(10);
        Obj.push(5);
        System.out.println(Obj.GetMin());
        System.out.println(Obj.pop());

        System.out.println(Obj.GetMin());
        System.out.println(Obj.pop());

        System.out.println(Obj.GetMin());
        System.out.println(Obj.pop());
        System.out.println(Obj.GetMin());




    }
}
