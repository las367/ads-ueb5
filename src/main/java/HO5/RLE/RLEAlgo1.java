package HO5.RLE;

public class RLEAlgo1 implements IRLE {

	@Override
	public String compress(String in) {

                int size = in.length();
                String res = new String();

                for (int i = 0; i < size; i++) {

                        int count = 1; // count the duplicate chars.
                        while (i < size - 1 && in.charAt(i) == in.charAt(i + 1)) {

                                count++;
                                i++;
                        }

                        res = res + count + in.charAt(i) + " "; 
                        // res += .. and res = res + .. have different behaviors here.\
                        // using res += returns 101 104 102 116 128
                        // while using res = res + .. returns 4a 6b 3c 15e 26f
                }

                return res;
	}
        
}