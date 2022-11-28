import java.util.Scanner;

class AngryBirds {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double v0 = sc.nextDouble();
		double alfa = sc.nextDouble();
		double distancia = sc.nextDouble();
		double R = Math.abs(v0*v0)*Math.sin(2*Math.toRadians(alfa))/9.8;
		if (Math.abs(distancia - R) <= 0.1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
