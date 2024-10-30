package ejercicio.uno;

public class Persona extends Thread{

    private GestorPiscina gestorPiscina;
    private String nombre;

    public Persona(GestorPiscina gestorPiscina, String nombre) {
        this.gestorPiscina = gestorPiscina;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            gestorPiscina.ingresarPiscina(nombre);
            Thread.sleep(5000);
            gestorPiscina.salirPiscina(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
