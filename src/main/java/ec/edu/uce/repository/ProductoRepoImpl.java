package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ec.edu.uce.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	private static final Logger LOG = Logger.getLogger(ProductoRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscarProducto(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public void borrarProducto(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarProducto(id));
	}

	@Override
	public Producto buscarProductoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT c FROM Producto c WHERE c.nombre =:nombre", Producto.class);
			myQuery.setParameter("nombre", nombre);
			return myQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("No se ecnontro el producto");
		}
		return null;
	}

	@Override
	public Producto buscarProductoPorCodigoDeBarra(String codigoDeBarra) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT c FROM Producto c WHERE c.codigoDeBarras =:codigo", Producto.class);
		myQuery.setParameter("codigo", codigoDeBarra);
		return myQuery.getSingleResult();
	} 
 
}
