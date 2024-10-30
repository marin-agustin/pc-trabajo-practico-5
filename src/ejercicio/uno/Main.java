package ejercicio.uno;

public class Main {

    public static void main(String[] args) {

        GestorPiscina gestorPiscina = new GestorPiscina();

        for (int i = 0; i < 50; i++) {
            Persona p1 = new Persona(gestorPiscina, i + "");
            p1.start();
        }

    }

}
