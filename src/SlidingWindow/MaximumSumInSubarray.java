package SlidingWindow;

public class MaximumSumInSubarray {

    public static void main(String[] args) {

        int[] arr={100,200,300,400,500,150};

        int n=arr.length;

        int k=2;

        solve(arr,n,k);
    }

    public static void solve(int[] arr,int n,int k)
    {
        int max=-1;
        int i=0,j=0;
        int sum=0;

        while(j<n)
        {
            sum+=arr[j];

            if (j-i+1<k)
            {
                j++;
            }
            else if(j-i+1==k)
            {
                max=Math.max(max,sum);
                sum-=arr[i];
                i++;
                j++;
            }
            max=Math.max(max,sum);

        }

        System.out.println("The maximum of Subarray is : "+max);
    }
}
