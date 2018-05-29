package test;


public class ReverseLinkedList {

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
    
	public void solve(int k, Node node) {
		Node head = null;
		while (node != null) {
			for (int i = 0; i < k; i++) {
				node = node.next;
				if (node == null) {
					return;
				}
			}
			
			Node end = node;
			reverse(head, end);
			
			head = node;
		}
	}
	public void reverse(Node begin, Node end){
		Node current = begin.next;
		Node previous = begin;
		
		
		while(current != end.next){
			Node tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		

		}
		
	}
}
