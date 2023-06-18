package graphpackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class basicOfGraph {
    public static void main(String[] args){

        int numofOfNodes = 5;
        int[][] mat = new int[numofOfNodes+1][numofOfNodes+1];

        // edge between 1 -2
        mat[1][2] = 1;
        mat[2][1] = 1;

        // edge between 2-3
        mat[2][3] = 1;
        mat[3][2] = 1;

        // it will take O(N2) space
        for(int i = 0 ; i<mat.length;i++){
            for(int j = i;j<mat[i].length;j++){
                System.out.println(mat[i][j]==1);
            }
        }





        // graph arr list implementation

        ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();

        // creating black arr list inside arr list
        for(int i = 0 ; i<=numofOfNodes;i++){  // == is very imp is graph satrting from 1 index
            arrList.add(new ArrayList<Integer>());  /// inserting blank arr list
        }

        // edge between 1-2
        arrList.get(1).add(2);
        arrList.get(2).add(1);

        // edge between 2-3
        arrList.get(2).add(3);
        arrList.get(3).add(2);


        for(int i = 0 ; i<arrList.size();i++){
            for(int j = 0 ; j<arrList.get(i).size();j++){
                System.out.println(arrList.get(i).get(j));
            }
        }

    }
}



class BFSTraversalOfGraph{
    static ArrayList<Integer> traverse(int numNodes , ArrayList<ArrayList<Integer>> adjList){
        // bfs store arr
        ArrayList<Integer> bfs = new ArrayList<Integer>();

        // visited arr
        int[] visited = new int[numNodes+1];

        // now iterate through the each component of graph
        for(int i = 1; i <=numNodes;i++) {
            if (visited[i] == 0) {
                Queue<Integer> queue = new LinkedList<Integer>();

                queue.offer(i);
                visited[i] = 1;

                while (queue.isEmpty() == false) {
                    Integer popped = queue.poll();
                    bfs.add(popped);

                    // now get the adjacent of the node i
                    for (Integer adj : adjList.get(popped)) {

                        if (visited[adj] == 0) { // if not visted then only push to queue
                            visited[adj] = 1; // mark as visted
                            queue.offer(adj); // push into queue
                        }
                    }
                }
            }
        }
        return bfs;
    }
}




