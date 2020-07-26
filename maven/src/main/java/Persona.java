public class Persona {
    //atributos nombre, ci y edad
  private String Nombre;
  private String ci;
  private int edad;

    // constructor con dos parametros
    public Persona(){
   this.Nombre="Pedro";
   this.ci="123363336";
   this.edad=12;
    }

    //
    public Persona(String unNombre, String unCi,int unaEdad){
        this.Nombre=unNombre;
        this.ci=unCi;
        this.edad=unaEdad;
    }


    // metodo trae nombre
    public String getNombre(){
        return this.Nombre;
    }
    // metodo escribe un nombre
    public void setNombre(String unNombre) {
        this.Nombre = unNombre;
    }

    // metodo trae ci
    public String getci(){
        return this.ci;
    }

    //metodo escribir
    public void setci( String unCi){
        this.ci=unCi;
    }

    // metodo que edad
    public int getedad(){
        return this.edad;
    }
    // metodo que escribe edad
    public void setTelefono(int unaedad){
        this.edad = unaedad;
    }

    // metodo to string
    public String toString(){
        return "Nombre : " + this.getNombre() + "  CI " + this.getci()
                + "  edad " + this.getedad();
    }



}// fin clase
