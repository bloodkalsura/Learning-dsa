package Stack;

import java.util.Stack;

public class NextSmallerLeft {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] arr={9,7,6,3,5,9,10,2};

        int[] ans=nextSmallerLeft(arr,8);

        for(int i=0;i<8;i++)
            System.out.print(ans[i]+" ");
    }

    public static int[] nextSmallerLeft(int[] arr,int n)
    {
        Stack<Integer> s=new Stack<>();
        int[] ans=new int[n];

        for(int i=0;i<n;i++) {
            while (!s.isEmpty() && arr[i] <= s.peek())
                s.pop();

            if (s.isEmpty())
                ans[i] = -1;
            else
                ans[i] = s.peek();

            s.push(arr[i]);
        }
        return ans;
    }
}
