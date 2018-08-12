/**
 * @author
 * Joseph Winicki SBU ID: 110505644
 * Assignment:
 * Homework #4 for CSE 214, Summer 2018
 * Date:
 * August 2nd 2018
 *
 * A class to be used in the Tree class in order to build a tree. This class contains all
 * the information in a node that includes its label, message, prompt, and any children that it
 * has.
 */

public class TreeNode {
    private TreeNode[] children;
    private String label, message, prompt;

    /**
     * Creates an instance of TreeNode with no parameters and intializes the children of the node to empty TreeNodes.
     */

    public TreeNode(){

    }

    /**
     * Creates a new TreeNode with the given parameters, label, message, and prompt
     * @param label - name of this TreeNode
     * @param message - messagae of this TreeNode
     * @param prompt - prompt of this TreeNode
     */
    public TreeNode(String label, String message, String prompt, int numChildren) {
        children = new TreeNode[numChildren];
        this.label = label;
        this.prompt = prompt;
        this.message = message;
    }

    /**
     * Gets the children of this TreeNode
     * @return
     * returns the array of TreeNodes that are the children of this TreeNode
     */
    public TreeNode[] getChildren() {
        return children;
    }

    /**
     * Changes the children of this TreeNode to a new array of TreeNodes
     * @param children - the array of TreeNodes to become the new children of this TreeNode
     */
    public void setChildren(TreeNode[] children) {
        this.children = children;
    }

    /**
     * Gets the name (otherwise known as label) of this TreeNode
     * @return
     * Returns the name of this TreeNode
     */
    public String getLabel() {
        return label;
    }
    /**
     * Changes the name(label) for this TreeNode to the given name
     * @param label - the new label for this TreeNode
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the message that this TreeNode has
     * @return
     * Returns the message for this Tree Node
     */
    public String getMessage() {
        return message;
    }
    /**
     * Changes the message for this TreeNode to the given message
     * @param message - the new message for this TreeNode
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Gets the prompt that this TreeNode has
     * @return
     * Returns the prompt for this Tree Node
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Changes the prompt for this TreeNode to the given prompt
     * @param prompt - the new prompt for this TreeNode
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Changes a specific child given the child number of this TreeNodes children with the given TreeNode.
     * @param childNum - which child is to be changed of this TreeNode
     * @param newNode - TreeNode to be added at this specific position
     */
    public void setChild(int childNum, TreeNode newNode){
        children[childNum] = newNode;
    }


    /**
     * Checks to see if this TreeNode is a leaf. ( Has no children)
     * @return
     * Returns true if this TreeNode is a leaf and false if it is not.
     */
    public boolean isLeaf(){
        for(int i = 0; i < children.length;i++){
            if(children[i] != null)
                return false;
        }
        return true;
    }



    /**
     * String representation of this TreeNode
     * @return
     * Returns the String representation of this TreeNode
     */
    public String toString(){
        return ("Label: " + label + "\nPrompt: " + prompt + "\nMessage: " + message);
    }
}
