public class Camion {
    //Definir la variable chapa y color de tipo int y String respectivamente
    private int chapa;
    private String color;
    //Agregar un atributo llamado añoCompra de tipo int.
    private int añoCompra;
    //constructor sin parámetros
    public Camion(){
        this.color= "Desconocido";
        this.chapa= 00000000;
        this.añoCompra=2010;
    }
    //constructor con únicamente la chapa como parámetro
    public Camion(int unaChapa){
        this.color= "Desconocido";
        this.chapa= unaChapa;
        this.añoCompra=2011;

    }

    //constructor con la chapa y el color
    public Camion(int unaChapa, String unColor){
        this.color= unColor;
        this.chapa= unaChapa;
        this.añoCompra=2012;

    }
  //constructor con la chapa y el color
  public Camion(int unaChapa, String unColor, int unAño){
      this.color= unColor;
      this.chapa= unaChapa;
      this.añoCompra=unAño;

  }

    //metodos que trae la chapa
    public int getChapa(){
        return this.chapa;
    }
     // metodo de inrgresar un numero de chapa
    public void setChapa (int unaChapa) {
        this.chapa = unaChapa;
    }
    // metodo que trae el color
    public String getColor(){
        return this.color;
    }
     // metodo que ingresa el color
    public void setColor (String unColor) {
        this.color = unColor;
    }
    // metodo que trae el año
    public int getter(){
        return this.añoCompra;
    }
    // metodo que ingresa el año
     public void setter(int unAño){
        this.añoCompra=unAño;
     }

    //Crear un método llamado tieneMismoColor,
    // que reciba un Camion como parámetro, y retorne verdadero si dos camiones tienen el mismo color
    public boolean tieneMismoColor (Camion otroCamion){
        return this.getColor().equals(otroCamion.getColor());
    }

    //método toString() que imprima todos los datos en pantalla del camión
    public String toString(){
        return "Camion de color  " + this.getColor() + " ,con una chapa " + this.getChapa() + " ,la revision es  "+this.leTocaRevision(this.getter());
    }

    //Agregar un método a la clase Camión,
    // llamado leTocaRevision que retorne true si el año de compra es menor a 2015
    public boolean leTocaRevision( int añoCompra ) {
        if (añoCompra < 2015) {
            return true;
        } else {
            return false;
        }
    }

}
