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
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Professor professor = new Professor();

		try {
			System.out.println("Qual o nome do professor que ser� cadastrado?");
			String nome = sc.nextLine();
			System.out.println("Qual o CPF deste professor? (Responda somente n�meros)");
			long cpf = sc.nextLong();
			System.out.println("Qual a data de nascimento do professor? (Responda no formato dd/mm/aaaa)");
			sc.nextLine();
			String dataNascimento = sc.nextLine();
			System.out.println("Qual o logradouro(endere�o) do professor?");
			String logradouro = sc.nextLine();
			System.out.println("E o n�mero?");
			int numero = sc.nextInt();
			System.out.println("E o complemento?");
			sc.nextLine();
			String complemento = sc.nextLine();
			System.out.println("Qual o cep do professor? (Responda somente n�meros)");
			int cep = sc.nextInt();
			System.out.println("Qual ser� o n�mero de matr�cula do professor? (Responda somente n�meros)");
			int numeroMatricula = sc.nextInt();
			System.out.println("Qual a data de matr�cula do professor? (Responda no formato dd/mm/aaaa)");
			sc.nextLine();
			String dataMatricula = sc.nextLine();
			System.out.println("Qual � o n�mero de registro do professor no Minist�rio da Educa��o(MEC)? (Responda somente n�meros)");
			long numeroRegistroMec = sc.nextLong();

			professor.setNome(nome);
			professor.setCpf(cpf);
			professor.setDataNascimento(dataNascimento);
			professor.setLogradouro(logradouro);
			professor.setNumero(numero);
			professor.setComplemento(complemento);
			professor.setCep(cep);
			professor.setNumeroMatricula(numeroMatricula);
			professor.setDataMatricula(dataMatricula);
			professor.setNumeroRegistroMec(numeroRegistroMec);

		} catch (InputMismatchException e) {
			System.out.println("Voc� entrou com um valor inv�lido. Por favor, reinicie o programa e tente novamente.");
		}

		@SuppressWarnings("unused")
		boolean createNewFolder = new File("c:\\arquivos_projetointegrador_senac").mkdir();
		
		String path = "c:\\arquivos_projetointegrador_senac\\professores.txt";
		boolean professorCriadoComSucesso = false;

		if (professor.getNome() != null && professor.getCpf() != 0 && professor.getLogradouro() != null
				&& professor.getNumeroMatricula() != 0 && professor.getNumeroRegistroMec() != 0) {

			professorCriadoComSucesso = true;

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write(String.valueOf(professor));
				bw.newLine();
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			finally {
				System.out.println("Professor cadastrado com sucesso: " + professorCriadoComSucesso);
			}
		} 
		else {
			System.out.println("Professor cadastrado com sucesso: " + professorCriadoComSucesso);
		}
	}

	@Override
	public void exibirPessoas() {

		String originPath = "c:\\arquivos_projetointegrador_senac\\professores.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Voc� n�o possui nenhum professor cadastrado no sistema. Por favor, fa�a um cadastro antes de escolher esta op��o.");
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void exibirPessoa(String nome) {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\professores.txt";
		
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
			System.out.println("Voc� n�o possui nenhum professor cadastrado no sistema. Por favor, fa�a um cadastro antes de escolher esta op��o.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome do Professor: " + getNome());
		sb.append(", ");
		sb.append("CPF: " + getCpf());
		sb.append(", ");
		sb.append("Data de Nascimento: " + getDataNascimento());
		sb.append(", ");
		sb.append("N� de Matr�cula: " + getNumeroMatricula());
		sb.append(", ");
		sb.append("Data Matr�cula: " + getDataMatricula());
		sb.append(", ");
		sb.append("N�mero de registro no MEC: " + getNumeroRegistroMec());
		sb.append(", ");
		sb.append("Logradouro: " + getLogradouro());
		sb.append(", ");
		sb.append("N�mero: " + getNumero());
		sb.append(", ");
		sb.append("Complemento: " + getComplemento());
		sb.append(", ");
		sb.append("CEP: " + getCep() + "\n");
		return sb.toString();
	}
}
