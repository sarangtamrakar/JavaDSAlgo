package linkedListPackage;


import java.util.ArrayList;
import java.util.HashSet;

// Singly linked list
class Node{
    int key;
    Node next;
    Node(int x){
        this.key = x;
        this.next = null;
    }
}


class IterateLinkedListLoop{
    static void fun1(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.println(curr.key);
            curr = curr.next;
        }
    }

    static void fun2(Node head){
        // recursive method
        if(head==null){
            return;
        }
        System.out.println(head.key);
        fun2(head.next);
    }
}


class SearchElementInLinkedList{
    static boolean fun1(Node head, int x){
        Node curr = head;
        while(curr!=null){
            if(curr.key==x){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    static boolean fun2(Node head, int x){
        if(head!=null){
            if(head.key==x){
                return true;
            }
            return fun2(head.next, x);
        }
        return false;
    }
}


class InsertAtBeginingOfLinkedList{
    static Node fun1(Node head, int x){

        Node newNode = new Node(x);

        newNode.next = head;

        // print updated Linked List
        IterateLinkedListLoop.fun2(newNode);

        return newNode;
    }
}


class InsertAtLastOfLinkedList{
    static Node fun1(Node head, int x){

         Node temp = new Node(x);

        if(head==null){
            return temp;
        }

        Node curr = head;

         while(true){
             if(curr.next==null){
                 curr.next = temp;
                 return head;
             }
             curr = curr.next;
         }
    }
}



class DeleteTheFirstNodeInLinkedList{
    static Node fun1(Node head){
        if(head==null){
            return null;
        }
        return head.next;
    }
}


class DeleteTheLastNodeInLinkedList{
    static Node fun1(Node head){
        if(head==null){
            return null;
        }

        if(head.next==null){
            return null;
        }

        Node curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }

        curr.next = null;
        return head;
    }
}





class DeleteTheithNodeInLinkedList{
    // Very Good Question Solve it again
    static Node fun1(Node head, int pos){
        // edge case
        if(pos==1) {
            return DeleteTheFirstNodeInLinkedList.fun1(head);
        }

        Node curr = head;
        int count = 1;
        while(count<pos-1 && curr.next!=null){   // very imp condition for Linked List
            curr = curr.next;
            count++;
        }

        if(curr.next!=null) {
            Node temp = curr.next.next;
            curr.next = temp;
            return head;
        }
        return head;
    }

}



class InsertAtPositionIndex{
    static Node fun1(Node head,int pos , int x){
        Node NodeToInsert = new Node(x);

        // Handle edge cases
        if(head==null){
            return NodeToInsert;
        }
        if(pos==1){
            NodeToInsert.next = head;
            return NodeToInsert;
        }

        Node curr = head;
        int count = 1;
        while(count<pos-1 && curr.next!=null){  // this very good condition to maintain edge case
            curr = curr.next;                    // if pos is > length of linked list , so it will insert at last
            count++;
        }

        // first save the next node to temp the
        Node temp = curr.next;
        curr.next = NodeToInsert;
        NodeToInsert.next = temp;
        return head;
    }
}



class DeleteNodeATithPositionIndex{
    static Node fun1(Node head,int pos){

        // Very Good Question solved it again

        // handle edge cases
        if(head==null){
            return null;
        }
        // if delete the first node
        if(pos==1){
            head = head.next;
            return head;
        }

        int count = 1;
        Node curr = head;
        while(count<pos-1 && curr.next!=null){  // count always pos-2
            curr = curr.next;
            count++;
        }

        if(curr.next==null){
            // here is the case of pos is greater than length of linked list
            return head;
        }

        curr.next = curr.next.next;

        return head;



    }
}




///// *************Doubly Linked List*********

class DoubleNode{
    int key;
    DoubleNode prev;
    DoubleNode next;
    DoubleNode(int x){
        this.key = x;
        this.prev = null;
        this.next = null;
    }
}



class TraversalOfDLL{
    static void fun1(DoubleNode head){
        if(head==null){
            return;
        }

        System.out.println(head.key);
        fun1(head.next);
    }
}


class InsertAtBeginingOfDLL{
    static DoubleNode fun1(DoubleNode head, int x){
        DoubleNode temp = new DoubleNode(x);
        // Handle edge cases....
        if(head==null){
            return temp;
        }

        temp.next = head;
        head.prev = temp;

        return temp;
    }
}


class InsertAtIthPositionOfDLL{
    static DoubleNode fun1(DoubleNode head, int x,int pos){
        // create temp node
        DoubleNode temp = new DoubleNode(x);

        // handle edge cases
        if(pos == 1 && head==null){
            return temp;
        }else if(pos==1 && head!=null){
            return InsertAtBeginingOfDLL.fun1(head,x);
        }

        if(head==null){
            return null;
        }


        int count = 1;
        DoubleNode curr = head;
        while(count<pos-1 && curr.next!=null){
            curr  = curr.next;
            count++;
        }

        DoubleNode nextelement = curr.next;
        curr.next = temp;
        temp.next = nextelement;
        temp.prev = curr;
        return head;

    }
}








class InsertAtLastOfDLL{
    static DoubleNode fun1(DoubleNode head,int x){

        DoubleNode newNode = new DoubleNode(x);
        if(head==null){
            return newNode;
        }

        DoubleNode curr = head;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;

        return head;
    }
}



// Very Imp question
class ReverseTheDLL{
    static DoubleNode fun1(DoubleNode head){

        if(head==null || head.next==null){
            return head;
        }

        DoubleNode curr = head;
        DoubleNode prev = null;
        DoubleNode next = null;
        while (curr!=null){
            // swapping prev & next
            prev = curr.prev;
            next = curr.next;
            curr.prev = next;
            curr.next = prev;
            curr = curr.prev;
        }
        // **********************************
        // returning prev.prev , here prev become next , so come to first node prev.prev is necessory
        return prev.prev;
    }

    static DoubleNode recursivelyReverse(DoubleNode head,DoubleNode prev){

        if(head==null && prev==null){  // if head elememnt id null & prev is null
            return null;
        }else if(head!=null && prev==null && head.next==null){ // if there is only one node so return that node itself
            return head;
        }else if(head==null && prev!=null){
            return prev.prev;
        }



        // swaping
        DoubleNode next = head.next;
        prev = head.prev;
        head.next = prev;
        head.prev = next;
        return recursivelyReverse(head.prev,prev);

    }

}









class DeleteTheFirstNodeInDLL{
    static DoubleNode fun1(DoubleNode head){
        // Handle edge cases

        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }

        DoubleNode temp = head.next;
        temp.prev = null;
        return temp;
    }
}

class DeleteTheLastNodeinDLL{
    static DoubleNode fun1(DoubleNode head){

        if(head==null){
            return null;
        }else if(head.next==null){
            return null;
        }else{
            DoubleNode curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
            return head;
        }
    }
}




// ************Singly circular Linked List*****************

class SCNode{
    int key;
    SCNode next;

