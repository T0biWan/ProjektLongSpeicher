import abstractLongSpeicher.AbstractLongSpeicher;

// Datei LongSpeicher30.java
/* ------------------------------------------------------------------------
 Jedes Objekt der Klasse LongSpeicher30 ist ein Speicher, in dem man
 long-Werte sammeln (einfuegen, entfernen, suchen) kann.
 Doppelgaenger sind erlaubt.
 ---------------------------------------------------------------------------
 Implementierung: Als unsortierte einfach verkettete Liste
 ------------------------------------------------------------------------ */
class LongSpeicher30 extends AbstractLongSpeicher {
   // ---------------------------------------------------------------------
   // Zum Ein-/Ausschalten von Testbefehlen:
   static final boolean TST1 = false;

   // ---------------------------------------------------------------------
   // Eine (statische) geschachtelte Klasse (nested static class).
   // Jedes Objekt dieser Klasse kann als Knoten einer einfach
   // verketteten Liste verwendet werden:
   static protected class Knoten {
      Knoten next;
      long   data;

      Knoten(Knoten next, long data) { // Konstruktor
         this.next = next;
         this.data = data;
      }
   } // class Knoten
     // ---------------------------------------------------------------------
     // Eine leere Liste besteht aus 2 Dummy-Knoten:
     // einem End-Dummy-Knoten EDK und einem Anfangs-Dummy-Knoten ADK. Die
     // "richtigen Knoten" werden spaeter zwischen die 2 Dummies gehaengt.

   final Knoten EDK = new Knoten(null, 0); // End-Dummy-Knoten
   final Knoten ADK = new Knoten(EDK, 0); // Anfangs-Dummy-Knoten

   // ---------------------------------------------------------------------

   private Knoten vorgaenger(long n) {
      // Liefert den ersten Knoten k in dieser unsortierten Liste fuer den
      // gilt: k.next.data == n
      // (d.h. k ist der Vorgaenger eines Knotens,
      // dessen data-Komponente gleich n ist).
      // Falls n in dieser Sammlung nicht vokommt, ist k der
      // Vorgaenger des EDK.

      // Die gesuchte Zahl n in den End-Dummy-Knoten eintragen
      // (spaetestens dort wird sie dann gefunden)
      EDK.data = n;

      // Die Suche beginnt mit dem Anfangs-Dummy-Knoten:
      Knoten hier = ADK;
      while (ne(hier.next.data, n))
         // not equal 
         hier = hier.next;
      //Währen hier(links).next.data  nicht equal ist mit letzten Knoten 
      //gehe immer einen nach recht(hier.next) und vergleiche den  
      return hier;
      //bis hier equal ist mit n dann returne hier; 

   }

   // ---------------------------------------------------------------------
   @Override
   public String toString() {
      // Liefert eine String-Darstellung dieses Speichers. Beispiele:
      //                    // Anzahl der long-Werte im Speicher:
      // "[]"               //  0
      // "[10]"             //  1
      // "[20, 30, 10]"     //  3

      //"Noch nicht implementiert!"; // MUSS ERSETZT WERDEN

      Knoten hier = ADK;
      hier = hier.next;

      if (hier.next == null) return "[]"; // WENN EDK  gleich null return []

      StringBuilder sb = new StringBuilder("[" + hier.data);

      while (hier.next !=EDK) {
         sb.append(", " + hier.next.data);
         hier = hier.next;

      }
      return sb.toString() + "]";

   }

