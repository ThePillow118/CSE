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
 */
public class TreeDriver {

    public static void main(String[] args) {
        Tree myTree = loadTree("C:\\Users\\Joe\\Desktop\\CS.txt");
        myTree.preOrder(myTree.getRoot());
        /*Scanner in = new Scanner(System.in);
        printMenu();
        String choice = in.nextLine();
        if(choice.toUpperCase().charAt(0) == 'L'){
            String path;
            System.out.println("Enter file path: ");
            path = in.nextLine();
            Tree currentTree = loadTree(path);
            if(currentTree == null)
                System.out.println("Unable to load tree.");
        }*/
        //myTree.preOrder(myTree.getRoot());
    }

    public static void printMenu(){
        System.out.println("L - Load a Tree\nH - Begin a Help Session\nTraverse the Tree in preorder\nQ - Quit\n " +
                "Choice: ");
    }

    public static Tree loadTree(String filePath){
        Tree newTree = new Tree();
        try{
            File file =  new File(filePath);
            String line,label, prompt, message;
            Scanner scan = new Scanner(file);
            line = scan.nextLine().trim();
            if(!line.equals("root"))
                return null;
            else{
                label = line;
                prompt = scan.nextLine().trim();
                message = scan.nextLine().trim();
                newTree.addNode(label,prompt,"","");
            }

            while(scan.hasNextLine()){
                TreeNode parent = newTree.getRoot();
                line = scan.nextLine().trim();
                String lineLabel = line.substring(0,line.length()-2);
                String lineNumChildren = line.substring(line.length()-1);
                int lineChildren = Integer.parseInt(line.substring(line.length()-1));
                parent = newTree.getNodeReference(lineLabel);
                if(parent != null){
                    int numberOfChildren = lineChildren;
                    for(int i = 0;i < numberOfChildren;i++){
                        label = scan.nextLine().trim();
                        prompt = scan.nextLine().trim();
                        message = scan.nextLine().trim();
                        newTree.addNode(label,prompt,message,lineLabel);
                    }
                }
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Path was invalid. Please try again.");
        }
        return newTree;
    }

}
