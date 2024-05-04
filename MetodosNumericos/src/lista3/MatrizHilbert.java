package lista3;

public class MatrizHilbert {

	private double[][] matrizHilbert;
	
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
		imprimir(n, n+1);
	}
	
	private void imprimir(int i, int j) {
		for(int ai = 0; ai<i; ai++) {
			for(int aj = 0; aj<j; aj++) {
				if(aj==0) {
					System.out.print("| ");
				}

				System.out.print(this.matrizHilbert[ai][aj]+" ");

				if(aj==j-1) {
					System.out.println("|\n");
				}
			}
		}		
	}	
}
