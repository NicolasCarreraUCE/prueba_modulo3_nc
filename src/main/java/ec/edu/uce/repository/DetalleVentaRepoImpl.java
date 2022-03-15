package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaRepoImpl implements IDetalleVentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarDetalleVenta(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleVenta);
	}

	@Override
	public DetalleVenta buscarDetalleVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleVenta.class, id);
	}

	@Override
	public void actualizarDetalleVenta(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalleVenta);
	}

	@Override
	public void borrarDetalleVenta(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarDetalleVenta(id));
	}

}
