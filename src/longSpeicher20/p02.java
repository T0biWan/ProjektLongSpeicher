package longSpeicher20;

import java.util.Scanner;

public class p02 {

	public static void main(String[] args) {
		//Variablen
//		Scanner scr = new Scanner(System.in);
//		String eingabe;
//		boolean bedingung = true;
//		
//		do {
//			System.out.print("Bitte j oder n\n:>");
//			eingabe = scr.nextLine();
//			
//			if(eingabe.equals("n") | eingabe.equals("j")) {
//				bedingung = false;
//			}
//			
//		} while(bedingung);
//		System.out.println("Wir haben es aus der Schleife geschafft!");
		int z�hler = 0;
		for(int i=0; i<5; i++) {
			System.out.println("+");
			for(int j=0; j<5; j++) {
				System.out.print("+");
				z�hler++;
			}
		}
		System.out.println(z�hler);
		
//		for(int j=0; j<5; j++) {
//			System.out.println(j);
//		}
	}

}
