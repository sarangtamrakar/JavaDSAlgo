package hashPackage;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class rough {
    public static void main(String[] args){
        int[] arr = {30,10,20,30,30,40,30,40,30};
        MorethanOccurrences(arr,2);

    }

    static void NaiveMethod(int[] arr,int k){

        int n = arr.length;
        for(int i = 0; i<(n-(k-1));i++){
            HashSet<Integer> hset = new HashSet<Integer>();
            for(int j = i;j<i+k;j++){
                hset.add(arr[j]);
            }
            System.out.println(hset.size());
        }
    }

    static void Optimised(int[] arr,int k){
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int n = arr.length;
        for(int i = 0 ; i<k;i++){
            if(hmap.containsKey(arr[i])){
                hmap.put(arr[i],hmap.get(arr[i])+1);
            }else{
                hmap.put(arr[i],1);
            }
        }

        System.out.println(hmap.size());

        for(int j = k;j<n;j++){
            //next value
            if(hmap.containsKey(arr[j])){
                hmap.put(arr[j],hmap.get(arr[j])+1);
            }else{
                hmap.put(arr[j],1);
            }

            // previous value
            if(hmap.containsKey(arr[j-k])){
                hmap.put(arr[j-k],hmap.get(arr[j-k])-1);
            }
            // if freq is 0 remove that element from hmap
            if(hmap.get(arr[j-k])==0){
                hmap.remove(arr[j-k]);
            }
            System.out.println(hmap.size());
        }
    }


    static void MorethanOccurrences(int[] arr,int k){
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

        for(int i = 0; i<arr.length;i++){
            int val = arr[i];
            if(hmap.containsKey(val)){
                hmap.put(val,hmap.get(val)+1);
            }else{
                hmap.put(val,1);
            }
        }

        

        int count = (arr.length/k);
        for(Integer e : hmap.keySet()){
            if(hmap.get(e)>count){
                System.out.println(e);
            }
        }
    }

}
