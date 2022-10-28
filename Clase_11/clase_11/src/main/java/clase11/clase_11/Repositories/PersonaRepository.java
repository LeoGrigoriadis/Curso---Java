package clase11.clase_11.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import clase11.clase_11.Models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    Persona findByNombre(String nombre);
    Persona findByApellido(String apellido);
    Persona getByEdad(Long edad);
    Persona getByDocumento(String documento);
    Persona readByPeso(Double peso);
}
