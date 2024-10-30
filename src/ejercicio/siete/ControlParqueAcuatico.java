package ejercicio.siete;

public class ControlParqueAcuatico extends Thread {

    private NaturalezaPlena naturalezaPlena;

    public ControlParqueAcuatico(NaturalezaPlena naturalezaPlena) {
        this.naturalezaPlena = naturalezaPlena;
    }

    @Override
    public void run() {
        while (true) {
            naturalezaPlena.utilizarTobogan();
        }
    }

}
