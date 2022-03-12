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
	
	public void cadastrarDisciplina() {
		
		Scanner sc = new Scanner(System.in);
		Disciplina disciplina = new Disciplina();
		
		try {
			System.out.println("Qual o nome da disciplina que será cadastrada?");
			String nome = sc.nextLine();
			System.out.println("Qual a carga horária desta disciplina? (Responda somente números)");
			int cargaHoraria = sc.nextInt();
			System.out.println("Qual a média final mínima para ser aprovado nesta disciplina?");
			double mediaFinalMinima = sc.nextDouble();
			
			disciplina.setNome(nome);
			disciplina.setCargaHoraria(cargaHoraria);
			disciplina.setMediaFinalMinima(mediaFinalMinima);
		}
		catch (InputMismatchException e) {
			System.out.println("Você entrou com um valor inválido. Por favor, reinicie o programa e tente novamente.");
		}
		finally {
			sc.close();
		}
		
		@SuppressWarnings("unused")
		boolean createNewFolder = new File("c:\\arquivos_projetointegrador_senac").mkdir();
		
		String path = "c:\\arquivos_projetointegrador_senac\\disciplinas.txt";
		boolean disciplinaCriadaComSucesso = false;
		
		if (disciplina.getNome() != null && disciplina.getCargaHoraria() != 0 && disciplina.getMediaFinalMinima() != 0) {
			
			disciplinaCriadaComSucesso = true;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write(String.valueOf(disciplina));
				bw.newLine();
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			finally {
				System.out.println("Aluno cadastrado com sucesso: " + disciplinaCriadaComSucesso);
			}
		}
		else {
			System.out.println("Aluno cadastrado com sucesso: " + disciplinaCriadaComSucesso);
		}
	}
	
	public void exibirDisciplinas() {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\disciplinas.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Você não possui nenhuma disciplina cadastrada no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void exibirDisciplina(String nome) {
		String originPath = "c:\\arquivos_projetointegrador_senac\\disciplinas.txt";
		
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
			System.out.println("Você não possui nenhuma disciplina cadastrada no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome da disciplina: " + getNome());
		sb.append(", ");
		sb.append("Carga horária: " + getCargaHoraria());
		sb.append(", ");
		sb.append("Média final mínima para aprovação: " + getMediaFinalMinima());
		return sb.toString();
	}
}
