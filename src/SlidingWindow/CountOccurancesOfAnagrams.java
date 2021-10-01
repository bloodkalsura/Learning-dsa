package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurancesOfAnagrams {

    public static int solve(String ss, String anaa)
    {
        char[] s=ss.toCharArray();
        char[] ana=anaa.toCharArray();


        // Generate a map of all character occurances of the 2nd string, i.e char and its count.
        // The window size becomes the length of 2nd string, as the anangrams wil also be of this length, amd another variable count denotes the distinct characters left in a sliding window.
        // In a window if the current character is present in map, then decrease its count, and if the count becomes 0, decrease the 'count' variable.
        // If the window size is lesser than k just move forward the window
        // When the window is hit ->
        // If the count is 0, it means all the characters needed for its anagram is here in it, therefore increase your answer
        // To remove the last part (arr[i] part) so that the window can be shifted ->
        // If the s[i] is present in map then increase its count and if it changes from 0->1 then increase the 'count' variable


        Map<Character,Integer> mp=new HashMap<>();

        for(char i : ana)
        {
            if(mp.containsKey(i))
                mp.put(i,mp.get(i)+1);
            else
                mp.put(i,1);
        }

        int k=ana.length;
        int count=mp.size();

        int i=0, j=0;
        int ans=0;

        while(j<s.length){

            if(mp.containsKey(s[j])){
                mp.put(s[j],mp.get(s[j])-1);

                if(mp.get(s[j])==0)
                    count--;
            }

            if((j-i+1)<k)
                j++;

            else if((j-i+1)==k){

                if(count==0)
                    ans++;

                if(mp.containsKey(s[i]))
                {
                    mp.put(s[i],mp.get(s[i])+1);

                    if(mp.get(s[i])>0)
                        count++;
                }

                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {


        // Given a string, and another string, find count of occurances of all anagrams of 2nd one in 1st one.

        // Input : "forxxorfxdofr", "for"
        // Output : 3
        // Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.

        String s = "forxxorfxdofr";
        String ana = "for";

        int ans = solve(s, ana);
        System.out.println("The total number of Anagrams in the given strings are : "+ans);
    }
}
