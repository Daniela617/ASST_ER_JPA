package co.edu.unicauca.asstproject.project_asst.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pregunta {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpregunta;
    @Column(length = 30)
    private String enunciado; 

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objPregunta")
    private List<Respuesta> respuestas;

    public Pregunta(){
        this.respuestas = new ArrayList<Respuesta>();
    }

}
