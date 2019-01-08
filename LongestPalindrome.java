
import java.util.*;
import java.lang.Math;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class PalindromeLL{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Node head=null;
			head=insert(head,sc.nextInt());
			for(int i=1;i<n;i++)
				insert(head,sc.nextInt());
			GfG g=new GfG();
			System.out.println(g.maxPalindrome(head));
		}
	}
	public static Node insert(Node head,int val){
		if(head==null)
			return new Node(val);
		head.next=insert(head.next,val);
		return head;
	}
	/*public static void print(Node head){
		while(head!=null){
			System.out.println(head.data);
			head=head.next;
		}
	}*/

static class GfG
{
    private static int palindrome(int[] arr) {
		int count = 0, count2 = 0, temp = 0, temp2 = 0;

		double axis = 0, orbit;
		for (axis = 0; axis < arr.length; ++axis) {
			count = -1;
			for (orbit = 0; orbit <= arr.length / 2; ++orbit) {

				if (axis + orbit >= arr.length || axis - orbit < 0) {
					break;

				}
				if (arr[(int) (axis + orbit)] == arr[(int) (axis - orbit)]) {
					count+=2;
				} else {
					break;
				}
			}
			temp = temp > count ? temp : count;
		}
		
		
		for (axis = 0.5; axis < arr.length; ++axis) {
			count2 = 0;
			for (orbit = 0.5; orbit <= arr.length / 2; ++orbit) {

				if (axis + orbit >= arr.length || axis - orbit < 0) {
					break;

				}
				if (arr[(int) (axis + orbit)] == arr[(int) (axis - orbit)]) {
					count2+=2;
				} else {
					break;
				}
			}

			temp2 = temp2 > count2 ? temp2 : count2;

		}
		return temp > temp2 ? temp : temp2;
	}

    
        public static int maxPalindrome(Node head)
        {
          //add code here.
          
          int count=0;
          Node node=head;
          while(node!=null){
              ++count;
              node=node.next;
          }
          
          int[] arr = new int[count+1];
          
          count=0;
          node=head;
          while(node!=null){
              ++count;
              arr[count]=node.data;
              node=node.next;
          }
          
          return palindrome(arr);
          
          
        }
}
}