package co.edu.unicauca.asstproject.project_asst;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asstproject.project_asst.models.Cuestionario;
import co.edu.unicauca.asstproject.project_asst.models.Departamento;
import co.edu.unicauca.asstproject.project_asst.models.Docente;
import co.edu.unicauca.asstproject.project_asst.models.Pregunta;
import co.edu.unicauca.asstproject.project_asst.models.Telefono;
import co.edu.unicauca.asstproject.project_asst.models.TipoPregunta;
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
	Scanner sc = new Scanner(System.in);
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
		cargarDatos();
		crearCuestionario();
		registrarDocente();
		registrarRespuestasCuestionario();
		listarCuestionarios();
		listarCuestionariosRespuestas();
	}
	
	private void cargarDatos() {
		TipoPregunta objPrgnta1 = new TipoPregunta(1,"","",null);	
		TipoPregunta objPrgnta2 = new TipoPregunta(2,"","",null);	
		Departamento objDepto1 = new Departamento(1,"","");
		Departamento objDepto2 = new Departamento(1,"","");

		this.srvTipoPreguntasBD.save(objPrgnta1);
		this.srvTipoPreguntasBD.save(objPrgnta2);
		this.srvDepartamentosBD.save(objDepto1);
		this.srvDepartamentosBD.save(objDepto2);


	}
	private void listarCuestionariosRespuestas() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listarCuestionariosRespuestas'");
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
		System.out.println("Crear Docente");
		Docente objDocente = new Docente();
		System.out.printf("Ingrese el nombre del docente: ");
		String nombre = sc.nextLine();
		objDocente.setNombres(nombre);
		System.out.printf("Ingrese el apellido del docente:");
		String apellido = sc.nextLine();
		objDocente.setApellidos(apellido);
		System.out.printf("Ingrese el tipo de identificacion: ");
		String tipoIdentificacion = sc.nextLine();
		objDocente.setTipoidentificacion(tipoIdentificacion);
		System.out.printf("Ingrese el numero de identificacion del docente: ");
		String numeroIdentificacion = sc.nextLine();
		objDocente.setNumeroidentificacion(numeroIdentificacion);
		System.out.printf("Ingrese el correo del docente: ");
		String correo = sc.nextLine();
		objDocente.setCorreo(correo);
		System.out.printf("Ingrese la vinculacion: ");
		String vinculacion = sc.nextLine();
		objDocente.setVinculacion(vinculacion);

		Telefono objTelefono = new Telefono();
		System.out.printf("Ingrese el numero de telefono perteneciente al docente: ");
		String numeroTelefono = sc.nextLine();
		objTelefono.setNumero(numeroTelefono);
		System.out.printf("Ingrese el tipo de telefono: ");
		String tipoTelefono = sc.nextLine();
		objTelefono.setTipotelefono(tipoTelefono);
		objDocente.setObjTelefono(objTelefono);

		System.out.printf("Ingrese el numero de departamentos: ");
		int cantDepartamentos = sc.nextInt();
        sc.nextLine();
		//TODO CREAR OTRA FN 
		for (int i = 0; i < cantDepartamentos; i++) {
			Departamento objDepto = new Departamento();

			System.out.printf("Ingrese el nombre del departamento: ");
			String nombreDepartamento = sc.nextLine();
			objDepto.setNombreDep(nombreDepartamento);
			System.out.printf("Ingrese la descripcion del departamento: ");
			String descripcionDepartamento = sc.nextLine();
			objDepto.setDescripcion(descripcionDepartamento);
			objDocente.getDepartamentos().add(objDepto);
		}

		srvDocentesBD.save(objDocente);
	}
	private void crearCuestionario() {
		System.out.println("_Crear cuestionario_");
		Cuestionario objCuestionario = new Cuestionario();
		System.out.println("Ingrese el titulo:");
		String titulo = sc.nextLine();
		objCuestionario.setTitulo(titulo);
		System.out.println("Ingrese la descripcion:");
		String desc = sc.nextLine();
		objCuestionario.setDescripcion(desc);
		System.out.println("Ingrese la cantidad de preguntas pertenecientes al cuestionario");
		int cantPreguntas = sc.nextInt();
		sc.nextLine();
		if(agregarPreguntasCuestionario(cantPreguntas, objCuestionario) && cantPreguntas>0)
			srvCuestionariosBD.save(objCuestionario);
	}
	private boolean agregarPreguntasCuestionario(int cantPreguntas, Cuestionario objCuestionario) {
		for(int i=0; i<cantPreguntas;i++)
		{
			Pregunta objPrn = new Pregunta();
			System.out.println("Ingrese el enunciado de la pregunta"+ (i+1));
			String enunciado = sc.nextLine();
			objPrn.setEnunciado(enunciado);
			TipoPregunta objTpPregunt = new TipoPregunta();
			System.out.println("Ingrese el nombre del tipo de pregunta: ");
			String nombre = sc.nextLine();
			objTpPregunt.setNombre(nombre);
			System.out.println("Ingrese la descripcion del tipo de pregunta: ");
			String descTpPregunta = sc.nextLine();
			objTpPregunt.setDescripcion(descTpPregunta);
			objPrn.setObjTipoPregunta(objTpPregunt);
            objPrn.setObjCuestionario(objCuestionario);
            // las preguntas las creo con el docente


			if (objCuestionario.getPreguntas() == null) objCuestionario.setPreguntas(new ArrayList<>());
			objCuestionario.getPreguntas().add(objPrn);

			
		}	
		return true;
	}

}
