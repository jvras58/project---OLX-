package transacoes;
import java.net.InterfaceAddress;

import Exception.TransacaoNaoEncontrada_Exception;
import Interface.Interface_Repositorio;
import Transacao.Transacao;

public class RepositorioTransacoesLista implements InterfaceRepositorio{
	    private Transacao primeiro, ultimo;
	    private int length;
	    
	    public RepositorioTransacoesLista() {
	        primeiro = new Transacao(null, null, null, 0, 0);
	        // VARIAVEL ARBITRARIA
	        primeiro.setNext(null);
	        ultimo = primeiro;
	        length = 0;
	    }
	    public void cadastrar (String cpfComprador, String cpfVendedor, String produto, int quantidade,double preco)  {
			Transacao transac = new Transacao 
				(cpfComprador,cpfVendedor,produto,quantidade,preco);
			inserir(transac);
		}
	    
	    public void inserir(Transacao transacao) {
	        ultimo.setNext(transacao);
	        ultimo = transacao;
	        length++;
	    }
	    
	    public void remover(String CPF) throws TransacaoNaoEncontradaException {
	        Transacao transacao = primeiro;
	        while(transacao.getNext() != null) {
	            if(transacao.getCPFComprador() == CPF | transacao.getCPFVendedor() == CPF) {
	                transacao.setNext(transacao.getNext().getNext());
	                return;
	            }
	            
	            transacao = transacao.getNext();
	        }
	        
	        TransacaoNaoEncontradaException excecao;
			excecao= new TransacaoNaoEncontradaException(CPF);
			throw excecao; 
	    }
	    
	    
	    public Transacao procurar(String CPF) throws TransacaoNaoEncontradaException {
	        Transacao transacao = primeiro;
	        while(transacao.getNext() != null) {
	            transacao = transacao.getNext();
	            
	            if(transacao.getCPFComprador() == CPF | transacao.getCPFVendedor() == CPF) {
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
	    	System.out.println(length);
	    	
	        String retorno = "";
	        Transacao transacao = primeiro.getNext();
	        while(transacao != null) {
	            retorno += "\nCPF Comprador: " + transacao.getCPFComprador() +
	            		" - CPF Vendedor" 	 + transacao.getCPFVendedor() +
	            		"   Preco :" +transacao.getPreco() +
	                   "    produto : " +transacao.getProduto()+
	                   "    quantidade : " +transacao.getQuantidade();
	            transacao = transacao.getNext();
	        }
	        return retorno;
	    }


	}

