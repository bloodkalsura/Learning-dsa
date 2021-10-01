package SlidingWindow;

import java.util.*;

public class PickToys {

    public static void main(String[] args) {

        String ss="abbaaccab";
        int k=2;

        solve(ss,k);
    }

    public static void solve(String ss,int k)
    {
        char[] s=ss.toCharArray();

        int i=0,j=0,ans=-1;
        int n=s.length;

        Map<Character,Integer> mp=new HashMap<>();

        while(j<n)
        {
            if(mp.containsKey(s[j]))
                mp.put(s[j],mp.get(s[j])+1);
            else
                mp.put(s[j],1);

            if(mp.size()==k)
            {
                ans=Math.max(ans,j-i+1);

                j++;
            }
            else if(mp.size()<k)
                j++;
            else if(mp.size()>k)
            {
                if(mp.containsKey(s[i]))
                    mp.put(s[i],mp.get(s[i])-1);

                if(mp.get(s[i])==0)
                    mp.remove(s[i]);

                i++;
            }
        }

        System.out.println("Maximum "+k+" types of toys that the pick can pick are : "+ans);
    }
}
