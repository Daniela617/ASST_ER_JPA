package co.edu.unicauca.asstproject.project_asst.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Setter
@Getter
@Entity
@Table(name = "Telefono")
public class Telefono {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtelefono;

    @Column(length = 30)
    private String tipotelefono;

    @Column(length = 30)
    private String numero;
    /*TODO */
    @OneToOne(cascade = {CascadeType.PERSIST })
    @JoinColumn(name = "idpersona",referencedColumnName = "idpersona")
    private Persona objDocente;

    public Persona getObjDocente()
    {
        return objDocente;
    }
    public void setObjDocente(Persona objDocente){
        this.objDocente=objDocente;
    }
}
