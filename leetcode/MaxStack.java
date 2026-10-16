package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Approach 1 - Use stack for LIFO order-> Simple stack don't provide peekMax and popMax
 * Approach 2 - Use stack for LIFO and max Heap for tracking maximums-> But heaps don't support efficient arbitrary deletion
 * Optimal Approach - doubly-linked list (for O(1) deletion at any position) with a TreeMap/balanced BST (for O(log n) max lookup and removal).
 */
class Node {
    int val;
    Node prev;
    Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }
}

class DoubleLinkedList {
    private final Node head;
    private final Node tail;

    DoubleLinkedList() {
        head = new Node();
        tail = new Node();
        tail.prev = head;
        head.next = tail;
    }
// Node will come in between tail and its previous
    public Node append(int val) {
        Node newNode = new Node(val);
        Node prevNode = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        return newNode;
    }

    public Node remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        return node;
    }

    public Node pop() {
        return remove(tail);
    }

    public int peek(){
        return tail.val;
    }
}

public class MaxStack {
    private final DoubleLinkedList stack;
    private final TreeMap<Integer, List<Node>> heap;

    MaxStack(){
        stack = new DoubleLinkedList();
        heap = new TreeMap<>();
    }

    public void push(int val) {
        Node node = stack.append(val);
        heap.getOrDefault(val, new ArrayList<>()).add(node);
    }

    public int pop(){
        Node node = stack.pop();
        List<Node> nodes = heap.get(node.val);
        int val = nodes.remove(nodes.size() - 1).val;
        if (nodes.isEmpty()) {
            heap.remove(node.val);
        }
        return val;
    }

    public int top(){
        return stack.peek();
    }

    public int peekMax(){
        return heap.lastKey();
    }

    public int popMax(){
        int val = peekMax();
        List<Node> nodes = heap.get(val);
        Node node = nodes.remove(nodes.size() - 1);
        if (nodes.isEmpty()) {
            heap.remove(val);
        }

        stack.remove(node);
        return val;
    }


}
