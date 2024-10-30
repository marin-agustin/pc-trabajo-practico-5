package ejercicio.dos;

public class Mozo extends Thread {

    private Restaurante restaurante;

    public Mozo(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public void run() {
        while (true) {
            try {
                restaurante.servirBebida();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
