package ejercicio.tres;

public class Gato extends Thread {

    private String nombre;
    private Comedor comedor;

    public Gato(String nombre, Comedor comedor) {
        this.nombre = nombre;
        this.comedor = comedor;
    }

    @Override
    public void run() {
        while(true){
            if (comedor.comerGato(nombre)) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                comedor.saleGato(nombre);
            }
        }
    }

}
