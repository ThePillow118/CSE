/**
 * @author
 * Joseph Winicki SBU ID: 110505644
 * Assignment:
 * Homework #4 for CSE 214, Summer 2018
 * Date:
 * August 2nd 2018
 */
public class Tree {

    private TreeNode root;

    /**
     * Creates an instance of the Tree class with the root of the tree initialized to null.
     */
    public Tree() {
        root = null;
    }

    /**
     * Gets the root node of this Tree
     * @return
     * Returns the root node of this Tree
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Changes the root node of this Tree to the specified TreeNode
     * @param root - the new root of this Tree
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * Performs a preorder traversal on the tree and prints out the information of each TreeNode
     * @param root - TreeNode to start the preorder traversal on.
     */
    public void preOrder(TreeNode root){
        System.out.println(root.toString());
        if(root.getChildren()[0] != null)
            preOrder(root.getChildren()[0]);
        if(root.getChildren()[1] != null)
            preOrder(root.getChildren()[1]);
        if(root.getChildren()[2] != null)
            preOrder(root.getChildren()[2]);

    }
    /**
     * A method to add a TreeNode to the tree. The location will be a child of parentLabel. The child node will be
     * left justified meaning that it should first be placed in the left most TreeNode reference, then the middle, then
     * the right.
     * @param label - name of the TreeNode to be added
     * @param prompt - prompt for the TreeNode to be added
     * @param message - message for the TreeNode to be added
     * @param parentLabel - parent name for the TreeNode to be added
     * @return
     * A return value of true indicates that the node was successfully added to the tree. Otherwise, the return value
     * is false.
     */
    public boolean addNode(String label, String prompt, String message, String parentLabel){
        TreeNode newNode = new TreeNode(label,message,prompt);
        TreeNode ptr;
        if(root == null){
            root = newNode;
            return true;
        }
        boolean added = addNode(root,newNode,parentLabel);
        return added;
    }

    /**
     * A helper method to add a TreeNode to the tree. The location will be a child of parentLabel. The child node will
     * be left justified meaning that it should first be placed in the left most TreeNode reference, then the middle,
     * then the right.
     * @param root - root of the tree or subtree of the original root
     * @param newNode - TreeNode to be inserted into the tree
     * @param parentLabel - label of the parent of the TreeNode to be inserted
     * @return
     * A return value of true indicates that the node was successfully added to the tree. Otherwise, the return value
     * is false.
     */
    public boolean addNode(TreeNode root, TreeNode newNode, String parentLabel){
        boolean added = false;
        if(parentLabel.equals(root.getLabel())){
           if(root.getChildren()[0] == null){
               root.setChild(0,newNode);
               added = true;
           }
           else if(root.getChildren()[1] == null){
               root.setChild(1,newNode);
               added = true;
           }
           else if(root.getChildren()[2] == null){
               root.setChild(2,newNode);
               added = true;
           }
           return added;
        }
        if(root.getChildren()[0] != null)
            addNode(root.getChildren()[0],newNode,parentLabel);
        else if(root.getChildren()[1] != null)
            addNode(root.getChildren()[1],newNode,parentLabel);
        else if(root.getChildren()[2] != null)
            addNode(root.getChildren()[2],newNode,parentLabel);
        return added;
    }

    /**
     * Gets the reference to a specific TreeNode with the specified label
     * @param label - label of the TreeNode we are looking for
     * @return
     * This method returns a null value if there is no Node in the tree with the given label. Otherwise, it will
     * return the TreeNode that has the label specified.
     */
    public TreeNode getNodeReference(String label){
        TreeNode answer;
        if(isEmpty()) {
            return null;
        }
        else if(root.getLabel().equals(label))
            return root;
        answer = getNodeReference(label,root);
        return answer;
    }

    /**
     * Gets the reference to a specific TreeNode with the specified label
     * @param label - label of the TreeNode we are looking for
     * @param root - start of the tree or subtree to traverse when looking for the specified label
     * @return
     * This method returns a null value if there is no Node in the tree with the given label. Otherwise, it will
     * return the TreeNode that has the label specified.
     */
    public TreeNode getNodeReference(String label,TreeNode root){
        TreeNode found = null;
        if(root.getLabel().equals(label)){
            found = root;
            return found;
        }
        else{
            if(root.getChildren()[0] != null && found == null) {
                found = getNodeReference(label, root.getChildren()[0]);
            }
            if(root.getChildren()[1] != null && found == null) {
                found = getNodeReference(label, root.getChildren()[1]);
            }
            if(root.getChildren()[2] != null && found == null) {
                found = getNodeReference(label, root.getChildren()[2]);
            }
        }
        return found;
    }
    /**
     * Checks to see if the tree is empty.
     * @return
     * Returns true if the tree is empty and false if there exists at least one node in the tree.
     */
    public boolean isEmpty(){
        if( root == null) {
            System.out.println("The tree is empty.");
            return true;
        }
        return false;
    }
}
