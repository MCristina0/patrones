package GestionLibro;

import java.util.List;

public interface LibroDAO {
    void agregarLibro(libro libro);
    libro obtenerLibroPorId(int id);
    List<libro> obtenerTodosLosLibros();
    void actualizarLibro(libro libro);
    void eliminarLibro(int id);
}
