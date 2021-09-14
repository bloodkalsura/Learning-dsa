package Array;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args)
    {
        int[] a1 = { 10, 27, 38, 43, 82 };
        int[] a2 = { 3, 9 };

        merge(a1, a2, a1.length, a2.length);


    }

    public static void merge(int[] a1,int[] a2,int l1,int l2)
    {
        int k=0;

        while(k<l1)
        {
            if(a1[k]<a2[0]) {
                int temp=a1[k];
                a1[k]=a2[0];
                a2[0]=temp;

                Arrays.sort(a2);
            }
            k++;
        }

        System.out.print("First Array: ");
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }

        System.out.println();

        System.out.print("Second Array: ");
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
    }
}
