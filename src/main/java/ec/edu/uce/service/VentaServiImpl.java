package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Venta;
import ec.edu.uce.repository.IVentaRepo;

@Service
public class VentaServiImpl implements IVentaServi {

	@Autowired
	private IVentaRepo ventaRepo;
	
	@Override
	public void insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.insertarVenta(venta);
	}

	@Override
	public Venta buscarVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarVenta(id);
	}

	@Override
	public void actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.actualizarVenta(venta);
	}

	@Override
	public void borrarVenta(Integer id) {
		// TODO Auto-generated method stub
		this.ventaRepo.borrarVenta(id);
	}

	@Override
	public List<Venta> buscarVentaPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarVentaPorFecha(fecha);
	}

}
