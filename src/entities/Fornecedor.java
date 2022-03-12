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

public class Fornecedor extends PessoaJuridica {
	
	private String nomeRepresentanteComercial;
	private int cpfRepresentanteComercial;
	
	private Set<Contrato> contratos = new HashSet<>();
	
	public Fornecedor() {
	}
	
	public Fornecedor(String razaoSocial, long cnpj, String logradouro, int numero, String complemento, int cep,
			String nomeRepresentanteComercial, int cpfRepresentanteComercial) {
		super(razaoSocial, cnpj, logradouro, numero, complemento, cep);
		this.nomeRepresentanteComercial = nomeRepresentanteComercial;
		this.cpfRepresentanteComercial = cpfRepresentanteComercial;
	}

	public String getNomeRepresentanteComercial() {
		return nomeRepresentanteComercial;
	}

	public void setNomeRepresentanteComercial(String nomeRepresentanteComercial) {
		this.nomeRepresentanteComercial = nomeRepresentanteComercial;
	}

	public int getCpfRepresentanteComercial() {
		return cpfRepresentanteComercial;
	}

	public void setCpfRepresentanteComercial(int cpfRepresentanteComercial) {
		this.cpfRepresentanteComercial = cpfRepresentanteComercial;
	}

	public Set<Contrato> getContratos() {
		return contratos;
	}

	@Override
	public void cadastrarPessoaJuridica() {
		
		Scanner sc = new Scanner(System.in);
		Fornecedor fornecedor = new Fornecedor();
		
		try {
			System.out.println("Qual o nome/razão social do fornecedor que será cadastrado?");
			String razaoSocial = sc.nextLine();
			System.out.println("Qual é o CNPJ deste fornecedor? (Responda somente números)");
			long cnpj = sc.nextLong();
			System.out.println("Qual o logradouro(endereço) do fornecedor?");
			sc.nextLine();
			String logradouro = sc.nextLine();
			System.out.println("E o número?");
			int numero = sc.nextInt();
			System.out.println("E o complemento?");
			sc.nextLine();
			String complemento = sc.nextLine();
			System.out.println("Qual o cep do fornecedor? (Responda somente números)");
			int cep = sc.nextInt();
			System.out.println("Qual é o nome do representante comercial deste fornecedor?");
			sc.nextLine();
			String nomeRepresentanteComercial = sc.nextLine();
			System.out.println("Qual é o CPF deste representante comercial? (Responda somente números)");
			int cpfRepresentanteComercial = sc.nextInt();

			fornecedor.setRazaoSocial(razaoSocial);
			fornecedor.setCnpj(cnpj);
			fornecedor.setLogradouro(logradouro);
			fornecedor.setNumero(numero);
			fornecedor.setComplemento(complemento);
			fornecedor.setCep(cep);
			fornecedor.setNomeRepresentanteComercial(nomeRepresentanteComercial);
			fornecedor.setCpfRepresentanteComercial(cpfRepresentanteComercial);

		}
		catch (InputMismatchException e) {
			System.out.println("Você entrou com um valor inválido. Por favor, reinicie o programa e tente novamente.");
		}
		finally {
			sc.close();
		}
		
		@SuppressWarnings("unused")
		boolean createNewFolder = new File("c:\\arquivos_projetointegrador_senac").mkdir();
		
		String path = "c:\\arquivos_projetointegrador_senac\\fornecedores.txt";
		boolean fornecedorCriadoComSucesso = false;
		
		if (fornecedor.getRazaoSocial() != null && fornecedor.getCnpj() != 0 && fornecedor.getLogradouro() != null
				&& fornecedor.getCpfRepresentanteComercial() != 0) {
			
			fornecedorCriadoComSucesso = true;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
				bw.write(String.valueOf(fornecedor));
				bw.newLine();
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			finally {
				System.out.println("Fornecedor cadastrado com sucesso: " + fornecedorCriadoComSucesso);
			}
		}
		else {
			System.out.println("Fornecedor cadastrado com sucesso: " + fornecedorCriadoComSucesso);
		}
	}

	@Override
	public void exibirEmpresas() {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\fornecedores.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Você não possui nenhum fornecedor cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public void exibirEmpresa(String razaoSocial) {
		
		String originPath = "c:\\arquivos_projetointegrador_senac\\fornecedores.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
			
			String line = br.readLine();
			boolean existeNome = false;
			
			while (existeNome == false) {
				if (line.contains(razaoSocial)) {
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
			System.out.println("Você não possui nenhum fornecedor cadastrado no sistema. Por favor, faça um cadastro antes de escolher esta opção.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Razão Social do fornecedor: " + getRazaoSocial());
		sb.append(", ");
		sb.append("CNPJ: " + getCnpj());
		sb.append(", ");
		sb.append("Logradouro: " + getLogradouro());
		sb.append(", ");
		sb.append("Número: " + getNumero());
		sb.append(", ");
		sb.append("Complemento: " + getComplemento());
		sb.append(", ");
		sb.append("CEP: " + getCep());
		sb.append(", ");
		sb.append("Nome do representante comercial: " + getNomeRepresentanteComercial());
		sb.append(", ");
		sb.append("CPF do representante comercial: " + getCpfRepresentanteComercial() + "\n");
		return sb.toString();
	}
}
