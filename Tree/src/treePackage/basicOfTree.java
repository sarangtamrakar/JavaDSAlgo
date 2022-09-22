package treePackage;

import javax.sound.sampled.Line;
import java.util.*;


class Node{
    int key;
    Node left;
    Node right;
    Node(int x){
        this.key = x;
    }
}


class A1InorderTraversal{
    // left root right
    static void traverse(Node root){
        if(root==null){
            return;
        }
        // go to left
        traverse(root.left);
        // print root
        System.out.println(root.key);
        // go to right
        traverse(root.right);
    }
}



class A2PreorderTraversal{
    static void traverse(Node root){
        // root , left, right
        if(root==null){
            return;
        }
        System.out.println(root.key);
        traverse(root.left);
        traverse(root.right);
    }
}


class A3PostorderTraversal{
    static void traverse(Node root){
        // l, r , root
        if(root==null){
            return;
        }
        traverse(root.left);
        traverse(root.right);
        System.out.println(root.key);
    }
}



class A4HeightOfBinaryTree{
    // parametric way
    static int fun1(Node root,int res){
        if(root==null){
            return res;
        }

        int leftHeight = fun1(root.left,res+1);
        int rightheight = fun1(root.right,res+1);
        // return whatever the max height between left & right
        return Math.max(leftHeight,rightheight);
    }

    // functional way
    static int fun2(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = fun2(root.left) + 1;
        int rightheight = fun2(root.right) +1;
        // return the maximum of left height & right height
        return Math.max(leftHeight,rightheight);
    }
}


class A5PrintNodeAtKDistance{
    static void fun1(Node root,int currDistance,int givendistance){
        if(root==null){
            return;
        }
        if(currDistance==givendistance && root!=null){
            System.out.println(root.key);
            return;
        }

        fun1(root.left,currDistance+1,givendistance);
        fun1(root.right,currDistance+1,givendistance);

    }

    //can also be solved using bfs /
    // we will print the element if levelIdx === k'
}






class A6LevelOrderTraversal{
    // without line by line
    static void fun1(Node root){
        Queue<Node> queue = new ArrayDeque<Node>();
        if(root==null){
            return;
        }
        queue.add(root);

        while(queue.isEmpty()==false){
            Node node = queue.poll();
            System.out.println(node.key);

            if(node.left!=null) {
                queue.offer(node.left);
            }
            if(node.right!=null) {
                queue.offer(node.right);
            }
        }
    }
}


