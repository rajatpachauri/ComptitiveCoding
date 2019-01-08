import java.util.*;
import java.lang.*;
class Height
{
    int feet;
    int inches;
    
      public Height(int ft, int inc)
      {
           feet = ft;
           inches = inc;
      }
}
class maximum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Height arr[] = new Height[n];
            for(int i = 0; i < n; i++)
            {
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();
                arr[i] = new Height(temp1, temp2);
              
            }
            GfG gfg = new GfG();
            
            int res = gfg.findMax(arr, n);
            System.out.println(res);
        }
    }
}

class GfG
{
	public static int findMax(Height arr[], int n)
    {
		int max=arr[0].feet*12 + arr[0].inches;
        for(int i=1;i<arr.length;++i){
            if(max<arr[i].feet*12+arr[i].inches){
                max=arr[i].feet*12+arr[i].inches;
            }
        }
        
        return max;
    }
    
}