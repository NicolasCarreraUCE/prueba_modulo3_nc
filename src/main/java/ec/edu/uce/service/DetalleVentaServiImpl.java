package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.repository.IDetalleVentaRepo;

@Service
public class DetalleVentaServiImpl implements IDetalleVentaServi {

	@Autowired
	private IDetalleVentaRepo detalleVentaRepo;
	
	@Override
	public void insertarDetalleVenta(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.detalleVentaRepo.insertarDetalleVenta(detalleVenta);
	}

	@Override
	public DetalleVenta buscarDetalleVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.detalleVentaRepo.buscarDetalleVenta(id);
	}

	@Override
	public void actualizarDetalleVenta(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.detalleVentaRepo.actualizarDetalleVenta(detalleVenta);
	}

	@Override
	public void borrarDetalleVenta(Integer id) {
		// TODO Auto-generated method stub
		this.detalleVentaRepo.borrarDetalleVenta(id);
	}

}
