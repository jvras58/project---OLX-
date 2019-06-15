package transacoes;

import Exception.TransacaoNaoEncontradaException;
import Transacao.Transacao;

public interface InterfaceRepositorio {
		public void inserir (Transacao transacao);
        public void cadastrar (String CPFComprador, String CPFVendedor, String produto, int quantidade,double preco) throws TransacaoNaoEncontradaException;
		public void remover (String CPF) throws TransacaoNaoEncontradaException;
		public Transacao procurar (String nome) throws TransacaoNaoEncontradaException;
        public boolean existe (String nome);
	}

