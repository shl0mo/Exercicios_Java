import java.util.Arrays;

class Main {

	class Pair {
	    private String left;
	    private String right;
	    
	    Pair (String left, String right) {
		this.left = left;
	    	this.right = right;
	    }
			
	    @Override
	    public String toString() {
	    	return "(" + this.left + ", " + this.right + ")";
	    }

	    public boolean equals(Object o) {
		if (this.left.equals(((Pair)o).left) && this.right.equals(((Pair)o).right)) {
			return true;
		} else {
			return false;
		}
	    }
	}
	
	static class Pairing {
	    private Pair pairs[];
		       
	    Pairing (String s1, String s2) throws Exception {
		String array_s1[] = getList(s1);
		String array_s2[] = getList(s2);
		if (array_s1.length != array_s2.length) {
		    throw new Exception("Cannot obtain pairs with different sizes!");
		}
		if (s1.equals("") || s2.equals("")) {
		    this.pairs = new Pair[0];
		} else if (getList(s1).length == 1) {
		    Pair array_pairs[] = new Pair[1];
		    array_pairs[0] = new Pair(s1, s2); 
		    this.pairs = array_pairs;
		} else {
		    this.pairs = obtainPairs(s1, s2);
		}
	    }

	    public Pair[] getPairs() {
		return this.pairs;
	    }

	    private String[] getList(String s) {
		return s.split(", ");
	    }

	    public Pair[] obtainPairs (String s1, String s2) throws Exception {
		String array_s1[] = getList(s1);
		String array_s2[] = getList(s2);
		if (array_s1.length != array_s2.length) {
		    throw new Exception("Cannot obtain pairs with different sizes!");
		}
		Pair objPair[] = new Pair[array_s1.length];
		    for (int i = 0; i < array_s1.length; i++) {
		        Pair pair = new Pair(array_s1[i], array_s2[i]);
		        objPair[i] = pair;
		    }
		return objPair;
	    }
	    
	    @Override
	    public String toString() {
		return Arrays.toString(this.pairs).replace("[","").replace("]","");
	    }
	}
		
        public static void main(String args[]) {
	    String s1 = "Person 1, Person 3, Person 5";
	    String s2 = "Person 2, Person 4, Person 6";
            Pairing pairing = new Pairing(s1, s2);
            //String resultado = pairing.pairs.toString();
            System.out.println(pairing.getPairs(0).toString());
        }
}
