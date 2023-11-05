package pe.edu.tecsup.tienda.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.util.ConexionBD;

public class CategoriaRepository {

	// Uso del log4j
	private static final Logger log 
		= Logger.getLogger(CategoriaRepository.class);

	public List<Categoria> listar() throws Exception {
		
		log.info("call listar()");
		
		Connection con = ConexionBD.obtenerConexion();
		
		String query = "SELECT * FROM categorias ORDER BY orden";
		
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		
		List<Categoria> lista = new ArrayList<Categoria>();
		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt("id"));
			categoria.setNombre(rs.getString("nombre"));
			categoria.setOrden(rs.getInt("orden"));
			lista.add(categoria);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		log.info("lista: " + lista);
		
		return lista;
	}

}
