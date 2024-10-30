package ejercicio.cinco;

import java.util.concurrent.Semaphore;

public class TrenTuristico {

    private int capacidad;
    private int asientosOcupados;
    private Semaphore accesoSubir;
    private Semaphore accesoBajar;
    private VendedorTickets vendedorTickets;
    private boolean empezoRecorrido = false;

    public TrenTuristico(int capacidad, VendedorTickets vendedorTickets) {
        this.capacidad = capacidad;
        this.asientosOcupados = 0;
        accesoSubir = new Semaphore(1);
        accesoBajar = new Semaphore(1);
        this.vendedorTickets = vendedorTickets;
    }

    public void subir(String nombre) {
        try {
            accesoSubir.acquire();
            System.out.println(nombre + ": se ha subido al tren");
            asientosOcupados++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            accesoSubir.release();
        }
    }

    public void bajar(String nombre) {
        try {
            accesoBajar.acquire();
            System.out.println(nombre + ": se ha bajado del tren");
            asientosOcupados--;
            vendedorTickets.recibirTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            accesoBajar.release();
        }
    }

    public boolean andar() {
        if (capacidad == asientosOcupados) {
            System.out.println("El tren inicia su recorrido con la capacidad llena");
            empezoRecorrido = true;
            return empezoRecorrido;
        } else {
            return empezoRecorrido;
        }
    }

    public void terminarRecorrido() {
        System.out.println("El tren termina su recorrido");
        empezoRecorrido = false;
    }

    public boolean getEmpezoRecorrido() {
        return empezoRecorrido;
    }

}
