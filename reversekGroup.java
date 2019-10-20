
public class reversekGroup {
	 public ListNode reverseKGroup(ListNode head, int k) {
	        int temp=0;
	        ListNode curr=head, prev=null,next=null;
	        while(curr!=null){
	            ++temp;
	            curr=curr.next;
	            if(temp==k)
	                break;
	        }
	        if(temp<k)
	            return head;
	        
	        curr=head;
	        int count=0;
	        
	        while(count<k&&curr!=null){
	            next=curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=next;
	            ++count;
	        }
	        if(next!=null)
	        head.next=reverseKGroup(next,k);
	        
	        return prev;
	    }
}
