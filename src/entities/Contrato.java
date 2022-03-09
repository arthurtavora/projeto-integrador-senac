package entities;

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
}
