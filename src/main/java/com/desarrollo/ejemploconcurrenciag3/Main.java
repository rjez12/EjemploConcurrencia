package com.desarrollo.ejemploconcurrenciag3;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Objeto compartido por todos los Threads

        Caja caja = new Caja();

        // Runnable representa la tarea que ejecutara cada uno de los vendedores
        Runnable vendedor1 = () -> procesarVentas("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVentas("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVentas("Vendedor 3", caja);

        // Crear los Threads (Hilos)
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println(" ----- Inicio del proceso de ventas -----");

        /**
         * start() es el encargado de iniciar el proceso del hilo
         * Los tres vendedores comienzan a procesar sus ventas concurrentemente
         */
        hilo1.start();
        hilo2.start();
        hilo3.start();

        /**
         * join() permite que el hilo main espere el proceso
         * hasta que terminen los otros Threads
         */
        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println(" ----- Termina el proceso de ventas -----");
        System.out.println("Cantidad de ventas: " + caja.getCantidadVentas());
        System.out.println("Total recaudado: C$" + caja.getTotalRecadudado());
    }

    private static void procesarVentas(String vendedor, Caja caja) {
        for (int i = 1; i <= 60; i++) {
            try {
                Thread.sleep(500);
                caja.registrarVentas(vendedor, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(vendedor + " fue interrumpido");
                return;
            }
        }
    }
}
