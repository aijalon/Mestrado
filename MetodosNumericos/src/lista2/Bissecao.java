package lista2;

public class Bissecao {
	
	public void bissecao(int a, double xl, double xu) {
		double tolerancia = 0.00001;
		double erroAbsoluto = 100;
		double x = 0;
		double xold = 0;
		double fx = 0;
		double fl = 0;
		int i = 0;
		
		fl = funcao(xl, a);

		while(erroAbsoluto>tolerancia) {
			xold=x;
			x=(xl+xu)/2;
			fx = funcao(x, a);
			i++;
			if(x!=0) {
				erroAbsoluto = Math.abs(((x-xold)/x)*100);
			}
			
			if(fl*fx<0) {
				xu = x;
			}else {
				xl = x;
				fl = fx;
			}
			
			System.out.println("x:"+x);
			System.out.println("Fx:"+fx);
			System.out.println("Erro Absoluto:"+erroAbsoluto);			
			System.out.println(i);
			fl = funcao(xl, a);
		}
		
		
	}

	public double funcao(double x, int a) {
		return x/a - Math.tan(x*a);
	}
}
