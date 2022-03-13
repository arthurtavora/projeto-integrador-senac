package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.enums.TipoContrato;

public class Contrato {
	
	private int numeroRegistro;
	private String dataInicio;
	private String dataFim;
	private TipoContrato tipo;
	
	private Fornecedor fornecedor;
	
	public Contrato() {
	}

	public Contrato(int numeroRegistro, String dataInicio, String dataFim, TipoContrato tipo, Fornecedor fornecedor) {
		this.numeroRegistro = numeroRegistro;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
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

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public TipoContrato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContrato tipo) {
		this.tipo = tipo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public void registrarContrato() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Contrato contrato = new Contrato();
		TipoContrato tipo;
		try {
			System.out.println("Qual é o número de registro do contrato que será cadastrado?");
			int numeroRegistro = sc.nextInt();
			System.out.println("Qual é a data de início deste contrato? (Responda no formato dd/mm/aaaa)");
			sc.nextLine();
			String dataInicio = sc.nextLine();
			System.out.println("Qual é a data final/encerramento do contrato? (Responda no formato dd/mm/aaaa)");
			String dataFim = sc.nextLine();
			System.out.println("Qual é o tipo contratual? Digite 1 para VENDA_DE_PRODUTO / Digite 2 para PRESTACAO_DE_SERVICO.");
			int respostaUsuario = sc.nextInt();
			
			if (respostaUsuario == 1) {
				tipo = TipoContrato.VENDA_DE_PRODUTO;
			}
			else if (respostaUsuario == 2) {
				tipo = TipoContrato.PRESTACAO_DE_SERVICO;
			}
			else {
				throw new InputMismatchException("Você entrou com um valor inválido. Digite apenas 1 ou 2. Por favor, reinicie o programa e tente novamente.");
			}
			
			contrato.setNumeroRegistro(numeroRegistro);
			contrato.setDataInicio(dataInicio);
			contrato.setDataFim(dataFim);
			contrato.setTipo(tipo);

		}
		catch (InputMismatchException e) {
			System.out.println("Você entrou com um valor inválido. Por favor, reinicie o programa e tente novamente.");
		}
		
		@SuppressWarnings("unused")
		boolean createNewFolder = new File("c:\\arquivos_projetointegrador_senac").mkdir();
		
		String path = "c:\\arquivos_projetointegrador_senac\\contratos.txt";
		boolean contratoCriadoComSucesso = false;
		
		if (contrato.getNumeroRegistro() != 0 && contrato.getDataInicio() != null && contrato.getDataFim() != null
				&& contrato.getTipo() != null) {
			
			contratoCriadoComSucesso = true;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write(String.valueOf(contrato));
				bw.newLine();
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			finally {
				System.out.println("Aluno cadastrado com sucesso: " + contratoCriadoComSucesso);
			}
		}
		else {
			System.out.println("Aluno cadastrado com sucesso: " + contratoCriadoComSucesso);
		}
	}
	
	public void exibirContratos() {
		String originPath = "c:\\arquivos_projetointegrador_senac\\contratos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Você não possui nenhum contrato cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void exibirContrato(int numeroRegistro) {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\contratos.txt";
		
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
			System.out.println("Você não possui nenhum contrato cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Número de registro do contrato: " + getNumeroRegistro());
		sb.append(", ");
		sb.append("Data de início do contrato: " + getDataInicio());
		sb.append(", ");
		sb.append("Data de encerramento do contrato: " + getDataFim());
		sb.append(", ");
		sb.append("Tipo do contrato: " + getTipo() + "\n");
		
		return sb.toString();
	}
}
