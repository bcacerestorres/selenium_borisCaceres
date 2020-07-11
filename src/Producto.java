public class Producto {
    //atributos: Nombre (String), Codigo (int), Importado (boolean), NroLote (String), NroProducto (int)
    private String Nombre;
    private int Codigo;
    private boolean Importado;
    private String NroLote;
    private static int NroProducto = 0;

    // constructor sin parametros
    public Producto() {
        this.Nombre = "Desconocido";
        this.Codigo = 0;
        this.Importado = false;
        this.NroLote = "Desconocido";
        NroProducto++;
    }

    // constructor con nombre
    public Producto(String unNombre) {
        this.Nombre = unNombre;
        this.Codigo = 1;
        this.Importado = false;
        this.NroLote = "Desconocido";
        NroProducto++;
    }

    // constructor con nombre , codigo
    public Producto(String unNombre, int unCodigo) {
        this.Nombre = unNombre;
        this.Codigo = unCodigo;
        this.Importado = false;
        this.NroLote = "Desconocido";
        NroProducto++;
    }

    // constructor con nombre, codigo, importado
    public Producto(String unNombre, int unCodigo, boolean unImportado) {
        this.Nombre = unNombre;
        this.Codigo = unCodigo;
        this.Importado = unImportado;
        this.NroLote = "Desconocido";
        NroProducto++;
    }

    // constructor con nombre, codigo, importado , numero de lote
    public Producto(String unNombre, int unCodigo, boolean unImportado, String unLote) {
        this.Nombre = unNombre;
        this.Codigo = unCodigo;
        this.Importado = unImportado;
        this.NroLote = unLote;
        NroProducto++;
    }

    //metodos que trae la nombre
    public String getNombre() { return this.Nombre; }

    // metodo que trae el codigo
    public int getCodigo() { return this.Codigo; }

    // metodo que trae importado
    public boolean getImportado() { return this.Importado; }

    // metodo que trae numero de lote
    public String getLote() { return this.NroLote; }

    // metodo que trae el numero de producto
    public int getNproducto() {
        return this.NroProducto;
    }

    //  metodo que ingresa nombre
    public void setNombre(String unNombre) {
        this.Nombre = unNombre;
    }

    // metodo que ingresa codigo
    public void setCodigo(int unCodigo) {
        this.Codigo = unCodigo;
    }

    // metodo que ingresa importado
    public void setImportado(boolean unImportado) {
        this.Importado = unImportado;
    }

    // metodo que ingresa lote
    public void setlote(String unLote) {
        this.NroLote = unLote;
    }

    //Mostrar todos los atributos en el método toString.
    // Si el producto es importado, se debe mostrar. “Este producto es importado”, sino, “Producto nacional”
    public String toString() {
        return "El producto se llama  " + this.getNombre() + " ,con codigo "
                + this.getCodigo() + " , " + this.esImportado(this.getImportado()) + "  ,con numero de lote" + this.getLote()
                +"  , numero de producto "+getNproducto();
    }

    //metodo mostrar si es importado
    public String esImportado(boolean unImportado) {
        if (unImportado == true) {
            return "Este producto es importado";
        } else {
            return "Producto nacional";
        }

    }


    //
}
