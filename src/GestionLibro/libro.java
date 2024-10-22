package GestionLibro;

import java.util.Date;

// id, título, autor y año de publicación.
public class libro
{
    private int id;
    private String titulo;
    private String autor;
    private int publicacion;

    public libro (int id, String titulo, String autor, int publicacion){
     this.id=id;
     this.titulo=titulo;
     this.autor=autor;
     this.publicacion=publicacion;
    }
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "Libro \n id=" + id + "\n, título=" + titulo + "\n, autor=" + autor + "\n, año de publicación=" + publicacion ;
    }
}
