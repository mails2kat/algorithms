package algorithm;


import java.util.*;


public class BinaryTree {
 
  public static void main(String[] args)  {
    
   
   TreeNode root = new TreeNode(100);
    TreeNode l1 = new TreeNode(80);
    TreeNode l2 = new TreeNode(70);
    root.left = l1;
    root.right = l2;
    
    //inorder2(root);
    
    //postorder(root);
  
    level(root);
    
  }
  
  private static void inorder1(TreeNode head) {
    if (head == null)
      return;
    inorder1(head.left);
    System.out.println(head.value);
    inorder1(head.right);
    
  }
  
  private static void inorder2(TreeNode node) {
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    while(!stack.isEmpty() || node!= null) {
      
      if (node != null) {
        
        stack.push(node);
        node = node.left;
        
      } else {
        
        node = stack.pop();
        System.out.println(node.value);
        node = node.right;
        
      }
      
      
    }
    
  }
  
  private static void preorder(TreeNode node) {
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    while(!stack.isEmpty() || node!= null) {
      
      if (node != null) {
        
        System.out.println(node.value);
        if (node.right != null) {
           stack.push(node.right);
        }
        node = node.left;
      } else {
        node = stack.pop();
      }
      
      
    }
    
  }
  
  private static void postorder(TreeNode node) {
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode lastvisitednode = null;
    while(!stack.isEmpty() || node!= null) {
      
      if (node != null) {
        
        stack.push(node);
        node = node.left;
      } else {
        TreeNode peeknode = stack.peek();
        if (peeknode.right != null && lastvisitednode != peeknode.right) {
          node = peeknode.right;
        } else {
          lastvisitednode = stack.pop();
          System.out.println(lastvisitednode.value);
        }
        
        
      }
      
      
    }
    
  }
  
 private static void level(TreeNode root) {
   
   
   List<TreeNode> queue = new LinkedList<TreeNode>();
   queue.add(root);
   
   while (queue.size() > 0) {
     
     TreeNode node = queue.remove(0);
      System.out.println(node.value);
     if(node.left != null) {
       queue.add(node.left);
     }
     
     if(node.right != null) {
       queue.add(node.right);
     }
     
     
   }
   //queue
 }
 
 private boolean isBalanced(TreeNode head) {
   if (head == null) {
     return true;
   }
   int height = height(head);
   if (height == -1) {
     return false;
   }
   return true;
 }

/**
 * @param head
 * @return
 */
private int height(TreeNode head) {
  if (head == null) {
    return 0;
  }
  int left = height(head.left);
  int right = height(head.right);
 
  if (left == -1 || right == -1) {
    return -1;
  }
  if (Math.abs(left -right) > 1) {
    return -1;
  }
  
  return Math.max(left, right) + 1;
}

/*
 *  
 */
private TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
  TreeNode m = root;

  if(m.value > p.value && m.value < q.value){
      return m;  
  }else if(m.value>p.value && m.value > q.value){
      return lowestCommonAncestorBST(root.left, p, q);
  }else if(m.value<p.value && m.value < q.value){
      return lowestCommonAncestorBST(root.right, p, q);
  }

  return root;
}


private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  if(root==null)
      return null;

  if(root==p || root==q)
      return root;

  TreeNode left = lowestCommonAncestor(root.left, p, q);
  TreeNode right = lowestCommonAncestor(root.right, p, q);

  if (left != null && right != null)
    return root;
  if (left != null)
      return lowestCommonAncestor(root.left, p, q);

  return lowestCommonAncestor(root.right, p, q);
}

public int minDepth(TreeNode root) {
  if(root == null){
      return 0;
  }

  LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
  LinkedList<Integer> counts = new LinkedList<Integer>();

  nodes.add(root);
  counts.add(1);

  while(!nodes.isEmpty()){
      TreeNode curr = nodes.remove();
      int count = counts.remove();

      if(curr.left == null && curr.right == null){
          return count;
      }

      if(curr.left != null){
          nodes.add(curr.left);
          counts.add(count+1);
      }

      if(curr.right != null){
          nodes.add(curr.right);
          counts.add(count+1);
      }
  }

  return 0;
}

