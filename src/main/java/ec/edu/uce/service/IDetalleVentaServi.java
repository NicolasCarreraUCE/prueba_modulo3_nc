package ec.edu.uce.service;

import ec.edu.uce.modelo.DetalleVenta;

public interface IDetalleVentaServi {
	void insertarDetalleVenta(DetalleVenta detalleVenta);
	DetalleVenta buscarDetalleVenta(Integer id);
	void actualizarDetalleVenta(DetalleVenta detalleVenta);
	void borrarDetalleVenta(Integer id);
}
