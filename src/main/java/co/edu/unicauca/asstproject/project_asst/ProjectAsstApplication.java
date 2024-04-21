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
import co.edu.unicauca.asstproject.project_asst.models.Respuesta;
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
		registrarRespuestasCuestionarioDocente();
		listarCuestionarios();
		listarDatosCuestionario();
	}
	
	private void cargarDatos() {
		TipoPregunta objPrgnta1 = new TipoPregunta(1,"Cultura","Pregutas culturales",null);
		TipoPregunta objPrgnta2 = new TipoPregunta(2,"Tecnologia","Pregutas tecnologicas",null);
		TipoPregunta objPrgnta3 = new TipoPregunta(3,"Naturaleza","Pregutas sobre medio ambiente",null);
		Departamento objDepto1 = new Departamento(1,"Cauca","Departamento del Cauca");
		Departamento objDepto2 = new Departamento(2,"Antioquia","Departamento de Antioquia");

		this.srvTipoPreguntasBD.save(objPrgnta1);
		this.srvTipoPreguntasBD.save(objPrgnta2);
		this.srvTipoPreguntasBD.save(objPrgnta3);
		this.srvDepartamentosBD.save(objDepto1);
		this.srvDepartamentosBD.save(objDepto2);


	}
	private void listarPreguntasCuestionario(Cuestionario objCuestionario){
		System.out.printf("Las preguntas del cuestionario: %s\n", objCuestionario.getTitulo());
		objCuestionario.getPreguntas().forEach(pregunta -> {
            System.out.printf("Id: %d\n, Enunciado: %s\n, Nombre tipo de pregunta: %s, Descipcion tipo pregunta: %s", pregunta.getIdpregunta(), pregunta.getEnunciado(),pregunta.getObjTipoPregunta().getNombre(),pregunta.getObjTipoPregunta().getDescripcion());
			listarRespuestasPregunta(pregunta);
        });
	}
	private void listarRespuestasPregunta(Pregunta objPregunta){
		System.out.printf("Respuestas de la pregunta: %s\n", objPregunta.getEnunciado());
		objPregunta.getRespuestas().forEach(respuesta -> {
			System.out.printf("Id: %d\n, Descripcion: %s\n", respuesta.getIdrespuesta(), respuesta.getDescripcion());
			System.out.printf("Docente:");
			System.out.printf("Id: %d\n, Nombres: %s\n, Apellidos: %s\n", respuesta.getObjDocente().getIdpersona(), respuesta.getObjDocente().getNombres(), respuesta.getObjDocente().getApellidos());
			System.out.printf("-------------------------");
		});
	}
	private void listarDocentes(){
		System.out.println("------Listando docentes-------\n");
		srvDocentesBD.findAll().forEach(docente -> {
			System.out.printf("Id: %d\n, Nombres: %s\n, Apellidos: %s\n,-----------------\n", docente.getIdpersona(), docente.getNombres(), docente.getApellidos());
		});
	}
	private void listarCuestionarios(){
		System.out.println("---------Listando cuestionarios con preguntas--------------\n");
		srvCuestionariosBD.findAll().forEach(cuestionario -> {
			System.out.println("----Cuestionario---\n");
			System.out.printf("Id: %d\n, Titulo: %s\n, Descripcion: %s\n", cuestionario.getIdCuestionario(), cuestionario.getTitulo(), cuestionario.getDescripcion());
			System.out.printf("Preguntas: \n");
			cuestionario.getPreguntas().forEach(pregunta -> {
				System.out.printf("Id: %d\n, Enunciado: %s\n", pregunta.getIdpregunta(), pregunta.getEnunciado());
				System.out.printf("Tipo de Pregunta: \n");
				System.out.printf("Id: %d\n, Nombre: %s\n, Descripcion: %s\n", pregunta.getObjTipoPregunta().getIdtippregunta(), pregunta.getObjTipoPregunta().getNombre(), pregunta.getObjTipoPregunta().getDescripcion());
			});
		});
	}
	private void listarTipoPreguntas(){
		System.out.println("---------Listando tipos de preguntas--------------\n");
		srvTipoPreguntasBD.findAll().forEach(TipoPregunta -> {
			System.out.printf("Id: %d\n, Nombre: %s\n, Descripcion: %s\n",TipoPregunta.getIdtippregunta() ,TipoPregunta.getNombre(),TipoPregunta.getDescripcion());
		});
	}
	private void listarDatosCuestionario() {
		System.out.println("---------Listando datos de cuestionario--------------\n");
		System.out.println("Cuestionarios disponibles: \n");
		listarCuestionariosSinPreguntas();
		Cuestionario objCuestionario = new Cuestionario();
		do {
			System.out.printf("Digite el id del cuestionario: \n");
			int idCuestionario = sc.nextInt();
			objCuestionario = srvCuestionariosBD.findById(idCuestionario).get();
			if (objCuestionario.getIdCuestionario()==0) {
				System.out.printf("El cuestionario con este id no existe\n");
			}
		} while (objCuestionario.getIdCuestionario()==0);

		System.out.printf("------Listando cuestionario con id: %d-------\n", objCuestionario.getIdCuestionario());
		System.out.printf("Titulo cuestionario: %s", objCuestionario.getTitulo());
		System.out.printf("Descripcion cuestionario: %s", objCuestionario.getDescripcion());
		listarPreguntasCuestionario(objCuestionario); //se listan las preguntas con las respuestas y el docente

			
	}
	private void listarCuestionariosSinPreguntas() {
		System.out.println("------Listando cuestionarios-------\n");
		srvCuestionariosBD.findAll().forEach(cuestionario -> {
			System.out.printf("Id: %d\n, Titulo: %s\n, Descripcion: %s\n,-----------------\n", cuestionario.getIdCuestionario(), cuestionario.getTitulo(), cuestionario.getDescripcion());
		});
	}
	private void registrarRespuestasCuestionarioDocente() {
		System.out.println("------Registrando respuestas cuestionario-------\n");
		System.out.printf("Docentes disponibles: \n");
		listarDocentes();
		Docente objDocente = new Docente();
		do {
			System.out.printf("Digite el id del docente: \n");
			int idDocente = sc.nextInt();
			objDocente = srvDocentesBD.findById(idDocente).get();
			if (objDocente.getIdpersona()==0) {
				System.out.printf("El docente con este id no existe\n");
			}
		} while (objDocente.getIdpersona()==0);

		System.out.printf("Cuestionarios disponibles: \n");
		listarCuestionariosSinPreguntas();
		//a partir del cuestionario listo las preguntas que tiene y obtengo el id de la pregunta para asignarle respuestas
		Cuestionario objCuestionario = new Cuestionario();
		do {
			System.out.printf("Digite el id del cuestionario: \n");
			int idCuestionario = sc.nextInt();
			objCuestionario = srvCuestionariosBD.findById(idCuestionario).get();
			if (objCuestionario.getIdCuestionario()==0) {
				System.out.printf("El cuestionario con este id no existe\n");
			}
		} while (objCuestionario.getIdCuestionario()==0);
		//listar preguntas del cuestionario hacer procedimiento
		listarPreguntasCuestionario(objCuestionario);
		Pregunta objPregunta = new Pregunta();
		do {
			System.out.printf("Digite el id de la pregunta: \n");
			int idPregunta = sc.nextInt();
			objPregunta = srvPreguntasBD.findById(idPregunta).get();
			if (objPregunta.getIdpregunta()==0) {
				System.out.printf("La pregunta con este id no existe\n");
			}
		} while (objPregunta.getIdpregunta()==0);
		
		int cantRespuestas =0;
		//pregunto por el numero de respuestas a la pregunta
		do {
			System.out.printf("Ingrese el numero de respuestas a registrar: \n");
			cantRespuestas = sc.nextInt();
			sc.nextLine();
			if (cantRespuestas<=0) {
				System.out.printf("La cantidad de respuestas debe ser mayor a cero\n");
			}
		} while (cantRespuestas<=0);

		for (int i = 0; i < cantRespuestas; i++) {
			Respuesta objRespuesta = new Respuesta(); //preguntar por Id
			System.out.printf("\nIngrese la descripcion de la respuesta :"  + (i+1));
			String descripcion = sc.nextLine();
			objRespuesta.setDescripcion(descripcion);
			objRespuesta.setObjDocente(objDocente);
			objRespuesta.setObjPregunta(objPregunta);
			objDocente.getRespuestas().add(objRespuesta);
			objPregunta.getRespuestas().add(objRespuesta);
		}

	}
	

	private void registrarDocente() {
		System.out.println("--------\nCreando Docente--------");
		Docente objDocente = new Docente();
		System.out.printf("Ingrese el nombre del docente: \n");
		String nombre = sc.nextLine();
		objDocente.setNombres(nombre);
		System.out.printf("Ingrese el apellido del docente: \n");
		String apellido = sc.nextLine();
		objDocente.setApellidos(apellido);
		System.out.printf("Ingrese el tipo de identificacion: \n");
		String tipoIdentificacion = sc.nextLine();
		objDocente.setTipoidentificacion(tipoIdentificacion);
		System.out.printf("Ingrese el numero de identificacion del docente: \n");
		String numeroIdentificacion = sc.nextLine();
		objDocente.setNumeroidentificacion(numeroIdentificacion);
		System.out.printf("Ingrese el correo del docente: \n");
		String correo = sc.nextLine();
		objDocente.setCorreo(correo);
		System.out.printf("Ingrese la vinculacion: \n");
		String vinculacion = sc.nextLine();
		objDocente.setVinculacion(vinculacion);

		Telefono objTelefono = new Telefono();
		System.out.printf("Ingrese el numero de telefono perteneciente al docente: \n");
		String numeroTelefono = sc.nextLine();
		objTelefono.setNumero(numeroTelefono);
		System.out.printf("Ingrese el tipo de telefono: \n");
		String tipoTelefono = sc.nextLine();
		objTelefono.setTipotelefono(tipoTelefono);
		objDocente.setObjTelefono(objTelefono);
		int cantDepartamentos = 0;
		do {
			System.out.printf("Ingrese el numero de departamentos a registrar: \n");
			cantDepartamentos = sc.nextInt();
			sc.nextLine();
			if (cantDepartamentos<=0) {
				System.out.printf("La cantidad de departamentos debe ser mayor a cero\n");
			}
		} while (cantDepartamentos<=0);
		//Agrego departamentos
		for (int i = 0; i < cantDepartamentos; i++) {
			Departamento objDepto = new Departamento();
			System.out.printf("Ingrese el nombre del departamento: \n");
			String nombreDepartamento = sc.nextLine();
			objDepto.setNombreDep(nombreDepartamento);
			System.out.printf("Ingrese la descripcion del departamento: \n");
			String descripcionDepartamento = sc.nextLine();
			objDepto.setDescripcion(descripcionDepartamento);
			objDocente.getDepartamentos().add(objDepto);
		}
		srvDocentesBD.save(objDocente);
	}
	private void crearCuestionario() {
		System.out.println("---------Creando cuestionario--------\n");
		Cuestionario objCuestionario = new Cuestionario();
		System.out.println("Ingrese el titulo: \n");
		String titulo = sc.nextLine();
		objCuestionario.setTitulo(titulo);
		System.out.println("Ingrese la descripcion: \n");
		String desc = sc.nextLine();
		objCuestionario.setDescripcion(desc);
		int cantPreguntas = 0;
		do {
			System.out.println("Ingrese la cantidad de preguntas pertenecientes al cuestionario: \n");
			cantPreguntas = sc.nextInt();
			sc.nextLine();
			if (cantPreguntas<=0) {
				System.out.printf("La cantidad de preguntas debe ser mayor a cero\n");
			}
		} while (cantPreguntas<=0);
		//Agrego preguntas
		for(int i=0; i<cantPreguntas;i++)
		{
			Pregunta objPregunta = new Pregunta();
			System.out.println("\nIngrese el enunciado de la pregunta"+ (i+1));
			String enunciado = sc.nextLine();
			objPregunta.setEnunciado(enunciado);
			//listo los tipos de preguntas
			listarTipoPreguntas();
			TipoPregunta objTipPregunta = new TipoPregunta();
			do {
				System.out.printf("Digite el id del tipo de pregunta: \n");
				int idTipoPregunta = sc.nextInt();
				objTipPregunta = srvTipoPreguntasBD.findById(idTipoPregunta).get();
				if (objTipPregunta.getIdtippregunta()==0) {
					System.out.printf("El tipo de pregunta con este id no existe\n");
				}
			} while (objTipPregunta.getIdtippregunta()==0);
			objTipPregunta.setObjPregunta(objPregunta);
			objPregunta.setObjTipoPregunta(objTipPregunta);
            objPregunta.setObjCuestionario(objCuestionario);
			objCuestionario.getPreguntas().add(objPregunta);
		}	

		srvCuestionariosBD.save(objCuestionario);
	}


}
