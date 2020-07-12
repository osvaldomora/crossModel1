package mx.com.banamex.tdc.modelo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Transactional
@Entity
@Table(name = "TDC_CROSSELL_CLTE")
public class CrossellEntity implements Serializable {

	private static final long serialVersionUID = 4287074766757765705L;
	
	@Id
	@Column(name = "CROSSELL_CLTE_FOLIO")
	private String crossellClteFolio;
	
	@Column(name = "CROSSELL_CLTE_NUMERO")
	private Long crosselClteNumero;
	
	@Column(name = "CROSSELL_CLTE_PRODUCT3")
	private Long crossellClteProduct3;
	
	@Column(name = "CROSSELL_CLTE_PRODUCT1")
	private Long crossellClteProduct1;
	
	@Column(name = "CROSSELL_CLTE_PRODUCT2")
	private Long crossellClteProduct2;

	public String getCrossellClteFolio() {
		return crossellClteFolio;
	}

	public void setCrossellClteFolio(String crossellClteFolio) {
		this.crossellClteFolio = crossellClteFolio;
	}

	public Long getCrosselClteNumero() {
		return crosselClteNumero;
	}

	public void setCrosselClteNumero(Long crosselClteNumero) {
		this.crosselClteNumero = crosselClteNumero;
	}

	public Long getCrossellClteProduct3() {
		return crossellClteProduct3;
	}

	public void setCrossellClteProduct3(Long crossellClteProduct3) {
		this.crossellClteProduct3 = crossellClteProduct3;
	}

	public Long getCrossellClteProduct1() {
		return crossellClteProduct1;
	}

	public void setCrossellClteProduct1(Long crossellClteProduct1) {
		this.crossellClteProduct1 = crossellClteProduct1;
	}

	public Long getCrossellClteProduct2() {
		return crossellClteProduct2;
	}

	public void setCrossellClteProduct2(Long crossellClteProduct2) {
		this.crossellClteProduct2 = crossellClteProduct2;
	}

}
