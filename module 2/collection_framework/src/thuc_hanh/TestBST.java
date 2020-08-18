package thuc_hanh;

public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
//        System.out.println("Preorder (sorted): " );
//        tree.preorder();
        System.out.println("The number of nodes is: " + tree.getSize());
        System.out.println(tree.search("Tom"));
        tree.delete("Tom");
        tree.preorder();
    }
}
