package co.edu.unicauca.asstproject.project_asst.models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;
//TODO
@Entity
@PrimaryKeyJoinColumn(name = "IdCuestionario")
@Getter @Setter 
public class Cuestionario extends Pregunta {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuestionario;
    @Column(nullable = false, length = 30)
    private String titulo;
    @Column(nullable = false, length = 30)
    private String descripcion;

    public Cuestionario(Integer idpregunta,String titulo, String descripcion, Integer idCuestionario) {
        super(idpregunta);
        this.titulo = titulo;
        this.descripcion=descripcion;

    }
    
}
