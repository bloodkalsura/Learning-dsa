package Stack;

import java.util.Stack;

public class StackSpan {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] arr={100,80,60,70,60,75,85};

        int[] ans=spanOfStock(arr,arr.length);

        for(int i:ans)
            System.out.print(i+" ");
    }

    public static int[] spanOfStock(int[] arr,int n)
    {
        Stack<Integer> s=new Stack<>();
        //int[] ngl=new int[n];
        int ans[]=new int[n];
        //{100,80,60,70,60,75,85}
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && arr[i]>=arr[s.peek()])
                s.pop();

            if(s.isEmpty())
                ans[i]=i+1;
            else
                ans[i]=i-s.peek();

            s.push(i);
        }
        return ans;
    }

}
