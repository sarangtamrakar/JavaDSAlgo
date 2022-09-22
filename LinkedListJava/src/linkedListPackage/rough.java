// { Driver Code Starts
//Initial template code for JAVA


//import linkedListPackage.Node;

import java.util.*;
import java.io.*;
import java.lang.*;

class Node1 {
    int data;
    Node1 next;
    Node1(int x)
    {
        data = x;
        next = null;
    }
}



class sortedinset{
    static Node1 fun1(Node1 head,int x){
        Node1 temp = new Node1(x);
        if(head==null){
            return head;
        }

        if(temp.data<head.data){
            temp.next = head;
            return temp;
        }
        Node1 curr = head;
        while(curr.next!=null){
            if(temp.data>curr.next.data){
                curr = curr.next;
            }
            else{
                break;
            }
        }
        Node1 next = curr.next;
        curr.next = temp;
        temp.next = next;
        return head;
    }
}

class A1IterateLinkedListLoop{
    static void fun1(Node1 head){
        Node1 curr = head;
        while(curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    static void fun2(Node1 head){
        // recursive method
        if(head==null){
            return;
        }
        System.out.println(head.data);
        fun2(head.next);
    }
}




public class rough{
    public static void main(String[] args){
        Node1 head1 = new Node1(10);
        Node1 head2 = new Node1(20);
        Node1 head3 = new Node1(30);
        Node1 head4 = new Node1(40);
        Node1 head5 = new Node1(50);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
//        head5.next = head3;

        Node1 head = sortedinset.fun1(head1,51);

        A1IterateLinkedListLoop.fun1(head);

    }
}