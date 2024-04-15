package co.edu.unicauca.asstproject.project_asst.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @AllArgsConstructor 
@Table(name = "Preguntas")
public class Pregunta {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpregunta;
    @Column(length = 30)
    private String enunciado; 

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objPregunta")
    private List<Respuesta> respuestas;

    @ManyToOne
    @JoinColumn(name="idtipopregunta",nullable = false)
    private TipoPregunta objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idCuestionario",nullable = false)
    private Cuestionario objCuestionario;

    //TODO
    public Pregunta(){
        this.respuestas = new ArrayList<Respuesta>();
    }

}
