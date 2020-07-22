public class Manager extends Empleado {
    // atributo
    private String area;
    // constructor
    public Manager(String unNombre, int unTelefono, float unSueldo, String unArea){
        super(unNombre, unTelefono, unSueldo);
        this.area =unArea ;
    }
    //metodo que trae el lenguaje
    public String getArea(){
        return this.area;
    }
    // metodo que escribe el lenguaje
    public void setArea(String unArea){
        this.area = unArea;
    }
    // metodo to string del developer
    public String toString(){
        return super.toString() + " El area es " + this.getArea();
    }
}//fin de la clase
