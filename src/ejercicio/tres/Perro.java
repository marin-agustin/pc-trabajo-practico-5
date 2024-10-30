package ejercicio.tres;

public class Perro extends Thread{

    private String nombre;
    private Comedor comedor;

    public Perro(String nombre, Comedor comedor) {
        this.nombre = nombre;
        this.comedor = comedor;
    }

    @Override
    public void run() {
        while(true){
            if (comedor.comerPerro(nombre)) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                comedor.salePerro(nombre);
            }
        }
    }

}
