package SlidingWindow;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        solve(s,t);
    }

    public static void solve(String ss,String tt)
    {
        char[] s=ss.toCharArray();
        char[] t=tt.toCharArray();

        Map<Character,Integer> mp=new HashMap<>();

        for(char i:t)
        {
            if(mp.containsKey(i))
                mp.put(i,mp.get(i)+1);
            else
                mp.put(i,1);
        }

        int count=mp.size();
        int i=0,j=0,min=Integer.MAX_VALUE;
        int x=-1,y=-1;

        while(j<s.length)
        {
            if(mp.containsKey(s[j]))
            {
                mp.put(s[j],mp.get(s[j])-1);
                if(mp.get(s[j])==0)
                    count--;

                j++;
            }
            else
                j++;

            if(count==0)
            {
                while(count==0)
                {
                    if(j-i<min)
                    {
                        min=Math.min(min,j-i);
                        x=i;
                        y=j;
                    }


                    if(mp.containsKey(s[i]))
                    {
                        mp.put(s[i],mp.get(s[i])+1);

                        if(mp.get(s[i])>0)
                            count++;
                        i++;
                    }
                    else
                        i++;
                }
            }
        }

        for(int z=x;z<y;z++)
            System.out.print(s[z]+" ");

        System.out.println("The Minimum Window Substring of size : "+min);
    }
}
