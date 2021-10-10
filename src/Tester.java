/** Testing the functionality of the BST, as well as the traversing functions*/
public class Tester {
    public static void main(String[]args){
        BinarySearchTree <Integer, String> yuh = new BinarySearchTree<>();
        yuh.add(21, "Bird");
        yuh.add(23, "WOW");
        yuh.add(53, "aaa");
        yuh.add(26, "Bingus");
        yuh.add(28, "Amogus");
        yuh.add(30, "G91");
        yuh.add(34, "Starfighter");
        yuh.add(50, "MIG21BIS");
        yuh.add(54, "MIG17");
        yuh.add(56, "a");
        yuh.inOrderTraverseRecursive();
        yuh.inOrderTraverseIterative();
    }
}
