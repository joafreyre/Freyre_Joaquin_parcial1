
package model;

import java.time.LocalDate;

public class Gastronomia extends Servicio {
    private String gastronomia; // Nombre del servicio gastronómico
    private double precio; // Precio base
    private int diaSemDesc; // Día de la semana en que se aplica el descuento

    // Constructor
    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    // Método para calcular el precio final
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precio;

        // Aplica el descuento si está en promoción
        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            precioFinal -= precioFinal * (getPorcentajeDescuento() / 100);
        }
        return precioFinal;
    }

   
     @Override public String toString() {
        return "Gastronomia {" + getCodServicio() + ", porcentajeDescuento = " + getPorcentajeDescuento() +", enPromocion = " + isEnPromocion() + ", gastronomia = " + gastronomia + ", precio= " + precio + ", diaSemDesc= " + diaSemDesc + "}";
    }
    
    
}



