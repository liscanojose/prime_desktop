package ucla.si.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ucla.si.modelo.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Noticia implements Serializable, Cloneable {
	
	private Long noticia_id;
	private String titulo;
	private String descripcion;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private String url_imagen;
    
    public Noticia(){
    	
    }

	public Noticia(Long noticia_id, String titulo, String descripcion,
			Date fecha_creacion, Date fecha_modificacion, String url_imagen) {
		super();
		this.noticia_id = noticia_id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
		this.url_imagen = url_imagen;
	}

	@Id
	@GeneratedValue
	public Long getNoticia_id() {
		return noticia_id;
	}

	public void setNoticia_id(Long noticia_id) {
		this.noticia_id = noticia_id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}
    
    
    
}
