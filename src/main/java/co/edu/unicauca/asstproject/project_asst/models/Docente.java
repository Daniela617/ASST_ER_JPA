package co.edu.unicauca.asstproject.project_asst.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Docentes")
public class Docente extends Persona{

    @Column(length = 30)
    private String correo; 
    @Column(length = 30)
    private String vinculacion; 
    
    @OneToOne
    @JoinColumn(name = "idtelefono")
    private Telefono objTelefono;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objDocente")
    private List<Respuesta> respuestas;

    public Docente(){
        this.respuestas = new ArrayList<Respuesta>();
    }

    public Docente (String tipoidentificacion, String numeroidentificacion, 
        String nombres, String apellidos,String correo, String vinculacion ){

        super(tipoidentificacion, numeroidentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;

    }
}
