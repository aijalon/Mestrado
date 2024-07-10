package desafio;

import projetoI.MatrizHilbert;

public class PivoteamentoCompleto {

	private double[][] matriz;
	private double[][] matrizCopia;
	private int[][] matrizPermutacao;
	private int i;
	private int j;
	private double[][] trocaLinhas;
	private double[][] trocaColunas;
	private int[][] trocaColunaMatrizPermutacao;
	private double[] primeiraLinha;
	private double pivo;
	private int linhaPivo = 0;
	private int colunaPivo = 0;
	private MatrizHilbert hilbert;

	public PivoteamentoCompleto(int i, int j) {
		this.i = i;
		this.j = j;
		this.matriz = new double[i][j];
		this.matrizCopia = new double[i][j];
		this.matrizPermutacao = new int[i][j];
		this.trocaLinhas = new double[2][j];
		this.trocaColunas = new double[i][2];
		this.trocaColunaMatrizPermutacao = new int[i][2];
		this.primeiraLinha = new double[j];

		matrizPermutacao();
		hilbert = new MatrizHilbert(i);
		matriz = hilbert.matrizHilbert();

//		Scanner entrada = new Scanner(System.in);
//
//		//		for(int ai = 0; ai<this.i; ai++) {
//		//			for(int aj = 0; aj<this.j; aj++) {
//		//				System.out.println("Informe o elemento a"+(ai+1)+(aj+1)+": ");
//		//
//		//				matriz[ai][aj] = entrada.nextDouble();
//		//			}
//		//		}
//		entrada.close();
//		this.matriz[0][0]= -2;
//		this.matriz[0][1]= 3;
//		this.matriz[0][2]= 1;
//		this.matriz[0][3]= -5;
//
//		this.matriz[1][0]= 2;
//		this.matriz[1][1]= -3;
//		this.matriz[1][2]= -2;
//		this.matriz[1][3]= -1;
//
//		this.matriz[2][0]= 4; //0
//		this.matriz[2][1]= 10;
//		this.matriz[2][2]= -6; //-5
//		this.matriz[2][3]= 2;

	}


	private void verificaSolucao() {
		if(i==j-1) {
			System.out.println("Sistema Solúvel e Determinado (SSD): o sistema têm\n"
					+ "uma única solução, o número de equações linearmente\n"
					+ "independentes é igual ao número de incógnitas (n=m)\n");
		}else if(i<j-1) {
			System.out.println("Sistema Solúvel e Indeterminado (SSI): o sistema\n"
					+ "tem infinitas soluções, o número de equções\n"
					+ "linearmente independentes é menor que o número de\n"
					+ "incógnitas (n<m)");
		}else {
			System.out.println("Sistema Insolúvel (SI): o sistema não tem solução, o\n"
					+ "número de equações LI é maior que o número de\n"
					+ "incógnitas (n>m)");
		}
	}

	public void eliminacaoGauss() {
		verificaSolucao();
		if(i==j-1) {
			double m = 0;
			sair:
				for(int k = 0; k<this.i-1; k++) {
					encontrarPivo(k);
					for(int i = k; i<this.i-1; i++) {

						for(int j = 0; j<this.j; j++) {
							if(i+1>this.i || j+1>this.j) {
								m = this.matrizCopia[i][k]/pivo;
								this.matriz[i][j] = (this.matrizCopia[i][j]-m*this.primeiraLinha[j]);
							}else {
								m = this.matrizCopia[i+1][k]/pivo;
								this.matriz[i+1][j+k] = (this.matrizCopia[i+1][j]-m*this.primeiraLinha[j]);
							}

							if (triangularSuperior()) {
								copiarMatriz();
								System.out.println("A matriz está triangular superior.");
								for(int n = 1; n<=2; n++) {
									this.matriz[i+1][j+k+n] = (this.matrizCopia[i+1][j+k+n]-m*this.primeiraLinha[j+k+n]);
								}

								imprimir();
								break sair;
							}
						}
					}

				}
			subtituicaoRegressiva();
		}
	}

