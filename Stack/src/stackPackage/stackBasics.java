package stackPackage;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class stackBasics {
    public static void main(String[] args){



        // *************** Array Deque Implementation from JAVA COLLECTION **********************
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}




// ******************Stack Using Linked List Implementation*********************
class Node{
    int key;
    Node next;
    Node(int x){
        this.key = x;
        this.next = null;
    }
}

class A1StackImplementationUsingLinkedList{
    Node head;
    int size;

    A1StackImplementationUsingLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void push(int x){
        Node temp = new Node(x);
        temp.next = this.head;
        this.head = temp;
        size++;
    }

    public int peek(){
        if(this.head==null){
            return Integer.MIN_VALUE;
        }
        return this.head.key;
    }

    public int pop(){
        if(head==null){
            return Integer.MIN_VALUE;
        }
        int val = this.head.key;
        this.head = this.head.next;
        this.size--;
        return val;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if(this.head==null){
            return true;
        }else{
            return false;
        }
    }
}



// ************ Dynamic size array implementation ***************
class A2MyStackViaArrayList{
    ArrayList<Integer> arr;
    int top;
    A2MyStackViaArrayList(){
        this.arr = new ArrayList<Integer>();
        this.top = -1;
    }
    public void push(int x){
        this.top++;
        this.arr.add(this.top,x);
    }
    public int peek(){
        int pk = this.arr.get(this.top);
        return pk;
    }
    public int pop(){
        int val = this.arr.get(this.top);
        this.arr.remove(this.top);
        this.top--;
        return val;
    }
    public int size(){
        return this.top +1;
    }

    public boolean isEmpty(){
        if(this.top==-1){
            return true;
        }
        else{
            return false;
        }
    }
}







// ************* Via simple fixed size array ***************
class A3MyStack{
    // define dtype in class
    int[] arr;
    int top;
    // initialised the constructure
    A3MyStack(int capacity){
        this.arr = new int[capacity];
        this.top = -1;
    }


    public void push(int x){
        // Increase the top first then insert at top
        this.top++;
        this.arr[this.top] = x;
    }

    public int pop(){
        if(this.top==-1){
            return Integer.MIN_VALUE;
        }
        // get value of top then reduce the top--;
        int topVal = this.arr[this.top];
        this.top--;
        return topVal;

    }

    public int peek(){
        if(this.top==-1){
            return Integer.MIN_VALUE;
        }
        int pk = this.arr[this.top];
        return pk;
    }

    public int size(){
        return this.top+1;
    }

    public boolean isEmpty(){
        if(this.top==-1){
            return true;
        }else{
            return false;
        }
    }
}


class A4StackInJava {
// ******************* Stack in Java Collection *******************
// *************** Array Deque Implementation from JAVA COLLECTION **********************
//ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
//stack.push(10);
//stack.push(20);
//stack.push(30);
//System.out.println(stack.pop());
//System.out.println(stack.pop());
//System.out.println(stack.size());
//System.out.println(stack.isEmpty());
//System.out.println(stack.pop());
//System.out.println(stack.peek());

}




// ********** Stack using