class A7LevelOrderTraversalLineByLine{
    // O(N) time & o(Width) space
    static void fun1(Node root){
        if(root==null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while(queue.size()>1){
            Node node = queue.poll();
            if(node==null){
                System.out.println();
                queue.offer(null);
                continue;
            }

            System.out.print(node.key);

            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    static void fun2(Node root){
        // O(N) solution  & O(width) of tree
        if(root==null){
            return;
        }

        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);

        while(queue.isEmpty()==false){
            int size = queue.size();
            for(int idx = 0; idx<size;idx++){
                Node node =queue.poll();
                System.out.print(node.key);

                if(node.left!=null){
                    queue.offer(node.left);
                }

                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
}




class A8SizeOfBinaryTree{
    static int fun1(Node root){
        // recursive way , Using post order traversal
        if(root==null){
          return 0;
        }
        return fun1(root.left) + fun1(root.right) + 1;
    }

    static int fun2(Node root){
        // using label order traversal
        if(root==null){
            return 0;
        }
        // using queue
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        int count = 0;
        while(queue.isEmpty()==false){
            Node node = queue.poll();
            count++;

            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return count;
    }
}


class A9MaximumInBinaryTree{
    static int fun1(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(fun1(root.left) , fun1(root.right)),root.key);
    }
}



class A10IterativePreOrderTraversal{
    static void fun1(Node root){
        if(root==null){
            return;
        }

        ArrayDeque<Node> st = new ArrayDeque<Node>();

        st.push(root);

        while(st.isEmpty()==false){
            Node poppedElement = st.pop();
            System.out.println(poppedElement.key);

            if(poppedElement.right!=null){
                st.push(poppedElement.right);
            }

            if(poppedElement.left!=null){
                st.push(poppedElement.left);
            }
        }
    }
}




class A11IterativeInorderTraversal{
    // go through again with breaking condition of while loop
    // O(N) time && O(N) space or O(height) of tree space 
    static void fun1(Node root){
        // left root right
        if(root==null){
            return;
        }

        ArrayDeque<Node> st = new ArrayDeque<Node>();

        Node curr = root;
        while(true){

            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }else if(curr==null){
                if(st.isEmpty()==true) break;
                Node popped = st.pop();
                System.out.println(popped.key);
                curr = popped.right;
            }
        }
    }
}




class A12IterativePostOrderTraversal{
    // using two stack
    static void fun1(Node root){
        if(root==null){
            return;
        }
        ArrayDeque<Node> st1 = new ArrayDeque<Node>();
        ArrayDeque<Node> st2 = new ArrayDeque<Node>();

        st1.push(root);
        while(st1.isEmpty()==false){
            Node popped = st1.pop();
            if(popped.left!=null){
                st1.push(popped.left);
            }

            if(popped.right!=null){
                st1.push(popped.right);
            }

            st2.push(popped);
        }

        for(Node e:st2){
            System.out.println(e.key);
        }

    }
}


class A13IterativePostOrderTraversal1Stack{
    // using single stack
    static void fun1(Node root){

        if(root==null){
            return;
        }

        ArrayDeque<Node> st = new ArrayDeque<Node>();

        Node curr = root;

        while(curr!=null || st.isEmpty()==false){

            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp !=null){
                    curr = temp;
                }

                // Very tricky understood by striver again & do some dry run
                else{
                    temp = st.pop();
                    System.out.println(temp.key);
                    while(st.isEmpty()==false && st.peek().right == temp){
                        temp = st.pop();
                        System.out.println(temp.key);
                    }
                }
            }
        }
    }
}



class A14leftViewOfTree{

    static int maxLabel = 0;
    static void fun1(Node root,int label){
        if(root==null){
            return;
        }
        if(maxLabel<label){
            System.out.println(root.key);
            maxLabel++;
        }

        if(root.left!=null){
            fun1(root.left,label+1);
        }

        if(root.right!=null){
            fun1(root.right,label+1);
        }
    }

    static void fun2(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.isEmpty()==false){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                Node popped = queue.poll();
                if(i==0){
                    System.out.println(popped.key);
                }

                if(popped.left!=null){
                    queue.offer(popped.left);
                }

                if(popped.right!=null) {
                    queue.offer(popped.right);
                }

            }
        }

    }
}



class A15CheckForChildrenSumProperty{
    static boolean fun1(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        int sum = 0;
        if(root.left!=null){
            sum = sum + root.left.key;
        }
        if(root.right!=null){
            sum = sum + root.right.key;
        }

        return (root.key==sum && fun1(root.left) && fun1(root.right));
    }
}



class A16CheckForBalancedBT1{
    // O(N2) solution
    static boolean fun1(Node root) {
        if (root == null) {
            return true;
        }

        int Lh = Height(root.left);
        int rh = Height(root.right);

        if((Math.abs(Lh - rh))>1){
           return false;
        }

        boolean left = fun1(root.left);
        boolean right = fun1(root.right);

        if(left==false || right==false){
            return false;
        }

        return true;
    }

    static int Height(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(Height(root.left) , Height(root.right))+1;
    }
}



class A17CheckForBalancedBT2{
    // very good solution O(N) time
    static boolean fun1(Node root) {
        if (HeightOfTree(root) == -1) {
            return false;
        } else return true;
    }


