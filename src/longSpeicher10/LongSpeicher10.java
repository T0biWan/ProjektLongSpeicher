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
	
	class LongSpeicher10 extends AbstractLongSpeicher {
	   // ---------------------------------------------------------------------
	   // Zum Ein-/Ausschalten von Testbefehlen:
	   static final boolean TST1 = true;
	   // ---------------------------------------------------------------------
	   private long[] speicher;
	   private int    lbi = -1; // letzter belegter Index
	
	   public LongSpeicher10(int length) {
	      speicher = new long[length];
	   }
	   // ---------------------------------------------------------------------
	   private int index(long n) {
		   //Was wenn eine Zahl doppelt im Speicher ist,
		   //dann wird nur der erste index erfasst?
			for(int i = 0; i < speicher.length; i++) {
				if(speicher[i] == n) return i;
			}
			return -1;
	   }
	   // ---------------------------------------------------------------------
	   @Override
	   public String toString() {
	      // Liefert eine String-Darstellung dieses Speichers. Beispiele:
	      //                    // Anzahl der long-Werte im Speicher:
	      // "[]"               //  0
	      // "[10]"             //  1
	      // "[20, 30, 10]"     //  3
	
	      return "Noch nicht implementiert!"; // MUSS ERSETZT WERDEN
	   }
	   // ---------------------------------------------------------------------
	   @Override
	   public boolean fuegeEin(long n) {
	      // Liefert false, falls dieser Speicher bereits voll ist.
	      // Fuegt sonst n in diesen Speicher ein und liefert true.
	
	      return false; // MUSS ERSETZT WERDEN
	   }
	   // ---------------------------------------------------------------------
	   @Override
	   public boolean loesche(long n) {
	      // Entfernt ein n aus diesem Speicher, und liefert true.
	      // Liefert false falls n in diesem Speicher nicht vorkommt.
	
	      return false; // MUSS ERSETZT WERDEN
	   }
	   // ---------------------------------------------------------------------
	   @Override
	   public boolean istDrin(long n) {
	      // Liefert true wenn n in diesem Speicher vorkommt, und sonst false.
	
	      return false; // MUSS ERSETZT WERDEN
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
	      LongSpeicher10 lsa = new LongSpeicher10(4);
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
	      // Hier sollen Sie weitere aehnliche Testbefehle eifuegen
	      printf("lsa.index(25): %d%n", lsa.index(25));
	      lsa.print("lsa");
	      
	      printf("-----------------------------------%n");
	      printf("LongSpeicher10: Das war's erstmal!%n%n");
	   } // main
	   // ---------------------------------------------------------------------
	} // class LongSpeicher10