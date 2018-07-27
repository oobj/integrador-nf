package br.com.oobj.integrador.model;

public class NotaFiscal {

	private Long id;
	private String nomeArquivo;
	private String conteudoArquivo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getConteudoArquivo() {
		return conteudoArquivo;
	}

	public void setConteudoArquivo(String conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}

}
