package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

/**
 * Servlet implementation class ProductoRegistrarServlet
 */
@WebServlet("/ProductoRegistrarServlet")
public class ProductoRegistrarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ProductoListarServlet.class);

	private CategoriaService categoriaService;
	private ProductoService productoService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoRegistrarServlet() {
		this.productoService = new ProductoService();
		this.categoriaService = new CategoriaService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("Get ProductoRegistrarServlet");
	
		List<Categoria> categorias;
		try {
			categorias = categoriaService.listar();
		
			request.setAttribute("categorias", categorias);
						
		} catch (Exception e) {

			e.printStackTrace();
		} 
		
	
		request.getRequestDispatcher("/WEB-INF/jsp/producto/registrar.jsp").
				forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
	
	}

}
