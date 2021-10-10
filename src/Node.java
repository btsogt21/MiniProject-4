/** Node class utilized in our binary search tree. Contains various methods I found useful for
 * BST operations.*/
public class Node<K extends Comparable<K>,V>{
    K key;
    V value;
    public Node leftchild;
    public Node rightchild;
    public Node parent;

    /** This method sets the right child of a given node*/
    public void setrightchild(Node <K, V> rightchild){
        this.rightchild = rightchild;
    }
    /** This method sets the left child of a given node*/
    public void setleftchild(Node <K, V> leftchild){
        this.leftchild = leftchild;
    }
    /** This method checks whether the current node is the left child of its parent node*/
    public boolean isLeftChild(){
        return this.parent.leftchild == this;
    }
    /** This method checks whether the current node is the right child of its parent node*/
    public boolean isRightChild(){
        return this.parent.rightchild == this;
    }
    /** This method checks whether current node is the root node of the BST*/
    public boolean isRoot(){
        return this.parent == null;
    }
    /** Node constructor */
    public Node (K key, V value){
        this.key = key;
        this.value = value;
        rightchild = null;
        leftchild = null;
        parent = null;
    }
}

