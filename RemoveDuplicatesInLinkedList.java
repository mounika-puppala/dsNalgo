package LinkedLists;

public class RemoveDuplicatesInLinkedList {
	
	
	public static void main(String[] args){

		Node n1 = new Node(1, null);
		n1.next = new Node(1, null);
		n1.next.next = new Node(1, null);
		n1.next.next.next = new Node(3, null);
		n1.next.next.next.next = new Node(5,null);
		n1.next.next.next.next.next = new Node(9,null);
		
		removeDuplicatesFromLinkedList(n1);
		printLinkedList(n1);
		
	}

	public static Node removeDuplicatesFromLinkedList(Node head) {
		Node curr = head;
		while(curr!=null && curr.next!=null) {
			if(curr.value == curr.next.value) {
				curr.next = curr.next.next;
			}
			//edge case 1-->1-->1-->1-->3-->5-->9-->null
            if(curr.next!=null && curr.value != curr.next.value)
    			curr = curr.next;
		}
		
		//Simple version
//		while(curr!=null && curr.next!=null) {
//			if(curr.value == curr.next.value) {
//				curr.next = curr.next.next;
//			} else {//edge case 1-->1-->1-->1-->3-->5-->9-->null
//				curr = curr.next;
//			}
//		}
		
		
		return head;
	}
	
	public static void printLinkedList(Node head) {
		while(head!=null) {
			System.out.print(head.value+"-->");
			head = head.next;
		}
		System.out.print("null");
	}
}

final class Node{
	int value;
	Node next;

 	 Node(int x, Node n){
		value = x;
		next = n;
	}

}