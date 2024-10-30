package ejercicio.cinco;

import java.util.concurrent.Semaphore;

public class VendedorTickets {

    private Semaphore tickets;
    private Semaphore accesoVenta;

    public VendedorTickets() {
        tickets = new Semaphore(5);
        accesoVenta = new Semaphore(1);
    }

    public boolean venderTicket(String nombre) {
        try {
            accesoVenta.acquire();
            if (tickets.availablePermits() > 0) {
                tickets.acquire();
                System.out.println(nombre + ": ha comprado un ticket");
                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            accesoVenta.release();
        }
    }

    public void recibirTicket() {
        tickets.release();
    }

}
