public class Lista2 {
    double tolerancia = 0.00001;
    double erroAbsoluto = 100;
    double x = 0.1;
    double xold = 0;
    double fx = 0;
    double fl = 0;
    double fu = 0;
    int i = 0;

    public void bissecao(int a, int i, double xl, double xu) {

        fl = funcao(xl, a);

        while(erroAbsoluto>tolerancia && this.i<i) {
            xold=x;
            x=(xl+xu)/2;
            fx = funcao(x, a);
            this.i++;
            if(x!=0) {
                erroAbsoluto = erroAbsoluto();
            }

            if(fl*fx<0) {
                xu = x;
            }else {
                xl = x;
                fl = fx;
            }

            imprimir();

        }
        resetarVariaveis();
    }

    public void falsaPosicao(int a, int i, double xl, double xu) {

        fl = funcao(xl, a);
        fu = funcao(xu, a);

        if(Math.abs(fl)<Math.abs(fu)) {
            x = xl;
        }else {
            x = xu;
        }

        while(erroAbsoluto > tolerancia && this.i<i) {
            xold = x;
            this.i++;
            x = xu + (fu*(xl-xu))/(fu-fl);
            fx = funcao(x, a);

            if(x!=0) {
                erroAbsoluto = erroAbsoluto();
            }

            if(Math.abs(fl)<Math.abs(fu)) {
                xl = x;
                fl = funcao(x, a);
            }else {
                xu = x;
                fu = funcao(x, a);
            }

            imprimir();
        }
        resetarVariaveis();
    }

    public void pontoFixo(int a, int i) {
        x=3;

        while(erroAbsoluto>tolerancia && this.i<i) {
            xold = x;
            this.i++;
            x = funcaoPontoFixo(xold);
            if(x!=0) {
                erroAbsoluto = erroAbsoluto();
            }
            imprimirPontoFixo();
        }

        resetarVariaveis();
    }

    public void newtonRaphson(int a, int i) {
        x++;
        while(erroAbsoluto>tolerancia && this.i<i) {
            xold = x;
            this.i++;
            x = xold - funcao(xold, a)/funcaoDerivada(xold, a);
            fx = funcao(x, a);
            if(x!=0) {
                erroAbsoluto = erroAbsoluto();
            }
            imprimir();
        }

        resetarVariaveis();
    }

    public void secante(int a, int i, double xl, double xu) {
        while(erroAbsoluto>tolerancia && this.i<i) {
            this.i++;
            fl = funcao(xl, a);
            fu = funcao(xu, a);
            x = xu - fu*(xl-xu)/(fl-fu);
            fx = funcao(x, a);
            if (x!=0) {
                erroAbsoluto = Math.abs(((x-xu)/x)*100);
            }

            xl = xu;
            xu = x;

            imprimir();
        }

        resetarVariaveis();
    }


    private double funcao(double x, int a) {
        return x/a - Math.tan(x*a);
    }

    private double funcaoPontoFixo(double x) {
        return x+(x*x*x)+(x*x)-2;
    }

    @SuppressWarnings("unused")
    private double funcaoG(double x, int a) {
        return a*a*Math.tan(x);
    }

    private double funcaoDerivada(double x, int a) {
        return 1/a - 1*a* Math.sqrt(1/Math.cos(a*x));
    }

    private void resetarVariaveis() {
        tolerancia = 0.00001;
        erroAbsoluto = 100;
        x = 0;
        xold = 0;
        fx = 0;
        fl = 0;
        fu = 0;
        i = 0;
    }

    private double erroAbsoluto() {
        return Math.abs(((x-xold)/x)*100);
    }

    private void imprimir() {
        System.out.println(this.i);
        System.out.println("x:"+x);
        System.out.println("Fx:"+fx);
        System.out.println("Erro Absoluto:"+erroAbsoluto);
    }

    private void imprimirPontoFixo() {
        System.out.println(this.i);
        System.out.println("x:"+xold);
        System.out.println("Fx:"+x);
        System.out.println("Erro Absoluto:"+erroAbsoluto);
    }

    public void vericarExistenciaRaiz(int a) {
        double inicio = 0;
        double fim = 0.1;
        int raizesPositivas = 0;
        double[][] raizes = new double[5][2];
        int j = 0;

        while(raizesPositivas<5) {
            fl = funcao(inicio, a);
            fu = funcao(fim, a);
            if(fl*fu<0) {
                raizes[raizesPositivas][j] = inicio;
                raizes[raizesPositivas][j+1] = fim;
                raizesPositivas++;
            }
            inicio=inicio+0.1;
            fim=fim+0.1;
        }

        for(int i=0; i<raizes.length; i++) {
            System.out.println("xl: "+raizes[i][0]+" xu: "+raizes[i][1]);
        }

        resetarVariaveis();
    }

}
