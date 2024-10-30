package ejercicio.seis;

public class Avion extends Thread {

    private String nombre;
    private TorreControl torreControl;
    private int probabilidad;

    public Avion(String nombre, TorreControl torreControl) {
        this.nombre = nombre;
        this.torreControl = torreControl;
    }

    @Override
    public void run() {
        while (true) {
            probabilidad = (int) (Math.random() * 10);

            if (probabilidad < 5) {
                torreControl.aterrizar(nombre);
            }
            if (probabilidad > 5) {
                torreControl.despegar(nombre);
            }
        }
    }

}
