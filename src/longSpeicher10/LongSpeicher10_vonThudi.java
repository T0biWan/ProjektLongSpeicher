package longSpeicher10;
// Datei LongSpeicher10.java
/* ------------------------------------------------------------------------
Jedes Objekt der Klasse LongSpeicher10 ist ein Speicher, in dem man
long-Werte sammeln (einfuegen, entfernen, suchen) kann.
Doppelgaenger sind erlaubt.
---------------------------------------------------------------------------
Implementierung: Als unsortierte Reihung.
------------------------------------------------------------------------ */
import static java.lang.String.format;

import java.util.Arrays;

class LongSpeicher10_vonThudi extends AbstractLongSpeicher {
	// ---------------------------------------------------------------------
	// Zum Ein-/Ausschalten von Testbefehlen:
	static final boolean TST1 = true;
	// ---------------------------------------------------------------------
	private long[] speicher;
	private int lbi = -1; // letzter belegter Index

	public LongSpeicher10_vonThudi(int length) {
		speicher = new long[length];
	}

	// ---------------------------------------------------------------------
	private int index(long n) {
		// Liefert -1, wenn n nicht in diesem Speicher vorkommt.
		// Liefert sonst einen Index i, an dem ein n im Speicher steht
		// (d.h. fuer diesen Index i gilt: speicher[i] == n).

		for (int indexI = 0; indexI <=lbi; indexI++) {
			if (speicher[indexI] == n)
				return indexI;

		}

		return -1;
	}

	// ---------------------------------------------------------------------
	@Override
	public String toString() {
		// Liefert eine String-Darstellung dieses Speichers. Beispiele:
		// // Anzahl der long-Werte im Speicher:
		// "[]" // 0
		// "[10]" // 1
		// "[20, 30, 10]" // 3

		StringBuilder sb = new StringBuilder();
		if (lbi==-1) {
			return "[]";
		}

		else {
			sb.append("[" + speicher[0]);
			for (int index = 1; index <= lbi; index++) {
				sb.append(", " + speicher[index]);
			}
			return sb.toString() + "]";
		}
	}

	// ---------------------------------------------------------------------
	@Override
	public boolean fuegeEin(long n) {
		// Liefert false, falls dieser Speicher bereits voll ist.
		// Fuegt sonst n in diesen Speicher ein und liefert true.
		if (lbi + 1 == speicher.length)
			return false;
		else
			speicher[++lbi] = n;

		return true; 
	}

	// ---------------------------------------------------------------------
	public boolean loesche(long n) {
	// Entfernt ein n aus diesem Speicher, und liefert true.
	// Liefert false falls n in diesem Speicher nicht vorkommt.	
//	-GRUDE	
		
//***************************************************************************
//		Auch eine Möglichkeit
//		- wenn n im Speicher vorhanden, rücke alle Zahlen eine nach links im 
//		Array, setze n auf den letzten besetzten Array und lösche den letzten
//		besetzten index		
//***************************************************************************			
		// if (speicher[index(n)]==n){ Auch eine Möglichkeit
		//
		// for(int i=index(n); i < speicher[lbi]; i++) {
		// speicher[i]=speicher[i+1];
		// }
		//
		// speicher[lbi] = n;
		// --lbi;
		// return true;
		// }
		
//***************************************************************************
//		richtig: vertausche n mit lbi (Arraystelle) und lösche lbi
//***************************************************************************		
		//
		if (index(n)!=-1 && speicher[index(n)] == n) {
			speicher[index(n)] = speicher[lbi];
			--lbi;
			return true;
		}
		return false; 
	}

	// ---------------------------------------------------------------------
	@Override
	public boolean istDrin(long zahl) {
		// Liefert true wenn n in diesem Speicher vorkommt, und sonst false.
		// -GRUDE
		
/*beser*/return (index(zahl)!=-1 && speicher[index(zahl)]==zahl);

		// if (index(zahl) >= 0 && speicher[index(zahl)]==zahl && index(zahl)=!1)
		//return true;
		// return false; //
	}

	// ---------------------------------------------------------------------
	// Zum Testen:
	private void print(String name) {
		// Gibt name, speicher.length, lbi und alle long-Werte dieser
		// Sammlung (in 2 Zeilen) zur Standardausgabe aus:
		printf("%s.length: %d, lbi: %2d:%n", name, speicher.length, lbi);
		printf("%s.toString(): %s%n", name, this.toString());
	}

	// ---------------------------------------------------------------------
	static public void main(String[] sonja) {
		printf("LongSpeicher10: Jetzt geht es los!%n");
		printf("-----------------------------------%n");
		printf("Test Konstruktor und toString:%n%n");
		LongSpeicher10_vonThudi lsa = new LongSpeicher10_vonThudi(4);
		lsa.print("lsa");
		printf("-----------------------------------%n");
		printf("Positive Tests mit fuegeEin:%n%n");
		printf("lsa.fuegeEin(25): %b%n", lsa.fuegeEin(25));
		lsa.print("lsa");
		printf("lsa.fuegeEin(15): %b%n", lsa.fuegeEin(15));
		lsa.print("lsa");
		printf("lsa.fuegeEin(35): %b%n", lsa.fuegeEin(35));
		lsa.print("lsa");
		printf("-----------------------------------%n");
		
		System.out.println("fuegeEin()-TEST");
		System.out.println("-> ARRAY kann nur 4 Einträge haben ");
		System.out.println("-> LongSpeicher10 lsa = new LongSpeicher10(4); ");
		System.out.println("-> hat bereits 3 Einträge");
		System.out.println();
		printf("lsa.fuegeEin(88): %b%n", lsa.fuegeEin(88));
		lsa.print("lsa");
		System.out.println();
		printf("lsa.fuegeEin(15): %b%n", lsa.fuegeEin(15));
		lsa.print("lsa");
		System.out.println();
		
		printf("-----------------------------------%n");
		System.out.println("istDrin()-TEST");
		printf("lsa.istDrin(15): %b%n", lsa.istDrin(15));
		printf("lsa.istDrin(2): %b%n", lsa.istDrin(2));
		System.out.println();
		
		System.out.println("loesche()-TEST");
		printf("lsa.loesche(15): %b%n", lsa.loesche(15));
		printf("lsa.loesche(2): %b%n", lsa.loesche(2));
		System.out.println();
		
		System.out.println("index()-TEST");
		printf("index(35): %d%n", lsa.index(35));
		printf("index(0): %d%n", lsa.index(0));

		
  long[] r1 = {10, 20, 30};
  System.out.println(r1);
  System.out.println(Arrays.toString(r1));
		
		 //System.out.println(lsa.istDrin(3));
		// System.out.println(lsa.istDrin(15));
		// System.out.println(lsa.loesche(15));
		// System.out.println(lsa.istDrin(35)); /// erkennt false nicht
		// System.out.println(lsa.loesche(5)); // erkennt nicht an bei falschen
		// werten
		// lsa.print("lsa");
		// System.out.println(lsa.istDrin(1));

		// Hier sollen Sie weitere aehnliche Testbefehle eifuegen

		printf("-----------------------------------%n");
		printf("LongSpeicher10: Das war's erstmal!%n%n");
	} // main
		// ---------------------------------------------------------------------
} // class LongSpeicher10