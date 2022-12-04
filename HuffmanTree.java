package data_structures_hw5;

import java.util.Arrays;

public class HuffmanTree {
	
	HuffmanNode root;
	
	//constructs a HuffmanTree and passes in a HuffmanNode to get set to the root
	public HuffmanTree(HuffmanNode huff) {
		this.root = huff;
	}
	
	//prints each letter and its key in the tree
	public void printLegend() {
		printLegend(root, "");
	}
	
	//helper method; recursively calls itself until it gets to the leaf node and prints the letter and its key
	private void printLegend(HuffmanNode t, String s) {
		 if (t.letter.length() > 1) {
			 printLegend(t.left, s + "0");
			 printLegend(t.right, s + "1");
		 } else {
			 System.out.println(t.letter+"="+s);
		 }
	}
	
	//builds a binary heap with the legend
	public static BinaryHeap legendToHeap(String legend) {
		String[] array = legend.split(" ");
		HuffmanNode[] nodeArray = {};
		//creates HuffmanNodes from the string array and copies into a HuffmanNode array
		for (int i = 0; i < array.length; i+=2) {
			nodeArray = Arrays.copyOf(nodeArray, nodeArray.length + 1);
			nodeArray[nodeArray.length - 1] = new HuffmanNode(array[i], Double.valueOf(array[i+1]));
		}
		//builds the binary heap with the HuffmanNode array
		BinaryHeap heap = new BinaryHeap(nodeArray);
		return heap;
	}
	
	//creates a HuffmanTree from the binary heap
	public static HuffmanTree createFromHeap(BinaryHeap b) {
		//while there is more than one HuffmanNode, take out the two smallest frequency HuffmanNodes
		//and create a HuffmanNode where those two are the left and right child and insert the new node back
		//into the binary heap
		while (b.getSize() > 1) {
			HuffmanNode left = (HuffmanNode) b.deleteMin();
			HuffmanNode right = (HuffmanNode) b.deleteMin();
			
			HuffmanNode huff = new HuffmanNode(left, right);
			b.insert(huff);
		}
		
		//when only one HuffmanNode left in the heap, remove it and make it the root of HuffmanTree
		HuffmanTree tree = new HuffmanTree((HuffmanNode) b.deleteMin());
		return tree;
	}
	
	public static void main(String[] args) {
		String legend = "A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2";
		BinaryHeap bheap = legendToHeap(legend);
		bheap.printHeap();
		
		HuffmanTree htree = createFromHeap(bheap);
		htree.printLegend();

	}

}
