package clase11.clase_11;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import clase11.clase_11.DTOs.PersonaDTO;
import clase11.clase_11.Models.Persona;

@SpringBootTest
class Clase11ApplicationTests {

	@Test
	void testMapper() {
		ModelMapper mapper = new ModelMapper();

		Persona persona = new Persona();
		persona.setId(1L);
		persona.setNombre("Leonel");
		persona.setApellido("Grigoriadis");
		persona.setDocumento("44781251");
		persona.setEdad(16L);
		persona.setPeso(65.5);
		
		PersonaDTO personaDTO = mapper.map(persona, PersonaDTO.class);
		
		System.out.println("\nid: "+personaDTO.getId()+
						   ",\nnombre: "+personaDTO.getNombre()+
						   ",\napellido: "+personaDTO.getApellido()+
						   ",\ndocumento: "+personaDTO.getDocumento());
	}

}