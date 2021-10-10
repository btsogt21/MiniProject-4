import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**Further testing of the functionality of the binary search tree. The following reads in a sample text file called
 * 'sampletext.txt' and counts the number of times each word appears utilizing a BST in which the key is the word and
 * the associated value is the number of times that particular word appears. Once finished counting, it traverses
 * through the BST, printing each word (key) and its associated value in alphabetic order.*/
public class CountWords {
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree <String, Integer> bingus = new BinarySearchTree<String, Integer>();
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("src/sampletext.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                s = s.replaceAll("[^a-zA-Z]","");
                s = s.toLowerCase();
                if (bingus.lookup(s) == null){
                    bingus.add(s,1);
                }
                else {
                    int current_count = bingus.lookup(s);
                    bingus.add(s, current_count+1);
                }
            }
        }
        bingus.inOrderTraverseRecursive();
    }
}
