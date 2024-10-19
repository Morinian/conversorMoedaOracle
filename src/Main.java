import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner cmd = new Scanner(System.in);
        Integer escolha, i = 0;
        Double valor;

        String de = "a";
        String para = "b";

        while(i == 0){

            System.out.println("-------------------------------------------");
            System.out.println("Bem vindo ao programa!");
            System.out.println("1) dolar americano -> peso chileno");
            System.out.println("2) peso chileno -> dolar americano");
            System.out.println("3) dolar americano -> real brasileiro");
            System.out.println("4) real brasileiro -> dolar americano");
            System.out.println("5) dolar australiano -> iene");
            System.out.println("6) iene -> dolar australiano");
            System.out.println("7) Sair");
            System.out.println("-------------------------------------------");

            System.out.println("Qual opção você escolherá:");
            escolha = cmd.nextInt();

            switch (escolha) {

                case 1:
                    de = "USD";
                    para = "CLP";
                    break;

                case 2:
                    de = "CLP";
                    para = "USD";
                    break;

                case 3:
                    de = "USD";
                    para = "BRL";
                    break;

                case 4:
                    de = "BRL";
                    para = "USD";
                    break;

                case 5:
                    de = "AUD";
                    para = "JPY";
                    break;

                case 6:
                    de = "JPY";
                    para = "AUD";
                    break;

                case 7:
                    i = 1;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 7.");
                    break;
            }

            System.out.println("Quanto você converterá?:");
            valor = cmd.nextDouble();

            System.out.println("Valor: " + valor + "["+de+"] ---> Valor: " + ChamadaAPI.Chamada(de,para,valor) + "["+para+"]");
        }
    }
}