package cs61b.src.mid1spring2005;

public class DListNode {
	public int item;
	public DListNode prev, next;
	
	public DListNode(int i, DListNode p, DListNode n){
		item = i;
		prev = p;
		next =n;
	}
		
	public static DListNode makeList(int [] counts){
		DListNode p = null;
		DListNode head = null;
		for(int i = 0; i < counts.length; i++){
			int number = counts[i];
			
			for(int j = 0; j < number; j++){
				if(j == 0 && i == 0) {
					p = new DListNode(number, null, null);
					head = p;
				}else{
					p.next = new DListNode(number, p, null);
					p = p.next;
				}
				
			}
			
		}
		
		return head;
	}
	public static void main(String[] args) {
		
		int counts[] = {3, 2, 3};
		DListNode node = DListNode.makeList(counts);
		while(node.next != null){
			System.out.print(node.item + " ");
			node = node.next;
		}
		System.out.println(node.item);// last item
	}

}
