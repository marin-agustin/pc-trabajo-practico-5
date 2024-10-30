package ejercicio.cinco;

public class ControlTren extends Thread {

    private TrenTuristico trenTuristico;

    public ControlTren(TrenTuristico trenTuristico) {
        this.trenTuristico = trenTuristico;
    }

    @Override
    public void run() {
        while (true) {
            if (trenTuristico.andar()){
                try {
                    Thread.sleep(1000);
                    trenTuristico.terminarRecorrido();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
