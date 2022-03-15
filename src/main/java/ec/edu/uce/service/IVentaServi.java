package ec.edu.uce.service;

import ec.edu.uce.modelo.Venta;

public interface IVentaServi {
	void insertarVenta(Venta venta);
	Venta buscarVenta(Integer id);
	void actualizarVenta(Venta venta);
	void borrarVenta(Integer id);
}
