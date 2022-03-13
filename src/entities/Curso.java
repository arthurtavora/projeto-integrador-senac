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

import entities.enums.TipoCurso;

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
	
	public void cadastrarCurso() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Curso curso = new Curso();
		TipoCurso tipo;
		
		try {
			System.out.println("Qual o nome do curso que será cadastrado?");
			String nome = sc.nextLine();
			System.out.println("Qual a carga horária que este curso possui? (Responda somente números)");
			int cargaHoraria = sc.nextInt();
			System.out.println("Qual é o tipo do curso? Digite 1 para TECNOLOGO / Digite 2 para BACHARELADO"
					+ "/ Digite 3 para LICENCIATURA / Digite 4 para POS_GRADUACAO.");
			int respostaUsuario = sc.nextInt();
			
			if (respostaUsuario == 1) {
				tipo = TipoCurso.TECNOLOGO;
			}
			else if (respostaUsuario == 2) {
				tipo = TipoCurso.BACHARELADO;
			}
			else if (respostaUsuario == 3) {
				tipo = TipoCurso.LICENCIATURA;
			}
			else if (respostaUsuario == 4) {
				tipo = TipoCurso.POS_GRADUACAO;
			}
			else {
				throw new InputMismatchException("Você entrou com um valor inválido. Digite apenas 1, 2, 3 ou 4. Por favor, reinicie o programa e tente novamente.");
			}
			
			curso.setNome(nome);
			curso.setCargaHoraria(cargaHoraria);
			curso.setTipo(tipo);
		}
		catch (InputMismatchException e) {
			System.out.println("Você entrou com um valor inválido. Por favor, reinicie o programa e tente novamente.");
		}

		@SuppressWarnings("unused")
		boolean createNewFolder = new File("c:\\arquivos_projetointegrador_senac").mkdir();
		
		String path = "c:\\arquivos_projetointegrador_senac\\cursos.txt";
		boolean cursoCriadoComSucesso = false;
		
		if (curso.getNome() != null && curso.getCargaHoraria() != 0 && curso.getTipo() != null) {
			
			cursoCriadoComSucesso = true;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write(String.valueOf(curso));
				bw.newLine();
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			finally {
				System.out.println("Aluno cadastrado com sucesso: " + cursoCriadoComSucesso);
			}
		}
		else {
			System.out.println("Aluno cadastrado com sucesso: " + cursoCriadoComSucesso);
		}
	}
	
	public void exibirCursos() {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\cursos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Você não possui nenhum curso cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void exibirCurso(String nome) {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\cursos.txt";
		
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
			System.out.println("Você não possui nenhum curso cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome do curso: " + getNome());
		sb.append(", ");
		sb.append("Carga horária: " + getCargaHoraria());
		sb.append(", ");
		sb.append("Tipo do curso: " + getTipo() + "\n");
		return sb.toString();
	}
}
