package co.edu.unicauca.asstproject.project_asst.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Personas")
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;

    @Column(length = 30)
    private String tipoidentificacion;

    @Column(length = 30)
    private String numeroidentificacion;

    @Column(length = 30)
    private String nombres;

    @Column(length = 30)
    private String apellidos;
    public Persona(){
        this.idpersona = 0;
        this.nombres = "Sin nombre";
        this.apellidos = "Sin apellido";
        this.tipoidentificacion = "Sin identificacion";
        this.tipoidentificacion = "Sin tipo";
    }
    public Persona(String tipoidentificacion, String numeroidentificacion, String nombres, String apellidos){
        this.tipoidentificacion = tipoidentificacion;
        this.numeroidentificacion = numeroidentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
