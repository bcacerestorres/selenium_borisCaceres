public class Noperecedero extends Productos {
    private String tipo;

    public Noperecedero(String unNombre, float unPrecio,String unTipo){
        super(unNombre, unPrecio);
        this.tipo =unTipo ;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String unTipo) {
        this.tipo=unTipo;
    }

    public float Calcular(int cantidad){
        float precio_final=0;
        precio_final=super.getPrecio() * cantidad;
        return precio_final;
    }


    public String toString() {
        return super.toString() + " del tipo  " + this.getTipo();
    }


}// fin clase
