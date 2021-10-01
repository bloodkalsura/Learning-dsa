package SlidingWindow;

public class LargestSubarrayOfVariableSize {

    public static void main(String[] args) {
        int[] arr={4,1,1,1,2,3,5};

        int n=arr.length;
        int k=6;

        solve(arr,n,k);
    }

    public static void solve(int[] arr,int n,int k)
    {
        int i=0,j=0;
        int sum=0;
        int max=-1;

        while(j<n)
        {
            sum+=arr[j];

            if(sum<k)
                j++;

            else if(sum==k)
            {
                max=Math.max(max,(j-i+1));
                sum-=arr[i];
                i++;
                j++;
            }
            else if(sum>k && i<n)
            {
                while(sum>k && i<n)
                {
                    sum-=arr[i];
                    i++;
                }
            }
        }

        System.out.println("The largest subarray of size K is :"+max);

    }
}
