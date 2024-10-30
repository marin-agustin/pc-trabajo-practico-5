package ejercicio.tres;

import java.util.concurrent.Semaphore;

public class Comedor {

    private Semaphore cantGatos;
    private Semaphore cantPerros;
    private int cantidad;

    public Comedor(int cantidad) {
        this.cantidad = cantidad;
        cantGatos = new Semaphore(cantidad);
        cantPerros = new Semaphore(cantidad);
    }

    public boolean comerGato(String nombreGato) {
        if (cantPerros.availablePermits() == cantidad) {
            try {
                cantGatos.acquire();
                System.out.println(nombreGato + ": ha entrado en el comedor y ha empezado a comer");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean comerPerro(String nombrePerro) {
        if (cantGatos.availablePermits() == cantidad) {
            try {
                cantPerros.acquire();
                System.out.println(nombrePerro + ": ha entrado en el comedor y ha empezado a comer");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public void saleGato(String nombreGato) {
        System.out.println(nombreGato + ": ha salido del comedor");
        cantGatos.release();
    }

    public void salePerro(String nombrePerro) {
        System.out.println(nombrePerro + ": ha salido del comedor");
        cantPerros.release();
    }

}
