package transacoes;

public class RepositorioTransacoesArray implements RepositorioTransacoes {
	
	public Transacao[] transacoes;
	

	public RepositorioTransacoesArray() {
		transacoes = new Transacao[50];
		for (int i = 0; i < Transacao.length; i++) {
			transacoes[i] = null;
		}
	}

	public void cadastrar (String cpfComprador, String cpfVendedor, String produto, int quantidade, double preco)  {
		Transacao transac = new Transacao 
			(cpfComprador,cpfVendedor,produto,quantidade,preco);
		inserir(transac);
	}

	public void inserir(Transacao Transacao) {
		for (int i = 0; i < transacoes.length; i++) {
			if (transacoes[i] == null) {
				transacoes[i] = Transacao;
				return;
			}
		}
	}

	public void Remover(String CPF) throws TransacaoNaoEncontradaException {
		for (int i = 0; i < transacoes.length; i++) {
			if (transacoes[i] != null) {
				if (transacoes[i].getCPFComprador() == CPF | transacoes[i].getCPFVendedor() == CPF) {
					transacoes[i] = null;
					return;
				}
			}
		}
		TransacaoNaoEncontradaException excecao;
		excecao= new TransacaoNaoEncontradaException(CPF);
		throw excecao;
	}

	public Transacao procurar(String CPF) throws TransacaoNaoEncontradaException {
		for (int i = 0; i < transacoes.length; i++) {
			Transacao transacao = transacoes[i];
			if (transacao.getCPFComprador() == CPF | transacao.getCPFVendedor() == CPF) {
				return transacao;
			}
		}
		TransacaoNaoEncontradaException excecao;
		excecao= new TransacaoNaoEncontradaException(CPF);
		throw excecao;
	}
	
	 public boolean existe (String CPF) {
	    	Transacao trans = null;
	    	try
	    	{trans = procurar (CPF); }
	    	catch (TransacaoNaoEncontradaException e) {}
	    		if(trans !=null) {
	    			return true;
	    		}else {
	    			return false;
	    		}
	    		}
	    		

	public String ToString() {
		String retorno = "";
		for (int i = 0; i < transacoes.length; i++) {
			Transacao transacao = transacoes[i];
			if (transacao != null) {
	            retorno += "\n CPF Comprador: " + transacao.getCPFComprador() +
	            		" - CPF Vendedor" 	 + transacao.getCPFVendedor() +
	            		"   Preco :" +transacao.getPreco() +
	                   "    produto : " +transacao.getProduto()+
	                   "    quantidade : " +transacao.getQuantidade();
			}
		}
		return retorno;
	}

}
