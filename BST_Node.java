package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	int height;

	BST_Node(String data){ this.data=data; }

	// --- used for testing  ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }

	// --- end used for testing -------------------------------------------


	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false 
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations


	public boolean containsNode(String s){ 
		int location = this.data.compareTo(s);
		if(location == 0) {
			return true;
		} else if(location < 0) {
			if(right == null) {
				return false;
			} else { 
				right.containsNode(s); 
			}
		} else if(location > 0) {
			if(left == null) {
				return false;
			} else {
				left.containsNode(s);
			}
		} return false;
	}
	public boolean insertNode(String s){ 
		int location = this.data.compareTo(s);
		if(location == 0) {
			return false;
		} else if(location < 0 && right == null) {
			right = new BST_Node(s);
			if(right == null && left == null) {
				height++;
			} return true;
		} else if(location > 0 && left == null) {
			left = new BST_Node(s);
			if(right == null && left == null) {
				height++;
			} return true;
		} else if(location < 0) {
			right.insertNode(s);
		} else if(location > 0) {
			left.insertNode(s);
		} return false;
	}
	public boolean removeNode(String s, BST_Node parent){
		int location = this.data.compareTo(s);
		if(location < 0) {
			if(right == null) {
				return false;
			} else { 
				right.removeNode(s, this); 
			}
		} else if(location > 0) {
			if(left == null) {
				return false;
			} else {
				left.removeNode(s, this);
			}
		} else {
			if(this.left != null && this.right != null) {
				this.data = right.findMin().data;
				right.removeNode(this.data, this);
			} else if(parent.left == this) {
				if(left != null) {
					parent.left = left;
					height--;
				} else {
					parent.right = right;
					height--;
				}
			} else if(parent.right == this) {
				if(left != null) {
					parent.right = left;
					height--;
				} else {
					parent.right = right;
					height--;
				}
			}
		}
		return false;
	}
	public BST_Node findMin(){ 
		if(left != null)return left.findMin();
		return this;
	}
	public BST_Node findMax(){ 
		if(right != null)return right.findMax();
		return this;
	}
	public int getHeight(){ 
		return height;
	}
	// --- end fill in these methods --------------------------------------


	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}
}