package ec.edu.uce.service;

import ec.edu.uce.modelo.Producto;

public interface IProductoServi {
	void insertarProducto(Producto producto);
	Producto buscarProducto(Integer id);
	void actualizarProducto(Producto producto);
	void borrarProducto(Integer id);

	Producto buscarProductoPorNombre(String nombre);

	Producto buscarProductoPorCodigoDeBarra(String codigoDeBarra);
}
