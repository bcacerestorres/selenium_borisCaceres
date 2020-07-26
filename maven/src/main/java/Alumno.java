public class Alumno extends Persona{
  //  atributo nroEstudiante, grupo de tipo string y tienePrevia de tipo booleano
  private int   nroEstudiante;
  private String grupo;
  private Boolean tienePrevia;

  //constructor
    public Alumno(String unNombre, String unCi,int unaEdad, int unestudiante){
        super(unNombre,unCi,unaEdad);
      this.nroEstudiante=unestudiante;
       this.grupo="1A";
      this.tienePrevia=false;
    }

    // metodo que trae numero estudiante
    public int getNroEstudiante(){
        return this.nroEstudiante;
    }

    // metodo que trar el numero de estudiante
    public void setNroEstudiante(int unestudiante){
        this.nroEstudiante=unestudiante;
    }

    // metodo que trae grupo
    public String getgrupo(){
        return this.grupo;
    }

    // metodo que trar el numero de estudiante
    public void setgrupo(String ungrupo){
        this.grupo=ungrupo;
    }

    // metodo que trae previa
    public Boolean getprevia(){
        return this.tienePrevia;
    }

    // metodo que trar el numero de estudiante
    public void setprevia(boolean unaprevia){
        this.tienePrevia=unaprevia;
    }

    // metodo  to string para tester
    public String toString(){
        return super.toString()+ " Numero estudiante " +this.getNroEstudiante()
                + "  grupo  "+this.getgrupo() +"  "+this.esPrevia(this.getprevia());
    }

    //metoco mostrar si es importado
    public String esPrevia(boolean unaprevia) {
        if (unaprevia == true) {
            return " tiene previa";
        } else {
            return "no tiene previa";
        }

    }



}// fin clase
