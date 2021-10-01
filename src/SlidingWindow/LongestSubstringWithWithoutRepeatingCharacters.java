package SlidingWindow;

import java.util.*;

public class LongestSubstringWithWithoutRepeatingCharacters
{

    public static void main(String[] args) {

        String arr="pwwkew";

        solve(arr);
    }

    public static void solve(String ss)
    {
        char[] s=ss.toCharArray();
        int n=s.length;

        Map<Character,Integer> mp = new HashMap<>();

        int i = 0, j = 0, ans = -1;

        while (j < n)
        {
            if (mp.containsKey(s[j]))
                mp.put(s[j], mp.get(s[j]) + 1);
            else
                mp.put(s[j], 1);

            if(mp.get(s[j]) == 1)
            {
                ans = Math.max(ans, j-i+1);
            }
            else if(mp.get(s[j])>1)
            {
                while (mp.get(s[j]) >1 && i < n)
                {
                    if (mp.containsKey(s[i]))
                        mp.put(s[i], mp.get(s[i]) - 1);

                    i++;

                    if(mp.get(s[j])==1)
                        ans=Math.max(ans,j-i+1);
                }
            }
            j++;
        }
        System.out.println("The length of longest substring with All Unique characters is : " + ans);
    }

}
