package Stack;

import java.util.*;
import java.lang.*;

class nextGreaterElementInArray
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] arr={9,7,6,3,5,9,10,2};

        int[] ans=nextGreaterElement(arr,8);

        for(int i=0;i<8;i++)
            System.out.print(ans[i]+" ");
    }

    public static int[] nextGreaterElement(int[] arr,int n)
    {
        Stack<Integer> s=new Stack<Integer>();

        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--)
        {
            if(!s.isEmpty())
                while(!s.isEmpty() && arr[i]>=s.peek())
                    s.pop();

            if(s.isEmpty())
                ans[i]=-1;
            else
                ans[i]=s.peek();

            s.push(arr[i]);
        }

        return ans;
    }
}