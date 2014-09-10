import java.util.Stack;

public class BiNode {
	public BiNode node1;
	public BiNode node2;
	public int data;

	public BiNode(BiNode n1, BiNode n2, int d) {
		node1 = n1;
		node2 = n2;
		data = d;
	}

	public BiNode(int d) {
		data = d;
	}

	public static BiNode transfer_bst_to_linkedList(BiNode root) {
		BiNode listStart = null;
		BiNode cur = root;
		BiNode prev = null;
		Stack<BiNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.node1;
			}
			if (!stack.isEmpty()) {
				BiNode bn = stack.pop();
				if (listStart == null)
					listStart = bn; //the start node of double linked list

				//link nodes back and forward
				if (prev != null)
					prev.node2 = bn;
				bn.node1 = prev;
				prev = bn;
				//System.out.println(bn.data);
				cur = bn.node2;
			}
		}
		return listStart;
	}

	public static void main(String[] args) {
		BiNode root = new BiNode(4);
		root.node1 = new BiNode(2);
		root.node2 = new BiNode(5);
		root.node1.node1 = new BiNode(1);
		root.node1.node2 = new BiNode(3);
		root.node2.node2 = new BiNode(6);
		root.node1.node1.node1 = new BiNode(0);
		BiNode listStart = transfer_bst_to_linkedList(root);
		BiNode listEnd = null;
		while (listStart != null) {
			System.out.print(listStart.data + "; ");
			if (listStart.node2 == null)
				listEnd = listStart;
			listStart = listStart.node2;
		}
		System.out.println();
		while (listEnd != null) {
			System.out.print(listEnd.data + "; ");
			listEnd = listEnd.node1;
		}
	}
}