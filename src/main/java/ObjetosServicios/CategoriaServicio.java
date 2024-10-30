package ObjetosServicios;

import ObjetosDAO.CategoriaDAO;
import ObjetosImpl.CategoriaImpl;
import Objetos.Categoria;
import Excepciones.DAOException;

import java.util.List;

public class CategoriaServicio {

    private CategoriaDAO categoriaDAO;
    /**
     * Constructor de la clase CategoriaServicio.
     * Inicializa la instancia de CategoriaDAO.
     */
    public CategoriaServicio() {
        this.categoriaDAO = new CategoriaImpl();
    }
    /**
     * Agrega una nueva categoría.
     *
     * @param id El ID de la categoría.
     * @param nombre El nombre de la categoría.
     * @param nombreCorto El nombre corto de la categoría.
     * @param relevancia La relevancia de la categoría.
     */
    public void agregarCategoria(int id, String nombre, String nombreCorto, int relevancia) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNombre(nombre);
        categoria.setNombre_corto(nombreCorto);
        categoria.setRelevancia(relevancia);
        try {
            categoriaDAO.insertar(categoria);
            System.out.println("Categoria agregada con ID: " + categoria.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene una categoría por su ID.
     *
     * @param id El ID de la categoría.
     * @return La categoría obtenida o null si ocurre un error.
     */
    public Categoria obtenerCategoria(int id) {
        try {
            return categoriaDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lista todas las categorías.
     *
     * @return Una lista de todas las categorías o null si ocurre un error.
     */
    public List<Categoria> listarCategorias() {
        try {
            return categoriaDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Actualiza una categoría existente.
     *
     * @param id El ID de la categoría.
     * @param nombre El nombre de la categoría.
     * @param nombreCorto El nombre corto de la categoría.
     * @param relevancia La relevancia de la categoría.
     */
    public void actualizarCategoria(int id, String nombre, String nombreCorto, int relevancia) {
        Categoria categoria = new Categoria(id, nombre, nombreCorto, relevancia);
        try {
            categoriaDAO.actualizar(categoria);
            System.out.println("Categoria actualizada: " + categoria);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina una categoría por su ID.
     *
     * @param id El ID de la categoría.
     */
    public void eliminarCategoria(int id) {
        try {
            categoriaDAO.eliminar(id);
            System.out.println("Categoria eliminada con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el último ID de las categorías.
     *
     * @return El último ID de las categorías.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
    public int obtenerUltimoID() throws DAOException {
        return categoriaDAO.obtenerUltimoID();
    }
}