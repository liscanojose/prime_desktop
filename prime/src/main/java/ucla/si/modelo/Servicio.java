package ucla.si.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Servicio implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	Long id;
	String codigo;
	String descripcion;
	double precio;

	String estatus;
	Date fecha_creacion;
	Date fecha_modificacion;

	public Servicio() {
		super();
	}

	public Servicio(String codigo, String descripcion, String estatus, double precio, Date fecha_creacion,
			Date fecha_modificacion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.estatus = estatus;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;

	}

	@Id
	@SequenceGenerator(name = "pk_sequence_servicio", sequenceName = "servicio_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_sequence_servicio")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true, nullable = false)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	@Column(nullable = false)
	public double getPrecio() {
		return precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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