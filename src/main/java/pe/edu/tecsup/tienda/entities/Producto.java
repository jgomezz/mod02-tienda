package pe.edu.tecsup.tienda.entities;

public class Producto {

	private Integer id;
	private Integer categorias_id;
	private Categoria categoria;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	private String imagen_nombre;
	private String imagen_tipo;
	private Long imagen_tamanio;
	private Integer estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategorias_id() {
		return categorias_id;
	}
	public void setCategorias_id(Integer categorias_id) {
		this.categorias_id = categorias_id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImagen_nombre() {
		return imagen_nombre;
	}
	public void setImagen_nombre(String imagen_nombre) {
		this.imagen_nombre = imagen_nombre;
	}
	public String getImagen_tipo() {
		return imagen_tipo;
	}
	public void setImagen_tipo(String imagen_tipo) {
		this.imagen_tipo = imagen_tipo;
	}
	public Long getImagen_tamanio() {
		return imagen_tamanio;
	}
	public void setImagen_tamanio(Long imagen_tamanio) {
		this.imagen_tamanio = imagen_tamanio;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", categorias_id=" + categorias_id + ", categoria=" + categoria + ", nombre="
				+ nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock
				+ ", imagen_nombre=" + imagen_nombre + ", imagen_tipo=" + imagen_tipo + ", imagen_tamanio="
				+ imagen_tamanio + ", estado=" + estado + "]";
	}
	
	
	
}
