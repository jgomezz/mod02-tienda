package pe.edu.tecsup.tienda.services;

import java.util.List;
import org.apache.log4j.Logger;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.repositories.ProductoRepository;

public class ProductoService {

	private static final Logger log 
		= Logger.getLogger(ProductoService.class);
	
	private ProductoRepository productoRepository;
	
	public ProductoService() {
	
		this.productoRepository = new ProductoRepository();
	
	}
	
	public List<Producto> listar() throws Exception {
	
		log.info("call listar()");
		
		return productoRepository.listar();
	
	}
	
}