public boolean hasPathSum(TreeNode root, int sum) {
  if(root == null) return false;

  LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
  LinkedList<Integer> values = new LinkedList<Integer>();

  nodes.add(root);
  values.add(root.value);

  while(!nodes.isEmpty()){
      TreeNode curr = nodes.poll();
      int sumValue = values.poll();

      if(curr.left == null && curr.right == null && sumValue==sum){
          return true;
      }

      if(curr.left != null){
          nodes.add(curr.left);
          values.add(sumValue+curr.left.value);
      }

      if(curr.right != null){
          nodes.add(curr.right);
          values.add(sumValue+curr.right.value);
      }
  }

  return false;
}

public int maxPathSum(TreeNode root) {
  int max[] = new int[1]; 
  max[0] = Integer.MIN_VALUE;
  calculateSum(root, max);
  return max[0];
}
 
public int calculateSum(TreeNode root, int[] max) {
  if (root == null)
    return 0;
 
  int left = calculateSum(root.left, max);
  int right = calculateSum(root.right, max);
 
  int current = Math.max(root.value, Math.max(root.value + left, root.value + right));
 
  max[0] = Math.max(max[0], Math.max(current, left + root.value + right));
 
  return current;
}

void printSpiral(TreeNode node) 
{
    if (node == null) 
        return;   // NULL check

    // Create two stacks to store alternate levels
    Stack<TreeNode> s1 = new Stack<TreeNode>();// For levels to be printed from right to left
    Stack<TreeNode> s2 = new Stack<TreeNode>();// For levels to be printed from left to right

    // Push first level to first stack 's1'
    s1.push(node);

    // Keep ptinting while any of the stacks has some nodes
    while (!s1.empty() || !s2.empty()) 
    {
        // Print nodes of current level from s1 and push nodes of
        // next level to s2
        while (!s1.empty()) 
        {
          TreeNode temp = s1.peek();
            s1.pop();
            System.out.print(temp.value + " ");

            // Note that is right is pushed before left
            if (temp.right != null) 
                s2.push(temp.right);
             
            if (temp.left != null) 
                s2.push(temp.left);
             
        }

        // Print nodes of current level from s2 and push nodes of
        // next level to s1
        while (!s2.empty()) 
        {
          TreeNode temp = s2.peek();
            s2.pop();
            System.out.print(temp.value + " ");

            // Note that is left is pushed before right
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }
    }
}

int diameter(TreeNode root)
{
    /* base case if tree is empty */
    if (root == null)
        return 0;

    /* get the height of left and right sub trees */
    int lheight = height(root.left);
    int rheight = height(root.right);

    /* get the diameter of left and right subtrees */
    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);

    /* Return max of following three
      1) Diameter of left subtree
     2) Diameter of right subtree
     3) Height of left subtree + height of right subtree + 1 */
    return Math.max(lheight + rheight + 1,
                    Math.max(ldiameter, rdiameter));

}


private TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
  //minimum key value in right subtree.
  if (p.right != null) {
    TreeNode current = p.right;
    while (current.left != null) {
      current = current.left;
    }
    return current;
  }
  
  TreeNode succ = null;
  //start from root and use search like technique
  while (root != null) {
    if (p.value < root.value) {
      succ = root;
      root = root.left;
    } else if (p.value > root.value) {
      root = root.right;
    } else {
      break;
    }
  }
  
  return succ;
}
  
private TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
  //maximum key value in left subtree.
  if (p.left != null) {
    TreeNode current = p.left;
    while (current.right != null) {
      current = current.right;
    }
    return current;
  }
  
  TreeNode pred = null;
  //start from root and use search like technique
  while (root != null) {
    if (p.value < root.value) {
      root = root.left;
    } else if (p.value > root.value) {
      pred = root;
      root = root.right;
    } else {
      break;
    }
  }
  
  return pred;
}



