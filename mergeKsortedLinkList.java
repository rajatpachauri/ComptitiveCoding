import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class mergeKsortedLinkList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode merge(ListNode[] list) {
		Comparator<ListNode> cmp = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		};
		ListNode rv = null, node = null;
		PriorityQueue<ListNode> q = new PriorityQueue<>(cmp);

		for (ListNode n : list) {
			if (n != null)
				q.add(n);
		}

		while (q.size() != 0) {
			ListNode rm = q.remove();

			if (rv == null) {
				rv = rm;
				node = rm;
			} else {
				node.next = rm;
				node = node.next;
			}
			if (rm.next != null)
				q.add(rm.next);
		}

		return rv;
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.com

	}

}
