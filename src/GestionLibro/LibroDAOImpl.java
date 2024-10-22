package GestionLibro;

import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private List<libro> libros;

    public LibroDAOImpl() {
        libros = new ArrayList<>();
    }

    @Override
    public void agregarLibro(libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    @Override
    public libro obtenerLibroPorId(int id) {
        for (libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public List<libro> obtenerTodosLosLibros() {
        return libros;
    }

    @Override
    public void actualizarLibro(libro libro) {
        libro libroExistente = obtenerLibroPorId(libro.getId());
        if (libroExistente != null) {
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setPublicacion(libro.getPublicacion());
            System.out.println("Libro actualizado: " + libroExistente);
        }
    }

    @Override
    public void eliminarLibro(int id) {
        libro libro = obtenerLibroPorId(id);
        if (libro != null) {
            libros.remove(libro);
            System.out.println("Libro eliminado: " + libro);
        }
    }
}
