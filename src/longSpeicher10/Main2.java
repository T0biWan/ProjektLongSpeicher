package longSpeicher10;

public class Main2 {
	public static void main(String[] args) {
		P01 projekt = new P01();
	
		System.out.println("toString: "+ projekt.toString());
		System.out.println("----------------------------------------------");
		System.out.println("fuegeEin: "+ projekt.fuegeEin(1));
		System.out.println("fuegeEin: "+ projekt.fuegeEin(2));
		System.out.println("fuegeEin: "+ projekt.fuegeEin(3));
		System.out.println("----------------------------------------------");
		System.out.println("toString: "+ projekt.toString());
		System.out.println("----------------------------------------------");
		System.out.println("loesche: "+ projekt.loescheThudi(2));
		System.out.println("----------------------------------------------");
		System.out.println("toString: "+ projekt.toString());
		System.out.println("----------------------------------------------");
		System.out.println("fuegeEin: "+ projekt.fuegeEin(2));
		System.out.println("----------------------------------------------");
		System.out.println("toString: "+ projekt.toString());
		
	}
}
