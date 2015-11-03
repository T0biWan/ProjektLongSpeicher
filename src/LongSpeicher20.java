

// Datei LongSpeicher20.java
/* ------------------------------------------------------------------------
 Jedes Objekt der Klasse LongSpeicher20 ist ein Speicher, in dem man
 long-Werte sammeln (einfuegen, entfernen, suchen) kann.
 Doppelgaenger sind erlaubt.
 ---------------------------------------------------------------------------
 Implementierung: Als sortierte Reihung.
 ------------------------------------------------------------------------ */

import java.util.Arrays;

class LongSpeicher20 extends AbstractLongSpeicher {
	// ---------------------------------------------------------------------
	// Zum Ein-/Ausschalten von Testbefehlen:
	static final boolean TST1 = true;
	// ---------------------------------------------------------------------
	private long[] speicher;
	private int lbi = -1; // letzter belegter Index

	public LongSpeicher20(int length) {
		speicher = new long[length];
		
		/********************************************************************
		 * TESTKONSTRUKTOR
		for (int index = 0; index < length; index++)
		speicher[index] = 10 * (index + 1);
		lbi = length-1;
		********************************************************************/
	}

	// ---------------------------------------------------------------------
	private int index(long n) {

		// Liefert (wenn moeglich) einen Index i, an dem ein n im speicher
		// steht (d.h. fuer den gilt: speicher[i] == n).
		// Falls n nicht im speicher steht, wird der Index geliefert, an dem
		// n eingefuegt werden sollte (falls man es einfuegen moechte).
		// Achtung:
		// Das Ergebnis von index ist moeglicherweise gleich speicher.length
		// (und somit kein Index von speicher), und zwar wenn
		// 1. der speicher voll ist (d.h. lbi == speicher.length-1 gilt) und
		// 2. n groesser ist als alle long-Werte in diesem Speicher.

		int von = 0;
		int bis = lbi;

		while (von <= bis) {
			int mitte = von + (bis - von) / 2;

			if (gt(n, speicher[mitte])) {
				von = mitte + 1;
			}

			else if (lt(n, speicher[mitte])) {
				bis = mitte - 1;
			}

			else {
				return mitte;
			}// hier gilt: eq(n, speicher[mitte])

		}//hier endet WHILESCHLEIFE

		return von; // n steht nicht im speicher
	}

	// ---------------------------------------------------------------------
	@Override
	public String toString() {
		// Liefert eine String-Darstellung dieses Speichers. Beispiele:
		// // Anzahl der long-Werte im Speicher:
		// "[]" // 0
		// "[10]" // 1
		// "[20, 30, 10]" // 3

		if (lbi == -1) return "[]";

		StringBuilder sb = new StringBuilder("[" + speicher[0]);
		for (int index = 1; index <= lbi; index++) {
			sb.append(", " + speicher[index]);
		}
		return sb.toString() + "]";

	}

	// ---------------------------------------------------------------------
	@Override
	public boolean fuegeEin(long n) {
		//		// Liefert false, falls dieser Speicher bereits voll ist.
		//		// Fuegt sonst n in diesen Speicher ein und liefert true.
		

		int index = index(n);
				
		if (lbi + 1 == speicher.length) { return false; }


		for (int i = lbi+1; i> index; i--) {
			speicher[i] = speicher[i-1];

		}

		speicher[index] = n;
		lbi++;
		return true;

	}

	// ---------------------------------------------------------------------
	@Override
	public boolean loesche(long n) {
		// Entfernt ein n aus diesem Speicher, und liefert true.
		// Liefert false falls n in diesem Speicher nicht vorkommt.	
	
	
		 if (!istDrin(n)){ return false;}
		
		 for(int i=index(n); i < lbi; i++) {
		 speicher[i]=speicher[i+1];
		 }
		
		 speicher[lbi--] = n;
		 return true;

	}

	// ---------------------------------------------------------------------
	@Override
	public boolean istDrin(long zahl) {
		// Liefert true wenn n in diesem Speicher vorkommt, und sonst false.
	
		int einsetzen = index(zahl);

		return (einsetzen < lbi + 1 && speicher[einsetzen] == zahl);

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
		printf("LongSpeicher20: Jetzt geht es los!%n");
		printf("-----------------------------------%n");
		printf("Test Konstruktor und toString:%n%n");

		printf("LongSpeicher10: Jetzt geht es los!%n");
		printf("-----------------------------------%n");
		printf("Test Konstruktor und toString:%n%n");
		printf("LongSpeicher20 lsa = new LongSpeicher20(4);");
		System.out.println();
		LongSpeicher20 lsa = new LongSpeicher20(4);
		lsa.print("lsa");
		printf("-----------------------------------%n");
		printf("Positive Tests mit fuegeEin:%n%n");
		printf("lsa.fuegeEin(15): %b%n", lsa.fuegeEin(15));
		lsa.print("lsa");
		printf("lsa.fuegeEin(10): %b%n", lsa.fuegeEin(10));
		lsa.print("lsa");
		printf("lsa.fuegeEin(5): %b%n", lsa.fuegeEin(5));
		lsa.print("lsa");
		printf("lsa.fuegeEin(3): %b%n", lsa.fuegeEin(3));
		lsa.print("lsa");
		printf("-----------------------------------%n");
		
		System.out.println("fuegeEin()-TEST NEGATIV");
		System.out.println("-> ARRAY kann nur 4 Einträge haben ");
		System.out.println("-> LongSpeicher20 lsa = new LongSpeicher20(4); ");
		System.out.println("-> hat bereits 4 Einträge");
		System.out.println();
		printf("lsa.fuegeEin(20): %b%n", lsa.fuegeEin(20));
		lsa.print("lsa");
		System.out.println();
		printf("lsa.fuegeEin(25): %b%n", lsa.fuegeEin(25));
		lsa.print("lsa");
		System.out.println();
		
		printf("-----------------------------------%n");
		System.out.println("istDrin()-TEST-POSITIV");
		printf("lsa.istDrin(5): %b%n", lsa.istDrin(5));
		printf("lsa.istDrin(10): %b%n", lsa.istDrin(10));
		System.out.println();
			
		System.out.println("istDrin()-TEST-NEGATIV");
		printf("lsa.istDrin(33): %b%n", lsa.istDrin(33));
		printf("lsa.istDrin(14): %b%n", lsa.istDrin(14));
		System.out.println();
			
		printf("-----------------------------------%n");
		System.out.println("loesche()-TEST-POSITIV");
		lsa.print("lsa");
		printf("lsa.loesche(5): %b%n", lsa.loesche(5));
		lsa.print("lsa");
		printf("lsa.loesche(10): %b%n", lsa.loesche(10));
		lsa.print("lsa");
		printf("lsa.loesche(15): %b%n", lsa.loesche(15));
		lsa.print("lsa");
		System.out.println();
				
		System.out.println("loesche()-TEST NEGATIV");
		printf("lsa.loesche(15): %b%n", lsa.loesche(15));
		printf("lsa.loesche(2): %b%n", lsa.loesche(2));
		System.out.println();
		
		printf("-----------------------------------%n");
		printf("LongSpeicher20: Das war's erstmal!%n%n");
	} // main
		// ---------------------------------------------------------------------
} // class LongSpeicher10