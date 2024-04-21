package co.edu.unicauca.asstproject.project_asst.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
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

    @Column(length = 30)
    private String nombre;

    @Column(length = 30)
    private String descripcion;

    @OneToOne
    @JoinColumn(name="idPregunta")
    private Pregunta objPregunta;
    
    public TipoPregunta(){
        this.idtippregunta = 0;
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descipcion";
        this.objPregunta = new Pregunta();
    }
    public TipoPregunta(Integer id, String nombre, String descripcion, Pregunta pregunta){
        this.idtippregunta= id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objPregunta = pregunta;

    }

   

    
}
