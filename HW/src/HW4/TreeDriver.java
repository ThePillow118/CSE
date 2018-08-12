import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author
 * Joseph Winicki SBU ID: 110505644
 * Assignment:
 * Homework #4 for CSE 214, Summer 2018
 * Date:
 * August 2nd 2018
 *
 *
 * Main driver class for creating a Tree based off of an input file. Allows a user to choose from a
 * menu and the class performs certain operations based off the input given. The following list of menu
 * options are given:
 *
 * Load a tree:                             L
 * Begin a help session:                    H
 * Traverse the tree in preorder:           T
 * Quit:                                    Q
 *
 */
public class TreeDriver {

    public static void main(String[] args) {
        Tree currentTree = null;
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        while(quit == false) {
            printMenu();
            String choice = in.nextLine();
            switch (choice.toUpperCase().charAt(0)) {
                case 'L':
                    String path;
                    System.out.println("Enter file path: ");
                    path = in.nextLine();
                    currentTree = loadTree(path);
                    if (currentTree == null)
                        System.out.println("Unable to load tree.");
                    else
                        System.out.println("Tree created successfully!");
                    break;

                case 'H':
                    if(currentTree == null)
                        System.out.println("No tree loaded. Please load a tree first.");
                    else {
                        currentTree.beginSession();
                    }
                    break;

                case 'T':
                    currentTree.preOrder(currentTree.getRoot());
                    break;

                case 'Q':
                    System.out.println("Thanks for using the service!");
                    quit = true;
                    break;

                default:
                    System.out.println("Please try a letter from the menu.");
                    break;
            }
            System.out.println();
        }
    }

    /**
     * Prints a menu for use in the main method for the user to choose an option from
     */
    public static void printMenu(){
        System.out.println("L - Load a Tree\nH - Begin a Help Session\nT - Traverse the Tree in preorder\nQ - Quit\n" +
                "Choice: ");
    }

    /**
     * Loads a tree given a file that contains information in a particular format,line by line descriptions of
     * what each node contains and how many children each node has. This creates a tree that can be used
     * in the main method.
     * @param filePath - path in the computer's storage that has the file
     * @return
     * Returns null if the file could not be loaded or the file's first line does not contain "root". Otherwise
     * it will return the tree version of the given file
     */
    public static Tree loadTree(String filePath){
        Tree newTree = new Tree();
        try{
            File file =  new File(filePath);
            String line,label, prompt, message;
            int children;
            Scanner scan = new Scanner(file);
            line = scan.nextLine().trim();
            if(!line.equals("root"))
                return null;
            else{
                label = line;
                prompt = scan.nextLine().trim();
                message = scan.nextLine().trim();
                line = scan.nextLine().trim();
                children = Integer.parseInt(line.substring(line.length()-1));
                newTree.addNode(label,prompt,message,children,"");
            }

            while(scan.hasNextLine()){
                if(line.equals(""))
                    line = scan.nextLine().trim();
                TreeNode parent = newTree.getRoot();
                String lineLabel = line.substring(0,line.length()-2);
                children = Integer.parseInt(line.substring(line.length()-1));
                parent = newTree.getNodeReference(lineLabel,parent);
                if(parent != null){
                    for(int i = 0;i < children;i++){
                        label = scan.nextLine().trim();
                        prompt = scan.nextLine().trim();
                        message = scan.nextLine().trim();
                        TreeNode newNode = new TreeNode(label,message,prompt,children);
                        newTree.addNode(parent,newNode,lineLabel);
                    }
                }
                if(scan.hasNextLine())
                    line = scan.nextLine().trim();
                else
                    break;
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Path was invalid. Please try again.");
        }
        return newTree;
    }

}
