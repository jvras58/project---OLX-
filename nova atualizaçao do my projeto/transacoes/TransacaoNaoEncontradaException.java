package transacoes;

public class TransacaoNaoEncontradaException extends Exception {
	private String CPF;
	
	public TransacaoNaoEncontradaException (String CPF) {
		super ("Transacao nao encontrada.");
		this.CPF = CPF;
	}
	
	public String getCPF() {
		return CPF;
	}
	//public TransacaoNaoEncontradaException ()
}

