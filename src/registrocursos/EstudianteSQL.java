package registrocursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudianteSQL {
    private Connection conn;
    
    final String INSERT = "INSERT INTO estudiantes(id_estudiante, nombre, carrera, semestre, curso) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE estudiantes SET nombre=?, carrera=?, semestre=?, curso=? WHERE id_estudiante=?";
    final String DELETE = "DELETE FROM estudiantes WHERE id_estudiante=?";
    final String GETALL = "SELECT * FROM estudiantes";
    
    public EstudianteSQL(Connection conn) {
        this.conn = conn;
    }
    
    public void insertar(Estudiante e)  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getCarrera());
            ps.setInt(4, e.getSemestre());
            ps.setInt(5, e.getCurso());
            if(ps.executeUpdate() == 0) {
                throw new SQLException("Error SQL");
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            if(ps != null) {
                try{
                    ps.close();
                } catch(SQLException ex) {
                }
            }
            if(rs != null) {
                try{
                    rs.close();
                } catch(SQLException ex) {
                }
            }
        }
    }
    
    public void modificar(Estudiante e) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCarrera());
            ps.setInt(3, e.getSemestre());
            ps.setInt(4, e.getCurso());
            ps.setInt(5, e.getId());
            if(ps.executeUpdate() == 0) {
                throw new SQLException("Error SQL");
            }
        } catch(SQLException ex) {
        } finally {
            if(ps != null) {
                try{
                    ps.close();
                } catch(SQLException ex) {
                }
            }
        }
    }
    
    public void borrar(Estudiante e) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, e.getId());
            if(ps.executeUpdate() == 0) {
                throw new SQLException("Error SQL");
            }
        } catch(SQLException ex) {
        } finally {
            if(ps != null) {
                try{
                    ps.close();
                } catch(SQLException ex) {
                }
            }
        }
    }
    
    public ArrayList obtenerTodos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Estudiante> listEst = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GETALL);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id_estudiante");
                String nombre = rs.getString("nombre");
                String carrera = rs.getString("carrera");
                int semestre = rs.getInt("semestre");
                int curso = rs.getInt("curso");
                
                Estudiante est = new Estudiante(id, nombre, carrera, semestre, curso);
                
                listEst.add(est);
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
        return listEst;
    }

}