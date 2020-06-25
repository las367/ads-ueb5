// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.PriorityQueue;

// public class Huffman {

        
//         private static class HuffmanNode {
                
//                 private final static Comparator<HuffmanNode> sFrequencyComparator = new Comparator<HuffmanNode>() {

//                         @Override
//                         public int compare(HuffmanNode x, HuffmanNode y) {
//                                 return x.freq - y.freq;
//                         }
                
//                 };
                
//                 private HuffmanNode(int freq, char ch, HuffmanNode x, HuffmanNode y) {
//                         this.freq = freq;
//                         this.ch = ch;
//                         this.left = x;
//                         this.right = y;
//                 }
                
//                 private HuffmanNode(int freq, char ch) {
//                         this(freq, ch, null, null);
//                 }
                
//                 private HuffmanNode() {
//                         this(0, Character.MIN_VALUE, null, null); 
//                 }
                
//                 private HuffmanNode(HuffmanNode x, HuffmanNode y) {
//                         this(x.freq + y.freq, '-', x, y);
//                 }
                
//                 boolean isLeaf() {
//                         return this.right == null && this.left == null;
//                 }
                
//                 private final int freq;
//                 private final char ch;
//                 private final HuffmanNode left;
//                 private final HuffmanNode right;
//         }
        
//         static public HashMap<Character, Integer> calcRelativeFrequency(String data) {
//                 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//                 for (char c: data.toCharArray()) {
//                         map.compute(c, (k, v) -> v == null ? 1 : v + 1); // lambdas
//                 }
//                 return map;
//         }
        
//         static private HuffmanNode buildBinaryTrie(String data) {
//                 HashMap<Character, Integer> mapCharFrequency = calcRelativeFrequency(data);
//                 System.out.println(mapCharFrequency);
                
//                 PriorityQueue<HuffmanNode> mQueue = new PriorityQueue<HuffmanNode>(mapCharFrequency.size(), HuffmanNode.sFrequencyComparator);
                
//                 for (Map.Entry<Character, Integer> charEntry : mapCharFrequency.entrySet()) {
//                         mQueue.add(new HuffmanNode(charEntry.getValue(), charEntry.getKey()));
//                 }
                
//                 while (mQueue.size() > 1) {
//                         mQueue.add(new HuffmanNode(mQueue.poll(), mQueue.poll()));
//                 }
                
//                 return mQueue.poll();                
//         }
        
//         static private void printCode(HuffmanNode root, String s) {
//                 if (root.isLeaf() && (root.ch != Character.MIN_VALUE)) {
//                         System.out.println(root.ch + ":" + s);
//                         return;
//                 }
//                 printCode(root.left, s + "0");
//                 printCode(root.right, s + "1");
                
//         }
        
//         static public void compress(String data) {
//                 HuffmanNode root = buildBinaryTrie(data);
                
//                 System.out.println("Huffman code book:");
//                 printCode(root, "");
//         }
        
        
        
        
        
// }
