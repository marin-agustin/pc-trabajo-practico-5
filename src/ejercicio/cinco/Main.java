package ejercicio.cinco;

public class Main {

    public static void main(String[] args) {

        VendedorTickets vendedorTickets = new VendedorTickets();
        TrenTuristico trenTuristico = new TrenTuristico(5, vendedorTickets);

        ControlTren controlTren = new ControlTren(trenTuristico);
        controlTren.start();

        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente(i + "", trenTuristico, vendedorTickets);
            cliente.start();
        }

    }

}
