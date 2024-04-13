package co.edu.unicauca.asstproject.project_asst.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
}
