package entities;

public abstract class PessoaFisica {
	
	private String nome;
	private long cpf;
	private String dataNascimento;
	private String logradouro;
	private int numero;
	private String complemento;
	private int cep;
	
	public PessoaFisica() {
	}

	public PessoaFisica(String nome, long cpf, String dataNascimento, String logradouro, int numero, String complemento,
			int cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	public abstract void cadastrarPessoaFisica();
	
	public abstract void exibirPessoas();
	
	public abstract void exibirPessoa(String nome);

	@Override
	public String toString() {
		return "Nome: " + nome + ", Cpf: " + cpf + ", Data de Nascimento: " + dataNascimento + ", Logradouro: "
				+ logradouro + ", Número: " + numero + ", Complemento: " + complemento + ", Cep: " + cep;
	}
}
