package ec.edu.uce.service;

import java.time.LocalDateTime;

import ec.edu.uce.modelo.Producto;

public interface IGestorSupermercadoServi {
	void ingresarProductos(Producto producto, Integer stock);
	void realizarVenta(String codigoDeBarras, Integer cantidad, String cedulaCliente, String numeroDeVenta);
	void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad);
}
