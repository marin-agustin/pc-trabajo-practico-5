package ejercicio.dos;

import java.util.concurrent.Semaphore;

public class Restaurante {

    private Semaphore cocinero;
    private Semaphore mozo;
    private Semaphore espacioComedor;
    private Semaphore avisarMozo;
    private Semaphore avisarCocinero;

    public Restaurante() {
        cocinero = new Semaphore(0);
        mozo = new Semaphore(0);
        espacioComedor = new Semaphore(2);
        avisarMozo = new Semaphore(1);
        avisarCocinero = new Semaphore(1);
    }

    public void llegarComedor(String nombre) {
        try {
            espacioComedor.acquire();
            System.out.println(nombre + ": ha entrado en el comedor");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saleComedor(String nombre) {
        System.out.println(nombre + ": sale del comedor");
        espacioComedor.release();
    }

    public void servirBebida() {
        try {
            mozo.acquire();
            System.out.println("Mozo le sirve la bebida a: " + Thread.currentThread().getName());
            avisarMozo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void servirComida() {
        try {
            cocinero.acquire();
            System.out.println("Cocinero le sirve la comida a: " + Thread.currentThread().getName());
            avisarCocinero.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void avisarMozo(String nombre) {
        try {
            avisarMozo.acquire();
            System.out.println(nombre + ": avisa al mozo que esta esperandolo");
            mozo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void avisarCocinero(String nombre) {
        try {
            avisarCocinero.acquire();
            System.out.println(nombre + ": avisa al cocinero que esta esperandolo");
            cocinero.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
