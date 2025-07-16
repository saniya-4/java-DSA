import java.util.*;
class Dis{
 List<Integer>rank=new ArrayList<>();
 List<Integer>parent=new ArrayList<>();
 public Dis(int n)
 {
    for(int i=0;i<=n;i++)
    {
        rank.add(0);
        parent.add(i);
    }
 }
 public  int findPair(int n)
 {
    if(n==parent.get(n))
    {
        return n;
    }
    int ulp=findPair(parent.get(n));
    parent.set(n,ulp);
    return parent.get(n);
    
 }
 public void unionByRank(int u,int v)
 {
    int ulp_u=findPair(u);
    int ulp_v=findPair(v);
    //as they belong to the same component no need to connect anyone to anyone;
    if(ulp_u==ulp_v)
    {
        return;
    }
    if(rank.get(ulp_u)<rank.get(ulp_v))
    {
        parent.set(ulp_u,ulp_v);
    }
    else if(rank.get(ulp_v)<rank.get(ulp_u))
    {
        parent.set(ulp_v,ulp_u);
    }
    else
    {
        parent.set(ulp_v,ulp_u);
        int rankU=rank.get(ulp_u);
        rank.set(ulp_u,rankU+1);

    }
 }
}
public class disjoint {
    public static void main(String[] args) {
      Dis ds=new Dis(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        if(ds.findPair(3)==ds.findPair(7))
        {
            System.out.println("same");
        }
        else{
            System.out.println("different");
        }
        ds.unionByRank(3,7);
        if(ds.findPair(3)==ds.findPair(7))
        {
            System.out.println("same");
        }
        else{
            System.out.println("different");
        }
    }
}
