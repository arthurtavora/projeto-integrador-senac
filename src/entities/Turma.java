package entities;

import java.util.HashSet;
import java.util.Set;

public class Turma {
	
	private int numeroRegistro;
	private String dataInicio;
	private int numeroVagas;
	
	private Professor professor;
	
	private Curso curso;
	
	private Set<Aluno> alunos = new HashSet<>();
	
	public Turma() {
	}

	public Turma(int numeroRegistro, String dataInicio, int numeroVagas, Professor professor, Curso curso) {
		this.numeroRegistro = numeroRegistro;
		this.dataInicio = dataInicio;
		this.numeroVagas = numeroVagas;
		this.professor = professor;
		this.curso = curso;
	}

	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}
}
