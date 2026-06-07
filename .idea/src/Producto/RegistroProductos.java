import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Clase RegistroProductos
 * Permite al usuario registrar productos y mostrarlos usando Iterator.
 * Los productos se almacenan en un ArrayList.
 */
public class RegistroProductos {

    public static void main(String[] args) {
        // Crear ArrayList para almacenar productos
        ArrayList<Producto> productos = new ArrayList<>();

        // Crear Scanner para lectura de datos
        Scanner scanner = new Scanner(System.in);

        // Variable para controlar el flujo del programa
        String continuar = "si";
        int siguienteId = 1;

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE REGISTRO DE PRODUCTOS             ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();

        // Bucle para solicitar datos de productos
        while (continuar.equalsIgnoreCase("si")) {
            System.out.println("─── Registro de Producto #" + siguienteId + " ───");

            // Solicitar y validar nombre
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("⚠ Error: El nombre no puede estar vacío.\n");
                continue;
            }

            // Solicitar y validar marca
            System.out.print("Ingrese la marca: ");
            String marca = scanner.nextLine().trim();

            if (marca.isEmpty()) {
                System.out.println("⚠ Error: La marca no puede estar vacía.\n");
                continue;
            }

            // Solicitar y validar precio
            System.out.print("Ingrese el precio: $");
            double precio = 0;
            try {
                precio = Double.parseDouble(scanner.nextLine().trim());

                if (precio < 0) {
                    System.out.println("⚠ Error: El precio no puede ser negativo.\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Error: Ingrese un precio válido (número).\n");
                continue;
            }

            // Crear nuevo producto y agregarlo al ArrayList
            Producto nuevoProducto = new Producto(siguienteId, nombre, marca, precio);
            productos.add(nuevoProducto);

            System.out.println("✓ Producto registrado exitosamente.\n");

            // Preguntar si desea continuar registrando
            System.out.print("¿Desea registrar otro producto? (si/no): ");
            continuar = scanner.nextLine().trim();

            // Validar respuesta
            while (!continuar.equalsIgnoreCase("si") && !continuar.equalsIgnoreCase("no")) {
                System.out.print("Por favor, ingrese 'si' o 'no': ");
                continuar = scanner.nextLine().trim();
            }

            if (continuar.equalsIgnoreCase("si")) {
                siguienteId++;
                System.out.println();
            }
        }

        // Cerrar Scanner
        scanner.close();

        // Mostrar productos registrados
        mostrarProductos(productos);
    }

    /**
     * Método que muestra todos los productos usando Iterator
     * @param productos ArrayList con los productos a mostrar
     */
    public static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║      PRODUCTOS REGISTRADOS                      ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();

        // Validar si hay productos registrados
        if (productos.isEmpty()) {
            System.out.println("⚠ No hay productos registrados.");
            return;
        }

        // Usar Iterator para recorrer la colección
        Iterator<Producto> iterador = productos.iterator();
        int contador = 1;

        System.out.println("Total de productos: " + productos.size());
        System.out.println("─".repeat(50));

        while (iterador.hasNext()) {
            Producto producto = iterador.next();
            System.out.println("[" + contador + "] " + producto.toString());
            contador++;
        }

        System.out.println("─".repeat(50));
        System.out.println();

        // Mostrar resumen de precios
        mostrarResumenPrecios(productos);
    }

    /**
     * Método auxiliar que muestra un resumen de precios
     * @param productos ArrayList con los productos
     */
    public static void mostrarResumenPrecios(ArrayList<Producto> productos) {
        double precioTotal = 0;
        double precioPromedio = 0;
        double precioMayor = 0;
        double precioMenor = Double.MAX_VALUE;

        Iterator<Producto> iterador = productos.iterator();

        while (iterador.hasNext()) {
            Producto producto = iterador.next();
            double precio = producto.getPrecio();

            precioTotal += precio;
            precioMayor = Math.max(precioMayor, precio);
            precioMenor = Math.min(precioMenor, precio);
        }

        precioPromedio = precioTotal / productos.size();

        System.out.println("📊 RESUMEN DE PRECIOS:");
        System.out.println("   • Precio Total: $" + String.format("%.2f", precioTotal));
        System.out.println("   • Precio Promedio: $" + String.format("%.2f", precioPromedio));
        System.out.println("   • Precio Máximo: $" + String.format("%.2f", precioMayor));
        System.out.println("   • Precio Mínimo: $" + String.format("%.2f", precioMenor));
        System.out.println();
    }
}