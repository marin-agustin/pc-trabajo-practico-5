package ejercicio.ocho;

public class Babuino extends Thread {

    private String nombre;
    private ParqueNacional parqueNacional;
    private int probabilidad;

    public Babuino(String nombre, ParqueNacional parqueNacional) {
        this.nombre = nombre;
        this.parqueNacional = parqueNacional;
        probabilidad = (int) (Math.random() * 10);;
    }

    @Override
    public void run() {

        if (probabilidad < 5) {
            while (true) {
                parqueNacional.cruzarA(nombre);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                parqueNacional.cruzarB(nombre);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if (probabilidad > 4) {
            while (true) {
                parqueNacional.cruzarB(nombre);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                parqueNacional.cruzarA(nombre);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
