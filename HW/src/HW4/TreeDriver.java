import java.io.*;

/**
 * @author
 * Joseph Winicki SBU ID: 110505644
 * Assignment:
 * Homework #4 for CSE 214, Summer 2018
 * Date:
 * August 2nd 2018
 */
public class TreeDriver {

    public static void main(String[] args){
        String lol = "root 3";
        System.out.println(Integer.parseInt(lol.substring(lol.length()-1)));
    }

    public Tree loadTree(){
        Tree newTree = new Tree();
        try{
            FileInputStream in = new FileInputStream("C:\\Users\\JoePillow\\Desktop\\cseHw.txt");
            DataInputStream input = new DataInputStream(in);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            String[] lines = new String[in.available()];
            int x = 0;
            while((line = br.readLine()) != null){
                lines[x] = line;
                x++;
            }
            input.close();
            if(!lines[0].equals("root"))
                return null;
            int index = 0;
            String label = lines[index];
            String message = lines[++index];
            int children = Integer.parseInt(lines[++index].substring(lines[index].length()-1));
            newTree.addNode(label,label,message,label);

            while(index <= x){

                for(int i = 0; i < children;i++){
                    String childLabel = lines[++index];
                    String childPrompt = lines[++index];
                    String childMessage = lines[++index];
                    newTree.getNodeReference(label).setChild(i,new TreeNode(childLabel,childMessage,childPrompt));
                }

            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return newTree;
    }
}
