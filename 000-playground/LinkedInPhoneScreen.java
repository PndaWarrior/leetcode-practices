import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Sample input:
 *
 *          1
 *         / \
 *        3   5
 *       /   / \
 *      2   4   7
 *     / \   \
 *    9   6   8
 
 *
 * Expected output:
 *    1
 *    3 5
 *    2 4 7
 *    9 6 8
 *    ==========

 *    1 - > 2 childs, queue,  1 if I see the queue is not empty, look at top item, insert its child in the queue
 *    3 -> 1 child, queue: 5, then insert 2
 *    5 -> 2 child, queue : 2, then insert 4 , 7
 * 1) loop through the entire tree, and store the tree in a queue, store the depth information into the node.  print out by 
 */



class LinkedInPhoneScreen {
    public static class Node {
    	Node leftChild;
    	Node rightChild;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }


	public static void main(String args[]) {
		Node rootNode = new Node(1);
		
		rootNode.leftChild = new Node(3);
		rootNode.rightChild = new Node(5);
		
		printBinaryTree(rootNode);
        
	}

    public static void printBinaryTree(Node root) {

        if(root == null) return;

        //One problem, need to use linkedlist as queue
        Queue<Node> que = new LinkedList<Node>();
        List<int[]> fullTree = new ArrayList<int[]>();

        que.add(root);
        ///Second problem, can't add the first item into the tree, it will be taken care of in the iteration

        int depth = 0;
        int[] depthCount = new int[2];
        depthCount[0] = 1;
        depthCount[1] = 0;

        while(!que.isEmpty()) {

            Node current = que.poll();
            //Third problem, the decrase in depth should be after we completed inserting the nodes in the list

            //Four problem, the check for count is after the node inserts, not here


            if(current.leftChild != null) {
              que.add(current.leftChild);  
              //Fifth problem, the depth count should be depth+1 here
              depthCount[ (depth+1) % 2]++;
            } 

            if(current.rightChild != null) {
                que.add(current.rightChild);
              depthCount[ (depth+1) % 2]++;
            }

            depthCount[depth % 2] --;
            
            fullTree.add(helper(current, depth));

            if (depthCount[depth % 2] == 0) {
                depth++;                
            }


        }
        
        int previousDepth = -1;
        
        for (int i = 0; i < fullTree.size(); i++) {
        	
        	int[] current = fullTree.get(i);
        	
        	if(previousDepth != current[1]) {
        		System.out.println();
        		previousDepth = current[1];
        	}
        	
        	System.out.print( current[0] + " ");
        	
        }


    }


    public static int[] helper(Node current, int depth) {

        int[] result = new int[2];

        result[0] = current.value;
        result[1] = depth;

        return result;

    }
    

}
