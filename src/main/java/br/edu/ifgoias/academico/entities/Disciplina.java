package br.edu.ifgoias.academico.entities;

import java.io.Serializable;

import java.util.Objects;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Disciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer iddisciplina;
	
	@Column (name= "nomedisciplina", nullable=false)
	private String nomedisciplina;
	
	@Column (name= "cargahoraria", nullable=true)
	private Integer cargahoraria;
	
			
	public Disciplina () {
		
	}

	public Disciplina(Integer iddisciplina, String nomedisciplina, Integer cargahoraria) {
		this.iddisciplina = iddisciplina;
		this.nomedisciplina = nomedisciplina;
		this.cargahoraria = cargahoraria;
	}
	/*
	 private List <Curso> listaCurso = new ArrayList<>();
	 
	
	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void adicionarCurso (Curso c) {
		
		if (!listaCurso.contains(c)) {
			listaCurso.add(c);
			c.adicionarDisciplina(this);
		}		
	}
	
	*/

	public Integer getIddisciplina() {
		return iddisciplina;
	}

	public void setIddisciplina(Integer iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public String getNomedisciplina() {
		return nomedisciplina;
	}

	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}

	public Integer getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(Integer cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cargahoraria, iddisciplina, nomedisciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(cargahoraria, other.cargahoraria) && Objects.equals(iddisciplina, other.iddisciplina)
				&& Objects.equals(nomedisciplina, other.nomedisciplina);
	}

	@Override
	public String toString() {
		return "Disciplina [iddisciplina=" + iddisciplina + ", nomedisciplina=" + nomedisciplina + ", cargahoraria="
				+ cargahoraria + "]";
	}
	
	
	

}
