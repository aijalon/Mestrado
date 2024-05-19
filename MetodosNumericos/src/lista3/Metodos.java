package lista3;

import java.util.Arrays;

public class Metodos {

	double[][] matrizCopia;
	double[][] matrizHilbert;
	int i = 0;
	int j = 0;
	String resultado = "";
	StringBuilder sb = new StringBuilder();



	// a) Eliminação de Gauss com substituição regressiva
	public void gaussEliminacao(double[][] matriz) {
		sb.setLength(0);

		this.i = matriz.length;
		this.j = matriz.length+1;

		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];

		sb.append("Matriz aumentada (n = "+n+"): \n \n");
		gerarMatriz();
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
		sb.append("Matriz com a eliminação: \n \n");
		imprimirTudo(n, n+1, solucao);

	}

	// b) Eliminação de Gauss com pivotamento parcial
	public void gaussPivotamentoParcial(double[][] matriz) {
		sb.setLength(0);
		
		this.i = matriz.length;
		this.j = matriz.length+1;
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];


		sb.append("Matriz aumentada (n = "+n+"): \n \n");
		gerarMatriz();
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

		sb.append("Matriz com a eliminação: \n \n");
		imprimirTudo(n, n+1, solucao);

	}

	// c) Eliminação de Gauss com pivotamento parcial com escala
	public void gaussPivotamentoParcialComEscala(double[][] matriz) {
		sb.setLength(0);
		
		this.i = matriz.length;
		this.j = matriz.length+1;
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];

		sb.append("Matriz aumentada (n = "+n+"): \n \n");
		gerarMatriz();

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

		sb.append("Matriz com a eliminação: \n \n");
		imprimirTudo(n, n+1, solucao);
	}

	// d) Eliminação de Gauss com pivotamento total
	public void gaussPivotamentoTotal(double[][] matriz) {
		sb.setLength(0);
		
		this.i = matriz.length;
		this.j = matriz.length+1;
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] solucao = new double[n];

	    int[] p = new int[n];
	    for (int i = 0; i < n; i++) {
	        p[i] = i;
	    }

	    // Fase de eliminação
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
	            matriz[k][i] = 0; // Para evitar pequenos erros numéricos
	            for (int j = i + 1; j < n + 1; j++) {
	                matriz[k][j] -= fator * matriz[i][j];
	            }
	        }
	    }

	    // Substituição retroativa
	    for (int i = n - 1; i >= 0; i--) {
	        solucao[i] = matriz[i][n];
	        for (int j = i + 1; j < n; j++) {
	            solucao[i] -= matriz[i][j] * solucao[j];
	        }
	        solucao[i] /= matriz[i][i];
	    }

	    // Reordenar a solução de acordo com a permutação de colunas
	    double[] solucaoOrdenada = new double[n];
	    for (int i = 0; i < n; i++) {
	        solucaoOrdenada[p[i]] = solucao[i];
	    }

	    // Exibir a solução
	    System.out.println("Soluções:");
	    for (int i = 0; i < n; i++) {
	        System.out.printf("x%d = %.10f%n", i + 1, solucaoOrdenada[i]);
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

		sb.append("Matriz com a eliminação: \n \n");
		imprimirTudo(n, n+1, solucao);
	}

	// e) Método de Jacobi
	public boolean jacobi(double[][] matriz, double tolerancia, int iteracoesMax) {
		sb.setLength(0);
		
		this.i = matriz.length;
		this.j = matriz.length+1;
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] x = new double[n]; // vetor inicial
		double[] novoX = new double[n]; // vetor para armazenar as novas iterações

		sb.append("Matriz aumentada (n = "+n+"): \n \n");
		gerarMatriz();

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
				imprimirSolucao(novoX);
				this.resultado = sb.toString();
				return true; // retorna a soluções se convergiu
			}

			// Atualiza vetor x
			x = Arrays.copyOf(novoX, n);
			iteracao++;
		}

		sb.append("O método de Jacobi não convergiu após " + iteracoesMax + " iterações. \n \n");
		imprimirSolucao(novoX);
		this.resultado = sb.toString();
		return false; // retorna null se não convergiu
	}

	// f) Método de Gauss-Seidel
	public boolean gaussSeidel(double[][] matriz, double tolerancia, int iteracoesMax) {
		sb.setLength(0);
		
		this.i = matriz.length;
		this.j = matriz.length+1;
		
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] x = new double[n]; // vetor inicial

		sb.append("Matriz aumentada (n = "+n+"): \n \n");
		gerarMatriz();

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
				imprimirSolucao(x);
				this.resultado = sb.toString();
				return true; // retorna a solução se convergiu
			}
			iteracao++;
		}

		sb.append("O método de Gauss-Seidel não convergiu após " + iteracoesMax + " iterações. \n \n");
		imprimirSolucao(x);
		this.resultado = sb.toString();
		return false; // retorna null se não convergiu
	}

	// g) Método de Sobre-relaxamento
	public boolean sobreRelaxamento(double[][] matriz, double omega, double tolerancia, int iteracoesMax) {
		sb.setLength(0);
		
		this.i = matriz.length;
		this.j = matriz.length+1;
		int n = matriz.length;
		this.matrizHilbert = matriz;
		double[] x = new double[n]; // vetor inicial

		sb.append("Matriz aumentada (n = "+n+"): \n \n");
		gerarMatriz();

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
				sb.append("Matriz com a eliminação: \n \n");
				imprimirTudo(n, n+1, x);
				return true; // retorna a solução se convergiu
			}
			iteracao++;
		}

		sb.append("O método de Sobre-relaxamento não convergiu após " + iteracoesMax + " iterações. \n \n" );
		imprimirTudo(n, n+1, x);
		return false; // retorna null se não convergiu
	}

	public void imprimirTudo(int i, int j, double[] solucao) {
		gerarMatriz();
		imprimirSolucao(solucao);
		this.resultado = sb.toString();
	}

	public void gerarMatriz() {
		for (int ai = 0; ai < i; ai++) {
			for (int aj = 0; aj < j; aj++) {
				if (aj == 0) {
					sb.append("[ ");
				}

				sb.append(this.matrizHilbert[ai][aj]).append(" ");

				if (aj == j - 1) {
					sb.append("]\n");
				}
			}
		}
		sb.append("\n");
	}
	
	public void imprimirSolucao(double[] solucao) {
		sb.append("Solução do sistema:\n \n");
		for (int n = 0; n < solucao.length; n++) {
			sb.append("x").append(n + 1).append(" = ").append(solucao[n]).append("\n");
		}
	}

	public String texto() {
		return resultado;
	}
}
