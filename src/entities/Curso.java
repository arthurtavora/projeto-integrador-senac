package entities;

import java.util.HashSet;
import java.util.Set;

public class Curso {
	
	private String nome;
	private int cargaHoraria;
	private TipoCurso tipo;
	
	private Set<Turma> turmas = new HashSet<>();
	
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	public Curso() {
	}

	public Curso(String nome, int cargaHoraria, TipoCurso tipo) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.tipo = tipo;
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

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}
