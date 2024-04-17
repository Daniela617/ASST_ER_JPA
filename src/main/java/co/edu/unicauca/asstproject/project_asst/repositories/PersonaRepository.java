package co.edu.unicauca.asstproject.project_asst.repositories;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asstproject.project_asst.models.Persona;


public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    
}
