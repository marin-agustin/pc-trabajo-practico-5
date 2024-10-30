package ejercicio.seis;

import java.util.concurrent.Semaphore;

public class TorreControl {

    private Semaphore pista;
    private Semaphore aterrizar;
    private Semaphore despegar;
    private int cantidadAterrizajes;

    public TorreControl() {
        pista = new Semaphore(1);
        aterrizar = new Semaphore(1);
        despegar = new Semaphore(1);
        cantidadAterrizajes = 0;
    }

    public void aterrizar(String nombre) {
        if (cantidadAterrizajes != 10) {
            try {
                aterrizar.acquire();
                if (pista.availablePermits() == 1) {
                    pista.acquire();
                    System.out.println(nombre + ": ha empezado a aterrizar");
                    Thread.sleep(500);
                    System.out.println(nombre + ": ha aterrizado exitosamente");
                    cantidadAterrizajes++;
                    pista.release();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                aterrizar.release();
            }
        } else {
            System.out.println("Limite de aterrizajes alcanzado, se debe priorizar un despegue");
            cantidadAterrizajes = 0;
        }

    }

    public void despegar(String nombre) {
        if (cantidadAterrizajes < 10) {
            System.out.println("El despegue se pospone, se debe priorizar un aterrizaje");
        } else {
            try {
                despegar.acquire();
                if (pista.availablePermits() == 1) {
                    pista.acquire();
                    System.out.println(nombre + ": ha empezado a despegar");
                    Thread.sleep(500);
                    System.out.println(nombre + ": ha despegado exitosamente");
                    pista.release();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                despegar.release();
            }
        }

    }

}
