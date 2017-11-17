package br.com.lilianyfotografia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fotografo")
public class Fotografo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fotografo")
	private Long idFotografo;
	@Column(name="nome_fotografo")
	private String nomeFotografo;

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
