package co.edu.unicauca.asstproject.project_asst.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Departamentos")
public class Departamento {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddepartamento;

    @Column(length = 30)
    private String nombredep;

    @Column(length = 30)
    private String descripcion;
    public Departamento(){
        this.iddepartamento = 0;
        this.nombredep = "Sin nombre";
        this.descripcion = "Sin descripcion";
    }

}
