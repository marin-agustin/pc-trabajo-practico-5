package ejercicio.ocho;

public class Main {

    public static void main(String[] args) {

        ParqueNacional parqueNacional = new ParqueNacional();

        for (int i = 0; i < 10; i++) {
            Babuino babuino = new Babuino(i + "", parqueNacional);
            babuino.start();
        }

    }

}
