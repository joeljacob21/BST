package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST(){ size=0; root=null; }

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {
		if(size == 0) {
			root = new BST_Node(s);
			return true;
		} else {
			return root.insertNode(s);
		}
	}

	@Override
	public boolean remove(String s) {
		if(root == null) {
			return false;
		} else {
			if(root.getData() == s) {
				BST_Node temp = new BST_Node(s);
				temp.left = root;
				boolean result = root.removeNode(s, temp);
				root = temp.getLeft();
				size--;
				return result;
			} else {
				size--;
				return root.removeNode(s, null);
			}
		}
	}

	@Override
	public String findMin() {
		if(root == null || size == 0)return null;
		return this.root.findMin().data;
	}

	@Override
	public String findMax() {
		if(root == null || size == 0)return null;
		return this.root.findMax().data;
	}

	@Override
	public boolean empty() {
		if(size == 0)return true;
		return false;
	}

	@Override
	public boolean contains(String s) {
		if(s == null) {
			return false;
		} else { return this.root.containsNode(s); }
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		return this.root.getHeight();
	}

}