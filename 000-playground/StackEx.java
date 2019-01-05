public class StackEx {

    //Keeps track of stack size
    private int length = 0;
   
    //Keep track of node on top of the stack
    private Node top = null;

    //Push node on top of the stack
    public void push(int item) {
        Node node = new Node(item);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }

        length++;
    }

    //Pop (Remove and return) node on top if the stack
    public int pop() {
        int result = -1;

        if (top != null) {
            result = top.data;
            top = top.next;
            length--;
        }

        return result;
    }
   
    //Returns node what is on top of the stack but does remove that node from the stack
    public int peek() {
        return (top == null) ? -1 : top.data;
    }

    // Print stack contains 
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node tempNode = null;
        result.append("[");
       
        if (top != null) {
            for(tempNode = top; tempNode != null; tempNode = tempNode.next) {
                result.append(tempNode.data + " ");
            }
        }

        result.append("]");
       
        return result.toString();
    }

    //Get stack size
    public int size() {
        return length;
    }
   
    //main method to test stack operations 
    public static void main(String[] args) {
        StackEx stack = new StackEx();

        System.out.println("Stack Length: " + stack.size());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        System.out.println("Stack Length: " + stack.size());
       
        System.out.println("Peek: " + stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println("Stack Length: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println("Stack Length: " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println("Stack Length: " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Stack Length: " + stack.size());
    }

    //Node class which contains actual payload. Keeping this class private to avoid exposing node object structure. 
    private class Node {
        //it stores reference to next item in the stack
        private Node next = null;
       
        //Node can store data as integer but code can be tweaked to store ArrayList or any other java object.
        private int data = 0;

        private Node(int value) {
            this.data = value;
        }
    }
}