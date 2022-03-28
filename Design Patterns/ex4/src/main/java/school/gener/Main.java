package school.gener;

public class Main {
    public static void main(String[] args) {
        Gerador gerador = new Gerador();

        NumListener listener = new NumListener(){
            public void onNum(int num) {
                System.out.println(num);   
            }
        };

        gerador.addListener(listener);

        gerador.start();
    }
}