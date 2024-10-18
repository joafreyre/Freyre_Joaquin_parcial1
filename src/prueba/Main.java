package prueba;

import model.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try {
            Sistema sistema = new Sistema();
            System.out.println("1-1");
            try {
                sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("1-2");
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("Gastronomia creada exitosamente.");
            System.out.println("1-3");
            try {
                sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("1-4");
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println("Hospedaje creado exitosamente.");
            System.out.println("2-1");
            Gastronomia gastronomia = (Gastronomia) sistema.traerServicio("489235");
            double precioFinalGastronomia = gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28));
            System.out.println("Precio final Gastronomia: " + precioFinalGastronomia);
            System.out.println("2-2");
            try {
                Hospedaje hospedaje = (Hospedaje) sistema.traerServicio("287282");
                double precioFinalHospedaje = hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27));
                System.out.println("Precio final Hospedaje: " + precioFinalHospedaje);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Hospedaje hospedaje = (Hospedaje) sistema.traerServicio("287282");
            double precioFinalHospedaje = hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27));
            System.out.println("Precio final Hospedaje: " + precioFinalHospedaje);
            System.out.println("3");
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);

            for (Servicio s : sistema.lstServicio) {
                System.out.println(s);
            }
            System.out.println("4-1");
            for (Servicio s : sistema.traerServicio(true)) {
                System.out.println(s);
            }
            System.out.println("4-2");
            for (Servicio s : sistema.traerServicio(true, LocalDate.of(2020, 10, 28))) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
