public class Ejercicio {

    private int n = 6;
    private int valorInicial = 5;

    private int[] primos = new int[n];
    private int[] fibonacci = new int[n];

    public void calcular() {
        iniciarFibonacci();
        iniciarPrimos();

        long f, p;
        double total = 0.0;

        int contador1 = 0;
        int contador2 = 1;

        int signo = 1;
        for (int i = 0; i < n; i++) {
            double resultado = 0.0;
            f = fibonacci[i];
            p = primos[i];
            p = factorial(p);

            //operacion 
            if (i % 2 == 0) {
                resultado = (double)f / (double)p;
            } else {
                resultado = (double)p / (double)f;
            }

            //controla el signo
            if (contador2 == contador1 && i < 0) {
                signo = signo * (-1);
                contador2++;
                contador1 = 0;
            } else {
                contador1++;
            }

            total = total + (resultado * signo);
            
        }
        
        System.out.println("TOTAL: " + total);
    }

    public long factorial(long numero) {
        long resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }

    public void iniciarFibonacci() {
        int f1 = 0;
        int f2 = 1;
        int i = 0;

        if (f1 >= valorInicial) {
            fibonacci[i++] = f1;
        }
        while (true) {
            if (i == n) {
                return;
            }
            if (f2 >= valorInicial) {
                fibonacci[i++] = f2;
            }

            f2 = f1 + f2;
            f1 = f2 - f1;
        }
    }

    public void iniciarPrimos() {
        int num = 0;
        int i = 1;
        do {
            if (esPrimo(i)) {
                if (i >= valorInicial) {
                    if (num == n) {
                        return;
                    }
                    primos[num++] = i;
                }
            }
            i++;
        } while (true);
    }

    public boolean esPrimo(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Ejercicio().calcular();
    }
