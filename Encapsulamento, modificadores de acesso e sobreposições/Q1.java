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
	}

	public static void main(String args[]) {
		System.out.println("Olá, mundo");
	}
}
