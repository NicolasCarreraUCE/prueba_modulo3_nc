package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.modelo.Producto;
import ec.edu.uce.modelo.Venta;

@Service
public class GestorSupermercadoServiImpl implements IGestorSupermercadoServi {
	
	private static final Logger LOG = Logger.getLogger(GestorSupermercadoServiImpl.class);
	
	@Autowired
	private IProductoServi productoServi;
	
	@Autowired
	private IVentaServi ventaServi;
	
	@Autowired
	private IDetalleVentaServi detalleVentaServi;
	
	@Override
	@Transactional
	public void ingresarProductos(Producto producto, Integer stock) {
		// TODO Auto-generated method stub
		Producto insertar = this.productoServi.buscarProductoPorNombre(producto.getNombre());
		if (insertar == null) {
			producto.setStock(stock);
			this.productoServi.insertarProducto(producto);
		} else {
			insertar.setStock(insertar.getStock() + stock);
			this.productoServi.actualizarProducto(producto);
		}
	}

	@Override
	@Transactional
	public void realizarVenta(String codigoDeBarras, Integer cantidad, String cedulaCliente, String numeroDeVenta) {
		// TODO Auto-generated method stub
		try {
			Producto venta = this.productoServi.buscarProductoPorCodigoDeBarra(codigoDeBarras);
			if (venta == null || venta.getStock() == 0) {
				throw new RuntimeException("El stock es insuficiente o el producto no existe");
			} else {
				Venta vn = new Venta();
				vn.setNumero(numeroDeVenta);
				vn.setFecha(LocalDateTime.now());
				vn.setCedulaCliente(cedulaCliente);
				vn.setTotalVenta(venta.getPrecio().multiply(new BigDecimal((cantidad <= venta.getStock()) ? cantidad : venta.getStock())));
				
				DetalleVenta dv = new DetalleVenta();
				dv.setCantidad(cantidad);
				dv.setPrecioUnitario(venta.getPrecio());
				dv.setSubtotal(vn.getTotalVenta());
				dv.setVenta(vn);
				dv.setProducto(venta);
				
				vn.getDetalleVentas().add(dv);
				this.ventaServi.insertarVenta(vn);
		
				this.detalleVentaServi.insertarDetalleVenta(dv);;
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("No se pudo realisar la venta");
		}
		
	}

	@Override
	public void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad) {
		// TODO Auto-generated method stub
		List<Venta> listaVentas = this.ventaServi.buscarVentaPorFecha(fechaVenta);
		listaVentas.stream().forEach(v -> {
			LOG.info(v.getDetalleVentas());
		});
	} 

}