boolean isBST(TreeNode root)  {
  return isBSTUtil(root, Integer.MIN_VALUE,
                         Integer.MAX_VALUE);
}

/* Returns true if the given tree is a BST and its
values are >= min and <= max. */
boolean isBSTUtil(TreeNode node, int min, int max)
{
  /* an empty tree is BST */
  if (node == null)
      return true;

  /* false if this node violates the min/max constraints */
  if (node.value < min || node.value > max)
      return false;

  /* otherwise check the subtrees recursively
  tightening the min/max constraints */
  // Allow only distinct values
  return (isBSTUtil(node.left, min, node.value-1) &&
          isBSTUtil(node.right, node.value+1, max));
}

void findPreSuc(TreeNode root, TreeNode pre, TreeNode suc, int key)
{
    // Base case
    if (root == null)  return ;
 
    // If key is present at root
    if (root.value == key)
    {
        // the maximum value in left subtree is predecessor
        if (root.left != null)
        {
            TreeNode tmp = root.left;
            while (tmp.right != null)
                tmp = tmp.right;
            pre = tmp ;
        }
 
        // the minimum value in right subtree is successor
        if (root.right != null)
        {
            TreeNode tmp = root.right ;
            while (tmp.left != null)
                tmp = tmp.left ;
            suc = tmp ;
        }
        return ;
    }
 
    // If key is smaller than root's key, go to left subtree
    if (root.value > key)
    {
        suc = root ;
        findPreSuc(root.left, pre, suc, key) ;
    }
    else // go to right subtree
    {
        pre = root ;
        findPreSuc(root.right, pre, suc, key) ;
    }
}

int findLevel(TreeNode root, int k, int level)
{
    if(root == null) return -1;
    if(root.value == k) return level;
 
    int left = findLevel(root.left, k, level+1);
    if (left == -1)
       return findLevel(root.right, k, level+1);
    return left;
}

public boolean hasPathSum1(TreeNode root, int sum) {
  if (root == null)
    return false;
  if (root.value == sum && (root.left == null && root.right == null))
    return true;
 
  return hasPathSum(root.left, sum - root.value)
      || hasPathSum(root.right, sum - root.value);
}
 
TreeNode sortedArrayToBST(int arr[], int start, int end) {
  
  /* Base Case */
  if (start > end) {
      return null;
  }

  /* Get the middle element and make it root */
  int mid = (start + end) / 2;
  TreeNode node = new TreeNode(arr[mid]);

  /* Recursively construct the left subtree and make it
   left child of root */
  node.left = sortedArrayToBST(arr, start, mid - 1);

  /* Recursively construct the right subtree and make it
   right child of root */
  node.right = sortedArrayToBST(arr, mid + 1, end);
   
  return node;
}

TreeNode sortedListToBST(Node head, int n) {
  return sortedListToBST(head, 0, n-1);
}

TreeNode sortedListToBST(Node head, int start, int end) {
  
  /* Base Case */
  if (start > end) {
      return null;
  }

  /* Get the middle element and make it root */
  int mid = (start + end) / 2;
  TreeNode left = sortedListToBST(head, start, mid-1);
  
  TreeNode node = new TreeNode(head.value);
  head = head.next;
  /* Recursively construct the right subtree and make it
   right child of root */
  TreeNode right = sortedListToBST(head, mid + 1, end);
  node.left = left;
  node.right = right;
  return node;
}


public boolean isSameTree(TreeNode p, TreeNode q) 
{
  if(p==null && q==null)
  {
    return true;
  }
  else if(p==null || q==null)
  { 
    return false;
  }
  else
  {
    return (p.value == q.value && 
        isSameTree(p.left,q.left) && 
        isSameTree(p.right,q.right));
  }
}

}

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;
  
  TreeNode(int value) {
    this.value = value;
  }
}



