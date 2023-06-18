package arrayPackage;

import java.util.ArrayList;
import java.util.Collections;

public class arrayBasic {
    public static void main(String[] args){


//        System.out.println(arr);
        FunctionsOfArrays.fun1(10);
    }
}


class FunctionsOfArrays{
    static void fun1(int n){

        // creation of array
        ArrayList<String> strArr = new ArrayList<String>();

        // other non primitive data type
//        Integer;
//        Character;
//        String;
//        Long;
//        Double;
//        Float;
//


        // add function
        strArr.add("tarang");
        strArr.add("samrakar");


        // add at certain index , o/p = ["pagal","Sarang","Tamrakar"]
        strArr.add(0,"pagal");
        System.out.println(strArr);


        // access or  get the element by calling the index
        System.out.println(strArr.get(0));

        // change or update the item
        strArr.set(0,"Intelligent");
        System.out.println(strArr);

        // remove an item of certain index
        strArr.remove(0);
        System.out.println(strArr);


        // remove all elements of array
        //strArr.clear();

        // find length of of array
        System.out.println(strArr.size());





        // loop (Iterate)through the array


        int i = 0;
        while(i<strArr.size()){
            System.out.println(strArr.get(i));
            i++;
        }


        for(int j=0; j<strArr.size();j++){
            System.out.println(strArr.get(j));
        }

        for(String k : strArr){
            System.out.println(k);
        }
        Collections.sort(strArr);
        System.out.println(strArr);


    }
}