package ejercicio.siete;

public class Persona extends Thread {

    private String nombre;
    private NaturalezaPlena naturalezaPlena;

    public Persona(String nombre, NaturalezaPlena nP) {
        this.nombre = nombre;
        naturalezaPlena = nP;
    }

    @Override
    public void run() {
        while (true) {
            naturalezaPlena.subirMirador(nombre);
            if (naturalezaPlena.subirseTobogan(nombre)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
