public class Developer extends Empleado {
    // atributo
    private String lenguaje;
   // constructor
    public Developer(String unNombre, int unTelefono, float unSueldo, String unLenguaje){
        super(unNombre, unTelefono, unSueldo);
        this.lenguaje = unLenguaje;
    }
    //metodo que trae el lenguaje
    public String getLenguaje(){
        return this.lenguaje;
    }
      // metodo que escribe el lenguaje
    public void setLenguaje(String unLenguaje){
        this.lenguaje = unLenguaje;
    }
    // metodo to string del developer
    public String toString(){
        return super.toString() + " Su lenguaje es " + this.getLenguaje();
    }

}// fin clase
