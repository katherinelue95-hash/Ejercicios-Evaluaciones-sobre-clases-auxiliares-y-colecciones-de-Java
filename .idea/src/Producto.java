public class Producto {
    // Atributos privados (Encapsulamiento)
    private String id;
    private String nombre;
    private String marca;
    private double precio;

    // Constructor
    public Producto(String id, String nombre, String marca, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    // Métodos Getter y Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para mostrar la información del producto organizada
    @Override
    public String toString() {
        return "Producto [ID=" + id + ", Nombre=" + nombre + ", Marca=" + marca + ", Precio=$" + precio + "]";
    }
}
