package ejercicio.siete;

import java.util.concurrent.Semaphore;

public class NaturalezaPlena {

    private Semaphore escalerasMirador;
    private Semaphore tobogan;

    public NaturalezaPlena() {
        escalerasMirador = new Semaphore(5);
        tobogan = new Semaphore(2);
    }

    public void subirMirador(String nombre) {
        try {
            escalerasMirador.acquire();
            System.out.println(nombre + ": esta subiendo al mirador");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public boolean subirseTobogan(String nombre) {
        if (tobogan.tryAcquire()) {
            System.out.println(nombre + ": ha subido al tobogan");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            escalerasMirador.release();
            return true;
        } else {
            return false;
        }
    }

    public void utilizarTobogan() {
        if (tobogan.availablePermits() == 0) {
            System.out.println("Las dos personas usan el tobogan");
            tobogan.release(2);
        }
    }

}
