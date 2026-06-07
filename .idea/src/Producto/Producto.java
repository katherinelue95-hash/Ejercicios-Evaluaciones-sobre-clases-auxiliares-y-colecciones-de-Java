/**
 * Clase Producto
 * Representa un producto con id, nombre, marca y precio.
 * Implementa encapsulamiento de propiedades mediante getters y setters.
 */
public class Producto {

    // Atributos privados
    private int id;
    private String nombre;
    private String marca;
    private double precio;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(int id, String nombre, String marca, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    // Getters y Setters (Encapsulamiento)

    /**
     * Obtiene el id del producto
     * @return id del producto
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del producto
     * @param id id a asignar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     * @param nombre nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca del producto
     * @return marca del producto
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del producto
     * @param marca marca a asignar
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el precio del producto
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     * @param precio precio a asignar
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo toString para representar el producto como cadena
     * @return representación en texto del producto
     */
    @Override
    public String toString() {
        return "Producto {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=$" + String.format("%.2f", precio) +
                '}';
    }
}