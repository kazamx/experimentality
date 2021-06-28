package experimentality.pruebatecnica.controllers;
import experimentality.pruebatecnica.models.ProductoModel;
import experimentality.pruebatecnica.services.ProductoService;

import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping()
	public ArrayList<ProductoModel> obtenerProductos(){
		return productoService.obtenerProductos();
	}
	
	@PostMapping()
	public int guardarProducto(@RequestBody ProductoModel producto ) {
		if((producto.getPais().equals("Colombia") || producto.getPais().equals("Mexico"))
				&& (producto.getDescuento_porc() > 50)) {
			return 1;
		}
		if((producto.getPais().equals("Chile") || producto.getPais().equals("Peru"))
				&& (producto.getDescuento_porc() > 30)) {
			return 2;
		}
		this.productoService.guardarProducto(producto);
		return 0;
	}
	
	@RequestMapping("/buscados")
	public ArrayList<ProductoModel> obtenerBuscados(){
		return this.productoService.obtenerBuscados();
	}
	
	@PostMapping(path = "/imagen/{selector}")
	public int cargarImagen(@RequestBody byte[] bytes, @PathVariable("selector") int selector) throws IOException{
		
		return productoService.escalarImagen(bytes,selector);
		
	}
}
