package ejercicio.uno;

import java.util.concurrent.Semaphore;

public class GestorPiscina {

    private Semaphore genteDisponible;

    public GestorPiscina() {
        genteDisponible = new Semaphore(20);
    }

    public void ingresarPiscina(String nombre) throws InterruptedException {
        genteDisponible.acquire();
        System.out.println(nombre + " ha ingresado a la piscina");
    }

    public void salirPiscina(String nombre) {
        System.out.println(nombre + " ha salido de la piscina");
        genteDisponible.release();
    }

}
