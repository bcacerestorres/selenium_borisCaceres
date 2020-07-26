public class Profesor extends Persona{
//  materia y salario
    private String materia;
    private float salario;
    // constructor con parametros
    public Profesor(String unNombre, String unCi,int unaEdad, String unMateria,float unSalario){
     super(unNombre,unCi,unaEdad);
     this.materia=unMateria;
     this.salario=unSalario;
    }

    // metodo trae materia
    public String getmateria(){
        return this.materia;
    }
    // metodo escribe un nombre
    public void setNombre(String unMateria) {
        this.materia =unMateria;
    }

    // metodo que trae salario
    public float getsalario(){
        return this.salario;
    }
    // metodo que escribe salario
    public void setSalario(float unSalario){
        this.salario =unSalario;
    }

    // metodo  to string para tester
    public String toString(){
        return super.toString()+ " profesor de la  materia " +this.getmateria()
                + " salario "+this.getsalario();
    }
}// fin clase