    SCNode(int x){
        this.key = x;
        this.next = null;
    }
}



class IterateSCLL{
    static void fun1(SCNode head){
        if(head==null){
            return;
        }
        SCNode curr = head;
        System.out.println(curr.key);
        curr = curr.next;
        while(curr!=head){
            System.out.println(curr.key);
            curr = curr.next;
        }
    }

    static void fun2(SCNode head){
        if(head==null){
            return;
        }
        SCNode curr = head;
        System.out.println(curr.key);
        curr = curr.next;
        for(SCNode node = curr;curr!=head;curr= curr.next){
            System.out.println(curr.key);
        }
    }
}



class InsertAtBeginingOfSCLL{
    // ******* Very IMP

    // O(N) Solution
    static SCNode fun1(SCNode head, int x){
        // if creation of node
        SCNode temp = new SCNode(x);
        if(head==null){
            temp.next = temp;
            return temp;
        }

        temp.next = head;
        SCNode curr = head;
        while(curr.next!=head){
            curr = curr.next;
        }
        curr.next = temp;
        return temp;
    }

    // O(1) solution
    static SCNode fun2(SCNode head, int x){
        SCNode temp = new SCNode(x);

        if(head==null){
            temp.next = temp;
            return temp;
        }

        // insert the temp node at second position
        SCNode secondNode = head.next;
        head.next = temp;
        temp.next = secondNode;

        // now swap the keys
        int headKey = head.key;
        int tempKey = temp.key;
        head.key = tempKey;
        temp.key = headKey;
        return head;
    }
}


class InsertATEndOfSCLL{

