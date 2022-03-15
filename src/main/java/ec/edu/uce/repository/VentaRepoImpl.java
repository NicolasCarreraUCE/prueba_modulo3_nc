package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Venta;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

	@Override
	public Venta buscarVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Venta.class, id);
	}

	@Override
	public void actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(venta);
	}

	@Override
	public void borrarVenta(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarVenta(id));
	}

	@Override
	public List<Venta> buscarVentaPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<Venta> myQuery = this.entityManager.createQuery("SELECT c FROM Venta c WHERE c.fecha =:fecha", Venta.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	} 

}
