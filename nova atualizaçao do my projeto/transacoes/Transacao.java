package Transacao;

public class Transacao {
	private String CPFComprador;
	private String CPFVendedor;
	private String produto;
	private int quantidade;
	private double preco;
	
	public Transacao(String CPFComprador, String CPFVendedor, String produto, int quantidade, double preco) {
		this.CPFComprador=CPFComprador;
		this.CPFVendedor=CPFVendedor;
		this.produto=produto;
		this.quantidade=quantidade;
		this.preco=preco;
	}


	public String getCPFComprador() {	
		
		return CPFComprador;
	}

	public String getCPFVendedor() {
		return CPFVendedor;
	}

	public String getproduto() {
		return produto;
	}

	
	public int getQuantidade() {
		return quantidade;
	}
	
	public double getPreco() {
		return preco;
	}

}