    static int HeightOfTree(Node root){
        // if tree is balanced so return height of tree otherwise return -1;
        if(root==null){
            return 0; // return 0 instead of Integer.MIN_VALUE
        }

        int Lh = HeightOfTree(root.left);
        int rh = HeightOfTree(root.right);

        // best cases
        if(Lh==-1 || rh==-1){
            return -1;
        }

        if(Math.abs(Lh-rh)>1){
            return -1;
        }

        return Math.max(Lh,rh)+1;

    }
}



class A18DiameterOfBT1{
    // O(n2) solution
    static int maxDiameter = 0;
    static void NaiveApproach(Node root){
        // we go to each node & find lh & rh  , maxDiameter = lh + rh
        if(root==null){
            return;
        }

        int lh = FindHeight(root.left);
        int rh =FindHeight(root.right);

        maxDiameter = Math.max(maxDiameter,lh + rh);

        NaiveApproach(root.left);
        NaiveApproach(root.right);

    }

    static void printMaxDiameter(){
        System.out.println(maxDiameter);
    }

    static int FindHeight(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        int lh = FindHeight(root.left);
        int rh = FindHeight(root.right);

        return Math.max(lh,rh) +1;
    }
}

class A19DiameterOfBT2{
    // O(N) solution
    static int fun1(Node root,int[] maxDiameter){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        int lh = fun1(root.left,maxDiameter);
        int rh = fun1(root.right,maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0],lh+rh);
        return Math.max(lh,rh) + 1;
    }
}


class A20MaximumPathSumInBT{
    static int fun1(Node root, int[] arr){
        if(root==null){
            return 0;
        }

        int lh = Math.max(fun1(root.left,arr) ,0);
        int rh = Math.max(fun1(root.right,arr),0);
        int sum = root.key + lh + rh;
        arr[0] = Math.max(arr[0],sum);
        return root.key + Math.max(lh,rh);
    }
}



class A21CheckTreesIdenticalOrNot{
    static boolean fun1(Node t1, Node t2){
        if(t1==null || t2==null){
            return (t1==t2);
        }

        return (t1.key==t2.key && fun1(t1.left,t2.left) && fun1(t1.right,t2.right));
    }
}



class A22ZigZagTraversal{
    static ArrayList<int[]> fun1(Node root){
        ArrayList<int[]> res = new ArrayList<int[]>();
        if(root==null){
            return res;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        boolean flag = true;


        while(queue.isEmpty()==false){
            int index = 0;
            int size = queue.size();
            int[] arr = new int[size];
            for(int i = 0; i<size;i++){

                // popped element
                Node popped = queue.poll();

                // checking flag
                if(flag==true){
                    index = i; // fill arr from front
                }else{
                    index = size-i-1; // fill arr from last
                }

                // fill arr of int
                arr[index]=popped.key;

                // pushing left & right into queue
                if(popped.left!=null){
                    queue.offer(popped.left);
                }
                if(popped.right!=null){
                    queue.offer(popped.right);
                }
            }
            // change the flag
            flag = !flag;
            // add arr to res arr
            res.add(arr);
        }
        return res;
    }
}




class A23BoundryTraversal{
    static boolean isLeafNode(Node root){
        if(root.left==null && root.right==null){
            return  true;
        }else {
            return false;
        }
    }

    static ArrayList<Integer> addLeftBoundry(Node root,ArrayList<Integer> arr){

        Node curr = root;
        while(curr!=null){
            if(isLeafNode(curr)==false) {
                arr.add(curr.key);
            }

            if(curr.left!=null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }

        }
        return arr;
    }

    static ArrayList<Integer> addLeafNode(Node root,ArrayList<Integer> arr){
        // preorder traversal
        if(isLeafNode(root)==true){
            arr.add(root.key);
        }

        if(root.left!=null) addLeafNode(root.left,arr);
        if(root.right!=null) addLeafNode(root.right,arr);
        return arr;
    }


