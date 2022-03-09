package entities;

import java.util.HashSet;
import java.util.Set;

public class Professor extends PessoaFisica {
	
	private int numeroMatricula;
	private String dataMatricula;
	private long numeroRegistroMec;
	
	private Set<Turma> turmas = new HashSet<>();
	
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	public Professor() {
	}
	
	public Professor(String nome, long cpf, String dataNascimento, String logradouro, int numero, String complemento,
			int cep, int numeroMatricula, String dataMatricula, long numeroRegistroMec) {
		super(nome, cpf, dataNascimento, logradouro, numero, complemento, cep);
		this.numeroMatricula = numeroMatricula;
		this.dataMatricula = dataMatricula;
		this.numeroRegistroMec = numeroRegistroMec;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(int numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public long getNumeroRegistroMec() {
		return numeroRegistroMec;
	}

	public void setNumeroRegistroMec(long numeroRegistroMec) {
		this.numeroRegistroMec = numeroRegistroMec;
	}

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@Override
	public void cadastrarPessoaFisica() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibirPessoas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibirPessoa(String nome) {
		// TODO Auto-generated method stub
		
	}
}
