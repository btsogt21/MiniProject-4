import java.util.Stack;

/** Implementation of a Binary Search Tree utilizing both the Comparable interface as well as a
 * Dictionary Interface.*/

public class BinarySearchTree<K extends Comparable<K>,V> implements DictionaryInterface<K,V> {
    public Node<K, V> origin;

    public BinarySearchTree(){
        origin = null;
    }

    /** Add an element to the binary search tree given a key and a value.
     * @param key - key with which to order nodes within the binary tree. That is, if key is 14, and the root
     * @param value - Value to associate with a given node and its specified key. Value does not determine
     * the position of a given node and its key in the binary search tree
     * node is 8, the key will go to the right of the root.
     * @return old value associated with key if the key already existed within the tree. If the key did not
     * exist, return null.*/

    public V add(K key, V value){
        Node <K, V> placeholder = new Node<>(key, value);
        if(origin == null){
            origin = placeholder;
            return null;
        }
        Node <K, V> current = origin;
        while(true){
            if(current.key.compareTo(key) > 0){
                if (current.leftchild == null){
                    current.setleftchild(placeholder);
                    return null;
                }
                else {
                    current = current.leftchild;
                }
            }
            else if (current.key.compareTo(key) < 0){
                if(current.rightchild == null){
                    current.setrightchild(placeholder);
                    return null;
                }
                else {
                    current = current.rightchild;
                }
            }
            else{
                V return_data = current.value;
                current.value = value;
                return(return_data);
            }
        }
    }

    /** Remove an element from the binary search tree given a key.
     * @param key - key with which to order nodes within the binary tree. Here, we remove the node with
     * our specified key.
     * @return the value associated with the key. If key is not present, or if the method was otherwise
     * unable to remove the key and value pair, return null*/
    public V remove(K key){
        V return_value = null;
        if(origin == null) {
            return null;
        }
        Node <K, V> current = origin;
        Node <K, V> prior = origin;
        while(current.key!=key){
            if(current.key.compareTo(key)>0){
                if(current.leftchild == null){
                    return null;
                }
                else{
                    prior = current;
                    current = current.leftchild;
                }
            }
            else {
                if(current.rightchild == null){
                    return null;
                }
                else{
                    prior = current;
                    current = current.rightchild;
                }
            }
        }
        if(current.leftchild == null && current.rightchild == null){
            if(current == origin){
                return_value = origin.value;
                origin = null;
            }
            else if(current == prior.leftchild){
                return_value = current.value;
                prior.setleftchild(null);
            }
            else {
                return_value = current.value;
                prior.setrightchild(null);
            }
        }
        else if(current.rightchild == null && current.leftchild != null){
            if(current == origin){
                return_value = origin.value;
                origin = current.leftchild;
            }
            else if(current == prior.leftchild){
                return_value = current.value;
                prior.setleftchild(current.leftchild);
            }
            else{
                return_value = current.value;
                prior.setrightchild(current.leftchild);
            }
        }
        else if(current.rightchild != null && current.leftchild == null){
            if(current == origin){
                return_value = origin.value;
                origin = current.rightchild;
            }
            else if(current == prior.leftchild){
                return_value = current.value;
                prior.setleftchild(current.rightchild);
            }
            else{
                return_value = current.value;
                prior.setrightchild(current.rightchild);
            }
        }
        else if (current.rightchild !=null && current.leftchild!=null){
            Node<K,V> successor = returnSuccessor(current);
            if(current == origin){
                return_value = origin.value;
                origin = successor;
            }
            else if(current == prior.leftchild){
                return_value = current.value;
                prior.setleftchild(successor);
            }
            else{
                return_value = current.value;
                prior.setrightchild(successor);
            }
        }
        return return_value;
    }

    /** Method to lookup whether a given key exists within the binary search tree
     * @param key - Key with which to order nodes within the tree. Method checks whether this key exists
     * within the tree.
     * @return the value associated with the key being looked up. If key is not present, return null*/
    public V lookup(K key){
        Node<K, V> current = origin;
        while(current!=null){
            if (current.key.compareTo(key)==0){
                return current.value;
            }
            else if (current.key.compareTo(key)> 0) {
                current = current.leftchild;
            }
            else{
                current = current.rightchild;
            }
        }
        return null;
    }

    /**Wrapper method for recursively traversing a binary search tree*/
    public void inOrderTraverseRecursive(){
        recursiveTraverse(origin);
    }

    /** Method that, when called upon the root, prints all the key value pairs (i.e all the nodes) in
     * ascending order. Each pair appears on a new line. This one uses a recursive method*/
    private void recursiveTraverse(Node<K, V> yeet){
        if (yeet!=null){
            recursiveTraverse(yeet.leftchild);
            System.out.println(yeet.key);
            System.out.println(yeet.value);
            recursiveTraverse(yeet.rightchild);
        }
    }

    /**Wrapper method for iteratively traversing a binary search tree*/
    public void inOrderTraverseIterative(){
        iterativeTraverse(origin);
    }

    /**Similar functionality to recursiveTraverse, but this one uses an iterative method*/
    public void iterativeTraverse(Node<K, V> yeet){
        Stack stack = new Stack<Node<K, V>>();
        if (!yeet.isRoot()){
            System.out.println("Inputted node is not root node");
        }
        else{
            while(yeet!=null||!stack.isEmpty()){
                while(yeet!=null){
                    stack.push(yeet);
                    yeet = yeet.leftchild;
                }
                yeet = (Node<K, V>) stack.pop();
                System.out.println(yeet.key);
                System.out.println(yeet.value);
                yeet = yeet.rightchild;
            }
        }
    }


    private Node<K, V> returnSuccessor(Node<K, V> pending_removal){
        Node<K, V> successor = null;
        Node <K, V> prior_successor = null;
        Node<K, V> current = pending_removal.rightchild;
        while(current!=null){
            prior_successor = successor;
            successor = current;
            current = current.leftchild;
        }
        if(successor!=pending_removal.rightchild){
            prior_successor.setleftchild(successor.rightchild);
            successor.setrightchild(pending_removal.rightchild);
        }
        return successor;
    }
}
