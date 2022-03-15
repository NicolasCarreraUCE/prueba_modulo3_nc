package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Venta;

public interface IVentaRepo {
	void insertarVenta(Venta venta);
	Venta buscarVenta(Integer id);
	void actualizarVenta(Venta venta);
	void borrarVenta(Integer id);
	
	List<Venta> buscarVentaPorFecha(LocalDateTime fecha);
	
}
