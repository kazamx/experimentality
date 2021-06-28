package experimentality.pruebatecnica.test;

import junit.framework.TestCase;
import experimentality.pruebatecnica.services.*;

import org.junit.jupiter.api.Test;

import experimentality.pruebatecnica.models.*;

public class TestProductos extends TestCase{
	ProductoModel productoModel;
	ProductoService productoService;
	byte[] bytes = "e04fd0".getBytes();
	
	public void iniciarVariables() {
		productoModel = objetoProductoModel();
		productoService = new ProductoService();
	}
	
	public ProductoModel objetoProductoModel() {
		long x = 15, precio = 200;
		productoModel.setId(x);
		productoModel.setNombre("Nombre test");
		productoModel.setDescripcion("Descripcion test");
		productoModel.setPrecio(precio);
		productoModel.setDescuento_porc(30);
		productoModel.setPais("Venezuela");
		productoModel.setBuscados(false);
		productoModel.setImagen_frontal(null);
		productoModel.setImagen_trasera(null);
		return productoModel;
	}

	@Test
	public void testGuardarProducto() {
		this.iniciarVariables();
		assertEquals(productoModel,this.productoService.guardarProducto(productoModel));
	}
	
	@Test
	public void testEscalarImagen() {
		this.iniciarVariables();
		assertEquals(1,this.productoService.escalarImagen(this.bytes,1));
	}

	
}
