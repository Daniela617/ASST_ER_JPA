package co.edu.unicauca.asstproject.project_asst.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Docentes")
public class Docente extends Persona{

    @Column(length = 30)
    private String correo; 
    @Column(length = 30)
    private String vinculacion; 
    
    
    @OneToOne(cascade = {  CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "objDocente")
    private Telefono objTelefono;

    @OneToMany( mappedBy = "objDocente")
    private List<Respuesta> respuestas;

    //TODO QUESTION EAGER-    
    //CARGA SE PRODUCE EN EL ACTO

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "DepartamentosDocentes",
                joinColumns = @JoinColumn(name = "iddocente"),
                inverseJoinColumns = @JoinColumn(name = "iddepartamento"))
    private List<Departamento> departamentos;

    public Docente(){
        this.respuestas = new ArrayList<Respuesta>();
        this.departamentos = new ArrayList<Departamento>();
    }

}
