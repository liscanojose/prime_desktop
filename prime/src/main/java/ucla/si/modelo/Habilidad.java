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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Habilidad implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private List<UsuarioHabilidad> usuariohabilidad = new ArrayList<UsuarioHabilidad>();
	private String estatus;
	private Date fecha_creacion;
	private Date fecha_modificacion;
	
	public Habilidad(){
		super();
	}

	public Habilidad(String descripcion, String estatus, Date fecha_creacion, Date fecha_modificacion) {
		super();
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
	}

	@Id
	@SequenceGenerator(name= "pk_sequence_habilidad", sequenceName="habilidad_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator="pk_sequence_habilidad")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(targetEntity=UsuarioHabilidad.class, mappedBy="habilidad", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<UsuarioHabilidad> getUsuariohabilidad() {
		return usuariohabilidad;
	}


	public void setUsuariohabilidad(List<UsuarioHabilidad> usuariohabilidad) {
		this.usuariohabilidad = usuariohabilidad;
	}
	
	@Column(nullable = false)
	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Column(nullable = true)
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	@Column(nullable = true)
	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

}
