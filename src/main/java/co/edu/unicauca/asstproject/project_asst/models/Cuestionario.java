package co.edu.unicauca.asstproject.project_asst.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "Cuestionarios") 
public class Cuestionario {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcuestionario;
    @Column(nullable = false, length = 30)
    private String titulo;
    @Column(nullable = false, length = 30)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "objCuestionario")
    private List<Pregunta> preguntas;


    public Cuestionario(){
        this.idcuestionario = 0;
        this.titulo = "Sin titulo";
        this.descripcion = "Sin descripcion";
        this.preguntas = new ArrayList<Pregunta>();
    }
    public Cuestionario(Integer idCuestionario, String titulo, String descripcion) {
        this.idcuestionario = idCuestionario;
        this.titulo = titulo;
        this.descripcion=descripcion;

    }
    
}
