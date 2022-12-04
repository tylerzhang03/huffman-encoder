package data_structures_hw5;

public class HuffmanNode implements Comparable {
	public String letter;
	public Double frequency;
	public HuffmanNode left, right;
	
	
	//constructor; sets letter and frequency of node and its children to null
	public HuffmanNode(String letter, Double frequency) {
		this.letter = letter;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}

	//constructor; creates a node that is the parents of two existing nodes
	//sets the letter to the concatenation of left.letter and right.letter and the freq to the sum of freq
	public HuffmanNode(HuffmanNode left, HuffmanNode right) {
		this.letter = left.letter + right.letter;
		this.frequency = left.frequency + right.frequency;
		this.left = left;
		this.right = right;
	}
	
	//compare the HuffmanNodes via frequency
	public int compareTo(Object o) {
		HuffmanNode huff = (HuffmanNode) o;
		return this.frequency.compareTo(huff.frequency);
	}
	
	@Override
	public String toString() {
		return "<"+letter+", "+frequency+">";
	}
}