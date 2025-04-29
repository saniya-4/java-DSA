class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }

}
public class lca
{
    public static Node leastcommon(Node root,Node p,Node q)
    {
        if(root==null || root==p || root==q)
        {
            return root;
        }
        Node left=leastcommon(root.left,p,q);
        Node right=leastcommon(root.right,p,q);
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        else{
            return root;
        }
    }

    public static void main(String []args)
    {
      Node root=new Node(3);
      root.left=new Node(5);
      root.right=new Node(1);
      root.left.left=new Node(6);
      root.left.right=new Node(2);
      root.right.left=new Node(0);
      root.right.right=new Node(8);
      root.left.right.left=new Node(7);
      root.left.right.right=new Node(4);
      Node p=root.left;
      Node  q=root.right;
     Node ans=leastcommon(root,p,q);
     System.out.println(ans.data);
    }
}
