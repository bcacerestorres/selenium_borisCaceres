public class Perecedero extends Productos {
   private int dias_a_caducar;

    public Perecedero(String unNombre, float unPrecio, int diasCaducar) {
        super(unNombre, unPrecio);
        this.dias_a_caducar = diasCaducar;
    }

    public int getCaducar() {
        return this.dias_a_caducar;
    }

    public void setCaducar(int diasCaducar) {
        this.dias_a_caducar = diasCaducar;
    }

    public String toString() {
        return super.toString() + " caduca en tantos dias " + this.getCaducar();
    }

   public float Calcular(int cantidad){
        float resultado = 0;
     if(this.getCaducar() == 1){
         resultado=super.Calcular(cantidad)/4;
        }else if(this.getCaducar() == 2){
         resultado=super.Calcular(cantidad)/3;
        }else if(this.getCaducar() == 3){
         resultado=super.Calcular(cantidad)/4;
        }
     return resultado;
    }



}