   // ---------------------------------------------------------------------
   @Override
   public boolean fuegeEin(long n) {
      // Fuegt n in diesen Speicher ein und liefert true.
      // Einen neuen Knoten mit n als data vorn in die Liste einfuegen:
      ADK.next = new Knoten(ADK.next, n);
      return true;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean loesche(long n) {

      // Loescht ein Vorkommen von n in diesem Speicher, und liefert true.
      // Liefert false falls n nicht in diesem Speicher vorkommt.
      
      
      Knoten VK=vorgaenger(n);
      if (VK.next==EDK) return false;  
      
      VK.next = VK.next.next;
      return true;
      
       // MUSS ERSETZT WERDEN
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean istDrin(long n) {
      // Liefert true wenn n in diesem Speicher vorkommt, und sonst false.
      Knoten VK=vorgaenger(n);
      return VK.next!=EDK;
     
   }

   // ---------------------------------------------------------------------
   // Zum Testen:
   private void print(String name) {
      // Gibt den name und diese Sammlung in lesbarer Form
      // zur Standardausgabe aus:
      printf("%s.toString(): %s%n", name, this.toString());
   }

   private String nach_vor(long n) { // Nachfolger des Vorgaengers
      // Zum Testen der Methode vorgaenger.
      // Liefert eine String-Repraesentation des Nachfolgers
      // des Knotens vorgaenger(n). Diese String-Repraesentation
      // stellt n dar oder ist gleich "EDK".

      Knoten nv = vorgaenger(n).next;

      if (nv == ADK) return "ADK"; // Sollte nie benoetigt werden
      if (nv == EDK) return "EDK";
      return "" + nv.data;
   }

   // ---------------------------------------------------------------------
   static public void main(String[] sonja) {
      printf("LongSpeicher30: Jetzt geht es los!%n");
      printf("-----------------------------------%n");
      
      LongSpeicher30 lsc = new LongSpeicher30();
      
      // Einfuegen ohne fuegeEin:
      Knoten adk = lsc.ADK;
      printf("toString(); - T E S T ");
     
      printf("%n");printf("%n");
      printf("Es ist noch nichts drinne! %n");
      lsc.print("lsc");
      
      printf("adk.next = new Knoten(adk.next, 35);");
      adk.next = new Knoten(adk.next, 35);
      lsc.print("lsc");
      
      printf("adk.next = new Knoten(adk.next, 25);");
      adk.next = new Knoten(adk.next, 25);
      lsc.print("lsc");
      
      printf("adk.next = new Knoten(adk.next, 15);");
      adk.next = new Knoten(adk.next, 15);
      lsc.print("lsc");
      printf("%n");
      
      printf("-----------------------------------%n");
      
      printf("%n");
      printf("vorgaenger(); - T E S T ");
      printf("ohne fuegeEin()");
      printf("%n");printf("%n");
      printf("lsc.nach_vor(15): %s%n", lsc.nach_vor(15));
      printf("lsc.nach_vor(25): %s%n", lsc.nach_vor(25));
      printf("lsc.nach_vor(35): %s%n", lsc.nach_vor(35));
      printf("lsc.nach_vor(99): %s%n", lsc.nach_vor(99));
      printf("%n");
      
      printf("-----------------------------------%n");
      
      printf("%n");
      printf("fuegeEin(); - T E S T ");
      printf("%n");printf("%n");
      printf("fuegeEin(13) %b%n", lsc.fuegeEin(13));
      lsc.print("lsc");
      printf("fuegeEin(23) %b%n", lsc.fuegeEin(23));
      lsc.print("lsc");
      printf("%n");
    
      printf("-----------------------------------%n");
    
      printf("%n");
      printf("loesche(); - T E S T ");
      printf("%n");printf("%n");
      printf("loesche(13) %b%n", lsc.loesche(13));
      lsc.print("lsc");
      printf("loesche(23) %b%n", lsc.loesche(23));
      lsc.print("lsc");
      printf("%n");
      printf("%n");
      printf("NEGATIV-TEST");
      printf("%n");printf("%n");
      printf("loesche(23) %b%n", lsc.loesche(23));
      lsc.print("lsc");
      printf("%n");
           
      printf("-----------------------------------%n");
      printf("%n");
      printf("istDrin(); - T E S T ");
      printf("%n");printf("%n");
      printf("istDrin(15) %b%n", lsc.istDrin(15));
      lsc.print("lsc");
      printf("istDrin(15) %b%n", lsc.istDrin(25));
      lsc.print("lsc");
      printf("%n");
      printf("%n");
      printf("NEGATIV-TEST");
      printf("%n");printf("%n");
      printf("istDrin(5) %b%n", lsc.istDrin(5));
      lsc.print("lsc");
      printf("istDrin(13) %b%n", lsc.istDrin(13));
      lsc.print("lsc");
      printf("%n");
      printf("-----------------------------------%n");
      
      System.out.println();
//      printf("lsc.nach_vor(25): %s%n", lsc.nach_vor(25));
//      printf("lsc.nach_vor(35): %s%n", lsc.nach_vor(35));
//      printf("lsc.nach_vor(99): %s%n", lsc.nach_vor(99));
      
    //  printf("Test Konstruktor und toString:%n%n");

      // Hier sollen Sie weitere aehnliche Testbefehle eifuegen 

      printf("-----------------------------------%n");
      printf("LongSpeicher30: Das war's erstmal!%n%n");
   } // main
     // ---------------------------------------------------------------------
}