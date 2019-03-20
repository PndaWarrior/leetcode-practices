import java.util.HashMap;

class LRUCache146 {

    class DLinkedNode {
        
        DLinkedNode next;
        DLinkedNode previous;
        int key;
        int value;
    }
    
    int size = 0;
    int capacity;
    HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    
    DLinkedNode head, tail;
    
    private void addNode(DLinkedNode node) {
        
        node.next = head.next;
        node.previous = head;
        
        head.next.previous = node;
        head.next = node;
        
    }
    
    private void removeNode(DLinkedNode node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
    
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode popTail() {
        DLinkedNode result = tail.previous;
        removeNode(result);
        return result;
    }
    
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.next = tail;
        tail.previous = head;
        
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        
        moveToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            
            newNode.key = key;
            newNode.value = value;
            
            addNode(newNode);
            cache.put(key, newNode);
            ++size;
            
            if(size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
            
        } else {
            node.value = value;
            
            moveToHead(node);
            cache.put(key, node);
        }
        
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */