import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//This function checks if the Binary Tree rooted at root is complete or not
//Definition of a complete tree:
//There is no bubble unless the bubble is on the last layer at the rightmost leaf

//Example:            5                                             5
//                   / \                                           / \
//                  3   4                                         3   9
//                 /                                               \
//                 9             this is a completed tree           10           this is not
public class BinaryTreeComplete {

    public static boolean isCompleted(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>(); //holding container of the treeNodes meaning: Not looked at yet
        boolean missChild = false; //Warning flag, if a node is missing a child,
        queue.offer(root); // put the root into the Queue, waiting
        while(!queue.isEmpty()){ // if there are nodes that are still not looked at
            TreeNode cur = queue.poll(); // Get a node from queue
            if ( cur.left == null ) { // if missing left child
                missChild = true;  //Warning flag, one of the node is missing left child
            } else if ( missChild ) { // left child presents but parennt has  warning flag
                return false; // Why ?
            } else { //cur.left != null and no flag
                queue.offer( cur.left );
            }

            if ( cur.right == null ) {
                missChild = true;
            } else if ( missChild ) {
                return false;
            }
            else {
                queue.offer(cur.right);
            }

        }

        return true;

    }
}
