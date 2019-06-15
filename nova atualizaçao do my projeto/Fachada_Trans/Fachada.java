package transacoes;
import Exception.TransacaoNaoEncontrada_Exception;
import Repositorios.Repositorio_lista_Transacao;
import Transacao.Transacao;
public class Fachada {

	public static void main(String[] args) {

		Repositorio_lista_Transacao lista = new Repositorio_lista_Transacao();
		//Repositorio_Array_Transacao lista = new Repositorio_Array_Transacao();
		
		
		lista.inserir(new Transacao("1213", "0788", "nome", 9,2));
		lista.inserir(new Transacao("0000", "1111", "nome", 9,2));
		lista.inserir(new Transacao("2222", "3333", "nome", 9,2));
		lista.cadastrar (new cadastro ("01123","00001","coco",4, 2,2));
		try {
			lista.procurar("1213");
			System.out.println("Cpf encontrado.");
		} catch (TransacaoNaoEncontrada_Exception e) {
			System.out.println("CPF nº " + e.getCPF() +" não encontrado");
		}
		System.out.println(lista.ToString());
	}
	//cadastrar("String cpf_comprador, String cpf_vendedor, String produto, int qntd,double preco");
	//  lista.cadastrar (new cadastro ("01123","00001","coco",4, 2,2));
	
}
        
