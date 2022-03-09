package entities;

import java.util.HashSet;
import java.util.Set;

public class Aluno extends PessoaFisica {
	
	private int numeroMatricula;
	private String dataMatricula;
	
	private Set<Turma> turmas = new HashSet<>();
		
	public Aluno() {
	}
		
	public Aluno(String nome, long cpf, String dataNascimento, String logradouro, int numero, String complemento,
			int cep, int numeroMatricula, String dataMatricula) {
		super(nome, cpf, dataNascimento, logradouro, numero, complemento, cep);
		this.numeroMatricula = numeroMatricula;
		this.dataMatricula = dataMatricula;
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
	
	public Set<Turma> getTurmas() {
		return turmas;
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
