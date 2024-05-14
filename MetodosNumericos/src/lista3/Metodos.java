package lista3;

import java.util.Arrays;

public class Metodos {

	double[][] matrizCopia;
	double[][] matrizHilbert;
	int i = 0;
	int j = 0;


	// a) Eliminação de Gauss com substituição regressiva
	public void gaussEliminacao(double[][] matriz) {
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];
		
		System.out.println("Matriz aumentada (n = "+n+"):");
		imprimirMatriz(n, n+1);
		// Fase de eliminação
		for (int i = 0; i < n - 1; i++) {
			for (int k = i + 1; k < n; k++) {
				double fator = matriz[k][i] / matriz[i][i];
				for (int j = i; j < n + 1; j++) {
					matriz[k][j] -= fator * matriz[i][j];
				}
			}
		}

		// Substituição regressiva
		for (int i = n - 1; i >= 0; i--) {
			double soma = 0.0;
			for (int j = i + 1; j < n; j++) {
				soma += matriz[i][j] * solucao[j];
			}
			solucao[i] = (matriz[i][n] - soma) / matriz[i][i];
		}
		
		System.out.println("Matriz com a eliminação:");
		imprimirMatriz(n, n+1);
		imprimirSoulucao(solucao);
	}

	// b) Eliminação de Gauss com pivotamento parcial
	public void gaussPivotamentoParcial(double[][] matriz) {
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];

		System.out.println("Matriz aumentada (n = "+n+"):");
		imprimirMatriz(n, n+1);
		// Fase de eliminação
		for (int i = 0; i < n - 1; i++) {
			// Encontrando a linha com o maior pivô
			int maxIndex = i;
			double maxValor = Math.abs(matriz[i][i]);
			for (int k = i + 1; k < n; k++) {
				if (Math.abs(matriz[k][i]) > maxValor) {
					maxValor = Math.abs(matriz[k][i]);
					maxIndex = k;
				}
			}
			// Trocando as linhas
			if (maxIndex != i) {
				double[] temp = matriz[i];
				matriz[i] = matriz[maxIndex];
				matriz[maxIndex] = temp;
			}
			// Eliminação
			for (int k = i + 1; k < n; k++) {
				double fator = matriz[k][i] / matriz[i][i];
				for (int j = i; j < n + 1; j++) {
					matriz[k][j] -= fator * matriz[i][j];
				}
			}
		}

		// Substituição regressiva
		for (int i = n - 1; i >= 0; i--) {
			double soma = 0.0;
			for (int j = i + 1; j < n; j++) {
				soma += matriz[i][j] * solucao[j];
			}
			solucao[i] = (matriz[i][n] - soma) / matriz[i][i];
		}
		
		System.out.println("Matriz com a eliminação:");
		imprimirMatriz(n, n+1);
		imprimirSoulucao(solucao);

	}

	// c) Eliminação de Gauss com pivotamento parcial com escala
	public void gaussPivotamentoParcialComEscala(double[][] matriz) {
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];
		
		System.out.println("Matriz aumentada (n = "+n+"):");
		imprimirMatriz(n, n+1);

		// Vetor para armazenar as escalas das linhas
		double[] escalas = new double[n];
		for (int i = 0; i < n; i++) {
			escalas[i] = Math.abs(matriz[i][0]);
			for (int j = 1; j < n; j++) {
				if (Math.abs(matriz[i][j]) > escalas[i]) {
					escalas[i] = Math.abs(matriz[i][j]);
				}
			}
		}

		// Fase de eliminação
		for (int i = 0; i < n - 1; i++) {
			// Encontrando a linha com o maior pivô
			int maxIndex = i;
			double maxValor = Math.abs(matriz[i][i] / escalas[i]);
			for (int k = i + 1; k < n; k++) {
				double ratio = Math.abs(matriz[k][i] / escalas[k]);
				if (ratio > maxValor) {
					maxValor = ratio;
					maxIndex = k;
				}
			}
			// Trocando as linhas
			if (maxIndex != i) {
				double[] temp = matriz[i];
				matriz[i] = matriz[maxIndex];
				matriz[maxIndex] = temp;
				double tempEscala = escalas[i];
				escalas[i] = escalas[maxIndex];
				escalas[maxIndex] = tempEscala;
			}
			// Eliminação
			for (int k = i + 1; k < n; k++) {
				double fator = matriz[k][i] / matriz[i][i];
				for (int j = i; j < n + 1; j++) {
					matriz[k][j] -= fator * matriz[i][j];
				}
			}
		}

		// Substituição regressiva
		for (int i = n - 1; i >= 0; i--) {
			double soma = 0.0;
			for (int j = i + 1; j < n; j++) {
				soma += matriz[i][j] * solucao[j];
			}
			solucao[i] = (matriz[i][n] - soma) / matriz[i][i];
		}

		System.out.println("Matriz com a eliminação:");
		imprimirMatriz(n, n+1);
		imprimirSoulucao(solucao);
	}

	// d) Eliminação de Gauss com pivotamento total
	public void gaussPivotamentoTotal(double[][] matriz) {
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];

		System.out.println("Matriz aumentada (n = "+n+"):");
		imprimirMatriz(n, n+1);
		
		// Fase de eliminação
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}

		for (int i = 0; i < n - 1; i++) {
			// Encontrando o maior elemento (pivô)
			double max = Math.abs(matriz[i][i]);
			int maxIndexI = i;
			int maxIndexJ = i;
			for (int j = i; j < n; j++) {
				for (int k = i; k < n; k++) {
					if (Math.abs(matriz[j][k]) > max) {
						max = Math.abs(matriz[j][k]);
						maxIndexI = j;
						maxIndexJ = k;
					}
				}
			}
			// Trocando linhas
			if (maxIndexI != i) {
				double[] temp = matriz[i];
				matriz[i] = matriz[maxIndexI];
				matriz[maxIndexI] = temp;
			}
			// Trocando colunas
			if (maxIndexJ != i) {
				for (int k = 0; k < n; k++) {
					double temp = matriz[k][i];
					matriz[k][i] = matriz[k][maxIndexJ];
					matriz[k][maxIndexJ] = temp;
				}
				int temp = p[i];
				p[i] = p[maxIndexJ];
				p[maxIndexJ] = temp;
			}
			// Eliminação
			for (int k = i + 1; k < n; k++) {
				double fator = matriz[k][i] / matriz[i][i];
				for (int j = i; j < n + 1; j++) {
					matriz[k][j] -= fator * matriz[i][j];
				}
			}
		}

		// Substituição regressiva
		for (int i = n - 1; i >= 0; i--) {
			double soma = 0.0;
			for (int j = i + 1; j < n; j++) {
				soma += matriz[i][j] * solucao[j];
			}
			solucao[i] = (matriz[i][n] - soma) / matriz[i][i];
		}

		// Reordenando a solução
		double[] solucaoReordenada = new double[n];
		for (int i = 0; i < n; i++) {
			solucaoReordenada[p[i]] = solucao[i];
		}

		System.out.println("Matriz com a eliminação:");
		imprimirMatriz(n, n+1);
		imprimirSoulucao(solucao);
	}
	
	// e) Método de Jacobi
	public double[] jacobi(double[][] matriz, double tolerancia, int iteracoesMax) {
        int n = matriz.length;
        this.matrizHilbert = matriz;
        double[] x = new double[n]; // vetor inicial
        double[] novoX = new double[n]; // vetor para armazenar as novas iterações
        
        System.out.println("Matriz aumentada (n = "+n+"):");
        imprimirMatriz(n, n+1);

        // Realiza iterações até convergir ou atingir o número máximo de iterações
        int iteracao = 0;
        while (iteracao < iteracoesMax) {
            for (int i = 0; i < n; i++) {
                double soma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        soma += matriz[i][j] * x[j];
                    }
                }
                novoX[i] = (matriz[i][n] - soma) / matriz[i][i];
            }

            // Verifica convergência pela norma máxima
            double erro = 0.0;
            for (int i = 0; i < n; i++) {
                double diff = Math.abs(novoX[i] - x[i]);
                if (diff > erro) {
                    erro = diff;
                }
            }
            if (erro < tolerancia) {
        		System.out.println("Matriz com a eliminação:");
        		imprimirMatriz(n, n+1);
        		imprimirSoulucao(novoX);
                return novoX; // retorna a solução se convergiu
            }

            // Atualiza vetor x
            x = Arrays.copyOf(novoX, n);
            iteracao++;
        }

        System.out.println("O método de Jacobi não convergiu após " + iteracoesMax + " iterações.");
        return null; // retorna null se não convergiu
    }

    // f) Método de Gauss-Seidel
	public double[] gaussSeidel(double[][] matriz, double tolerancia, int iteracoesMax) {
        int n = matriz.length;
        this.matrizHilbert = matriz;
        double[] x = new double[n]; // vetor inicial
        
        System.out.println("Matriz aumentada (n = "+n+"):");
        imprimirMatriz(n, n+1);

        // Realiza iterações até convergir ou atingir o número máximo de iterações
        int iteracao = 0;
        while (iteracao < iteracoesMax) {
            double erro = 0.0;
            for (int i = 0; i < n; i++) {
                double soma1 = 0.0;
                for (int j = 0; j < i; j++) {
                    soma1 += matriz[i][j] * x[j];
                }
                double soma2 = 0.0;
                for (int j = i + 1; j < n; j++) {
                    soma2 += matriz[i][j] * x[j];
                }
                double novoX = (matriz[i][n] - soma1 - soma2) / matriz[i][i];
                double diff = Math.abs(novoX - x[i]);
                if (diff > erro) {
                    erro = diff;
                }
                x[i] = novoX;
            }
            if (erro < tolerancia) {
        		System.out.println("Matriz com a eliminação:");
        		imprimirMatriz(n, n+1);
        		imprimirSoulucao(x);
                return x; // retorna a solução se convergiu
            }
            iteracao++;
        }

        System.out.println("O método de Gauss-Seidel não convergiu após " + iteracoesMax + " iterações.");
        return null; // retorna null se não convergiu
    }

    // g) Método de Sobre-relaxamento
	 public double[] sobreRelaxamento(double[][] matriz, double omega, double tolerancia, int iteracoesMax) {
	        int n = matriz.length;
	        this.matrizHilbert = matriz;
	        double[] x = new double[n]; // vetor inicial
	        
	        System.out.println("Matriz aumentada (n = "+n+"):");
	        imprimirMatriz(n, n+1);

	        // Realiza iterações até convergir ou atingir o número máximo de iterações
	        int iteracao = 0;
	        while (iteracao < iteracoesMax) {
	            double erro = 0.0;
	            for (int i = 0; i < n; i++) {
	                double soma1 = 0.0;
	                for (int j = 0; j < i; j++) {
	                    soma1 += matriz[i][j] * x[j];
	                }
	                double soma2 = 0.0;
	                for (int j = i + 1; j < n; j++) {
	                    soma2 += matriz[i][j] * x[j];
	                }
	                double novoX = (1 - omega) * x[i] + (omega / matriz[i][i]) * (matriz[i][n] - soma1 - soma2);
	                double diff = Math.abs(novoX - x[i]);
	                if (diff > erro) {
	                    erro = diff;
	                }
	                x[i] = novoX;
	            }
	            if (erro < tolerancia) {
	        		System.out.println("Matriz com a eliminação:");
	        		imprimirMatriz(n, n+1);
	        		imprimirSoulucao(x);
	                return x; // retorna a solução se convergiu
	            }
	            iteracao++;
	        }

	        System.out.println("O método de Sobre-relaxamento não convergiu após " + iteracoesMax + " iterações.");
	        return null; // retorna null se não convergiu
	    }

	private void imprimirMatriz(int i, int j) {
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

	private void imprimirSoulucao(double[] solucao) {
		System.out.println("Solução do sistema:");
		for (int n = 0; n < solucao.length; n++) {				
			System.out.println("x" + (n + 1) + " = " + solucao[n]);					

		}
	}
}
