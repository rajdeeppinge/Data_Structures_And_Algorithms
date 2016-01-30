package advancedQ2;

public class TreapTree {
	private Node root;
	
	public TreapTree() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void add( Node x ) {
        root = add( x, root );
    }
	
	public Node add(Node newNode, Node currRoot) {
		if(currRoot == null) {
			currRoot = newNode;
		}
		
		else if( newNode.getKey() < currRoot.getKey() )
        {
            currRoot.setLeft(add( newNode, currRoot.getLeft() ));
            if( currRoot.getLeft().getPriority() < currRoot.getPriority() ) {
            	Node left = currRoot.getLeft();
            	currRoot.setLeft(left.getRight());
            	left.setRight(currRoot);
            	return left;
            }
        }
		else if( newNode.getKey() > currRoot.getKey() )
        {
            currRoot.setRight(add( newNode, currRoot.getRight() ));
            if( currRoot.getRight().getPriority() < currRoot.getPriority() ) {
            	Node right = currRoot.getRight();
            	currRoot.setRight(right.getLeft());
            	right.setLeft(currRoot);
            	return right;
            }
        }
		
		return currRoot;
	}
	
	public void printTree(Node currRoot) {
        if( currRoot != null)
        {
            printTree( currRoot.getLeft() );
            System.out.print( currRoot.getKey() + " ");
            printTree( currRoot.getRight() );
        }
    }
}
