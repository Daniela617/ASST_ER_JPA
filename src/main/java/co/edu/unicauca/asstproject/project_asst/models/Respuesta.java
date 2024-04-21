package co.edu.unicauca.asstproject.project_asst.models;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Respuesta")
public class Respuesta {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrespuesta;

    @Column(length = 30)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente objDocente;

    @OneToOne
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta objPregunta;

}
