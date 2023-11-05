package pe.edu.tecsup.tienda.services;

import java.util.List;
import org.apache.log4j.Logger;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;

public class CategoriaService {

	private static final Logger log 
		= Logger.getLogger(CategoriaService.class);
	
	private CategoriaRepository categoriaRepository;

	public CategoriaService() {
		this.categoriaRepository = new CategoriaRepository();
	}

	public List<Categoria> listar() throws Exception {
		log.info("call listar()");
		return categoriaRepository.listar();
	}

}
