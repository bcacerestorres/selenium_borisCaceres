public class Productos {
private String nombre;
private float precio;

public Productos(String unNombre,float unPrecio){
    this.nombre=unNombre;
    this.precio=unPrecio;
  }

  public String getNombre(){
        return this.nombre;
   }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public float getPrecio(){
        return this.precio;
    }
    // metodo que escribe el sueldo
    public void setPrecio(float unPrecio){
        this.precio=unPrecio;
    }

    public String toString(){
        return "Nombre del producto: " + this.getNombre() + " con precio " + this.getPrecio();
    }

  public float Calcular(int cantidad){
    float precio_final=0;
    precio_final=this.precio * cantidad;
    return precio_final;
  }

}