    static ArrayList<Integer> addRightBoundary(Node root,ArrayList<Integer> arr){
        ArrayList<Integer> temp = new ArrayList<Integer>();

        Node curr = root;
        while(curr!=null){
            if(isLeafNode(root)==false) temp.add(curr.key);
            if(root.left!=null) curr = curr.left;
            else curr = curr.right;
        }

        // reverse the sequence bottom to top
        int n = temp.size();
        for(int i= n-1; i>=0;i--){
            arr.add(temp.get(i));
        }
        return arr;
    }

    static void fun1(Node root){
        if(root==null){
            return;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(isLeafNode(root)==false) res.add(root.key);

        // add left boundry
        res = addLeftBoundry(root.left,res);

        // add leaf node
        res = addLeafNode(root,res);

        // add right boundry in reverse
        res = addRightBoundary(root.right,res);


        for (Integer e:res){
            System.out.println(e);
        }
    }

}

// for vertical traversal
class verticalNode{
    Node root;
    int v;
    int h;
    verticalNode(Node root, int v , int h) {
        this.root = root;
        this.v = v;
        this.h = h;
    }
}



class A24VerticalLevelTraversal{
    static void fun1(Node root){

        if(root==null){
            return;
        }
        // creting queue ds
        Queue<verticalNode> queue = new LinkedList<verticalNode>();
        verticalNode node = new verticalNode(root,0,0);
        queue.offer(node);




        verticalNode curr = node;
        while(queue.isEmpty()==false){
            verticalNode popped = queue.poll();

            int v = popped.v;
            int h = popped.h;
            Node rot = popped.root;

            System.out.println(Integer.toString(v)+ Integer.toString(h)+Integer.toString(rot.key));

            // push left to queue
            if(rot.left!=null){
                queue.offer(new verticalNode(rot.left,v-1,h+1));
            }
            // push right to queue
            if(rot.right!=null){
                queue.offer(new verticalNode(rot.right,v+1,h+1));
            }

        }

    }
}



class A25TopViewOfTree{
    static HashMap<Integer,HashMap<Integer,Integer>> fun1(Node root){
        // crete hmp for results
        HashMap<Integer,HashMap<Integer,Integer>> hmap = new HashMap<>();

        // queue for processing label order traversal
        Queue<verticalNode> queue = new LinkedList<>();

        // putting root node with v , h in queue
        verticalNode node = new verticalNode(root,0,0);

        queue.offer(node);


        while(queue.isEmpty()==false) {
            verticalNode popped = queue.poll();

            int v = popped.v;
            int h = popped.h;
            Node rot = popped.root;

            if(!hmap.containsKey(v)){
                hmap.put(v,new HashMap<>());
                hmap.get(v).put(h,rot.key);
            }

            if(rot.left!=null){
                queue.offer(new verticalNode(rot.left,v-1,h+1));
            }

            if(rot.right!=null){
                queue.offer(new verticalNode(rot.right,v+1,h+1));
            }
        }
        return hmap;
    }
}





class BottomNode{

