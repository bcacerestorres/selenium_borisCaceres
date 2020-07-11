public class Libro {
    //ISBN: int
   // Titulo: String
  //  Autor: String
   // Número de páginas: int
private int ISBN;
private String Titulo;
private String Autor;
private int Numero_paginas;
// constructor sin parametros
public Libro(){
    this.ISBN=0000001;
    this.Titulo="Sin título";
    this.Autor="Desconocido";
    this.Numero_paginas=100;
 }
 // constructor con parametros
  public Libro(int unIsbn, String unTitulo,String unAutor,int unNpagina){
  this.ISBN=unIsbn;
  this.Titulo=unTitulo;
  this.Autor=unAutor;
  this.Numero_paginas=unNpagina;
  }
  // metodo get
   public String getTitulo(){ return this.Titulo;}
   public  String getAutor (){return this.Autor;}
   public int getNumero_paginas(){return this.Numero_paginas; }
   public int getISBN(){return this.ISBN;}
   // metodo set
    public void setISBN(int unIsbn) { this.ISBN = unIsbn;}
    public void setAutor(String unAutor) { this.Autor = unAutor;}
    public void setTitulo(String unTitulo) { this.Titulo = unTitulo;}
    public void setNumero_paginas(int unNpagina) { this.Numero_paginas =unNpagina ;}
    //metodo de impresion
    public String toString() {
    return " El titulo del libro   "+this.getTitulo()+" con  ISBN  "+this.getISBN()+" creado por el autor  " +this.getAutor() +" tiene "+this.getNumero_paginas()+" paginas ";
    }

    //Si el autor está en null, se debe mostrar “desconocido”.
    public String esDesconocido(String autores) {
        if (autores == null) {
            return "El autor es desconocido";
        } else {
            return "El autor es conocido";
        }
    }


//
}
