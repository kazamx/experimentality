package experimentality.pruebatecnica.models;

import java.awt.Image;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	private Long precio;
	private Integer descuento_porc;
	private String pais;
	private Boolean buscados;
	private String imagen_frontal;
	private String imagen_trasera;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public Integer getDescuento_porc() {
		return descuento_porc;
	}
	public void setDescuento_porc(Integer descuento_porc) {
		this.descuento_porc = descuento_porc;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Boolean getBuscados() {
		return buscados;
	}
	public void setBuscados(Boolean buscados) {
		this.buscados = buscados;
	}
	public String getImagen_frontal() {
		return imagen_frontal;
	}
	public void setImagen_frontal(String imagen_frontal) {
		this.imagen_frontal = imagen_frontal;
	}
	public String getImagen_trasera() {
		return imagen_trasera;
	}
	public void setImagen_trasera(String imagen_trasera) {
		this.imagen_trasera = imagen_trasera;
	}
	@Override
	public String toString() {
		return "ProductoModel [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", descuento_porc=" + descuento_porc + ", pais=" + pais + ", buscados=" + buscados
				+ ", imagen_frontal=" + imagen_frontal + ", imagen_trasera=" + imagen_trasera + "]";
	}
	
	
	
}
