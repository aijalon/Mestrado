package lista3;

public class Condicionamento {

	StringBuilder sb = new StringBuilder();
	String retorno = "";

	private double calcularNormaEuclidiana(double[][] matriz) {
		double normSq = 0.0;
        for (double[] row : matriz) {
            for (double val : row) {
                normSq += val * val;
            }
        }
        return Math.sqrt(normSq);
	}

	// Função para calcular a inversa de uma matriz quadrada
	private double[][] calcularInversa(double[][] matriz) {
        int n = matriz.length;
        double[][] inverse = new double[n][n];

        // Calcular a matriz inversa usando a fórmula de Cramer
        double det = 1.0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                double val = 1.0;
                for (int k = 0; k < n; k++) {
                    if (k != i) {
                        val *= matriz[k][j];
                    }
                }
                inverse[j][i] = Math.pow(-1.0, i + j) * val;
            }
            det *= matriz[j][j];
        }

        // Dividir a matriz inversa pelo determinante
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] /= det;
            }
        }

        return inverse;
	}

	// Método para analisar a matriz de Hilbert
	public String analisarMatrizHilbert(double[][] hilbert) {
		sb.setLength(0);
		double normaHilbert = calcularNormaEuclidiana(hilbert);
		double[][] inversaHilbert = calcularInversa(hilbert);
		double normaInversaHilbert = calcularNormaEuclidiana(inversaHilbert);
		double condicionamento = normaHilbert * normaInversaHilbert;

		sb.append("Norma Euclidiana da Matriz de Hilbert: "+ normaHilbert);
		sb.append("\nNorma Euclidiana da Inversa da Matriz de Hilbert: "+ normaInversaHilbert);
		sb.append("\nNúmero de Condicionamento: "+ condicionamento);

		if (condicionamento > 1e5) {
			sb.append("\nA matriz é mal condicionada.");
		} else {
			sb.append("\nA matriz é bem condicionada.");
		}

		this.retorno = sb.toString();
		return retorno;
	}
}
