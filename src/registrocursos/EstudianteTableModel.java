package registrocursos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class EstudianteTableModel extends AbstractTableModel {
    
    private List<Estudiante> datos = new ArrayList<>();
    private EstudianteSQL est;
    private CursoSQL cur;
    
    public EstudianteTableModel(EstudianteSQL est, CursoSQL cur) {
        this.est = est;
        this.cur = cur;
    }

    public void updateModel() {
        datos = est.obtenerTodos();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Matricula";
            case 1: return "Nombre";
            case 2: return "Carrera";
            case 3: return "Semestre";
            case 4: return "Curso";
            default: return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList<Curso> listCursos = cur.getAll();
        Estudiante est = datos.get(rowIndex);
        
        String curso = "";
        for(Curso c: listCursos) {
            if(c.getId() == est.getCurso())
                curso = c.getNombre();
        }
        
        switch(columnIndex) {
            case 0: return est.getId();
            case 1: return est.getNombre();
            case 2: return est.getCarrera();
            case 3: return est.getSemestre();
            case 4: return curso;
            default: return null;
        }
    }

    public Object getValue(int rowIndex) {
        Estudiante est = datos.get(rowIndex);
        return est;
    }
}