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

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="TipoPregunta")
public class TipoPregunta {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtippregunta;
    private String nombre;
    private String descripcion;

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
