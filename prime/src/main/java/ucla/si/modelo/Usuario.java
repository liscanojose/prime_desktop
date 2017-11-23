package ucla.si.modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author dreik-laptop
 *
 */
@Entity
public class Usuario implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String correo;
	private String contrasenna;
	private String pregunta;
	private String respuesta;
	private String estatus;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Persona persona;
	private List<GrupoUsuario> grupoUsuarios = new ArrayList<GrupoUsuario>();
	private List<UsuarioHabilidad> usuarioHabilidades = new ArrayList<UsuarioHabilidad>();
	private List<Garaje> garajes = new ArrayList<Garaje>();
	private List<Sesion> sesiones = new ArrayList<Sesion>();
	private List<Cita> citas = new ArrayList<Cita>();

	public Usuario() {
		super();
	}
	
	public Usuario(String correo, String contrasenna, String pregunta, String respuesta, String estatus,
			Date fechaCreacion, Date fechaModificacion) {
		super();
		this.correo = correo;
		this.contrasenna = contrasenna;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.estatus = estatus;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	@Id
	@SequenceGenerator(name= "pk_sequence_usuario", sequenceName="usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator="pk_sequence_usuario")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true, nullable = false)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(nullable = false)
	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	@Column(nullable = false)
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	@Column(nullable = false)
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Column(nullable = false)
	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Column(nullable = true)
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(nullable = true)
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona", nullable = true)
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@OneToMany(/*targetEntity=GrupoUsuario.class,*/ mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<GrupoUsuario> getGrupoUsuarios() {
		return grupoUsuarios;
	}

	public void setGrupoUsuarios(List<GrupoUsuario> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	@OneToMany(/*targetEntity=UsuarioHabilidad.class,*/ mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<UsuarioHabilidad> getUsuarioHabilidades() {
		return usuarioHabilidades;
	}

	public void setUsuarioHabilidades(List<UsuarioHabilidad> usuarioHabilidades) {
		this.usuarioHabilidades = usuarioHabilidades;
	}

	@OneToMany(/*targetEntity=Garaje.class,*/ mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Garaje> getGarajes() {
		return garajes;
	}

	public void setGarajes(List<Garaje> garajes) {
		this.garajes = garajes;
	}

	@OneToMany(/*targetEntity=Sesion.class,*/ mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	@OneToMany(/*targetEntity=Cita.class,*/ mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Cita> getCitas() {
		return citas;
	}

	
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

}


