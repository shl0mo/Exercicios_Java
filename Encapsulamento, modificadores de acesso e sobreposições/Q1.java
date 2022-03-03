class Main {

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

	public static void main(String args[]) {
		Pair objPair = new Pair("Esquerda", "Direita");
		Pair objPair2 = new Pair("Esquerda", "Direita");
		System.out.println(objPair.equals(objPair, objPair2));
	}
}
