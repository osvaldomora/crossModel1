package mx.com.banamex.tdc.modelo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Transactional
@Entity
@Table(name = "TDC_TARJETAS_CREDITO")
public class TarjetasEntity implements Serializable {

	private static final long serialVersionUID = 4287074766757765705L;
	
	@Id
	@Column(name = "TDC_FOLIO")
	private String crossellClteFolio;
	
	@Column(name = "TDC_DATOS")
	private Long crosselClteDatos;
	
	@Column(name = "TDC_FECHA")
	private Long crossellClteFecha;
	
	@Column(name = "TDC_STATUS")
	private Long crossellClteStatus;
	
	@Column(name = "TDC_CEL")
	private Long crossellClteCel;
	
	@Column(name = "TDC_MAIL")
	private Long crossellClteMail;

	public String getCrossellClteFolio() {
		return crossellClteFolio;
	}

	public void setCrossellClteFolio(String crossellClteFolio) {
		this.crossellClteFolio = crossellClteFolio;
	}

	public Long getCrosselClteDatos() {
		return crosselClteDatos;
	}

	public void setCrosselClteDatos(Long crosselClteDatos) {
		this.crosselClteDatos = crosselClteDatos;
	}

	public Long getCrossellClteFecha() {
		return crossellClteFecha;
	}

	public void setCrossellClteFecha(Long crossellClteFecha) {
		this.crossellClteFecha = crossellClteFecha;
	}

	public Long getCrossellClteStatus() {
		return crossellClteStatus;
	}

	public void setCrossellClteStatus(Long crossellClteStatus) {
		this.crossellClteStatus = crossellClteStatus;
	}

	public Long getCrossellClteCel() {
		return crossellClteCel;
	}

	public void setCrossellClteCel(Long crossellClteCel) {
		this.crossellClteCel = crossellClteCel;
	}

	public Long getCrossellClteMail() {
		return crossellClteMail;
	}

	public void setCrossellClteMail(Long crossellClteMail) {
		this.crossellClteMail = crossellClteMail;
	}

}
