package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reserva;
import excecoes.Excecoes;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Número do quarto : ");
			int numeroquarto = sc.nextInt();
			System.out.println("Data de chegada (dd/MM/yyyy) : ");
			Date chegada = sdf.parse(sc.next());
			System.out.println("Data de saida (dd/MM/yy) : ");
			Date saida = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroquarto, chegada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Digite dados para atualizar a reserva.");
			System.out.println("Data de chegada (dd/MM/yy) : ");
			chegada = sdf.parse(sc.next());
			System.out.println("Data de saída (dd/MM/yy) : ");
			saida = sdf.parse(sc.next());
			
			reserva.atualizardatas(chegada, saida);
			System.out.println("Reserva: " + reserva);
			
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido");
		}
        catch(Excecoes e) {
        	System.out.println("Erro na Reserva: " + e.getMessage());
		}
        catch(RuntimeException e) {
        	System.out.println("Erro inesperado");
		}
		
        sc.close();
	}

}
