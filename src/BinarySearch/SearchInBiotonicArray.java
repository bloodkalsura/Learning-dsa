package BinarySearch;

public class SearchInBiotonicArray {

    public static void main(String args[])
    {
        int arr[] = { -8, 1, 2, 3, 4, 5, -2, -3 };
        int key = 5;
        int n, l, r;
        n = arr.length;
        l = 0;
        r = n - 1;
        int index;
        index = findBitonicPoint(arr, n, l, r);

        int x = searchBitonic(arr, n, key, index);

        if (x == -1) {
            System.out.println("Element Not Found");
        }
        else {
            System.out.println("Element Found at index "
                    + x);
        }
    }

    public static int findBitonicPoint(int[] arr,int n,int l,int r)
    {
        while(l<r)
        {
            int mid=l+(r-l)/2;

            if(mid!=0 && mid!=n-1)
            {
                if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid])
                    return mid;

                else if(arr[mid-1]>arr[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }
            if(mid==0 && arr[mid+1]>arr[mid])
                return mid+1;

            if(mid==n-1 && arr[mid-2]>arr[mid-1])
                return mid-2;
        }
        return -1;
    }

    static int searchBitonic(int arr[], int n,
                             int key, int index)
    {
        if (key > arr[index])
        {
            return -1;
        }
        else if (key == arr[index])
        {
            return index;
        }
        else {
            int temp = ascendingBinarySearch(
                    arr, 0, index - 1, key);
            if (temp != -1)
            {
                return temp;
            }

            // Search in right of k
            return descendingBinarySearch(arr, index + 1,
                    n - 1, key);
        }
    }

    static int ascendingBinarySearch(int arr[],
                                     int low,
                                     int high,
                                     int key)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }
            if (arr[mid] > key)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int descendingBinarySearch(int arr[],
                                      int low,
                                      int high,
                                      int key)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }
            if (arr[mid] < key)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }

}
