package treePackage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class rough {
    public static void main(String[] args){

//        Node root = new Node(10);
//        root.left = new Node(20);
//        root.right = new Node(30);
//        int[] arr = new int[1];
//
//        rightViewOfBinaryTree.fun1(root,arr,1);


        List<Integer> lis = new ArrayList<Integer>(1);

        int index = 0;
        index = 1-0-1;

        lis.add(0,2);

        for(int i = 0 ; i<lis.size() ; i++){
            System.out.println(lis.get(i));
        }





    }
}

class preorderTraversal{
    static void fun1(Node root){
        if(root==null){
            return;
        }
        // create stack
        ArrayDeque<Node> st = new ArrayDeque<Node>();
        st.push(root);

        while(st.isEmpty()==false){
            Node popped = st.pop();
            System.out.println(popped.key);

            if(popped.right!=null) st.push(root.right);

            if(popped.left!=null) st.push(root.left);
        }
    }
}

class InorderTraversal{
    static void fun1(Node root){
        if(root==null){
            return;
        }

        // create stack
        ArrayDeque<Node> st = new ArrayDeque<>();
        Node curr = root;

        while(true){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }else{
                if(st.isEmpty()==true){
                    break;
                }
                // we popped root element
                Node popped = st.pop();
                System.out.println(popped.key);
                // then go to right
                curr = popped.right;
            }
        }
    }


}



class PostOrder{
    static void fun1(Node root){
        if(root==null){
            return;
        }
        ArrayDeque<Node> st1 = new ArrayDeque<>();
        ArrayDeque<Node> st2 = new ArrayDeque<>();
        st1.push(root);
        while (st1.isEmpty()==false){
            Node popped = st1.pop();

            st2.push(popped);

            if(popped.left!=null){
                st1.push(popped.left);
            }
            if(popped.right!=null){
                st1.push(popped.right);
            }
        }

        while(st2.isEmpty()==false){
            System.out.println(st2.pop().key);
        }
    }

    static void fun2(Node root){
        if(root==null){
            return;
        }
        ArrayDeque<Node> st  = new ArrayDeque<>();
        Node curr = root;

        while(curr!=null || st.isEmpty()==false){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp!=null){
                    curr = temp;
                }else{
                    Node popped = st.pop();
                    System.out.println(popped.key);

                    while(st.isEmpty()==false && st.peek().right==popped){
                        temp = st.pop();
                        System.out.println(temp.key);
                    }
                }
            }
        }
    }
}



class lvobt{
    static void fun1(Node root,int[] maxlabel,int label){
        // it's a preorder traversal
        if(root==null){
            return;
        }

        if(maxlabel[0]<label){
            System.out.println(root.key);
            maxlabel[0] = maxlabel[0]+1;
        }

        // go to the left
        fun1(root.left,maxlabel,label+1);
        // go to the right
        fun1(root.right,maxlabel,label+1);
    }
}


class rightViewOfBinaryTree{
    static void fun1(Node root,int[] arr,int label){
        if(root==null){
            return;
        }

        if(arr[0]<label){
            System.out.println(root.key);
            arr[0] = arr[0] +1;
        }

        fun1(root.right,arr,label+1);
        fun1(root.left,arr,label+1);

    }
}

