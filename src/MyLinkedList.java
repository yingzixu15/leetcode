public class MyLinkedList {
    Node head;
    Node tail;
    int size;
    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index >= this.size || index < 0)
            return -1;
        Node cur = getNode(index);
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        if (this.head == null) {
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
        }
        this.head = newNode;
        this.size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.prev = this.tail;
        if (this.tail == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size)
            return;
        Node newNode = new Node(val);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else if (index == this.size) {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        } else if (index == 0) {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        } else {
            Node nextNode = getNode(index);
            Node prevNode = nextNode.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size)
            return;
        Node target = getNode(index);
        if (target.prev != null)
            target.prev.next = target.next;
        if (target.next != null)
            target.next.prev = target.prev;
        if (index == 0)
            this.head = target.next;
        if (index == this.size - 1)
            this.tail = target.prev;
        this.size--;
    }

    private Node getNode(int index) {
        Node cur;
        if (index >= this.size / 2) {
            cur = this.tail;
            for (int i = this.size - 1; i > index; i--)
                cur = cur.prev;
        } else {
            cur = this.head;
            for (int i = 0; i < index; i++)
                cur = cur.next;
        }
        return cur;
    }
}
