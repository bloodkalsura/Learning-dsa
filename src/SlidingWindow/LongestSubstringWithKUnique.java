package SlidingWindow;

import java.util.*;

public class LongestSubstringWithKUnique {

    public static void main(String[] args)
    {
        String arr = "aabacebebebe";
        int k = 3;

        int n = arr.length();

        solve(arr, n, k);
    }

    public static void solve(String arr, int n, int k)
    {
        char[] s = arr.toCharArray();

        Map<Character,Integer> mp = new HashMap<>();

        int i = 0, j = 0, ans = 0;

        while (j < n)
        {
//            System.out.print(s[j] + " ");
            if (mp.containsKey(s[j]))
                mp.put(s[j], mp.get(s[j]) + 1);
            else
                mp.put(s[j], 1);

            if (mp.size() < k)
                j++;
            else if (mp.size() == k)
            {
                int temp = j - i + 1;
                ans = Math.max(ans, temp);

                j++;
            }
            else if (mp.size() > k)
            {
                while (mp.size() > k && i < n)
                {
                    if (mp.containsKey(s[i]))
                        mp.put(s[i], mp.get(s[i]) - 1);

                    if (mp.get(s[i]) == 0)
                    {
                        mp.remove(s[i]);
                    }
                    i++;
                }
            }
        }

        System.out.println("The longest substring with K Unique characters is : " + ans);
    }
}
