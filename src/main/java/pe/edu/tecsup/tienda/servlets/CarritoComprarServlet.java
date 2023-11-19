package pe.edu.tecsup.tienda.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.ProductoService;

/**
 * Servlet implementation class CarritoComprarServlet
 */
@WebServlet("/CarritoComprarServlet")
public class CarritoComprarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(CarritoComprarServlet.class);

	private ProductoService productoService;

	public CarritoComprarServlet() {
		this.productoService = new ProductoService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("Post CarritoComprarServlet");

		try {

			// Guardar el producto en la sesion 
			
			String id = request.getParameter("id"); 
			log.info("ID del prod. seleccionado : " + id);
			
			
			Producto producto 
				= productoService.obtener(Integer.parseInt(id)); 
			
			log.info(producto);
			
			// Trabajo con la session
			HttpSession session = request.getSession();
			
			List<Producto> productosCarrito 
				= (List<Producto>) session.getAttribute("productosCarrito");
			
			if(productosCarrito == null) {
				// Si es el primer producto a agregar al carrito de comprar
				// debe crearse el objeto que almacena los productos del carrito.
				productosCarrito = new ArrayList<Producto>();
			}
			
			// Agrego el producto seleccionado al carrito de compras.
			productosCarrito.add(producto);
			
			// Guardar en la sesion los productos del carrito actualizado
			session.setAttribute("productosCarrito", productosCarrito); 
			
			request.getSession().setAttribute("success", "Producto añadido al carrito");
			
			response.sendRedirect(request.getContextPath() + "/CarritoListarServlet");
			
		} catch (Exception e) {
			log.error(e, e);
			throw new ServletException(e.getMessage(), e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
