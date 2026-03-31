class LFUCache {
    class Node{
        int feq;
        Node next, prev;
        int key, data;
        Node(int key, int data){
            this.key = key;
            this.data = data;
            this.feq = 1;
        }
    }
    class DLL{
        Node head, tail;
        int size;
        DLL(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size=0;
        }
        void add(Node node){
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next =node;
            size++;
        }

        void delete(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast(){
            if(size > 0){
                Node node = tail.prev;
                delete(node);
                return node;
            }else{
                return null;
            }
        }
    }
    int capacity, size,min;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLL> feqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        feqMap = new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.data;
        
    }
    
    public void put(int key, int value) {
        
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.data = value;
            update(node);
        }else{
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            if(size == capacity){
                DLL last = feqMap.get(min);
                Node lastNode = last.removeLast(); //rm fron DLL
                nodeMap.remove( lastNode.key ); // rm from map
                size--;
            }
            min = 1;
            DLL newList = feqMap.getOrDefault(node.feq, new DLL());
            newList.add(node);
            feqMap.put(node.feq, newList);
            size++;

        }
        
    }
    public void update(Node node){
        DLL list = feqMap.get(node.feq);
        list.delete(node);
        if(node.feq == min && list.size ==0) min++;
        node.feq++;
        DLL newList = feqMap.getOrDefault(node.feq, new DLL());
        newList.add(node);
        feqMap.put(node.feq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */