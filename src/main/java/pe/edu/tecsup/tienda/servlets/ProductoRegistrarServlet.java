package pe.edu.tecsup.tienda.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

/**
 * Servlet implementation class ProductoRegistrarServlet
 */
@WebServlet("/ProductoRegistrarServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProductoRegistrarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ProductoRegistrarServlet.class);

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

		request.getRequestDispatcher("/WEB-INF/jsp/producto/registrar.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("Post ProductoRegistrarServlet");

		try {
			String categorias_id = request.getParameter("categorias_id");
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			String stock = request.getParameter("stock");
			String descripcion = request.getParameter("descripcion");

			Producto producto = new Producto();
			producto.setCategorias_id(Integer.parseInt(categorias_id));
			producto.setNombre(nombre);
			producto.setPrecio(Double.parseDouble(precio));
			producto.setStock(Integer.parseInt(stock));
			producto.setDescripcion(descripcion);

			// Procesamiento de archivo adjunto
			Part part = request.getPart("imagen");
			if (part.getSubmittedFileName() != null) {
				
				File filepath = new File(getServletContext().getRealPath("") + File.separator + "files");
				
				if (!filepath.exists())
					filepath.mkdir();
				
				String filename = System.currentTimeMillis() + "-" + part.getSubmittedFileName();
				
				part.write(filepath + File.separator + filename);
				
				log.info("Imagen cargada en: " + filepath + File.separator + filename);
				
				producto.setImagen_nombre(filename);
				producto.setImagen_tipo(part.getContentType());
				producto.setImagen_tamanio(part.getSize());
			}

			log.info(producto);

			productoService.registrar(producto);
			
			// mensaje a mostrar en la vista
			request.getSession().setAttribute("success", 
					"Registro guardado satisfactoriamente");
					

			response.sendRedirect(request.getContextPath() + "/ProductoListarServlet");

		} catch (Exception e) {
			log.error(e, e);
			throw new ServletException(e.getMessage(), e);
		}
	}

}
