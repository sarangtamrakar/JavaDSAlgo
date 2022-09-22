package graphpackage;

import java.util.*;


class A1BFSTRAVERSAL{
    static ArrayList<Integer> traverse(int numberOfNodes, ArrayList<ArrayList<Integer>> adjMat){

        // storing the bfs results
        ArrayList<Integer> bfs = new ArrayList<Integer>();

        // visited arr for each nodes
        int[] visited = new int[numberOfNodes+1];   // +1 because it starts from 1

        // iterate through the each components of graph
        for(int i= 1; i<=numberOfNodes;i++){

            // if not visited then only apply bfs traversal
            if(visited[i]==0){
                // create queue for that component
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                visited[i] = 1; // mark as visited

                while(queue.isEmpty()==false){
                    Integer popped = queue.poll();
                    bfs.add(popped);
                    // getting its adjacents & putting into the queue
                    for(Integer adj : adjMat.get(popped)){
                        if(visited[adj]==0){
                            queue.offer(adj);
                            visited[adj] = 1;
                        }
                    }
                }
            }
        }
        return bfs;
    }
}



class A2DFSTraversal{
    static ArrayList<Integer> traversal(int number_of_nodes, ArrayList<ArrayList<Integer>> adjMat){

        ArrayList<Integer> dfslist =  new ArrayList<Integer>();
        int[] visited = new int[number_of_nodes+1];   // because node is starting from 1 so index should go till number of nodes idx
        for(int i = 0; i<=number_of_nodes;i++){
            dfs(i,visited,adjMat,dfslist);
        }
        return dfslist;
    }

    static void dfs(int node , int[] visited , ArrayList<ArrayList<Integer>> adjMat, ArrayList<Integer> dfslist){
        if(visited[node]==0){ // not visted till now
            dfslist.add(node);
            visited[node] = 1;
            // call dfs for its adjacent nodes
            for(Integer adj : adjMat.get(node)){
                if(visited[adj]==0){
                    visited[adj] = 1;
                    dfs(adj,visited,adjMat,dfslist);
                }
            }
        }
    }
}



class bfscycle_node{
    Integer node;
    Integer prev;
    bfscycle_node(int node,int prev){
        this.node = node;
        this.prev = prev;
    }
}


