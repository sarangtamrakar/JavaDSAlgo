package graphpackage;

import java.util.*;


public class rough {
    public static void main(String[] args){
        ArrayList<ArrayList<pair>> AdjList = new ArrayList<ArrayList<pair>>();
        int num = 6;
        // add num arrList into the
        for(int i = 0 ; i<num;i++){
            AdjList.add(new ArrayList<pair>());
        }

        AdjList.get(0).add(new pair(1,2));
        AdjList.get(0).add(new pair(4,1));
        AdjList.get(1).add(new pair(2,3));
        AdjList.get(2).add(new pair(3,6));
        AdjList.get(4).add(new pair(2,2));
        AdjList.get(4).add(new pair(5,4));
        AdjList.get(5).add(new pair(3,1));





        int res = smallestDistanceBetweenNodesDirectedWeightedGraph.distance(6,0,3,AdjList);
        System.out.println(res);


    }
}


