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

public class Turma {
	
	private int numeroRegistro;
	private String dataInicio;
	private int numeroVagas;
	
	private Professor professor;
	
	private Curso curso;
	
	private Set<Aluno> turmas = new HashSet<>();
	
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
		return turmas;
	}
	
	public void cadastrarTurma() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Turma turma = new Turma();
		
		try {
			System.out.println("Qual o número de registro da turma que será cadastrada?");
			int numeroRegistro = sc.nextInt();
			System.out.println("Qual a data de início da turma? (Responda no formato dd/mm/aaaa)");
			sc.nextLine();
			String dataInicio = sc.nextLine();
			System.out.println("Quantas vagas esta turma possuirá? (Responda somente número)");
			int numeroVagas = sc.nextInt();
			
			turma.setNumeroRegistro(numeroRegistro);
			turma.setDataInicio(dataInicio);
			turma.setNumeroVagas(numeroVagas);
		}
		catch (InputMismatchException e) {
			System.out.println("Você entrou com um valor inválido. Por favor, reinicie o programa e tente novamente.");
		}
		
		@SuppressWarnings("unused")
		boolean createNewFolder = new File("c:\\arquivos_projetointegrador_senac").mkdir();
		
		String path = "c:\\arquivos_projetointegrador_senac\\turmas.txt";
		boolean turmaCriadaComSucesso = false;
		
		if (turma.getNumeroRegistro() != 0 && turma.getDataInicio() != null && turma.getNumeroVagas() != 0) {
			
			turmaCriadaComSucesso = true;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write(String.valueOf(turma));
				bw.newLine();
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			finally {
				System.out.println("Aluno cadastrado com sucesso: " + turmaCriadaComSucesso);
			}
		}
		else {
			System.out.println("Aluno cadastrado com sucesso: " + turmaCriadaComSucesso);
		}
	}
	
	public void exibirTurmas() {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\turmas.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Você não possui nenhuma turma cadastrada no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void exibirTurma(int numeroRegistro) {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\turmas.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			boolean existeNome = false;
			
			while (existeNome == false) {
				if (line.contains(String.valueOf(numeroRegistro))) {
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
			System.out.println("Você não possui nenhuma turma cadastrada no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Número de registro da turma: " + getNumeroRegistro());
		sb.append(", ");
		sb.append("Data de início da turma: " + getDataInicio());
		sb.append(", ");
		sb.append("Quantidade de vagas da turma: " + getNumeroVagas());
		return sb.toString();
	}
}
