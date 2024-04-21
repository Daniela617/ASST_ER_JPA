package co.edu.unicauca.asstproject.project_asst.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Telefono")
public class Telefono {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtelefono;

    @Column(length = 30)
    private String tipotelefono;

    @Column(length = 30)
    private String numero;

    @OneToOne
    @JoinColumn(name = "idpersona")
    private Docente objDocente;

   
}
