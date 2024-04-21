package co.edu.unicauca.asstproject.project_asst.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
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
    
    
    @OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "objDocente")
    private Telefono objTelefono;

    @OneToMany( mappedBy = "objDocente")
    private List<Respuesta> respuestas;

    //TODO QUESTION EAGER-    
    //CARGA SE PRODUCE EN EL ACTO

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "DepartamentosDocentes",
                joinColumns = @JoinColumn(name = "idp"),
                inverseJoinColumns = @JoinColumn(name = "idDep"))
    private List<Departamento> departamentos;

    public Docente(){
        this.respuestas = new ArrayList<Respuesta>();
        this.departamentos = new ArrayList<Departamento>();
    }

    public Docente (String tipoidentificacion, String numeroidentificacion, 
        String nombres, String apellidos,String correo, String vinculacion ){
        super(tipoidentificacion, numeroidentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;

    }
}
