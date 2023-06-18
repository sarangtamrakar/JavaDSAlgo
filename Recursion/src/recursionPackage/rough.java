package recursionPackage;


import java.util.ArrayList;

class printNameNtimes{
    static void fun1(int n,String name,int i){
        if(i==n){
            return;
        }
        System.out.println(name);
        fun1(n,name,i+1);
    }
}


class Print1ToN{
    static void fun1(int n,int i){

        if(i>n){
            return;
        }

        System.out.println(i);
        fun1(n,i+1);
    }
}

class PrintNto1{
    static void fun1(int n , int i){
        if(i<1){
            return;
        }

        System.out.println(i);
        fun1(n,i-1);
    }
}


class SumofNNumbers{
    static int fun1(int n , int x){
        if(n==0){
            return x;
        }
        return fun1(n-1,x+n);
    }
}



class ReverseTheArray{
    static int[] fun1(int[] arr,int l, int r){
        if(l>=r){
            return arr;
        }

        // swap
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return fun1(arr,l+1,r-1);

    }
}


class NthFabonacciNumber1{
    static int fun1(int n){

        if(n == 0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        return fun1(n-1) + fun1(n-2);
    }
}



class PrintAllSubsequences{
    static void fun1(int[] arr, ArrayList<Integer> res , int idx) {
        // 1. Base Case
        // 2. add element arr[i] in to res arr;
        // 3. fun(idx+1,res)
        // 4. remove that arr[i] from res
        // 5. fun(idx+1,res)

        if (idx == arr.length) {

            if(res.size()==0){
                System.out.print("{}");
                System.out.println();
                return;
            }

            for (Integer e : res) {
                System.out.print(e);

            }
            System.out.println();
            return;
        }

        res.add(arr[idx]);

        fun1(arr, res, idx + 1);

        res.remove(res.size() - 1);   // it always takes index not value
        fun1(arr, res, idx + 1);
    }
}




public class rough {
    public static void main(String[] args) {

        int[] arr = {0,1,2,4,5};
        ArrayList<Integer> res = new ArrayList<>(arr.length);
        PrintAllSubsequences.fun1(arr,res,0);

    }
}