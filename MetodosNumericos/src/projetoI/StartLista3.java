package projetoI;

import javax.swing.JOptionPane;

import exception.DomainException;
import view.TelaInicial;

public class StartLista3 {

	public static void main(String[] args) {
		
	
		try {
			new TelaInicial().telainicial();
		} catch (DomainException e) {

			JOptionPane.showMessageDialog(null, "Erro " + e.getMessage(),
                    "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
		}
	}
}
