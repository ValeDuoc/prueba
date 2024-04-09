/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package venta.entrada;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vurru
 */
public class SistemaVentasTeatro {
    private static String nombreTeatro = "Teatro Moro";
    private static int capacidadSala = 100; // Ejemplo: capacidad de la sala del teatro
    private static double precioBaseEntrada = 20000; // Ejemplo: precio base de las entradas

    private static ArrayList<Entrada> entradasVendidas = new ArrayList<>();
    private static int numeroEntrada = 1; // Para asignar números únicos a cada entrada vendida

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Venta de entradas");
            System.out.println("2. Promociones");
            System.out.println("3. Búsqueda de entradas");
            System.out.println("4. Eliminación de entradas");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ventaEntradas(scanner);
                    break;
                case 2:
                    mostrarPromociones();
                    break;
                case 3:
                    buscarEntradas();
                    break;
                case 4:
                    eliminarEntrada();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Gracias por utilizar el sistema de ventas del Teatro Moro. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        scanner.close();
    }

    private static void ventaEntradas(Scanner scanner) {
        System.out.println("\nVenta de entradas:");
        System.out.println("Ubicación de la entrada (VIP, Platea, General): ");
        String ubicacion = scanner.next();
        
        double precioFinal = precioBaseEntrada;
        double descuento = 0;
        
        System.out.println("¿Es estudiante? (Sí/No): ");
        String respuestaEstudiante = scanner.next();
        
        if (respuestaEstudiante.equalsIgnoreCase("Sí")) {
            descuento += 0.10;
        }
        
        System.out.println("¿Es de la tercera edad? (Sí/No): ");
        String respuestaTerceraEdad = scanner.next();
        
        if (respuestaTerceraEdad.equalsIgnoreCase("Sí")) {
            descuento += 0.15;
        }
        
        precioFinal -= precioBaseEntrada * descuento;
        
        System.out.println("Precio final de la entrada: $" + precioFinal);
        
        // Almacenar la entrada vendida
        entradasVendidas.add(new Entrada(numeroEntrada++, ubicacion, precioFinal));
    }

    private static void mostrarPromociones() {
        System.out.println("\nPromociones:");
        // Implementa aquí la lógica para mostrar las promociones disponibles
    }

    private static void buscarEntradas() {
        System.out.println("\nBúsqueda de entradas:");
        // Implementa aquí la lógica para buscar entradas por número, ubicación o tipo
    }

    private static void eliminarEntrada() {
        System.out.println("\nEliminación de entradas:");
        // Implementa aquí la lógica para eliminar una entrada específica por su número
    }

    // Clase interna para representar una entrada vendida
    static class Entrada {
        private int numero;
        private String ubicacion;
        private double precioFinal;

        public Entrada(int numero, String ubicacion, double precioFinal) {
            this.numero = numero;
            this.ubicacion = ubicacion;
            this.precioFinal = precioFinal;
        }

        @Override
        public String toString() {
            return "Entrada " + numero + ": " + ubicacion + " - Precio: $" + precioFinal;
       
        }
    
    }
}
