import java.util.Scanner;

class TanqueCombustivel {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		double x = sc.nextDouble();
		int opcao = sc.nextInt();
		double pi = Math.PI;
		if (opcao == 1) {
			double volume_comust
			System.out.println(4/3*pi*Math.pow(r, 3));
		} else if (opcao == 2) {
			System.out.println(4/3*pi*Math.pow(x, 2)*(3*r - x));
		}
	}
}
