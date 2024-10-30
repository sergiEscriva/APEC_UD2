package ObjetosServicios;

import ObjetosDAO.CategoriaDAO;
import ObjetosImpl.CategoriaImpl;
import Objetos.Categoria;
import Excepciones.DAOException;

import java.util.List;

public class CategoriaServicio {

    private CategoriaDAO categoriaDAO;

    public CategoriaServicio() {
        this.categoriaDAO = new CategoriaImpl();
    }

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

    public Categoria obtenerCategoria(int id) {
        try {
            return categoriaDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Categoria> listarCategorias() {
        try {
            return categoriaDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarCategoria(int id, String nombre, String nombreCorto, int relevancia) {
        Categoria categoria = new Categoria(id, nombre, nombreCorto, relevancia);
        try {
            categoriaDAO.actualizar(categoria);
            System.out.println("Categoria actualizada: " + categoria);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCategoria(int id) {
        try {
            categoriaDAO.eliminar(id);
            System.out.println("Categoria eliminada con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    public int obtenerUltimoID() throws DAOException {
        return categoriaDAO.obtenerUltimoID();
    }
}