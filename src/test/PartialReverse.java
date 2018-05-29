package test;

public class PartialReverse {

    public static void main(String args[]) {
        Node head = createNewList(21);
        head.print();
        head = partialReverse(head, 5);
        head.print();
    }

    public static Node partialReverse(Node head, int k) {
        if(k <= 1) return head;
        Node startBefore = head;
        Node currentNode = head;
        for (int i = 0; currentNode != null; i++, currentNode = currentNode.next) {
            if ((i + 1) % k == 0) {
                //at a multiple of k
                Node start = null;
                if (head == startBefore) {
                    start = head;
                    head = reverseLinkedListWithBoundaries(null, start, currentNode.next);
                } else {
                    start = startBefore.next;
                    reverseLinkedListWithBoundaries(startBefore, start, currentNode.next);
                }
                currentNode = start;
                startBefore = start;
            }
        }

        return head;
    }

    public static Node reverseLinkedListWithBoundaries(Node beforeStart, Node start, Node endBefore) {
        //If start is the head it will return the new head(beforeStart would be null);
        Node previous = null;
        Node node = start;
        while (node != endBefore) {
            Node next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
        start.next = endBefore;
        if (beforeStart != null) {
            beforeStart.next = previous;
        }
        return previous;
    }

    public static Node createNewList(int length) {
        Node head = null;
        Node last = null;
        for (int i = 1; i <= length; i++) {
            Node current = new Node(i);
            if (last == null) {
                head = current;
            } else {
                last.next = current;
            }
            last = current;
        }
        return head;
    }

    public static class Node {
        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Integer value) {
            this.value = value;
        }

        public void print() {
            Node n = this;
            while (n != null) {
                System.out.print("  " + n.value + "  ");
                n = n.next;
            }
            System.out.print("\n");
        }

        public Integer value;
        public Node next;
    }
}
