//Implement stack using deque
import java.util.Deque;
import java.util.LinkedList;

public class Question130 {
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();

        //add
        public void push(int data){
            deque.addLast(data);
        }

        //remove
        public int pop(){
            return deque.removeLast();
        }

        //peek
        public int peek(){
            return deque.getLast();
        }
    }
    public static void main(String[] args) {
       Stack s = new Stack();
       s.push(1); 
       s.push(2);
       s.push(3);
       System.out.println("peek: " + s.peek());
       System.out.println(s.pop());
       System.out.println(s.pop());
       System.out.println(s.pop());
    }
}
