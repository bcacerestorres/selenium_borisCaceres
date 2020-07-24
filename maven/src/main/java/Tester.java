public class Tester extends  Empleado {
    // atributos
    private boolean testerManual;
    private boolean testerAutomatizador;
    // constructor con parametros
    public Tester(String unNombre, int unTel, float unSueldo, boolean esManual, boolean esAutomatizador){
        super(unNombre, unTel, unSueldo);
        this.testerManual = esManual;
        this.testerAutomatizador = esAutomatizador;
    }
    // trae si es tester manual
    public boolean getTesterManual(){
        return this.testerManual;
    }
    // ingresar si es tester manual
    public void setTesterManual(boolean esManual){
        this.testerManual = esManual;
    }
    // trae si es tester automatizador
    public boolean getTesterAutomatizador(){
        return this.testerAutomatizador;
    }
    // ingresar si es tester automatizador
    public void setTesterAutomatizador(boolean esAuto){

        if (esAuto == true){
            this.testerManual = true;
        }
        this.testerAutomatizador = esAuto;
    }
    // metodo  to string para tester
    public String toString(){
        String retorno = "";
        retorno += "Nombre del empleado: " + this.getNombre();
        retorno += ". Sueldo del empleado: " + this.getSueldo();
        retorno += ". Telefono del empleado: " + this.getTelefono();

        if (testerManual == true){
            retorno += " Es tester Manual.";
        } else {
            retorno += " NO Es tester Manual.";

        }
        if (testerAutomatizador == true){
            retorno += " Es tester Automatizador.";
        } else {
            retorno += " NO Es tester Automatizador.";

        }

        return  retorno;

    }

}// fin clase
