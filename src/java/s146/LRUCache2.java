package s146;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chao on 2018/11/28.
 *
 * 最快答案
 */
public class LRUCache2 {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Map<Integer, Node> map = new HashMap<>();

    int size = 0;
    Node dummy = new Node();
    Node tail = new Node();
    int capa;

    public LRUCache2(int capacity) {
        capa = capacity;
        dummy.next = tail;
        tail.prev = dummy;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node i = map.get(key);
        Node tempPrev = i.prev;
        Node tempNext = i.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
        Node tempTailPrev = tail.prev;
        tempTailPrev.next = i;
        i.prev = tempTailPrev;
        i.next = tail;
        tail.prev = i;
        return i.value;

    }

    public void put(int key, int value) {
        Node i = map.get(key);
        if (i == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            if(size >= capa){
                Node tempHead = dummy.next;
                dummy.next = tempHead.next;
                dummy.next.prev = dummy;
                map.remove(tempHead.key);
            }
            map.put(key, newNode);
            Node tempTailPrev = tail.prev;
            tempTailPrev.next = newNode;
            newNode.prev = tempTailPrev;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        } else {
            i.value = value;
            Node tempPrev = i.prev;
            Node tempNext = i.next;
            tempPrev.next = tempNext;
            tempNext.prev = tempPrev;

            Node tempTailPrev = tail.prev;
            tempTailPrev.next = i;
            i.prev = tempTailPrev;
            i.next = tail;
            tail.prev = i;
        }
    }
}
