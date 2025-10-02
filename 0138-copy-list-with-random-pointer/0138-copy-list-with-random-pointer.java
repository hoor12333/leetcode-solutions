import java.util.*; // make sure to import this for HashMap

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // First pass: make all nodes and store mapping from original to copy
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: assign next and random pointers
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
