package br.com.lilianyfotografia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FotografoDTO {
	private Long idFotografo;
	private String nomeFotografo;

	public FotografoDTO(Long idFotografo, String nomeFotografo) {
		super();
		this.idFotografo = idFotografo;
		this.nomeFotografo = nomeFotografo;
	}

	public Long getIdFotografo() {
		return idFotografo;
	}

	public void setIdFotografo(Long idFotografo) {
		this.idFotografo = idFotografo;
	}

	public String getNomeFotografo() {
		return nomeFotografo;
	}

	public void setNomeFotografo(String nomeFotografo) {
		this.nomeFotografo = nomeFotografo;
	}

}
