package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurancesOfAnagrams {

    public static int solve(String ss, String anaa)
    {
        char[] s=ss.toCharArray();
        char[] ana=anaa.toCharArray();

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

                if(mp.containsKey(s[j]))
                {
                    mp.put(s[j],mp.get(s[j])+1);

                    if(mp.get(s[j])==1)
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
        String s = "forxxorfxdofr";
        String ana = "for";

        int ans = solve(s, ana);
        System.out.println("The total number of Anagrams in the given strings are : "+ans);
    }
}