class A3BFSCycleDetectionInUnDirectedGraph{
    static boolean detect(int number_of_nodes, ArrayList<ArrayList<Integer>> adjMat){

        int[] visited = new int[number_of_nodes+1];
        for(int node = 1; node<=number_of_nodes;node++){
            if(visited[node]==0){
                if(checkForCycle(node,adjMat,visited)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }


    static boolean checkForCycle(int node, ArrayList<ArrayList<Integer>> adjMat, int[] visited){
        visited[node] = 1;
        Queue<bfscycle_node> queue  = new LinkedList<>();
        queue.offer(new bfscycle_node(node,-1));

        while(queue.isEmpty()==false){
            bfscycle_node popped = queue.poll();
            int nod = popped.node;
            int prev = popped.prev;
            // its adjacent
            for(Integer adj :adjMat.get(nod)){
                if(visited[adj]==0){
                    queue.offer(new bfscycle_node(adj,nod));
                    visited[adj] = 1;
                }else{
                    if(adj!=prev){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}



class A4DFSCycleDetectionInUnDirectedGraph{
    static boolean detect(int number_of_nodes , ArrayList<ArrayList<Integer>> adjMat){

        int[] visited = new int[number_of_nodes+1];

        for(int node = 1; node <=number_of_nodes;node++){
            if(visited[node]==0){
                visited[node] = 1;
                if(checkForCycle(node,visited,adjMat,-1)){
                    return true;
                }
            }
        }
        return false;
    }


    static boolean checkForCycle(int node , int[] visited, ArrayList<ArrayList<Integer>> adjList,int prev){

        for(Integer adj : adjList.get(node)){
            if(visited[adj]==0){
                if(checkForCycle(adj,visited,adjList,node)){
                    return true;
                }
            }else{
                if(adj!=prev){
                    return true;
                }
            }
        }
        return false;
    }
}







class A5CheckBipartiteGraphBFS{
    static boolean check(int number_of_nodes,ArrayList<ArrayList<Integer>> adjMat){

        int[] colors = new int[number_of_nodes+1];
        for(int i = 0 ; i<colors.length ; i++){
            colors[i] = -1;
        }


        for(int node =1; node<=number_of_nodes;node++){
            if(colors[node]==-1){
                colors[node] = 0;
                if(checkbipartite(node,colors,colors[node], adjMat)==false){
                    return false;
                }
            }
        }

        return true;
    }


    static boolean checkbipartite(int node,int[] colors,int currColor, ArrayList<ArrayList<Integer>> adjMat){

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);

        int adjcolor = -1;
        if(currColor==0){
            adjcolor = 1;
        }else{
            adjcolor = 0;
        }

        while(queue.isEmpty()==false){
            Integer popped = queue.poll();

            // check for its adjacent
            for(Integer adj : adjMat.get(popped)){
                if(colors[adj]==-1){
                    colors[adj] = adjcolor;
                    queue.offer(adj);
                }else{
                    if(colors[adj]==colors[popped]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}






class CheckForBipatiteGraphDFS{
    static boolean isBipartiteGraph(int number_of_nodes, ArrayList<ArrayList<Integer>> adjMat){
        int[] colors = new int[number_of_nodes+1];

        for(int i = 0 ; i<colors.length;i++){
            colors[i] = -1;
        }

        for(int node = 1; node<=number_of_nodes;node++){
            if(colors[node]==-1){
                colors[node] = 1;
                if(checkBipartite(node,colors,adjMat)==false){
                    return false;
                }
            }
        }
        return true;
    }


    static boolean checkBipartite(int node, int[] colors,ArrayList<ArrayList<Integer>> adjMat){
        // getting all the adj node
        for(Integer adj : adjMat.get(node)){
            // checking whether it is colored or not
            if(colors[node]==-1){
                colors[adj] = 1-colors[node];
                if(checkBipartite(adj,colors,adjMat)==false){
                    return false;
                }
            }
            else{
                if(colors[node]==colors[adj]){
                    return false;
                }
            }
        }
        return true;
    }
}



class A6CycleDetectInDirectedGraph{
    static boolean detect(int number_of_nodes, ArrayList<ArrayList<Integer>> adjList){

        int[] visited = new int[number_of_nodes+1];
        int[] dfsvisited  = new int[number_of_nodes+1];

        for(int node =1; node<=number_of_nodes;node++){
            if(visited[node]==0){
                if(check(node,visited,dfsvisited,adjList)){
                    return true;
                }
            }
        }
        return false;
    }


    static boolean check(int node, int[] visited,int[] dfsvisited,ArrayList<ArrayList<Integer>> adjList){

        visited[node] = 1;
        dfsvisited[node] = 1;

        for(Integer adj : adjList.get(node)){
            if(visited[adj]==0){
                visited[adj] = 1;
                if(check(adj, visited,dfsvisited,adjList)){
                    return true;
                }
            }else{
                // if visted & also visted in the dfvisted so there is cycle
                if(visited[adj]==dfsvisited[adj]){
                    return true;
                }
            }
        }
        // if cycle not detected so again by going back mark as unvisted in curr dfsvisit
        dfsvisited[node] = 0;
        return false;
    }
}




class TopologicalSortDFS{
    static ArrayDeque<Integer> sort(int num,ArrayList<ArrayList<Integer>> adjList){
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        // cretaed visited arr
        int[] visited = new int[num + 1];

        for(int node = 1; node<=num;node++){
            if(visited[node]==0){
                check(node, adjList, visited, st);
            }
        }
        return st;
    }

    static void check(int node , ArrayList<ArrayList<Integer>> adjList,int[] visited, ArrayDeque<Integer> st){

        // mark as visited
        visited[node] = 1;

        for(Integer adj : adjList.get(node)){
            if(visited[adj]==0){
                check(adj,adjList,visited,st);
            }
        }

        // if node not having any adj  then only add it to the stack
        st.add(node);

    }
}



class TopologicalSortBFS{
    // Kanh's alogorithms
    // 1 first we are creating the indegree arr
    // 2. elements those having degree 0 , push into the queue
    // 3. pop ech elemnet from queue & add to res arr ,
    // 4. ^& check its adj eleemnts , & decrese the degree by 1
    // 5. & if degree == 0 push that adj into th equque

    static ArrayList<Integer> fun1(int n , ArrayList<ArrayList<Integer>> adjList){

        // 1. creating the indegree arr from adjList
        int[] indegree = new int[n];
        for(int idx1= 0;idx1<adjList.size();idx1++){
            for(int idx2 = 0;idx2<adjList.get(idx1).size();idx2++){
                indegree[adjList.get(idx1).get(idx2)]++;
            }
        }

        // 2. create the array for bfs
        Queue<Integer> queue = new LinkedList<Integer>();

        // 3. elemnst which haing zeo degree psuh into queue
        for(int node = 0 ; node <indegree.length;node++){
            if(indegree[node]==0){
                queue.offer(node);
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        while (queue.isEmpty()==false){
            Integer popped = queue.poll();
            res.add(popped);

            for(Integer adj : adjList.get(popped)){
                indegree[adj]--;
                if(indegree[adj]==0){
                    queue.offer(adj);
                }
            }
        }

        return res;
    }
}



class shortestPathInUndirectedGraph{
    static int path(int n, ArrayList<ArrayList<Integer>> adjList, int src, int destination){

        int[] distance = new int[n];
        for(int i = 0 ; i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);
        distance[src] = 0;

        while(queue.isEmpty()==false){
            Integer popped = queue.poll();

            int adjDistance = distance[popped]+1;

            for(Integer adj : adjList.get(popped)){
                // if curr distance > adjdistance so put that value in curr distnace
                // & push that adj into queue
                if(distance[adj]>adjDistance){
                    distance[adj] = adjDistance;
                    queue.offer(adj);
                }
            }
        }

        return distance[destination];
    }
}



class pair{
    int node;
    int weight;
    pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}



class smallestDistanceBetweenNodesDirectedWeightedGraph{
    static int distance(int numNodes ,int src , int dest, ArrayList<ArrayList<pair>> adjList){


        int[] distance = new int[numNodes];
        for(int i = 0 ; i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(src);
        distance[src] = 0;

        while(queue.isEmpty()==false){
            Integer popped = queue.poll();

            for(pair adjpair : adjList.get(popped)){
                int adj = adjpair.node;
                int weight = adjpair.weight;

                if(distance[popped]+weight<distance[adj]){
                    distance[adj] = distance[popped] + weight;
                    // only offer when distance is smaller
                    queue.offer(adj);
                }
            }
        }
        return distance[dest];
    }
}


class MinimumSpanningTree{
    static void graphToTree(int num, ArrayList<ArrayList<pair>> adjList){
        // create the weight , mst and parents arr
        boolean[] mst = new boolean[num];
        int[] weight = new int[num];
        int[] parent = new int[num];
        int i = 0;


        for(i = 0 ; i<num;i++){
            weight[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mst[i] = false;
        }
        // mark first weight zero
        weight[0] = 0;

        // iterating for each edges N-1
        for(int idx = 0;idx<num-1;idx++){

            // get the minimum value in weight arr for whih mst = false
            int mini = Integer.MAX_VALUE; int node = 0;
            for(i = 0 ; i<num;i++){
                if(mst[i]==false && weight[i]<mini){
                    mini = weight[i];
                    node = i;
                }
            }

            // mark mst == true
            mst[node] = true;

            // look for its adj
            for(pair adjPair : adjList.get(node)){
                if(mst[adjPair.node]==false && adjPair.weight <weight[adjPair.node]){
                    weight[adjPair.node] = adjPair.weight; // update the weight
                    parent[adjPair.node] = node; // update the parent
                }
            }
        }

        // print tree
        for(i = 0 ; i<parent.length;i++){
            System.out.println(i +" - " + parent[i]);
        }
    }
}




class DisjointSet{
    static int[] parent = new int[100];
    static int[] rank = new int[100];

    static void makeSet(){
        for(int i = 0 ; i<parent.length; i++){
            // each elemnt is itself parent
            parent[i]  = i;
            // rank of each elemnt initially is 0
            rank[i] = 0;
        }
    }


    static int getParent(int node){
        if(parent[node]==node){
            return node;
        }
        // follow struver video to understand
        // because of path compression we are doing the parent[node]
        return parent[node] = getParent(parent[node]);
    }


    static void findUnion(int node1 , int node2){
        // first fid their parents
        int u  = getParent(node1);
        int v = getParent(node2);

        // & now find the rank of their parent
        // if rank of u > v so u is parent of v

        if(rank[u]>rank[v]){
            parent[v] = u;
        }else if(rank[v]>rank[u]){
            parent[u] = v;
        }else{
            // if both the rank are same so incerese the rank of any one of them
            parent[v] = u;
            rank[u]++;
        }

        if(parent[u]==parent[v]){
            System.out.println("yes they belongs to same components");
        }else{
            System.out.println("No . they dont belongs to same components");
        }
    }

}




public class problemsOfGraph {
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


        DisjointSet.makeSet();
        DisjointSet.findUnion(2,3);


    }
}














