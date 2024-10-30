package ejercicio.cinco;

public class Cliente extends Thread {

    private String nombre;
    private TrenTuristico trenTuristico;
    private VendedorTickets vendedorTickets;

    public Cliente(String nombre, TrenTuristico trenTuristico, VendedorTickets vendedorTickets) {
        this.nombre = nombre;
        this.trenTuristico = trenTuristico;
        this.vendedorTickets = vendedorTickets;
    }

    @Override
    public void run() {
        while (true) {
            if (vendedorTickets.venderTicket(nombre)) {
                trenTuristico.subir(nombre);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    while (!trenTuristico.getEmpezoRecorrido()) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                trenTuristico.bajar(nombre);
            }
        }
    }

}
