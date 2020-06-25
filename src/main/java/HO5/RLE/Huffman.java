package HO5.RLE;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

        // to create a tree
        private static class HuffmanNode {

                private final int freq;
                private final char ch;
                private final HuffmanNode left;
                private final HuffmanNode right;

                private HuffmanNode (int freq, char ch, HuffmanNode x, HuffmanNode y) {
                        this.freq = freq;
                        this.ch = ch;
                        this.left = x;
                        this.right = y;
                }

                private HuffmanNode (int freq, char ch) {
                        this(freq, ch, null, null);
                }

                private HuffmanNode (HuffmanNode x, HuffmanNode y) {
                        this(x.freq + y.freq, '-', x, y);
                }

                private HuffmanNode () {
                        this(0, Character.MIN_VALUE, null, null);
                }

                boolean isLeaf () { return this.left == null && this.right == null; }

                private final static Comparator<HuffmanNode> sFrequencyComparator = new Comparator<HuffmanNode>() {

			@Override
			public int compare(HuffmanNode x, HuffmanNode y) {
                                return x.freq - y.freq;
			}
                };
        }

	// @Override
	// public String compress (String in) {
	// 	// TODO Auto-generated method stub
	// 	return null;
	// }
        
        public static HashMap<Character, Integer> calcRelativeFreq (String in) {
                
                HashMap<Character, Integer> map = new HashMap<Character, Integer>();
                for (char c: in.toCharArray()) {
                        map.compute(c, (k, v) -> v == null ? 1 : v + 1); // lambda
                }

                return map;
        }

        private static HuffmanNode buildBinaryTree (String in) {

                HashMap<Character, Integer> map = calcRelativeFreq(in);
                System.out.println(map);
                PriorityQueue<HuffmanNode> mQueue = new PriorityQueue<HuffmanNode>( map.size(), HuffmanNode.sFrequencyComparator );

                for (Map.Entry<Character, Integer> cEntry: map.entrySet()) {
                        mQueue.add( new HuffmanNode(cEntry.getValue(), cEntry.getKey()) ); // create tree branch
                }

                while (mQueue.size() > 1) {
                        mQueue.add( new HuffmanNode( mQueue.poll(), mQueue.poll() ) );
                }

                return mQueue.poll();
        }

        private static void printNode (HuffmanNode root, String s) {

                if ( root.isLeaf() && (root.ch != Character.MIN_VALUE) ) {
                        System.out.printf("%c:%s\n", root.ch, s);
                        return;
                }

                printNode(root.left, s + "0");
                printNode(root.right, s  + "1");
        }

        private static void makeLookupTable (HashMap<Character, String> map, HuffmanNode root, String s) {

                if ( root.isLeaf() && (root.ch != Character.MIN_VALUE) ) {
                        map.put(root.ch, s);
                        return;
                }

                makeLookupTable(map, root.left, s + "0");
                makeLookupTable(map, root.right, s + "1");
        }

        private static String encodeDataToBits (HashMap<Character, String> map, String in) {

                String res = new String();
                for (char c: in.toCharArray()) {
                        res = res + map.get(c) + " ";
                }

                return res;
        }

        public  static String compress (String in) {
                
                HashMap<Character, String> map = new HashMap<Character, String>();
                HuffmanNode root = buildBinaryTree(in);

                printNode(root, "");
                makeLookupTable(map, root, "");

                return encodeDataToBits(map, in);
        }
}
