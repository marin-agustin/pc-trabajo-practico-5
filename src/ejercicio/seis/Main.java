package ejercicio.seis;

public class Main {

    public static void main(String[] args) {

        TorreControl torreControl = new TorreControl();

        for (int i = 0; i < 10; i++) {
            Avion avion = new Avion(i + "", torreControl);
            avion.start();
        }

    }

}
