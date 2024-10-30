package ejercicio.siete;

public class Main {

    public static void main(String[] args) {

        NaturalezaPlena naturalezaPlena = new NaturalezaPlena();
        ControlParqueAcuatico controlParqueAcuatico = new ControlParqueAcuatico(naturalezaPlena);
        controlParqueAcuatico.start();

        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona(i + "", naturalezaPlena);
            persona.start();
        }

    }

}
