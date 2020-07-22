public class Empleado {
    //atributos
    private String nombre;
    private int telefono;
    private float sueldo;
 // constructor con palametros
    public Empleado(String unNombre, int unTelefono, float unSueldo){
        this.nombre = unNombre;
        this.sueldo = unSueldo;
        this.telefono = unTelefono;
    }
// constructor sin parametros
    public Empleado(){
        this.nombre ="Mario Peres";
        this.sueldo = 900000;
        this.telefono =9333662;
    }
    // metodo trae nombre
    public String getNombre(){
        return this.nombre;
    }
    // metodo escribe un nombre
    public void setNombre(String unNombre){
        this.nombre = unNombre;
    }
    // metodo que trae telefono
    public int getTelefono(){
        return this.telefono;
    }
  // metodo que escribe telefono
    public void setTelefono(int unTelefono){
        this.telefono = unTelefono;
    }
  // metodo que trae sueldo
    public float getSueldo(){
        return this.sueldo;
    }
    // metodo que escribe el sueldo
    public void setSueldo(float unSueldo){
        sueldo = unSueldo;
    }
// metodo to string
    public String toString(){
        return "Nombre del empleado: " + this.getNombre() + ". Telefono " + this.getTelefono() + ". Su sueldo es " + this.getSueldo();
    }

} //fin clase
