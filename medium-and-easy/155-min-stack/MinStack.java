class MinStack {
    private class Node{
        Node next = null;
        Node nextMin = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }
    Node min = null;
    Node top = null;
    /** initialize your data structure here. */
    public MinStack() {
    }
    public void push(int x) {
        Node newNode = new Node(x);
        if(this.top == null) {
            this.top = newNode;
            this.min = newNode;
        } else {
            if(newNode.value < this.min.value) {
                newNode.nextMin = this.min;
                this.min = newNode;
            }
            newNode.next = this.top;
            this.top = newNode;
        }
    }
    public void pop() {
        if(this.top.next == null) {
            this.min = null;
        } else if(this.top == this.min) {
            this.min = this.top.nextMin;
        }
        this.top = this.top.next;
    }
    
    public int top() {
        return this.top.value;
    }
    
    public int getMin() {
        return this.min.value;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */