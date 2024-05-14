package lista3;

import java.util.Arrays;

public class InversaoMatrizLU {

    // Função para realizar a decomposição LU de uma matriz sem pivotamento
    public static void decomposicaoLU(double[][] matriz, double[][] L, double[][] U) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            // Matriz L tem 1s na diagonal
            L[i][i] = 1;

            // Calcula elementos de U
            for (int k = i; k < n; k++) {
                double soma = 0;
                for (int j = 0; j < i; j++) {
                    soma += (L[i][j] * U[j][k]);
                }
                U[i][k] = matriz[i][k] - soma;
            }

            // Calcula elementos de L
            for (int k = i + 1; k < n; k++) {
                double soma = 0;
                for (int j = 0; j < i; j++) {
                    soma += (L[k][j] * U[j][i]);
                }
                L[k][i] = (matriz[k][i] - soma) / U[i][i];
            }
        }
    }

    // Função para resolver um sistema de equações lineares utilizando decomposição LU
    public static double[] resolverSistemaLU(double[][] L, double[][] U, double[] b) {
        int n = L.length;
        double[] y = new double[n];
        double[] x = new double[n];

        // Resolve Ly = b
        for (int i = 0; i < n; i++) {
            double soma = 0;
            for (int j = 0; j < i; j++) {
                soma += L[i][j] * y[j];
            }
            y[i] = b[i] - soma;
        }

        // Resolve Ux = y
        for (int i = n - 1; i >= 0; i--) {
            double soma = 0;
            for (int j = i + 1; j < n; j++) {
                soma += U[i][j] * x[j];
            }
            x[i] = (y[i] - soma) / U[i][i];
        }

        return x;
    }

    // Função para calcular a inversa de uma matriz utilizando decomposição LU
    public static double[][] calcularInversa(double[][] matriz) {
        int n = matriz.length;
        double[][] inversa = new double[n][n];
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        // Realiza a decomposição LU
        decomposicaoLU(matriz, L, U);

        // Calcula a inversa
        for (int i = 0; i < n; i++) {
            double[] b = new double[n];
            b[i] = 1; // Coluna da matriz identidade
            double[] colunaInversa = resolverSistemaLU(L, U, b);
            for (int j = 0; j < n; j++) {
                inversa[j][i] = colunaInversa[j];
            }
        }

        return inversa;
    }

    // Função para verificar se o produto de duas matrizes resulta na matriz identidade
    public static boolean verificaIdentidade(double[][] A, double[][] inversa) {
        int n = A.length;
        double[][] produto = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double soma = 0;
                for (int k = 0; k < n; k++) {
                    soma += A[i][k] * inversa[k][j];
                }
                produto[i][j] = soma;
            }
        }

        // Verifica se o produto é aproximadamente a matriz identidade
        double epsilon = 1e-6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    if (Math.abs(produto[i][j] - 1) > epsilon) {
                        return false;
                    }
                } else {
                    if (Math.abs(produto[i][j]) > epsilon) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Definição das matrizes A e B
        double[][] A = {
            {10, 2, -1},
            {-3, -6, 2},
            {1, 1, 5}
        };

        double[][] B = {
            {1, 4, 9, 16},
            {4, 9, 16, 25},
            {9, 16, 25, 36},
            {16, 25, 36, 49}
        };

        // Calcula as inversas das matrizes A e B
        double[][] inversaA = calcularInversa(A);
        double[][] inversaB = calcularInversa(B);
        
     // Imprime as inversas calculadas
        System.out.println("Inversa da matriz A:");
        for (double[] linha : inversaA) {
            System.out.println(Arrays.toString(linha));
        }

        System.out.println("\nInversa da matriz B:");
        for (double[] linha : inversaB) {
            System.out.println(Arrays.toString(linha));
        }

        // Verifica se o produto de A pela sua inversa é a matriz identidade
        boolean resultadoA = verificaIdentidade(A, inversaA);
        boolean resultadoB = verificaIdentidade(B, inversaB);

        // Imprime os resultados
        System.out.println("Resultado para A*A^-1 = I: " + resultadoA);
        System.out.println("Resultado para B*B^-1 = I: " + resultadoB);
    }
}