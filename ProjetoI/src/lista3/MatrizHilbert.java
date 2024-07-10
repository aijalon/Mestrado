package lista3;

public class MatrizHilbert {

	private double[][] matrizHilbert;
	private Metodos metodos = new Metodos();
	
	public MatrizHilbert(int n) {
		this.matrizHilbert = new double[n][n+1];
		double soma = 0;
		
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<=n-1; j++) {
					this.matrizHilbert[i][j] = 1.0/(i+j+1);
					soma+= this.matrizHilbert[i][j];
			}
			this.matrizHilbert[i][n] = soma;
			soma=0;
		}
		metodos.sobreRelaxamento(matrizHilbert, 2, 1.0/100000, 20);
	}
	
	public double[][] matrizHilbert(){
		return matrizHilbert;
	}
}
