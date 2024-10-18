package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public List<Servicio> lstServicio = new ArrayList<>();

    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        return null; // Si no se encuentra el servicio.
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) > 0) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio con código " + codServicio + " ya existe.");
        }
        lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio con código " + codServicio + " ya existe.");
        }
        lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }
}

