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
@Table(name = "Departamentos")
public class Departamento {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDepartamento;
    private String nombreDep;
    private String descripcion;
}
