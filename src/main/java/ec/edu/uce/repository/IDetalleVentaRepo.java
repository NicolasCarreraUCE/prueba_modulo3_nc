package ec.edu.uce.repository;

import ec.edu.uce.modelo.DetalleVenta;

public interface IDetalleVentaRepo {
	void insertarDetalleVenta(DetalleVenta detalleVenta);
	DetalleVenta buscarDetalleVenta(Integer id);
	void actualizarDetalleVenta(DetalleVenta detalleVenta);
	void borrarDetalleVenta(Integer id);
}
