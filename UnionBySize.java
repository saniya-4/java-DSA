import java.util.*;
class dis{
    List<Integer>parent=new ArrayList<>();
    List<Integer>size=new ArrayList<>();
    public dis(int n)
    {
        for(int i=0;i<=n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }
        int ulp=findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void  UnionBySize(int u,int v)
    {
        int ulp_u=findParent(u);
        int ulp_v=findParent(v);
        if(ulp_u==ulp_v)
        {
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
public class UnionBySize {
    public static void main(String[] args) {
        dis d=new dis(7);
        d.UnionBySize(1,2);
        d.UnionBySize(3,4 );
        d.UnionBySize(5, 6);
        d.UnionBySize(6, 7);
        d.UnionBySize(5, 6);
        if(d.findParent(3)==d.findParent(7))
        {
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }
        d.UnionBySize(3, 7);
        if(d.findParent(3)==d.findParent(7))
        {
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }


    }
    
}
