import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------\n"
                + "Gerenciamento de Entrada/Saída" + "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Digite o intervalo de blocos no disco." + "\nDigite o valor minimo: ");
        int minimo = ler.nextInt();

        System.out.print("Digite o valor maximo: ");
        int maximo = ler.nextInt();

        Memoria memoria = new Memoria(minimo, maximo);

        System.out.printf("Informe a quantidade de blocos a serem visitados [%d,%d]: ", 1, maximo - minimo + 1);
        int qtdReqBlocos = ler.nextInt();

        while ((qtdReqBlocos < 1) || (qtdReqBlocos > maximo - minimo)) {
            System.out.printf("Voce precisa informar um número entre %d e %d.\n", 1, maximo - minimo + 1);
            System.out.printf("Informe a quantidade de blocos a serem visitados {Valor = [%d,%d]:} ", 1, maximo - minimo + 1);
            qtdReqBlocos = ler.nextInt();
        }

        ArrayList<Integer> reqBlocos = new ArrayList<>();

        int endBloco;

        for (int i = 0; i < qtdReqBlocos; i++) {
            System.out.printf("Informe os blocos a serem visitados {Indice do bloco = [%d,%d]}: ", minimo, maximo);
            endBloco = ler.nextInt();

            while ((endBloco < minimo) || (endBloco > maximo)) {
                System.out.printf("Voce precisa informar um número entre %d e %d.\n", minimo, maximo);
                System.out.printf("Informe os blocos a serem visitados {Indice do bloco = [%d,%d]}: ", minimo, maximo);
                endBloco = ler.nextInt();
            }

            endBloco = endBloco - minimo;
            reqBlocos.add(endBloco);

        }

        Collections.sort(reqBlocos);

        CSCAN cscan = new CSCAN(memoria, reqBlocos);

        cscan.escalonar();

        ler.close();

    }

    public static void delay(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}