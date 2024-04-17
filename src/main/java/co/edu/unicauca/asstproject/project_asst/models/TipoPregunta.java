package co.edu.unicauca.asstproject.project_asst.models;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
//TODO EXTENDS?
@Setter
@Getter
@Entity
@Table(name="TipoPregunta")
public class TipoPregunta {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtippregunta;

    @Column(length = 30)
    private String nombre;

    @Column(length = 30)
    private String descripcion;

    /*
     * Siempre que se consulte un tipo de pregunta se cargan sus preguntas
     * CARGA SE PRODUCE EN EL ACTO
     */
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "objTipoPregunta")
    private List<Pregunta> preguntas;

    public TipoPregunta(){
        this.preguntas = new ArrayList<Pregunta>();
    }

    public void agregarPreguntas(Pregunta objPregunta){
        this.preguntas.add(objPregunta);
    }
    public List<Pregunta> getPreguntas(){
        return this.preguntas;
    }

    
}
