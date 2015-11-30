package lab6;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 20;
        
        int array[] = new int[n];
        for(int i = 0; i < n; i++){
            Random generator = new Random(); 
            array[i] = generator.nextInt(100);
            System.out.print(array[i] + " ");
            
        }
        System.out.println();
        BinaryTree tree1 = new BinaryTree(new Node(array[0]));
        for(int i = 1; i < n; i++){
            tree1.insertRecursive(tree1.root, array[i]);
        }
        //System.out.println(tree.size);
        tree1.traversal(tree1.root);
        System.out.println();
        System.out.println("-------------------------");
        BinaryTree tree2 = new BinaryTree();
        for(int i = 0; i < n; i++){
            tree2.insertNonRecursive(tree2.root, array[i]);
        }
        tree2.traversal(tree2.root);
    }

}