	private void subtituicaoRegressiva() {
		double[] solucao = new double[this.i];

		for (int linha = this.i - 1; linha >= 0; linha--) {
			double soma = 0.0;
			for (int coluna = linha + 1; coluna < this.j - 1; coluna++) {
				soma += this.matriz[linha][coluna] * solucao[coluna];
			}
			solucao[linha] = (this.matriz[linha][this.j - 1] - soma) / this.matriz[linha][linha];
		}

		// Exibe a solução
		System.out.println("Solução do sistema:");
		for (int n = 0; n < this.i; n++) {
			for(int k = 0; k < this.j-1; k++) {
				if(this.matrizPermutacao[n][k]==1) {
					System.out.println("x" + (n + 1) + " = " + solucao[k]);					
				}
			}
			
		}

	}

	private boolean triangularSuperior() {
		for (int linha = 0; linha < this.i; linha++) {
			for (int coluna = 0; coluna < this.j; coluna++) {
				// Se estiver abaixo da diagonal principal e diferente de zero
				if (coluna < linha && Math.abs(this.matriz[linha][coluna]) > 1e-10) {
					return false;
				}
			}
		}
		return true;
	}

	private void imprimir() {
		for(int ai = 0; ai<this.i; ai++) {
			for(int aj = 0; aj<this.j; aj++) {
				if(aj==0) {
					System.out.print("| ");
				}

				System.out.print(this.matriz[ai][aj]+" ");

				if(aj==this.j-1) {
					System.out.println("|\n");
				}
			}
		}		
	}	

	private void encontrarPivo(int iteracao) {
		this.pivo = this.matriz[iteracao][iteracao];

		for(int i=iteracao; i<this.i; i++) {
			for(int j=iteracao; j<this.j-1; j++) {
				if(Math.abs(pivo)<Math.abs(this.matriz[i][j])) {
					pivo =this.matriz[i][j];
					this.linhaPivo = i;
					this.colunaPivo = j;
				}
			}
		}

		selecionaLinhas(iteracao);
		trocaLinha(iteracao);
		selecionaColuna(iteracao);
		trocaColuna(iteracao);
		guardaPrimeiraLinha(iteracao);
		copiarMatriz();
	}


	private void copiarMatriz() {
		for (int i = 0; i < this.i; i++) {
			for (int j = 0; j < this.j; j++) {
				this.matrizCopia[i][j] = this.matriz[i][j];
			}
		}

	}

	private void matrizPermutacao() {
		for(int i = 0; i<this.i; i++) {
			for(int j = 0; j<this.j; j++) {
				if(i==j) {
					this.matrizPermutacao[i][j] = 1;								
				}else {
					this.matrizPermutacao[i][j] = 0;								
				}			
			}
		}

	}


	private void guardaPrimeiraLinha(int iteracao) {
		for(int i = 0; i<this.primeiraLinha.length; i++) {
			this.primeiraLinha[i] = this.matriz[iteracao][i];
		}

	}

	private void selecionaLinhas(int linha) {
		for(int k = 0; k<this.j; k++) {

			this.trocaLinhas[0][k] = this.matriz[linhaPivo][k];
			this.trocaLinhas[1][k] = this.matriz[linha][k];
		}
	}

	private void trocaLinha(int linha) {
		for(int k = 0;k<this.j; k++ ) {
			this.matriz[linha][k] = this.trocaLinhas[0][k];
			this.matriz[this.linhaPivo][k] = this.trocaLinhas[1][k];
		}
	}

	private void selecionaColuna(int iteracao) {
		for(int k = 0; k<this.i; k++) {
			this.trocaColunas[k][0] = this.matriz[k][this.colunaPivo];
			this.trocaColunas[k][1] = this.matriz[k][iteracao];
			
			this.trocaColunaMatrizPermutacao[k][0] = this.matrizPermutacao[k][this.colunaPivo];
			this.trocaColunaMatrizPermutacao[k][1] = this.matrizPermutacao[k][iteracao];			
		}
	}

	private void trocaColuna(int iteracao) {
		for(int k = 0; k<this.i; k++) {
			this.matriz[k][iteracao] = this.trocaColunas[k][0];
			this.matriz[k][this.colunaPivo] = this.trocaColunas[k][1];
			
			this.matrizPermutacao[k][iteracao] = this.trocaColunaMatrizPermutacao[k][0];
			this.matrizPermutacao[k][this.colunaPivo] = this.trocaColunaMatrizPermutacao[k][1];			
		}

	}
}
