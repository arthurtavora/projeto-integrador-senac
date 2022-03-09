package entities;

import java.util.HashSet;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibirEmpresas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibirEmpresa(String razaoSocial) {
		// TODO Auto-generated method stub
		
	}
}
