package entities;

import java.util.HashSet;
import java.util.Set;

public class Disciplina {
	
	private String nome;
	private int cargaHoraria;
	private double mediaFinalMinima;
	
	private Set<Professor> professores = new HashSet<>();
	
	private Set<Curso> cursos = new HashSet<>();
	
	public Disciplina() {
	}

	public Disciplina(String nome, int cargaHoraria, double mediaFinalMinima) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.mediaFinalMinima = mediaFinalMinima;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public double getMediaFinalMinima() {
		return mediaFinalMinima;
	}

	public void setMediaFinalMinima(double mediaFinalMinima) {
		this.mediaFinalMinima = mediaFinalMinima;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}
}