    int v;
    Node root;
    BottomNode(int v, Node root){
        this.v = v;
        this.root = root;
    }
}


class A26BottomViewOfTree{
    static HashMap<Integer,Integer> fun1(Node root){
        HashMap<Integer,Integer> hmap = new HashMap<>();

        if(root==null){
            return hmap;
        }

        Queue<BottomNode> queue = new LinkedList<>();
        BottomNode node = new BottomNode(0,root);
        queue.offer(node);


        while(queue.isEmpty()==false){
            BottomNode popped = queue.poll();
            Node rot = popped.root;
            int v = popped.v;

            // push elements into the queue
            if(popped.root.left!=null) queue.offer(new BottomNode(v-1,rot.left));
            if(popped.root.right!=null) queue.offer(new BottomNode(v+1,rot.right));
            // put data into the hmap
            hmap.put(v,rot.key);
        }

        return hmap;

    }
}


class A27RSOFBT{
    static void fun1(Node root){

        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.isEmpty()==false){

            int size = queue.size();

            for(int i = 0; i<size;i++){
                Node popped = queue.poll();

                if(popped.left!=null) queue.offer(popped.left);
                if(popped.right!=null) queue.offer(popped.right);

                if(i ==size-1){
                    System.out.println(popped.key);
                }
            }
        }
    }
}

class A28rightViewRecursiveWay{
    // striver method
    // preorder trversal  ==> rooot right left
    static ArrayList<Integer> fun1(Node root,ArrayList<Integer> arr, int label){

        if(root==null){
            return arr;
        }

        if(arr.size()==label){
            arr.add(root.key);
        }

        fun1(root.left,arr,label+1);
        fun1(root.right,arr,label+1);

        return arr;

    }
}

class A29CheckForSymmetrical{
    static boolean fun1(Node root1, Node root2){

        if(root1==null || root2==null){
            return (root1==root2);
        }

        // go to left
        boolean leftres = fun1(root1.left,root2.right);
        // got to right
        boolean rightres = fun1(root1.right,root2.left);
        // check current key &
        return (root1.key== root2.key && leftres==true && rightres==true);

    }
}



class A30printRootToNode{
    static boolean fun1(Node root,ArrayList<Integer> arr , int key){
        if(root==null){
            return false;
        }
        arr.add(root.key);

        if(root.key==key){
            return true;
        }

        boolean lr = fun1(root.left,arr,key);
        boolean rr = fun1(root.right,arr,key);

        if(lr==false && rr ==false){
            arr.remove(arr.size()-1);
            return false;
        }
        return true;
    }
}



class A31LowestCommonAncestor{
    static Node fun1(Node root,Node n1, Node n2){
        // pre order traversal
        if(root==null){
            return  root;
        }
        // compare nodes
        if(root==n1){
            return n1;
        }
        if(root==n2){
            return n2;
        }

        Node lr = fun1(root.left,n1,n2);
        Node rr = fun1(root.right,n1,n2);

        if(lr==null){
            return  rr;
        }
        else if(rr==null){
            return lr;
        }
        else return root;
    }
}


class WidthNode{
    Node root;
    int idx;
    WidthNode(Node root,int idx){
        this.root = root;
        this.idx = idx;
    }
}





class A32maximumWidthOfBinryTree{
    // gfg question
    static int fun1(Node root){
        if(root==null){
            return 0;
        }
        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.isEmpty()==false){
            int size = queue.size();
            res = Math.max(res,size);

            for(int i = 0 ; i<size;i++){
                Node popped = queue.poll();

                if(popped.left!=null){
                    queue.offer(popped.left);
                }
                if(popped.right!=null){
                    queue.offer(popped.right);
                }
            }
        }
        return res;
    }

    // leetcode question indexing based
    static int fun2(Node root){
        // further optmization needed of curridx , see striver video
        if(root==null){
            return 0;
        }
        int res = 0;

        Queue<WidthNode> queue = new LinkedList<>();
        queue.offer(new WidthNode(root,0));

        while(queue.isEmpty()==false){
            // take the first left most idx of that level
//            int minIdx = queue.peek().idx;
            int size = queue.size();
            int firstIdx = 0;
            int lastidx = 0;
            for(int i = 0 ; i<size;i++){
                // pop th element
                WidthNode popped = queue.poll();
                int currIdx = popped.idx;
                Node currNode = popped.root;

                // now push left elemnet
                // 2*1+1
                if(currNode.left!=null) {
                    queue.offer(new WidthNode(currNode.left, currIdx * 2 + 1));
                }
                // 2*i+2
                if(currNode.right!=null) {
                    queue.offer(new WidthNode(currNode.right, currIdx * 2 + 2));
                }
                if(i==0){
                    firstIdx = currIdx;
                }
                if(i==size-1){
                    lastidx = currIdx;
                }
            }
            res = Math.max(res,lastidx-firstIdx+1);

        }
        return res;
    }
}


