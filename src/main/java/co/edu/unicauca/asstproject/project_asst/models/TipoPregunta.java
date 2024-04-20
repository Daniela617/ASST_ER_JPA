package co.edu.unicauca.asstproject.project_asst.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//TODO EXTENDS?
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToOne
    @JoinColumn(name="idPregunta")
    private Pregunta objPregunta;

   

    
}
