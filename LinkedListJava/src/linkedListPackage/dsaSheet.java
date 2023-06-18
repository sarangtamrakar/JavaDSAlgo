package linkedListPackage;

import java.util.HashSet;

class NodeSLL{
    int key;
    NodeSLL next;
    NodeSLL(int x){
        this.key = x;
        this.next = null;
    }
}



class A1TraversingSinglyLinkedList{
    // iterative way
    static void fun1(NodeSLL head){

        NodeSLL curr = head;
        while(curr!=null){
            System.out.println(curr.key);
            curr = curr.next;
        }
    }

    // recursion Way
    static void Recursively(NodeSLL head){
        if(head==null){
            return;
        }

        System.out.println(head.key);
        Recursively(head.next);
    }
}

class A2InsertAtBeginingOfSLL{
    static NodeSLL fun1(NodeSLL head, int x){
        NodeSLL temp = new NodeSLL(x);
        temp.next = head;
        head = temp;
        return head;
    }
}


class A3InsertAtLastOfSLL{
    static NodeSLL fun1(NodeSLL head, int x){

        NodeSLL temp = new NodeSLL(x);
        if(head==null){
            return temp;
        }

        NodeSLL curr = head;
        while(curr!=null && curr.next!=null){
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
}


class A4InsertAtIthPositionOfSLL{
    static NodeSLL fun1(NodeSLL head, int x, int pos){
        NodeSLL temp = new NodeSLL(x);

        if(head==null){
            return temp;
        }else if(pos==0){
            temp.next = head;
            head = temp;
            return head;
        }

        int count = 0;
        NodeSLL curr = head;
        while(curr.next!=null && count<pos-1){   // this is very good condition
            curr = curr.next;                // if len of LL < pos , so it will add elemnet to last node
        }

        NodeSLL next = curr.next;
        curr.next = temp;
        temp.next = next;
        return head;
    }
}


class A5DeleteTheLastNodeInSLL{
    static NodeSLL fun1(NodeSLL head){
        if(head==null || head.next==null){
            return null;
        }

        NodeSLL curr = head;
        while(curr.next!=null && curr.next.next!=null){
            curr = curr.next;
        }

        curr.next = null;
        return head;
    }
}

class A6DeleteTheiThNodeInSLL{
    static NodeSLL fun1(NodeSLL head, int pos){
        if(head==null){
            return null;
        }else if(head.next==null){
            return null;
        }

        int count = 0;
        NodeSLL curr = head;
        while(count<pos-1 && curr.next.next!=null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
}



class A7SearchElementInSLL{
    // Iterative way
    static boolean Iterative(NodeSLL head, int x){
        if(head==null){
            return false;
        }
        NodeSLL curr = head;
        while(curr!=null){
            if(curr.key == x){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    static boolean Recursively(NodeSLL head, int x){
        if(head==null){
            return false;
        }
        
        if(head.key==x){
            return true;
        }
        return Recursively(head.next,x);
    }
}


class A8SortedInsertInSLL{
    static NodeSLL fun1(NodeSLL head , int x){
        NodeSLL temp = new NodeSLL(x);

        if(head==null){
            return temp;
        }
        if(x<=head.key){
            temp.next = head;
            head = temp;
            return head;
        }

        NodeSLL curr = head;
        while(curr.next!=null){
            if(curr.next.key>x){
                NodeSLL next = curr.next;
                curr.next = temp;
                temp.next = next;
                return head;
            }
            curr = curr.next;
        }

        curr.next = temp;
        return head;
    }
}



class A9MiddleOfLinkedList{
    // Count the length &  reach n/2 th idx & return key from there
    static int Naive(NodeSLL head){

        if(head==null){
            return 0;
        }



        int count = 0;
        NodeSLL curr = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }

        int midIdx = count/2;

        curr = head;
        int i = 0;
        while(curr!=null && i<midIdx){
            curr = curr.next;
            i++;
        }
        return curr.key;
    }

    // two fast & slow pointer approach
    // Single traversal solution
    static int Optimised(NodeSLL head){
        NodeSLL slow = head;
        NodeSLL fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.key;
    }
}


class A10NthNodeFromEndOfLinkedList{
    static int Naive(NodeSLL head,int idx){
        if(head==null){
            return Integer.MIN_VALUE;
        }
        int count = 0;
        NodeSLL curr;
        for(curr= head; curr!=null;curr = curr.next){
            count++;
        }
        idx = count - idx -1;
        int i = 0;
        for(curr = head;curr!=null && i<idx;curr = curr.next){
            i++;
        }
        return curr.key;
    }


    static int Optimised(NodeSLL head,int idx){
        if(head==null){
            return Integer.MIN_VALUE;
        }

        int i = 0;
        NodeSLL ahead = head;
        NodeSLL back = head;
        while(ahead!=null && i<idx){
            ahead = ahead.next;
            i++;
        }

        while(ahead!=null && ahead.next!=null){
            ahead = ahead.next;
            back = back.next;
        }
        return back.key;
    }
}


class A11ReverseSLL{
    static NodeSLL OptmisedSolution(NodeSLL head){
        if(head==null){
            return null;
        }

        NodeSLL curr = head;
        NodeSLL prev = null;
        while(curr!=null){
            NodeSLL next = curr.next;
            curr.next = prev;
            // now set prev & curr again
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static NodeSLL recursivelyReverse(NodeSLL head, NodeSLL prev){
        if(head==null){
            return prev;
        }

        NodeSLL next = head.next;
        head.next = prev;
        prev = head;
        head = next;
        return recursivelyReverse(head,prev);
    }
}



class A12RemoveDuplicatesFromSortedSLLL{
    static NodeSLL fun1(NodeSLL head){

        if(head==null){
            return null;
        }

        NodeSLL curr = head;

        while(curr!=null && curr.next!=null){
            if(curr.key == curr.next.key){
               curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;

    }
}

class A13DetectLoopInSLL{

    // o(N) solution with O(N) extra space
    static boolean NaiveMethod(NodeSLL head){
        if(head==null){
            return false;
        }
        HashSet<NodeSLL> hset = new HashSet<NodeSLL>();
        hset.add(head);
        NodeSLL curr = head;
        while(curr!=null){
            if(hset.contains(curr.next)){
                return true;
            }else{
                hset.add(curr.next);
            }
            curr = curr.next;
        }
        return false;
    }

    static boolean superOptimised(NodeSLL head){
        if(head==null){
            return false;
        }
        // two fast & slow pointer approach
        NodeSLL fast = head;
        NodeSLL slow = head;
        while(fast!=null && fast.next!=null){
            // first increment then compare
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                System.out.println("Loop detected");
                return true;
            }
        }
        System.out.println("No Loop Detected");
        return false;
    }
}


class A14RemoveLoopInLinkedList{
    static NodeSLL NaiveMethod(NodeSLL head){
        if(head==null){
            return head;
        }

        HashSet<NodeSLL> hset = new HashSet<NodeSLL>();
        hset.add(head);

        NodeSLL curr = head;
        while(curr!=null && curr.next!=null){
            if(hset.contains(curr.next)){
                curr.next = null;
                return head;
            }else{
                hset.add(curr.next);
            }
        }
        return head;
    }

    static NodeSLL OptmisedSolution(NodeSLL head){
        if(head==null){
            return null;
        }

        NodeSLL fast = head;
        NodeSLL slow = head;
        boolean isDetected = false;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                isDetected = true;
                break;
            }
        }

        if(isDetected==true){
            slow = head;
            while(slow.next!=fast.next){
                fast = fast.next;
                slow = slow.next;
            }
            fast.next = null;
            return head;
        }
        return head;
    }
}





public class dsaSheet {
    public static void main(String[] args){

        NodeSLL head1 = new NodeSLL(10);
        NodeSLL head2 = new NodeSLL(10);
        NodeSLL head3 = new NodeSLL(10);
        NodeSLL head4 = new NodeSLL(10);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        NodeSLL res = A12RemoveDuplicatesFromSortedSLLL.fun1(head1);
        A1TraversingSinglyLinkedList.fun1(res);

    }
}





















