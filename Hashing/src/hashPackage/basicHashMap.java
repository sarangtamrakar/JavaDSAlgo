package hashPackage;
import java.util.HashMap;



public class basicHashMap {
    public static void main(String[] args){


        // function
        // 1. put
        // 2. containsKey
        // 3. containsValue
        // 4. get
        // 5. size
        // 6. remove
        // 7. clear
        // 8. iterate ==> hmap.keysSets()   ==> hmap.values()



        // create HashMap
        HashMap<String,Integer> hmap = new HashMap<String,Integer>();



        // 1. put
        hmap.put("Sarang",23);
        hmap.put("kalyani",23);
        hmap.put("Adarsh",20);
        hmap.put("Gunnu",16);

        // 2. containsKey
        boolean isThere = hmap.containsKey("babu");
        System.out.println(isThere);

        // 3. containsValue
        boolean isPresent = hmap.containsValue(23);
        System.out.println(isPresent);

        // 3. size
        System.out.println(hmap.size());


        // 4. get
        int res = hmap.get("Sarang");
        System.out.println(hmap.get("Sarang"));


        // 5. remove
        // if something is removed that will return removed element other wise return null
        Integer isremoved = hmap.remove("Sarang");
        System.out.println(isremoved);

        // 6. size
        System.out.println(hmap.size());


        // 7. iterate only keys
        for(String s : hmap.keySet()){
            System.out.println(s);
        }



        // 8. iterate only values
        for(Integer s : hmap.values()){
            System.out.println("values : " + s);
        }



        // iterate keys & values
        for(String s : hmap.keySet()){
            System.out.println("Names : "+s+" , age : "+hmap.get(s));
        }


        // 9. isEmpty()
        System.out.println(hmap.isEmpty());



    }

}













