
import java.util.Comparator;
import java.util.Hashtable;

class BinaryTreeNodeComparator implements Comparator<BinaryTreeNode> {

	@Override
	public int compare(BinaryTreeNode o1, BinaryTreeNode o2) {
		return o1.value - o2.value;
	}
}

public class HuffmanEncoder {

	private char alphabet[];
	private int frequencies[];
	private int sigma;

	private int encodingLength;
	private int tableSize;
	private Hashtable<Character, String> charToEncodingMapping;

	public HuffmanEncoder(char alphabet[], int frequencies[], int sigma) {
		this.alphabet = alphabet;
		this.sigma = sigma;
		this.frequencies = frequencies;
		encodingLength = tableSize = 0;
		charToEncodingMapping = new Hashtable<>();
		encode();
	}

	private void encode() throws IndexOutOfBoundsException { // complete this method
		BinaryTreeNode root = buildTree();
		createTable(root, "");
		for (int i = 0; i < sigma-1; i++) {
			char c = alphabet[i];
			String str = getEncoding(c);
			encodingLength = encodingLength + frequencies[i] * str.length();
			tableSize = tableSize + str.length() + 8;
		}
	}

	private BinaryTreeNode buildTree() throws IndexOutOfBoundsException { // complete this method
		PriorityQueue<BinaryTreeNode> pq = new PriorityQueue<>(new BinaryTreeNodeComparator());
		for (int i = 0; i < sigma-1; i++) {
			BinaryTreeNode x = new BinaryTreeNode(alphabet[i], frequencies[i]);
			pq.add(x);
		}
		while (pq.size() > 1) {
			BinaryTreeNode min = pq.poll();
			BinaryTreeNode secondMin = pq.poll();
			BinaryTreeNode y = new BinaryTreeNode('\0', min.value + secondMin.value);
			y.left = min;
			y.right = secondMin;
			pq.add(y);
		}
		return pq.peek();
	}

	private void createTable(BinaryTreeNode node, String encoding) { // complete this method
		if (node.left == null && node.right == null) {
			charToEncodingMapping.put(node.character, encoding);
		}
		else {
			if (node.left != null) {
				createTable(node.left, encoding + "0");
			}
			if (node.right != null) {
				createTable(node.right, encoding + "1");
			}
		}
	}

	public String getEncoding(char c) {
		return charToEncodingMapping.get(c);
	}

	public int getSigma() {
		return sigma;
	}

	public int[] getFrequencies() {
		return frequencies;
	}

	public char[] getAlphabet() {
		return alphabet;
	}

	public int getTableSize() {
		return tableSize;
	}

	public int getEncodingLength() {
		return encodingLength;
	}
}
