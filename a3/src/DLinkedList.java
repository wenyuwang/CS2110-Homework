/* NetId(s): nnnn, nnnn. Time spent: hh hours, mm minutes.

 * Name(s):
 * What I thought about this assignment:
 *
 *
 */

/** An instance is a doubly linked list. */
public class DLinkedList<E> {
    private int size;  // Number of nodes in the linked list.
    private Node head; // first node of linked list (null if none)
    private Node tail; // last node of linked list (null if none)

    /** Constructor: an empty linked list. */
    public DLinkedList() {
    }

    /** Return the number of values in this list. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node getHead() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node getTail() {
        return tail;
    }

    /** Return the data in node n of this list.
     * Precondition: n is a node of this list; it may not be null. */
    public E getData(Node n) {
        assert n != null;
        return n.data;
    }

    /** Return a representation of this list: its data, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[6, 3, 8]". */
    public String toString() {
        //TODO: Write this method first. Do NOT use field size
        String ret = "[";
        Node iter = head;
        
        while(iter!=null){
        	ret = ret + iter.data.toString() ;
        	if(iter.succ != null){
        		ret = ret+ ", ";
        	}
        	iter = iter.succ;
        }
        ret = ret +"]";
        return ret;

    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[8, 3, 6]".*/
    public String toStringRev() {
        //TODO: Write this method second. Do NOT use field size
        String ret = "[";
        Node iter = tail;
        
        while(iter!=null){
        	ret = ret + iter.data.toString() ;
        	if(iter.pred != null){
        		ret =ret + ", ";
        	}
        	iter = iter.pred;
        }
        ret = ret +"]";
        return ret;

    
    }

    /** Place data v in a new node at the beginning of the list and
     * return the new node */
    public Node prepend(E v) {
        //TODO: This is the third method to write. Then you can begin testing
        //private Node(Node p, E v, Node s) {pred= p;succ= s;data= v;
    	
    	if(size!=0) {
    		Node newHead = new Node(null, v ,head);
    		size = size +1;
    		head.pred = newHead;
    		head = newHead;
    		return newHead;
    	}
    	else { // size == 0
    		Node newHead = new Node(null, v ,null);
    		size = size +1;
    		head = newHead;
    		tail = newHead;
    		return newHead;
    	}
       
       
    }

    /** Place data v in a new node at the end of the list and
     * return the new node. */
    public Node append(E v) {
        //TODO:This is the fourth method to write.
        
    	if(size!=0) {
    		Node newTail = new Node(tail, v ,null);
    		size = size +1;
    		tail.succ = newTail;
    		tail = newTail;
    		return newTail;
    	}
    	else { // size == 0
    		Node newTail= new Node(null, v ,null);
    		size = size +1;
    		head = newTail;
    		tail = newTail;
    		return newTail;
    	}
     
    }

    /** Place data v in a new node after node n and
     * return the new node.
     * Precondition: n must be a node of this list; it may not be null. */
    public Node insertAfter(E v, Node n) {
        //TODO: This is the fifth method to write and test
    	if (n == tail) {//n.succ == null === n == tail
    		Node newNode = new Node(tail, v ,null);
    		size = size +1;
    		tail.succ = newNode;
    		tail = newNode;
    		return newNode; }
    	else{
    		Node newNode = new Node(n, v, n.succ);
    		size = size+1;
    		n.succ.pred= newNode;
    		n.succ = newNode;
    		
    		return newNode;
    		
    	}
    }

    /** Place data v in a new node before node n and
     * return the new node.
     * Precondition: n must be a node of this list; it may not be null. */
    public Node insertBefore(E v, Node n) {
        //TODO: This is the sixth method to write and test
    	if (n == head){
    		Node newNode = new Node(null, v ,head);
    		size = size +1;
    		head.pred = newNode;
    		head = newNode;
    		return newNode;
    	}
    	else{
    		Node newNode = new Node(n.pred, v ,n);
    		size = size +1;
    		n.pred.succ = newNode;
    		n.pred = newNode;
    		return newNode;
    	}
        
    }

    /** Remove node n from this list.
     * Precondition: n must be a node of this list; it may not be null. */
    public void remove(Node n) {
        //TODO: This is the seventh method to write and test
    	size = size-1;
    	if (n ==head){
    		n.succ.pred = null;
    		head = n.succ;
    	}
    	else if(n==tail){
    		n.pred.succ = null;
    		tail = n.pred;
    	}
    	else {
    		n.pred.succ = n.succ;
    		n.succ.pred = n.pred;
    	}

    
    } 


    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        /** Predecessor of this node on list (null if this is the first node). */
        private Node pred;

        /** The data in this element. */
        private E data; 

        /** Successor of this node on list. (null if is the last node). */
        private Node succ; 

        /** Constructor: an instance with predecessor node p (can be null),
         * successor node s (can be null), and data v. */
        private Node(Node p, E v, Node s) {
            pred= p;
            succ= s;
            data= v;
        }

        /** Return the data in this node. */
        public E getData() {
            return data;
        }

        /** Return the predecessor of this node (null if this is the
         * first node of the list). */
        public Node pred() {
            return pred;
        }

        /** Return the successor of this node (null if this is the
         * last node of this list). */
        public Node succ() {
            return succ;
        }
    }

}