    // O(N) solution
    static SCNode Naive(SCNode head, int x){
        SCNode temp = new SCNode(x);

        if(head==null){
            temp.next = temp; // in circular linked list this line very IMP
            return temp;
        }

        SCNode curr = head.next;
        while(curr.next!=head){
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;
        return head;
    }


    // O(1) Solution
    static SCNode Optimised(SCNode head, int x){
        SCNode temp = new SCNode(x);

        // swap head
        SCNode secondHead = head.next;
        temp.next = secondHead;
        head.next = temp;

        // swapping keys
        int headKey = head.key;
        int tempKey = temp.key;
        head.key = tempKey;
        temp.key = headKey;
        return temp;
    }
}



class DeleteheadOfTheSCLL{

    // O(N) solution
    static SCNode NaiveApproach(SCNode head){
        if(head==null){
            return null;
        }

        SCNode secondHead = head.next;
        if(secondHead==head){
            return null;
        }

        SCNode curr = secondHead;
        while(curr.next!=head){
            curr = curr.next;
        }
        curr.next = secondHead;

        return secondHead;
    }


    // O(1) solution
    static SCNode Optimised(SCNode head){
        if(head==null){
            return null;
        }else if(head==head.next){
            return null;
        }else {

            head.key = head.next.key;
            head.next = head.next.next;
            return head;
        }
    }

}


class DeleteKthNodeInSCLL{
    static SCNode fun1(SCNode head, int x){
        if(head==null){
            return null;
        }

        if(x==1){
            return DeleteheadOfTheSCLL.Optimised(head);
        }

        if(head.next == head){
            return null;
        }

        SCNode curr = head;
        int count = 1;
        while(count<x-1){
            curr = curr.next;
            count++;
        }
        curr.next = curr.next.next;

        return head;

    }
}


class SortedInsertInLinkedList{
    static Node fun1(Node head, int x){

        Node temp = new Node(x);

        if(head==null){
            return temp;
        }

        if(x<=head.key){
            temp.next = head;
            return temp;
        }

        Node curr = head;
        while(curr!=null){
            if(curr.key<=x && curr.next==null){ // it means we are in the last node
                curr.next = temp;
                return head;
            }else if(curr.key<=x && curr.next.key>=x){ // if found in middle
                Node next = curr.next;
                curr.next = temp;
                temp.next = next;
                return head;
            }
            curr = curr.next;
        }

        return head;

    }
}



// IMP question
class MiddleOfLinkedList{
    static void NaiveApproach(Node head){
        // first count number of nodes
        int count = 0;
        Node curr = null;
        for(curr = head; curr!=null;curr = curr.next){
            count++;
        }
        // make increment by 1 , just sake of naming convention start from 1 for sarang
        count = (count/2)+1;
        curr = head;
        for(int i = 1;i<count; i++){
            curr = curr.next;
        }
        System.out.println(curr.key);
    }


    static void optimisedApproach(Node head){
        // fast - low approach revise it again*************************
        Node fast = head;
        Node low = head;
        while(fast!=null && fast.next!= null){
            low = low.next;
            fast = fast.next.next;
        }

        System.out.println(low.key);

    }
}



class GetNthNodeFromBackInLinkedList{
    static void NaiveApproach(Node head, int n){
        // first count the Node in Linked List
        if(n<1){
            return;
        }
        int count = 0;
        Node curr = null;
        for(curr = head;curr!=null;curr = curr.next){
            count++;
        }
        count = count-n+1;
        curr = head;
        int i = 1;
        while(curr!=null && i<count){
            curr = curr.next;
            i++;
        }
        System.out.println(curr.key);
    }

    static void OptimisedSolution(Node head, int x){

        if(x<1){
            return;
        }
        if (head==null){
            return;
        }

        int i = 0;
        Node fast = head;
        while(fast!=null && i<x){
            fast = fast.next;
            i++;
        }

        Node slow = head;

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.key);
    }

}




class ReverseTheLinkedListIteratively{

