// Datei LongSpeicher30.java
/* ------------------------------------------------------------------------
 Jedes Objekt der Klasse LongSpeicher30 ist ein Speicher, in dem man
 long-Werte sammeln (einfuegen, entfernen, suchen) kann.
 Doppelgaenger sind erlaubt.
 ---------------------------------------------------------------------------
 Implementierung: Als unsortierte einfach verkettete Liste
 ------------------------------------------------------------------------ */
class LongSpeicher40 extends AbstractLongSpeicher {
   // ---------------------------------------------------------------------
   // Zum Ein-/Ausschalten von Testbefehlen:
   static final boolean TST1 = false;
   Methoden             meth = new Methoden();

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
      // Liefert den ersten Knoten k in dieser sortierten Liste fuer den
      // gilt: ge(k.next.data, n)
      // (d.h. k ist der Vorgaenger des ersten Knotens,
      // dessen data-Komponente groesser oder gleich n ist).
      // Falls n in dieser Sammlung nicht vorkommt, ist k der
      // Vorgaenger des EDK.

      return null; // MUSS ERSETZT WERDEN
   }

   // ---------------------------------------------------------------------
   @Override
   public String toString() {
      // F E R T I G
      meth.testPrint(TST1, "toString:\t");
      String ausgabeString = "[";
      Knoten aktuellerKnoten = ADK.next;
      while (aktuellerKnoten != EDK) {
         ausgabeString += aktuellerKnoten.data;
         aktuellerKnoten = aktuellerKnoten.next;
         if (aktuellerKnoten != EDK) ausgabeString += ", ";
      }
      ausgabeString += "]";
      return ausgabeString;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean fuegeEin(long n) {
      // F E R T I G
      ADK.next = new Knoten(ADK.next, n);
      meth.testPrint(TST1, "fuegeEin:\tWert: " + n + " wurde eingefügt.");
      return true;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean loesche(long n) {
      // F E R T I G
      Knoten aktuellerKnoten = ADK;
      while (aktuellerKnoten != EDK) {
         if (aktuellerKnoten.data == n) {
            vorgaenger(aktuellerKnoten.data).next = aktuellerKnoten.next;
            meth.testPrint(TST1, "loesche:\tWert: " + n + " wurde entfernt.");
            return true;
         }
         aktuellerKnoten = aktuellerKnoten.next;
      }
      return false;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean istDrin(long n) {
      // F E R T I G
      meth.testPrint(TST1, "istDrin:\t");
      Knoten aktuellerKnoten = ADK;
      while (aktuellerKnoten != EDK) {
         if (aktuellerKnoten.data == n) return true;
         aktuellerKnoten = aktuellerKnoten.next;
      }
      return false;
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
   static public void main(String [] sonja) {
      printf("LongSpeicher30: Jetzt geht es los!%n");
      printf("-----------------------------------%n");
      printf("Test vorgaenger (ohne fuegeEin!):%n%n");
      LongSpeicher40 lsc = new LongSpeicher40();
      lsc.print("lsc");
      // Einfuegen ohne fuegeEin:
      Knoten adk = lsc.ADK;
      adk.next = new Knoten(adk.next, 35);
      adk.next = new Knoten(adk.next, 25);
      adk.next = new Knoten(adk.next, 15);
      lsc.print("lsc");
      printf("%n");
      printf("lsc.nach_vor(15): %s%n", lsc.nach_vor(15));
      printf("lsc.nach_vor(25): %s%n", lsc.nach_vor(25));
      printf("lsc.nach_vor(35): %s%n", lsc.nach_vor(35));
      printf("lsc.nach_vor(99): %s%n", lsc.nach_vor(99));
      printf("-----------------------------------%n");
      printf("Test Konstruktor und toString:%n%n");

      // Hier sollen Sie weitere aehnliche Testbefehle eifuegen

      printf("-----------------------------------%n");
      printf("LongSpeicher30: Das war's erstmal!%n%n");
   } // main
     // ---------------------------------------------------------------------
}