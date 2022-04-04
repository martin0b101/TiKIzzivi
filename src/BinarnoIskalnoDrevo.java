public class BinarnoIskalnoDrevo<Tip extends Comparable> implements Seznam<Tip>{

    class Node<Tip extends Comparable> {
        Tip key;
        Node left;
        Node right;

        public Node(Tip data){
            key = data;
            left = right = null;
        }
    }


    Node root; //BST koren

    public BinarnoIskalnoDrevo(){
        root = null;
    }


    @Override
    public void add(Tip e) {
        root = insert(root, e);
    }

    @Override
    public Tip removeFirst() {
        Tip deletedElement = (Tip) root.key;
        root = delete(root, (Tip) root.key);
        return deletedElement;
    }


    @Override
    public Tip getFirst() {
        if (root != null){
            return (Tip) root.key;
        }
        return null;
    }

    @Override
    public int size() {
        return countNode(root);
    }

    @Override
    public int depth() {
        return getDepth(root);
    }

    @Override
    public boolean isEmpty() {
        if (root == null){
            return true;
        }
        return false;
    }

    @Override
    public Tip remove(Tip e) {
        if (root == null){
            throw new java.util.NoSuchElementException();
        }
        Node removeThis = member(root, e);
        root = delete(root, e);
        return (Tip) removeThis.key;
    }

    @Override
    public boolean exist(Tip e) {
        Node element;
        element = member(root, e);
        if (element == null){
            return false;
        }
        else if (element.key.compareTo(e) == 0){
            return true;
        }

        return false;
    }


    public String toString(){
        String output = "";
        while (root != null) {
            output += root.key;
            root = root.left;
        }
        return output;
    }

   private Tip minValue(Node root)  {
        //initially minval = root
        Tip minval = (Tip) root.key;
        //find minval
        while (root.left != null)  {
            minval = (Tip) root.left.key;
            root = root.left;
        }
        return minval;
    }


    private Node insert(Node node, Tip e){
        if (node == null){
            node = new Node(e);
            return node;
        }
        else if (node.key == e){
            //gre za dvojnike
            return node;
        }
        // e < d.key
        else if (e.compareTo(node.key) < 0){
            node.left = insert(node.left, e);
        }

        // e > d.key
        else if (e.compareTo(node.key) > 0){
            node.right = insert(node.right, e);
        }
        return node;
    }

    private Node delete(Node d, Tip e){
        if (d == null){
            return null;
        }
        // e < d.key
        if (e.compareTo(d.key) < 0){
            d.left = delete(d.left, e);
        }
        // e > d.key
        else if (e.compareTo(d.key) > 0){
            d.right = delete(d.right, e);
        }
        // vrednost eneaka
        else{
            if (d.left == null && d.right == null){
                return null;
            }
            if (d.left == null){
                return d.right;
            }
            if (d.right == null){
                return d.left;
            }
            // oba soseda gremo v desno najdemo najmansega in zbrisemo list
            root.key = minValue(d.right);

            // Delete the inorder successor
            root.right = delete(d.right, (Tip) d.key);

        }
        return d;
    }


    private Node member(Node node, Tip e){
        if (node == null){
            return node;
        }
        if (node.key.compareTo(e) == 0){
            return node;
        }
        // key > e
        if (node.key.compareTo(e) > 0){
            return member(node.left, e);
        }
        return member(node.right, e);
    }


    private int countNode(Node node){
        if (node == null){
            return 0;
        }
        else {
            return 1 + countNode(node.left) + countNode(node.right);
        }
    }

    private int getDepth(Node node){
        if (node == null){
            return 0;
        }
        else{
            int leftDepth = getDepth(node.left);
            int rightDepth = getDepth(node.right);

            if (leftDepth > rightDepth){
                return 1+leftDepth;
            }
            else{
                return 1 + rightDepth;
            }
        }
    }

}
