package QueuePackage;

import java.util.*;


// Queue Implementation Using Array List
// in simple arr implementation deque is O(N) & all other operation is O(1)
class A1QueueArrayList{
    // defining variables
    int front;
    int rear;
    ArrayList<Integer> arr;
    int capacity;
    // calling constructure
    A1QueueArrayList(int capacity){
        this.front = 0;
        this.rear = -1;
        this.capacity = capacity;
        this.arr = new ArrayList<Integer>(capacity);
    }

    // fill the value in queue data-structure
    public void enqueue(int x){
        if(this.rear<this.capacity){
            this.rear++;
            this.arr.add(this.rear,x);
        }else{
            System.out.println("capacity is full");
        }
    }

    // Here deque is O(N) solution
    public void dequeue(){
        if(this.rear>=0) {
            this.arr.remove(this.front);
            this.rear--;
        }else{
            System.out.println("Queue is empty");

        }
    }

    public int getFront(){
        if(this.rear>=0){
            return this.arr.get(this.front);
        }else{
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
    }

    public int getRear(){
        if(this.rear>=0){
            return this.arr.get(this.rear);
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public boolean isFull(){
        if(this.rear==this.capacity){
            return true;
        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(this.rear==-1){
            return true;
        }
        else return false;
    }

    public int size(){
        return this.rear+1;

    }
}



class A2CircularArrayQueueImplementation{
    int cap;
    int[] arr;
    int front;
    int rear;

    A2CircularArrayQueueImplementation(int c){
        cap = c;
        arr = new int[cap];
        front = 0;
        rear = -1;
    }

    public void enqueue(int x){
        rear = (rear+1)%cap;
        arr[rear] = x;
    }

    public void dequeue(){
        front = (front + 1)%cap;
    }

    public int size(){
        return (rear - front +1)%cap;
    }

    public boolean isFull(){
        if(size()==cap){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(size()==0){
            return true;
        }else{
            return false;
        }
    }
}


// **************** Linked List Implementation of Queue Data Structure *************

class Node{
    int key;
    Node next;
    Node(int x){
        this.key = x;
        this.next = null;
    }
}

class A3QueueUsingLinkedList{
    Node front = null;
    Node rear = null;
    int size = 0;

    public void enqueue(int x) {
        Node temp = new Node(x);
        if (front == null && rear == null) {
            front = temp;
            rear = front;
            size++;
        } else if (front != null && rear != null) {
            rear.next = temp;
            rear = temp;
            size++;
        }
    }

    public void dequeue() {
        if (front != null && front != rear) {
            front = front.next;
            size--;
        } else if (front != null && front==rear){
            front = front.next;
            rear = front;
            size--;
        }
    }

    public int size(){
        return size;
    }


    public int getFront(){
        if(front!=null){
            return front.key;
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public int getRer(){
        if(rear!=null){
            return rear.key;
        }else {
            return Integer.MIN_VALUE;
        }
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
}





// ************************Queue Interface in Java************
// In java There is No class for Queue ,but there interface from ArrayDeque && LinkedList class
//
//Queue<Integer> queue = new LinkedList<Integer>();
//Queue<Integer> queue = new ArrayDeque<Integer>();
//
//// To add the item
//queue.offer(10);
//queue.offer(20);
//queue.offer(30);
//
//// get the size
//queue.size();
//
//// get the first elemnt in in queue
//queue.peek();
//
//// check for isEmpty()
//System.out.println(queue.isEmpty());
//
//
//// Top get first item
//System.out.println(queue.peek());
//
//
//// to remove the first item
//System.out.println(queue.poll());




class A4StackImplementationUsingQueue{
    // ************ Using two queues *************
    Queue<Integer> q1;
    Queue<Integer> q2;
    int size = 0;

    A4StackImplementationUsingQueue(){
        q1 = new ArrayDeque<Integer>();
        q2 = new ArrayDeque<Integer>();
    }

    public void push(int x){
        // 1. push into q1
        q2.offer(x);

        // 2. copy all elements of q1 into q2
        while(q1.isEmpty()==false) {
            q2.offer(q1.peek());
            q1.poll();
        }

        // 3. copy all elemnets of q2 to back q1
        while(q2.isEmpty()==false) {
            q1.offer(q2.peek());
            q2.poll();
        }
        size++;
    }


    public Integer top(){
        return q1.peek();
    }

    public Integer pop(){
        Integer val = q1.peek();
        q1.poll();
        size--;
        return val;
    }
}





class A5ImplementationOfStackUsingSingleQueue{
    Queue<Integer> q;
    int size;
    A5ImplementationOfStackUsingSingleQueue(){
        q = new ArrayDeque<Integer>();
        size = 0;
    }

    public void push(int x){
        // step 1.
        q.offer(x);
        size++;

        // step 2.
        for(int i = 0;i<size-1;i++){
            q.offer(q.poll());
        }
    }

    public int top(){
        return q.peek();
    }

    public int pop(){
     int val = q.peek();
     q.poll();
     size--;
     return val;
    }

    public int size(){
        return size;
    }
}




class A6QueueImplementationUsingStack{

    // O(N) push time complexity
    ArrayDeque<Integer> s1;
    ArrayDeque<Integer> s2;
    A6QueueImplementationUsingStack(){
        s1 = new ArrayDeque<Integer>();
        s2 = new ArrayDeque<Integer>();

    }

    public void offer(int x){

        // step 1 . copy all elements from s1 to s2
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }

        // step2 push x into the s1;
        s1.push(x);

        // step3 :- copy all elements from s2 to s1
        while(!s2.isEmpty()){
            s1.push(s2.peek());
            s2.pop();
        }
    }

    public int poll(){
        return s1.pop();
    }

    public int peek(){
        if(!s1.isEmpty()){
            return s1.peek();
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public int size(){
        return s1.size();
    }
}





class A7ReverseTheQueue{

    ArrayDeque<Integer> s;
    int size;
    A7ReverseTheQueue(){
        s = new ArrayDeque<Integer>();
        size = 0;
    }

    public Queue<Integer> reverse(Queue<Integer> queue){

        // cp all elements of queue to stack
        while(queue.isEmpty()==false) {
            s.push(queue.peek());
            queue.poll();
        }

        // stack to queue back
        while(s.isEmpty()==false){
            queue.offer(s.peek());
            s.pop();
        }
        return queue;
    }
}



class RecursivelyReverseQueue{
    public Queue<Integer> reverse(Queue<Integer> queue){
        if(queue.isEmpty()){
            return queue;
        }

        // pop the elements
        int val = queue.poll();

        // reverse()
        reverse(queue);

        // push element
        queue.offer(val);

        // queue
        return queue;
    }

}




class GenerateNumbersWithGivenDigits{
    void generateNumber(int n, HashSet<Long> hset){
        int count = 0;long i = 1;
        while(true){
            if(isValidNumber(i,hset)==true){
                count++;
                System.out.println(i);
            }
            if(count==n){
                break;
            }
            i++;
        }
    }


    private boolean isValidNumber(long x,HashSet<Long> hset){
        while(x!=0){
            long val = x%10;
            if(!hset.contains(val)){
                return false;
            }
            x = x/10;
        }
        return true;
    }


    // ****** Using Queue
    void Generate(int n){

        Queue<String> queue = new LinkedList<String>();

        int count = 0;
        queue.offer("5");
        queue.offer("6");

        while(count<n){
            String val = queue.poll();
            System.out.println(val);
            queue.offer(val+"5");
            queue.offer(val+"6");
            count++;

        }
    }
}



class CheckForBalancedParantise{
    boolean fun1(String x){
        ArrayDeque<Character> st = new ArrayDeque<Character>();

        int n = x.length();
        for(int i=0;i<n;i++){
            char c = x.charAt(i);
            if((c=='[') || (c=='{') || (c=='(')) {
                st.push(c);
            }else{
                if(st.isEmpty()==true){
                    return false;
                }

                char popped = st.pop();
                if(matching(popped,c)==false){
                    return false;
                }
            }
        }

        if(st.isEmpty()==true){
            return true;
        }
        return false;
    }

    boolean matching(char a,char b){
        if(b == ')'){
            b = '(';
        }else if(b=='}'){
            b = '{';
        }else{
            b = '[';
        }

        if(a==b){
            return true;
        }else{
            return false;
        }
    }
}







public class basicsOfQueue {
    public static void main(String[] args){

        CheckForBalancedParantise Obj = new CheckForBalancedParantise();

        System.out.println(Obj.fun1("[{()}]"));

    }
}

