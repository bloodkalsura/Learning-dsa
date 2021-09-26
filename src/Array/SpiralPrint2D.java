package Array;

public class SpiralPrint2D {

    public static void main(String[] args) {
        int[][] arr={{2,3,4,7,9},
                     {6,8,9,2,3},
                     {7,5,9,10,11},
                     {12,9,4,6,3}};

        solve(arr);
    }

    public static void solve(int[][] arr)
    {
        int minc=0;
        int minr=0;
        int maxr=arr.length-1;
        int maxc=arr[0].length-1;
        int max=arr.length*arr[0].length;
        int count=0;

        while(count<max)
        {
            //left wall
            for(int i=minr,j=minc;i<=maxr && count<max;i++)
            {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            minc++;
            //lower wall
            for(int i=maxr,j=minc;j<=maxc && count<max;j++)
            {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            maxr--;
            //right wall
            for(int i=maxr,j=maxc;i>=minr && count<max;i--)
            {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            maxc--;
            //upper wall
            for(int i=minr,j=maxc;j>=minc && count<max;j--)
            {
                System.out.print(arr[i][j]+" ");
                count++;
            }
            minr++;
        }
    }
}
/*
 {2,3,4,7,9},
 {6,8,9,2,3},
 {7,5,9,10,11},
 {12,9,4,6,3}};
 */