class A33CovertBinaryTreeToCSP{
    // convert binary tree to childern sum property
    static void fun1(Node root){

        if(root==null){
            return;
        }

        int sum = 0;
        if(root.left!=null){
            sum = sum + root.left.key;
        }
        if(root.right!=null){
            sum = sum + root.right.key;
        }


        if(sum>=root.key){
            root.key = sum;
        }else{
            if(root.left!=null) root.left.key = root.key;
            if(root.right!=null) root.right.key = root.key;
        }

        // call for left
        fun1(root.left);
        // call for right
        fun1(root.right);

        // after come back from left & right, left & right will be updated
        // again upadate the root value
        int sum2 = 0;
        if(root.left!=null){
            sum2 = sum2 + root.left.key;
        }
        if(root.right!=null){
            sum2 = sum2 + root.right.key;
        }

        // except leaf node
        if(root.left!=null || root.right!=null){
            root.key = sum2;
        }
    }
}



// do it again very good problem
class A34printAllTheNodesAtDistanceK{
    static void getParentInfo(Node root,HashMap<Node,Node> map){
        if(root==null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(queue.isEmpty()==false){
            Node popped = queue.poll();

            if(popped.left!=null){
                queue.offer(popped.left);
                map.put(popped.left,popped);
            }

            if(popped.right!=null){
                queue.offer(popped.right);
                map.put(popped.right,popped);
            }
        }

    }

    static void printAllNodes(Node root, Node target, int Distance){
        // for outer traversal from node we should knw it parents
        // get the ready parents int the map
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        getParentInfo(root,map);

        // create the visited map
        HashMap<Node,Boolean> visited = new HashMap<Node,Boolean>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(target);
        visited.put(target,true);
        int currDistance = 0;

        while(queue.isEmpty()==false){

            if(currDistance==Distance){
                break;
            }
            currDistance++;

            // move to the outwards
            int size = queue.size();

            for(int i = 0 ; i<size;i++){
                Node popped = queue.poll();
                // go left
                if(popped.left!=null && visited.get(popped.left)==null){
                    // mark as visited
                    visited.put(popped.left,true);
                    queue.offer(popped.left);
                }
                // go right
                if(popped.right!=null && visited.get(popped.right)==null){
                    // mark as visited
                    visited.put(popped.right,true);
                    queue.offer(popped.right);
                }

                // Go upper side
                if(map.get(popped)!=null && visited.get(map.get(popped))==null){
                    visited.put(map.get(popped),true);
                    queue.offer(map.get(popped));
                }
            }
        }

        // now whatever remain in the queue is Ans..
        for(Node node : queue){
            System.out.println(node.key);
        }
    }
}


class A35MinimumTimeTakenToBurnBT{
    static int fun1(Node root,Node target) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();

        map = getParentInfo(root, map);

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
        // push target into queue for bfs
        queue.offer(target);
        // mark as visited
        visited.put(target, true);
        int res = 0;
        while(queue.isEmpty() == false){
            int size = queue.size();
            int val = 0;
            for (int i = 0; i < size; i++) {
                Node popped = queue.poll();
                // process left
                if (popped.left != null && visited.get(popped.left) == null) {
                    queue.offer(popped.left);
                    visited.put(popped.left, true);
                    val++;
                }

                // processed right
                if (popped.right != null && visited.get(popped.right) == null) {
                    queue.offer(popped.right);
                    visited.put(popped.right, true);
                    val++;
                }
                // processed parents if they not visited
                if(map.get(popped)!=null && visited.get(map.get(popped))==null){
                    queue.offer(map.get(popped));
                    visited.put(map.get(popped),true);
                    val++;
                }
            }
            // if any one of then burned then only update the result
            if(val>0){
                res += 1;
            }
        }
        return res;
    }

    static HashMap<Node,Node> getParentInfo(Node root,HashMap<Node,Node> map){

        // queue for BFS
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(queue.isEmpty()==false){
            Node popped = queue.poll();

            if(popped.left!=null){
                queue.offer(popped.left);
                map.put(popped.left,popped);
            }

            if(popped.right!=null){
                queue.offer(popped.right);
                map.put(popped.right,popped);
            }
        }
        return map;
    }
}



