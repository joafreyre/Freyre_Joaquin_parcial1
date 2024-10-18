
package model;

import java.time.LocalDate;

public class Hospedaje extends Servicio {
    private String hospedaje; // Descripción del tipo de hospedaje 
    private double precioPorNoche; // Precio base por noche

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precioPorNoche;
        // Se aplica el descuento de lunes a viernes si está en promoción.
        if (isEnPromocion() && dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5) {
            precioFinal -= precioPorNoche * (getPorcentajeDescuento() / 100);
        }
        return precioFinal;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}';
    }
    
}
