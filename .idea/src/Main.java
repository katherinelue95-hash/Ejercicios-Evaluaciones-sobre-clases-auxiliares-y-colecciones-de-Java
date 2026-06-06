import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear el ArrayList para almacenar los productos
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String continuar;

        System.out.println("--- REGISTRO DE PRODUCTOS ---");

        // Bucle para solicitar datos hasta que el usuario decida detenerse
        do {
            System.out.print("Ingrese el ID del producto: ");
            String id = scanner.nextLine();

            System.out.print("Ingrese el Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la Marca del producto: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese el Precio del producto: ");
            double precio = scanner.nextDouble();

            // Limpiar el buffer del scanner después de leer un número
            scanner.nextLine();

            // Crear el objeto Producto y agregarlo a la colección
            Producto nuevoProducto = new Producto(id, nombre, marca, precio);
            listaProductos.add(nuevoProducto);

            // Preguntar si desea seguir registrando
            System.out.print("\n¿Desea registrar otro producto? (S/N): ");
            continuar = scanner.nextLine();
            System.out.println();

        } while (continuar.equalsIgnoreCase("s")); // Se repite si el usuario presiona 's' o 'S'

        // Mostrar los productos usando la clase Iterator
        System.out.println("--- LISTA DE PRODUCTOS REGISTRADOS ---");
        Iterator<Producto> iterador = listaProductos.iterator();

        while (iterador.hasNext()) {
            Producto prod = iterador.next();
            System.out.println(prod); // Llama automáticamente al método toString() de Producto
        }

        System.out.println("\nPrograma finalizado correctamente.");
        scanner.close();
    }
}
