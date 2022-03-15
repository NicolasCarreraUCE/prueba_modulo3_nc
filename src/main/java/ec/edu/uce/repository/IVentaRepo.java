package ec.edu.uce.repository;

import ec.edu.uce.modelo.Venta;

public interface IVentaRepo {
	void insertarVenta(Venta venta);
	Venta buscarVenta(Integer id);
	void actualizarVenta(Venta venta);
	void borrarVenta(Integer id);
}
