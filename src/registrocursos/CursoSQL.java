package registrocursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoSQL {
    private Connection conn;
    
    final String GETALL = "SELECT id_curso, nombre_curso FROM cursos";
    
    public CursoSQL(Connection conn) {
        this.conn = conn;
    }
    
    public ArrayList getAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Curso> listCursos = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GETALL);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id_curso");
                String nombre = rs.getString("nombre_curso");
                
                Curso curso = new Curso(id, nombre);
                
                listCursos.add(curso);
            }
        } catch(SQLException ex) {
        } finally {
            if(rs != null) {
                try{
                    rs.close();
                } catch(SQLException ex) {
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                } catch(SQLException ex) {
                }
            }
        }
        return listCursos;
    }
}