    // Using extra arr to store the element
    static Node NaiveApproach(Node head){
        // it requires extra spae for array & 2 traversal of linked list
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Node curr = head;

        while(curr!=null){
            arr.add(curr.key);
            curr = curr.next;
        }

        int i = arr.size()-1;
        curr = head;
        while(curr!=null){
            curr.key = arr.get(i);
            curr = curr.next;
            i--;
        }

        return head;
    }

    static Node OptimisedSolution(Node head){

        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            // now update the prev & next
            prev = curr;
            curr = next;
        }
        return prev;
    }
}



class RemoveDuplicatesFromSortedSLL{
    // Good question solve it again
    static Node fun1(Node head){

        if(head==null){
            return head;
        }

        Node curr = head;
        while(curr!=null && curr.next!=null){

            if(curr.key==curr.next.key){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
}




class ReverseTheLinkedListInSizeK{
    // Do it again
    static Node recursivelyReverse(Node head, int k){

        if(head==null){
            return head;
        }

        int count = 1;
        Node curr = head;
        Node prev = null;
        while(curr!=null && count<=k){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // if curr or next  != null then only call for recursion
        Node restNext = recursivelyReverse(curr, k);
        head.next = restNext;

        return prev;

    }

    static Node IterativelyReverse(Node head, int k){
        // Good question do it again
        if(head==null){
            return head;
        }

        Node curr = head;

        // Maintaining extra variable
        boolean isFirstPass = true;
        Node prevFirst = null;

        while(curr!=null){

            // ****** Always initialize next & prev just before the coun variable
            Node next = null;
            Node prev = null;
            int count = 1;
            // maintaining extra variable
            Node first = curr;
            while(curr!=null && count<=k){
                next = curr.next;
                curr.next = prev;

                // upadate prev & curr
                prev = curr;
                curr = next;
                count++;
            }

            if(isFirstPass){  // in first k size , we are storing our prev as head so that it will beocme final head
                head = prev;
                isFirstPass = false;

            }else{
                prevFirst.next = prev;
            }
            prevFirst = first;
        }

        return head;
    }
}



class DetectLoops{

    // O(N2) Solution
    static boolean fun1(Node head){

        Node curr = head;

        while(curr!=null){
            Node temp = curr.next;

            Node curr2 = head;
            while(curr2!=curr){
                if(curr2==temp){
                    return true;
                }

                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        return false;
    }

    // O(N) solution && O(N) space required && without cahngeing Node architecture & refrences of linked list
    static boolean fun2(Node head){
        HashSet<Node> hset = new HashSet<Node>();

        Node curr = head;
        while(curr!=null){

            if(hset.contains(curr)){
                return true;
            }
            hset.add(curr);
            curr = curr.next;
        }
        return false;
    }
}




// Detect loop using floyd cycle detection
class DetectLoopsOptmisedWay{
    static boolean fun1(Node head){
        // O(N) solution && O(1) extra space best solution
        // slow pointer :- will move 1 step && fast pointer will move two step , & when they meet it means they is loop
        if(head==null){
            return false;
        }
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}


// detect && remove the Loop
class detectAndRemoveLoop{
    // o(N) time && O(N) extra space
    static Node fun1(Node head){
        HashSet<Node> hset = new HashSet<Node>();
        Node curr = head;
        hset.add(curr);

        while(curr!=null && curr.next!=null){
            if(hset.contains(curr.next)){
                curr.next = null;
                return head;
            }else{
                hset.add(curr.next);
            }
            curr = curr.next;
        }
        return head;
    }

    // O(N) solution && O(1) space floyd cycle
    static Node OptimisedSolution(Node head){

        if(head==null){
            return head;
        }


        // define slow && fast pointer
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }

        // if there is no loop ,so return head
        if(fast.next==null){
            return head;
        }
        // if there is loop detected
        slow = head;
        while(slow.next!=fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }
}





public class BasicsOfLinkedList {
    public static void main(String[] args){

        Node head1 = new Node(10);
        Node head2 = new Node(20);
        Node head3 = new Node(30);
        Node head4 = new Node(40);
        Node head5 = new Node(50);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head3;


        Node res = detectAndRemoveLoop.OptimisedSolution(head1);
        IterateLinkedListLoop.fun1(res);

    }
}





