import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeByLayer {
    public static List< List<Integer> >  LayerByLayer(TreeNode root){
        List< List<Integer> > results = new ArrayList<>();
        if (root == null) { //Edge case, if root is null, return the empty list
            return results;
        }
        Queue<TreeNode> nodeQueue= new LinkedList<>(); //Store the node that will be looked in future steps
        nodeQueue.offer(root); // Put the root into the queue for now
        while (!nodeQueue.isEmpty()) { // While we have nodes to look:


        }

    }
}
