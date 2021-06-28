package experimentality.pruebatecnica;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import experimentality.pruebatecnica.models.ProductoModel;
import experimentality.pruebatecnica.services.ProductoService;

@SpringBootTest
class PruebatecnicaApplicationTests {

	ProductoService productoService = new ProductoService();
	byte[] bytes = "e04fd0".getBytes();

	public void iniciarVariables() {
		productoService = new ProductoService();
	}
	
	public ProductoModel objetoProductoModel() {
		long x = 15, precio = 200;
		ProductoModel productoModel = new ProductoModel();
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
		ProductoModel productoModel =  this.objetoProductoModel();
		assertEquals(productoModel,this.productoService.guardarProducto(productoModel));
	}
	
	@Test
	public void testEscalarImagen() {
		this.iniciarVariables();
		assertEquals(1,this.productoService.escalarImagen(this.bytes,0));
	}
	
	@Test
	public void testUrlImagenes(){
		assertEquals(0,this.productoService.urlImagenes(1));
	}

}
