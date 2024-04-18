package lista2;

public class Start {

	public static void main(String[] args) {
		Lista2 lista2 = new Lista2();
//		
//		lista2.bissecao(1, 4.4, 4.8);
//		lista2.bissecao(2, 4.4, 4.8);
		//lista2.falsaPosicao(1, 4.4, 4.8);
		//lista2.pontoFixo(1, 100000);
		//lista2.newtonRaphson(1, 100);
		
		lista2.secante(2, 100, 1, 2);
	}
}
