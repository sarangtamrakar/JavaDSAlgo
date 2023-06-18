package hashPackage;

import java.util.HashSet;
import java.util.Iterator;

public class basicHashSet {
    public static void main(String[] args){


        // haset having few main functions:-
        // 1. add
        // 2. contains
        // 3. Iterator
        // 4. size
        // 5. remove
        // 6. isEmpty
        // 7. clear







        HashSet<String> hash = new HashSet<String>();

        // 1. add
        // it return true if item added to hashset
        //  if any key already present it will not add , return false
        hash.add("Sarang");
        hash.add("Tamrakar");
//        System.out.println(hash);




        // 2. contains
        // if keys present return true else return false
        boolean res = hash.contains("sarang");
//        System.out.println(res);




        // 3. iterator
        // how to iterate
        // 1st way
        Iterator<String> itr = hash.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 2nd way
        for(String s:hash){
            System.out.println(s);
        }


        // 4. size()
        System.out.println(hash.size());

        // 5. remove
        // it will remove the item if it is present there & return true
        // otherwise it will return false
        boolean res2 = hash.remove("Sarang");
        System.out.println(res2);

        // 6. isEmpty()
        // if hash-set contains any item it return false
        // otherwise it return true
        boolean res3 = hash.isEmpty();
        System.out.println(res3);


        // 7. clear
        // it function will remove all the hashSet
        hash.clear();
        System.out.println(hash.size());


    }

}
