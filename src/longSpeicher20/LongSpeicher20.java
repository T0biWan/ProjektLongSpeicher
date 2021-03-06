package longSpeicher20;

// Datei LongSpeicher20.java
/* ------------------------------------------------------------------------
Jedes Objekt der Klasse LongSpeicher20 ist ein Speicher, in dem man
long-Werte sammeln (einfuegen, entfernen, suchen) kann.
Doppelgaenger sind erlaubt.
---------------------------------------------------------------------------
Implementierung: Als sortierte Reihung.
------------------------------------------------------------------------ */

import static java.lang.String.format;

import java.util.Arrays;

import abstractLongSpeicher.AbstractLongSpeicher;

class LongSpeicher20 extends AbstractLongSpeicher {
   // ---------------------------------------------------------------------
   // Zum Ein-/Ausschalten von Testbefehlen:
   static final boolean TST1 = true;
   // ---------------------------------------------------------------------
   private long[] speicher;
   private int    lbi = -1; // letzter belegter Index

   public LongSpeicher20(int length) {
      speicher = new long[length];
   }
   // ---------------------------------------------------------------------
   private int index(long n) {
	   for(int i = 0; i <= lbi; i++){
		   if(speicher[i] == n) return i;
	   }
	   
      // Liefert -1, wenn n nicht in diesem Speicher vorkommt.
      // Liefert sonst einen Index i, an dem ein n im Speicher steht
      // (d.h. fuer diesen Index i gilt: speicher[i] == n).

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
	
	   if(lbi == -1) return "[]";
	   StringBuilder sb = new StringBuilder();
	   sb.append("[" + speicher[0]);
	   for(int i = 1; i <= lbi; i++){
		   sb.append(", " + speicher[i]);
	   }
	   sb.append("]");
	   
   
      return sb.toString(); 
   }
   // ---------------------------------------------------------------------
   @Override
   public boolean fuegeEin(long n) {
	   
	   if(lbi >= speicher.length-1)  return false; 
	   speicher[++lbi] = n;
	   
      // Liefert false, falls dieser Speicher bereits voll ist.
      // Fuegt sonst n in diesen Speicher ein und liefert true.

      return true; 
   }
   // ---------------------------------------------------------------------
   @Override
   public boolean loesche(long n) {
	   
	   if(index(n) == -1) return false;
	   speicher[index(n)] = speicher[lbi];
	   lbi--;
	   
      // Entfernt ein n aus diesem Speicher, und liefert true.
      // Liefert false falls n in diesem Speicher nicht vorkommt.

      return true; // MUSS ERSETZT WERDEN
   }
   // ---------------------------------------------------------------------
   @Override
   public boolean istDrin(long n) {
      // Liefert true wenn n in diesem Speicher vorkommt, und sonst false.
	   return index(n) != -1;
	   
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
      LongSpeicher20 lsa = new LongSpeicher20(4);
      lsa.print("lsa");
      printf("-----------------------------------%n");
      printf("Positive Tests mit fuegeEin:%n%n");
      printf("lsa.fuegeEin(25): %b%n", lsa.fuegeEin(25));
      lsa.print("lsa");
      printf("lsa.fuegeEin(15): %b%n", lsa.fuegeEin(15));
      lsa.print("lsa");
      printf("lsa.fuegeEin(35): %b%n", lsa.fuegeEin(35));
      lsa.print("lsa");
      printf("lsa.fuegeEin(35): %b%n", lsa.fuegeEin(35));
      lsa.print("lsa");
      
      printf("-----------------------------------%n");
      printf("Negative Tests mit fuegeEin:%n%n");
      
      printf("lsa.fuegeEin(50): %b%n", lsa.fuegeEin(50));
      lsa.print("lsa");
      printf("lsa.fuegeEin(50): %b%n", lsa.fuegeEin(60));
      lsa.print("lsa");
      
      printf("-----------------------------------%n");
      printf("Positive Tests mit istDrin:%n%n");
      
      printf("lsa.istDrin(25): %b%n", lsa.istDrin(25));
      lsa.print("lsa");
      
      printf("-----------------------------------%n");
      printf("Negative Tests mit istDrin:%n%n");
      
      printf("lsa.istDrin(25): %b%n", lsa.istDrin(50));
      lsa.print("lsa");
      
      printf("-----------------------------------%n");
      printf("Tests mit Index, der existiert:%n%n");
      
      printf("lsa.index(25): %d%n", lsa.index(25));
      lsa.print("lsa");
      printf("lsa.index(15): %d%n", lsa.index(15));
      lsa.print("lsa");
      
      printf("-----------------------------------%n");
      printf("Tests mit Index, der nicht existiert:%n%n");
      
      printf("lsa.index(15): %d%n", lsa.index(60));
      lsa.print("lsa");
      
      printf("-----------------------------------%n");
      printf("Tests mit L�schen:%n%n");
      
      printf("lsa.loesche(25): %b%n", lsa.loesche(25));
      lsa.print("lsa");
      printf("lsa.loesche(50): %b%n", lsa.loesche(50));
      lsa.print("lsa");


      printf("-----------------------------------%n");

      printf("-----------------------------------%n");
      printf("LongSpeicher10: Das war's erstmal!%n%n");

   } // main
   
   // ---------------------------------------------------------------------
} // class LongSpeicher10
