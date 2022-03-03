class Main {
	
	//Q1:
	static class Pair {
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

		public boolean equals(Pair p1, Pair p2) {
			if (p1.left.equals(p2.left) && p1.right.equals(p2.right)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	//Q2:
	static class Pairing {
		private Pair pairs[];
                
                Pairing (String s1, String s2) {
                    try {
                        String array_s1[] = getList(s1);
                        String array_s2[] = getList(s2);
                        if (array_s1.length != array_s2.length) {
                            throw IncompatibleArgumentsExceptions();
                        }
                    } catch (IncompatibleArgumentsExceptions) {
                        System.out.println("\nArrays com diferentes tamanhos");
                    }
                    this.pairs = obtainPairs(s1, s2);
		}

		public Pair getPairs(int i) {
			return this.pairs[i];
		}

		private String[] getList(String s) {
			return s.split(",");
		}

		public Pair[] obtainPairs (String s1, String s2) {
			try {
				String array_s1[] = getList(s1);
				String array_s2[] = getList(s2);
				Pair objPair[] = new Pair[array_s1.length];
				for (int i = 0; i < array_s1.length; i++) {
					Pair pair = new Pair(array_s1[i], array_s2[i]);
					objPair[i] = pair;
				}
				return objPair;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public static void main(String args[]) {
            Pairing pairing = new Pairing("Teste 1", "Teste 2");
	}
}
