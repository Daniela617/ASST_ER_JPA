package co.edu.unicauca.asstproject.project_asst.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Cuestionarios")
public class Cuestionario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuestionario;
    @Column(nullable = false, length = 30)
    private String titulo;
    @Column(nullable = false, length = 30)
    private String descripcion;
}
