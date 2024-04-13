package co.edu.unicauca.asstproject.project_asst.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Telefono")
public class Telefono {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtelefono;

    private String tipotelefono;

    private String numero;

    @OneToOne(cascade = {CascadeType.PERSIST })
	@JoinColumn(name = "idDocente",referencedColumnName = "id")
    private Docente objDocente;



    public Docente getObjDocente()
    {
        return objDocente;
    }
    public void setObjDocente(Docente objDocente){
        this.objDocente=objDocente;
    }
}
