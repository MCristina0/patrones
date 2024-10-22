package GestionLibro;
import java.util.List;
import java.util.Scanner;



public class gestion {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestión de Libros");
            System.out.println("1. Agregar libro");
            System.out.println("2. Ver todos los libros");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Ver libro por ID");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar libro
                    System.out.print("Ingrese el ID del libro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación del libro: ");
                    int anioPublicacion = scanner.nextInt();
                    libroDAO.agregarLibro(new libro(id, titulo, autor, anioPublicacion));
                    break;

                case 2:
                    // Ver todos los libros
                    List<libro> libros = libroDAO.obtenerTodosLosLibros();
                    System.out.println("\nLista de libros:");
                    for (libro libro : libros) {
                        System.out.println(libro);
                    }
                    break;

                case 3:
                    // Actualizar libro
                    System.out.print("Ingrese el ID del libro a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    libro libroAActualizar = libroDAO.obtenerLibroPorId(idActualizar);
                    if (libroAActualizar != null) {
                        System.out.print("Ingrese el nuevo título del libro: ");
                        String nuevoTitulo = scanner.nextLine();
                        System.out.print("Ingrese el nuevo autor del libro: ");
                        String nuevoAutor = scanner.nextLine();
                        System.out.print("Ingrese el nuevo año de publicación del libro: ");
                        int nuevoAnioPublicacion = scanner.nextInt();
                        libroAActualizar.setTitulo(nuevoTitulo);
                        libroAActualizar.setAutor(nuevoAutor);
                        libroAActualizar.setPublicacion(nuevoAnioPublicacion);
                        libroDAO.actualizarLibro(libroAActualizar);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    // Eliminar libro
                    System.out.print("Ingrese el ID del libro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    libroDAO.eliminarLibro(idEliminar);
                    break;

                case 5:
                    // Ver libro por ID
                    System.out.print("Ingrese el ID del libro: ");
                    int idBuscar = scanner.nextInt();
                    libro libroObtenido = libroDAO.obtenerLibroPorId(idBuscar);
                    if (libroObtenido != null) {
                        System.out.println("Libro obtenido: " + libroObtenido);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo >:|..");
                    break;

                default:
                    System.out.println("Opción no válida :).");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
