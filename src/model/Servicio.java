package model;

import java.time.LocalDate;

public abstract class Servicio {
    private String codServicio; // Identificador único de longitud 6
    private double porcentajeDescuento;
    private boolean enPromocion;

    // Constructor
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        setCodServicio(codServicio);
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    // Método para establecer el código de servicio
    public void setCodServicio(String codServicio) {
        if (codServicio.length() != 6) {
            throw new IllegalArgumentException("El código de servicio debe tener una longitud de 6.");
        }
        this.codServicio = codServicio;
    }

    // Método para obtener el código de servicio
    public String getCodServicio() {
        return codServicio;
    }

    // Método para obtener el porcentaje de descuento
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    // Método para verificar si está en promoción
    public boolean isEnPromocion() {
        return enPromocion;
    }

    // Método abstracto para calcular el precio final
    public abstract double calcularPrecioFinal(LocalDate dia);
}


