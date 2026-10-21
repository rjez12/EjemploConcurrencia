package com.desarrollo.ejemploconcurrenciag3;

public class Caja {

    private int cantidadVentas = 0;
    private int totalRecadudado = 0;

    /**
     * synchronized permite que solamennte un Thread(hilo) ejecute el método a la vez
     * con esto evitamos el problema de race condition
     * @param vendedor es el numero o nombre del vendedor (hilo)
     * @param monto es el monto asignado
     */
    public synchronized void registrarVentas(String vendedor, int monto){
        cantidadVentas++;
        totalRecadudado += monto;

        System.out.println(vendedor + " registró una venta de C$ " + monto + " | ventas acumuladas: "
                + cantidadVentas + " | total: C$" + totalRecadudado);
    }
    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getTotalRecadudado() {
        return totalRecadudado;
    }


}