class A36NumberOfNodesInCompleteBinaryTree{

    // (log(N))2 time complexity
    static int fun1(Node root){
        if (root==null){
            return 0;
        }

        int lh = fun1(root.left);
        int rh = fun1(root.right);

        // if right h & left h is equal so return 2^h -1;
        if(lh==rh){
            int height = lh +1;
            // return (2<<height)-1;
            return (int)Math.pow((double) 2,(double)height)-1;  // 2^H -1
        }

        // otherwise call for left & right

        int leftCount = fun1(root.left);
        int rightCount = fun1(root.right);

        return leftCount  + rightCount + 1;

    }

    static int findHeight(Node root){
        if(root==null){
            return 0;
        }

        return findHeight(root.left) + findHeight(root.right) + 1;
    }
}



class A37ConstructBinaryTreeFromPreOrderInorder{
    // O(N) solution
    static Node CraeteUniqueTree(int[] preorder, int[] inorder){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        // create the inorder map to get index of root elemnt in O(1) in
        for(int i = 0 ; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        // build the unique tree from reorder & inorder
        Node root = BuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }


    static Node BuildTree(int[] preorder, int preStart, int preEnd, int[] inorder,int inStart, int inEnd, HashMap<Integer,Integer> inMap){

        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        Node root = new Node(preorder[preStart]);
        // find root index int inorder map
        int idxRoot = inMap.get(root.key);

        int numLeft = idxRoot-inStart;

        // Build the tree for left with remaining element except root
        // left :- prestart  = prestart +1
        //         preEnd = prestart + numleft
        //         instart  = instart
        //         InEnd = idxRoot-1

        root.left = BuildTree(preorder,preStart+1,preStart+numLeft,inorder,inStart,idxRoot-1,inMap);

        // Build the tree for right with remaining element except root
        // right :- prestart  = prestart + numleft +1
        //         preEnd = preEnd
        //         instart  = idxRoot +1
        //         InEnd = inEnd

        root.right = BuildTree(preorder,preStart+numLeft,preEnd,inorder,idxRoot+1,inEnd,inMap);

        return root;
    }
}


class A38ConstructBinaryTreeFromPostOrderInorder{
    static Node CraeteUniqueBT(int[] postorder , int[] inorder){
        HashMap<Integer, Integer> map = new HashMap<>();

        // create hashmap for inorder index int O(1) from post order last element
        for(int i = 0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        Node root = BuildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }


    static Node BuildTree(int[] postorder, int postStart , int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map){

        if(postStart>postEnd || inStart > inEnd){ // when inorder or postorder array will empty
            return null;
        }

        // build the root node
        Node root = new Node(postorder[postEnd]);
        int idxRoot = map.get(root.key);
        int numRight = inEnd-idxRoot;

        // build the right tree first
        root.right =  BuildTree(postorder,postEnd-numRight,postEnd-1,inorder,idxRoot+1,inEnd,map);
        root.left = BuildTree(postorder,postStart,postEnd-1-numRight,inorder,inStart,idxRoot-1,map);
        return root;
    }
}




class SerializeAndDeserialize{
    static String serialize(Node root){

        StringBuilder res = new StringBuilder();
        // level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.isEmpty()==false){
            Node popped = queue.poll();

            if(popped==null){
                res.append("n ");
                continue;
            }



            res.append(popped.key + " ");

            queue.offer(popped.left);
            queue.offer(popped.right);

        }
        return res.toString();
    }

//    static Node Deserialize(String data){
//        String[] values = data.split(" ");
//
//
//
//    }
}



public class basicOfTree {
    public static void main(String[] args){

        // Building tree data structure
        Node root1 = new Node(10);
        root1.left = new Node(20);
        root1.right = new Node(30);
        root1.left.right = new Node(40);
        String res = SerializeAndDeserialize.serialize(root1);
        System.out.println(res);

    }
}









