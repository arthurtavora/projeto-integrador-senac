package entities;

public abstract class PessoaJuridica {
	
	private String razaoSocial;
	private long cnpj;
	private String logradouro;
	private int numero;
	private String complemento;
	private int cep;
	
	public PessoaJuridica() {
	}

	public PessoaJuridica(String razaoSocial, long cnpj, String logradouro, int numero, String complemento, int cep) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public abstract void cadastrarPessoaJuridica();
	
	public abstract void exibirEmpresas();
	
	public abstract void exibirEmpresa(String razaoSocial);

	@Override
	public String toString() {
		return "PessoaJuridica [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
}
