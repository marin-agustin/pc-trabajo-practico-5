package ejercicio.ocho;

import java.util.concurrent.Semaphore;

public class ParqueNacional {

    private Semaphore cuerdaA;
    private Semaphore cuerdaB;
    private int ladoA;
    private int ladoB;

    public ParqueNacional() {
        cuerdaA = new Semaphore(5);
        cuerdaB = new Semaphore(5);
        ladoA = 0;
        ladoB = 0;
    }

    public void cruzarA(String nombre) {
        if (cuerdaB.availablePermits() == 5) {
            try {
                cuerdaA.acquire();
                System.out.println(nombre + ": esta cruzando del lado A->B");
                ladoA++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                cuerdaA.release();
            }
        } else {
            System.out.println("Hay un babuino cruzando en direccion contraria");
        }
    }

    public void cruzarB(String nombre) {
        if (cuerdaA.availablePermits() == 5) {
            try {
                cuerdaB.acquire();
                System.out.println(nombre + ": esta cruzando del lado B->A");
                ladoB++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                cuerdaB.release();
            }
        } else {
            System.out.println("Hay un babuino cruzando en direccion contraria");
        }
    }

    public int getLadoA() {
        return ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

}
