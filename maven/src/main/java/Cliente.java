public class Cliente {
    private String nombre;
    private int edad;
    private int DNI;

    public Cliente(){
        this.DNI = 12341234;
        this.edad=30;
        this.nombre ="Juan";
    }

    public Cliente (String unNombre, int unaEdad,int unDNI) {
        this.nombre = unNombre;
        this.edad =unaEdad;
        this.DNI =unDNI;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String unNombre){
        this.nombre = unNombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public int getDNI(){
        return this.DNI;
    }

    public void setEdad(int unaEdad){
        this.edad =unaEdad;
    }

    public void setDNI(int unDNI){
        this.DNI=unDNI;
    }


    public String toString(){
        return "El nombre del cliente es " + this.getNombre() + " y su DNI es " + this.getDNI() +" edad "+this.getEdad();
    }

}
