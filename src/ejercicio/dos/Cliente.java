package ejercicio.dos;

import java.util.Scanner;

public class Cliente extends Thread {

    private String nombre;
    private Restaurante restaurente;

    public Cliente(String nombre, Restaurante restaurente) {
        this.nombre = nombre;
        this.restaurente = restaurente;
    }

    @Override
    public void run() {
        try {
            restaurente.llegarComedor(nombre);

            boolean quiereBeber = Math.random() > 0.5;
            boolean quiereComer = Math.random() > 0.5;

            if (quiereBeber) {
                restaurente.avisarMozo(nombre);
                Thread.sleep(2000);
                restaurente.saleComedor(nombre);
            }

            if (quiereComer) {
                restaurente.avisarCocinero(nombre);
                Thread.sleep(2000);
                restaurente.saleComedor(nombre);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            restaurente.saleComedor(nombre);
        }
    }

}
