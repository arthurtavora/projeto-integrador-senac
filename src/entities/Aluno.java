package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
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
		
		Scanner sc = new Scanner(System.in);
		Aluno aluno = new Aluno();
		
		try {
			System.out.println("Qual o nome do aluno que será cadastrado?");
			String nome = sc.nextLine();
			System.out.println("Qual o CPF deste aluno? (Responda somente números)");
			long cpf = sc.nextLong();
			System.out.println("Qual a data de nascimento do aluno? (Responda no formato dd/mm/aaaa)");
			sc.nextLine();
			String dataNascimento = sc.nextLine();
			System.out.println("Qual o logradouro(endereço) do aluno?");
			String logradouro = sc.nextLine();
			System.out.println("E o número?");
			int numero = sc.nextInt();
			System.out.println("E o complemento?");
			sc.nextLine();
			String complemento = sc.nextLine();
			System.out.println("Qual o cep do aluno? (Responda somente números)");
			int cep = sc.nextInt();
			System.out.println("Qual será o número de matrícula do aluno? (Responda somente números)");
			int numeroMatricula = sc.nextInt();
			System.out.println("Qual a data de matrícula do aluno? (Responda no formato dd/mm/aaaa)");
			sc.nextLine();
			String dataMatricula = sc.nextLine();

			aluno.setNome(nome);
			aluno.setCpf(cpf);
			aluno.setDataNascimento(dataNascimento);
			aluno.setLogradouro(logradouro);
			aluno.setNumero(numero);
			aluno.setComplemento(complemento);
			aluno.setCep(cep);
			aluno.setNumeroMatricula(numeroMatricula);
			aluno.setDataMatricula(dataMatricula);

		}
		catch (InputMismatchException e) {
			System.out.println("Você entrou com um valor inválido. Por favor, reinicie o programa e tente novamente.");
		}
		finally {
			sc.close();
		}
		
		@SuppressWarnings("unused")
		boolean createNewFolder = new File("c:\\arquivos_projetointegrador_senac").mkdir();
		
		String path = "c:\\arquivos_projetointegrador_senac\\alunos.txt";
		boolean alunoCriadoComSucesso = false;
		
		if (aluno.getNome() != null && aluno.getCpf() != 0 && aluno.getLogradouro() != null
				&& aluno.getNumeroMatricula() != 0) {
			
			alunoCriadoComSucesso = true;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write(String.valueOf(aluno));
				bw.newLine();
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			finally {
				System.out.println("Aluno cadastrado com sucesso: " + alunoCriadoComSucesso);
			}
		}
		else {
			System.out.println("Aluno cadastrado com sucesso: " + alunoCriadoComSucesso);
		}
	}

	@Override
	public void exibirPessoas() {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\alunos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Você não possui nenhum aluno cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void exibirPessoa(String nome) {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\alunos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			boolean existeNome = false;
			
			while (existeNome == false) {
				if (line.contains(nome)) {
					System.out.println(line);
					existeNome = true;
				}
				else {
					if (line != null) {
						line = br.readLine();
					}
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Você não possui nenhum aluno cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome do Aluno: " + getNome());
		sb.append(", ");
		sb.append("CPF: " + getCpf());
		sb.append(", ");
		sb.append("Data de Nascimento: " + getDataNascimento());
		sb.append(", ");
		sb.append("Nº de Matricula: " + getNumeroMatricula());
		sb.append(", ");
		sb.append("Data Matrícula: " + getDataMatricula());
		sb.append(", ");
		sb.append("Logradouro: " + getLogradouro());
		sb.append(", ");
		sb.append("Número: " + getNumero());
		sb.append(", ");
		sb.append("Complemento: " + getComplemento());
		sb.append(", ");
		sb.append("CEP: " + getCep() + "\n");
		return sb.toString();
	}
}
