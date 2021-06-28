package experimentality.pruebatecnica.services;
import experimentality.pruebatecnica.repositories.ProductoRepository;
import experimentality.pruebatecnica.models.ProductoModel;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	ProductoModel productoModel = new ProductoModel();
	
	public ArrayList<ProductoModel> obtenerProductos(){
		return (ArrayList<ProductoModel>)productoRepository.findAll();
	}
	
	public ProductoModel guardarProducto(ProductoModel producto) {
		return this.productoRepository.save(producto);
	}
	
	public ArrayList<ProductoModel> obtenerBuscados(){
		return productoRepository.obtenerBuscados();
	}
	
	public int escalarImagen(byte[] bytes, int selector) {
		// Convertir arreglo de bytes a imagen
		try {
		
		if(this.urlImagenes(selector).equals("2")) {
			return 2;
		}
		
		Path target = Paths.get(this.urlImagenes(selector)); // Le paso la url de la imagen ya sea frontal o trasera
		InputStream is = new ByteArrayInputStream(bytes);
		BufferedImage bi = ImageIO.read(is);
		double escala = 1.0;
		double w = bi.getWidth();
		double h = bi.getHeight();
		
		if(w*h > 1000000) {
			escala = 1000000/(w*h);
		}
		
		BufferedImage newBi = new BufferedImage((int)(escala*w),(int)(escala*h),BufferedImage.TYPE_INT_ARGB);
		AffineTransform scaleInstance = AffineTransform.getScaleInstance(escala, escala);
		AffineTransformOp scaleOp = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);
		scaleOp.filter(bi, newBi);
		
		ImageIO.write(newBi, "png", target.toFile());
		// Fin de convertir arreglo de bytes a imagenes
		return 0;
		}catch(IOException e) {
			return 1;
		}
	}
	
	public String urlImagenes(int selector){
		
		long idProducto = productoRepository.obtieneUltimoId();
		
		Optional<ProductoModel> producto = productoRepository.findById(idProducto);
		productoModel = producto.get();
		String url = "";
		
		productoModel.setId(idProducto);
		if(selector == 1) {
			url = "C:\\Users\\Analista\\Desktop\\imagenes\\imagen"+ idProducto + "_frontal.png";
			productoModel.setImagen_frontal(url);
		}else if(selector == 2) {
			url = "C:\\Users\\Analista\\Desktop\\imagenes\\imagen"+ idProducto + "_trasera.png";
			productoModel.setImagen_trasera(url);
		}else {
			return "2";
		}
		
		productoRepository.save(productoModel);
		return url;
		
	}
	
}
