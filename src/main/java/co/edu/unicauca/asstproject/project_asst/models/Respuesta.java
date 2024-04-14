package co.edu.unicauca.asstproject.project_asst.models;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Respuesta {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrespuesta;

    @ManyToOne
    @JoinColumn(name = "idpersona", nullable = false)
    private Persona objDocente;

    @ManyToOne
    @JoinColumn(name = "idpregunta", nullable = false)
    private Pregunta objPregunta;

}
