/* Helios 
~~ Je Crois En Moi ~~
 
 */

import java.io.*;
import java.math.*;
import java.util.*;
import java.lang.*;
 
public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
         PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
           while(t-->0)
           {
               
           }
          out.close();
    }
    public static int __gcd(int a,int b)
    {
          if(b==0)
          {
              return a;
          }
          return __gcd(b,a%b);
    }
    
    public static int __lcm(int a,int b)
    {
          int get_gcd=Main.__gcd(a,b);
             return ((a*b)/get_gcd);
    }
    //sieve ~ primes btw a range
    public static boolean[] sieve_of_eratosthenes(int limit)
    {
        boolean prime[]=new boolean[limit+1];
         Arrays.fill(prime,true);
          for(int i=2;i*i<=limit;i++)
          {
              if(prime[i]==true)
              {
                  for(int j=i*i;j<=limit;j=j+i)
                  {
                      prime[j]=false;
                  }
              }
          }
          return prime;
    }
    //Primality Test
    public static boolean Isprime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    // wheel factorization 
    public static ArrayList<Integer>Prime_factors(int n) {
        ArrayList<Integer> li = new ArrayList<>();
        
        while (n % 2 == 0) {
            li.add(2);
            n /= 2;
        }
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                li.add(i);
                n /= i;
            }
        }
        if (n > 2) 
            li.add(n);
        return li;
    }
// Divisors/Factors of a num
    public static ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> li = new ArrayList<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                li.add(i);
                if (i != n / i) {
                    li.add(n / i);
                }
            }
        }
        return li;
    }
    public static int[] segment_tree(FastReader k)
    {
           int n=k.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=k.nextInt();
            }
            int tree[]=new int[2*n];
            Main.buildtree(a,tree,0,a.length-1,1);
              return tree;
    }
    public static void buildtree(int a[],int tree[],int start,int end,int index)
    {
           if(start==end)
           {
               tree[index]=a[start];
                 return;
           }
           int mid=start+(end-start)/2;
            buildtree(a,tree,start,mid,2*index);
            buildtree(a,tree,mid+1,end,2*index+1);
              tree[index]=tree[2*index]+tree[2*index+1];
    }
    public static void updatetree(int a[],int tree[],int start,int end,int index,int index_change,int value)
    {
        if(start==end)
        {
            a[index_change]=value;
            tree[index]=value;
             return;
        }
        int mid=start+(end-start)/2;
         if(index_change>mid)
         {
             updatetree(a,tree,mid+1,end,2*index+1,index_change,value);
         }
         else{
             updatetree(a,tree,start,mid,2*index,index_change,value);
         }
         tree[index]=tree[2*index]+tree[2*index+1];
    }
    
    public static int query(int tree[],int start,int end,int index,int left,int right)
    {
          //completely outside
          
          if(start>right || end<left)
          {
              return 0;
          }
          //completely inside
          else if(start>=left && end<=right)
          {
               return tree[index];
          }
          int mid=start+(end-start)/2;
          int ans1=query(tree,start,mid,2*index,left,right);
          int ans2=query(tree,mid+1,end,2*index+1,left,right);
            return ans1+ans2;
    }

  public static void dfs(ArrayList<ArrayList<Integer>>edges,int node,int parent)
	{
	      System.out.print(node+" ");
	    for(int i=0;i<edges.get(node).size();i++)
	    {
	           if(edges.get(node).get(i)!=parent)
	           {
	               dfs(edges,edges.get(node).get(i),node);
	           }
	    }
	    
	    
	}
    
}