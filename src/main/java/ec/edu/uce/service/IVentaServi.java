package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Venta;

public interface IVentaServi {
	void insertarVenta(Venta venta);
	Venta buscarVenta(Integer id);
	void actualizarVenta(Venta venta);
	void borrarVenta(Integer id);
	
	List<Venta> buscarVentaPorFecha(LocalDateTime fecha);
	
}
