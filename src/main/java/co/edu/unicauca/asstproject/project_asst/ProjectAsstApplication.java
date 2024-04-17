package co.edu.unicauca.asstproject.project_asst;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asstproject.project_asst.repositories.CuestionarioRepository;
import co.edu.unicauca.asstproject.project_asst.repositories.DepartamentoRepository;
import co.edu.unicauca.asstproject.project_asst.repositories.DocenteRepository;
import co.edu.unicauca.asstproject.project_asst.repositories.PersonaRepository;
import co.edu.unicauca.asstproject.project_asst.repositories.PreguntaRepository;
import co.edu.unicauca.asstproject.project_asst.repositories.RespuestaRepository;
import co.edu.unicauca.asstproject.project_asst.repositories.TelefonoRepository;
import co.edu.unicauca.asstproject.project_asst.repositories.TipoPreguntaRepository;

@SpringBootApplication
@Transactional
public class ProjectAsstApplication implements CommandLineRunner{

	@Autowired
	private CuestionarioRepository srvCuestionariosBD;

	@Autowired
	private DepartamentoRepository srvDepartamentosBD;

	@Autowired
	private DocenteRepository srvDocentesBD;

	@Autowired
	private PersonaRepository srvPersonasBD;

	@Autowired
	private PreguntaRepository srvPreguntasBD;

	@Autowired
	private RespuestaRepository srvRespuestasBD;

	@Autowired
	private TelefonoRepository srvTelefonosBD;

	@Autowired
	private TipoPreguntaRepository srvTipoPreguntasBD;
	public static void main(String[] args) {
		SpringApplication.run(ProjectAsstApplication.class, args);
	}
	/*
	 * 1. Crear cuestionario (cascada persist)
	 * 2. Registrar docente (cascada persist)
	 * 3. Registrar Respuestas de un cuestionario
	 * 4. Listar respuestas de un cuestionario (EAGER-TIPOSDEPREGUNTAS-CUESTIONARIOS LAZY-PREGUNTAS)
	 */
	@Override 
	public void run(String... args) throws Exception {
		crearCuestionario();
		registrarDocente();
		registrarRespuestasCuestionario();
		listarCuestionarios();
		listarCuestionarios();
	}
	private void listarCuestionarios() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listarCuestionarios'");
	}
	private void registrarRespuestasCuestionario() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'registrarRespuestasCuestionario'");
	}
	private void registrarDocente() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'registrarDocente'");
	}
	private void crearCuestionario() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearCuestionario'");
	}

}
