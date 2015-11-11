public class Werkstatt {
   // Attribute
   boolean      testen = true;
   Methoden     meth   = new Methoden();
   final Knoten EDK    = new Knoten(null, 0); // End-Dummy-Knoten
   final Knoten ADK    = new Knoten(EDK, 0); // Anfangs-Dummy-Knoten

   // Methoden
   public boolean fuegeEin(long n) {
      ADK.next = new Knoten(ADK.next, n);
      meth.testPrintln(testen, "Wert: " + n + " wurde eingefügt.");
      return true;
   }

   public String toString() {
      // Liefert eine String-Darstellung dieses Speichers.
      // Beispiele:
      // Anzahl der long-Werte im Speicher:
      // "[]" // 0
      // "[10]" // 1
      // "[20, 30, 10]" // 3

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

   public Knoten vorgaenger(long n) {
      // Liefert den ersten Knoten k in dieser unsortierten Liste fuer den
      // gilt: k.next.data == n
      // (d.h. k ist der Vorgaenger eines Knotens,
      // dessen data-Komponente gleich n ist).
      // Falls n in dieser Sammlung nicht vokommt, ist k der
      // Vorgaenger des EDK.
      Knoten aktuellerKnoten = ADK;
      while (aktuellerKnoten != EDK) {
         if (aktuellerKnoten.next.data == n) return aktuellerKnoten;
         aktuellerKnoten = aktuellerKnoten.next;
      }

      // Die gesuchte Zahl n in den End-Dummy-Knoten eintragen
      // (spaetestens dort wird sie dann gefunden)
      EDK.data = n;

      return null; // MUSS ERSETZT WERDEN
   }

   public boolean loesche(long n) {
      // Loescht ein Vorkommen von n in diesem Speicher, und liefert true.
      // Liefert false falls n nicht in diesem Speicher vorkommt.
      Knoten aktuellerKnoten = ADK.next;
      while (aktuellerKnoten != EDK) {
         if (aktuellerKnoten.data == n) {
            vorgaenger(aktuellerKnoten.data).next = aktuellerKnoten.next;
            // meth.pln(vorgaenger(aktuellerKnoten.data).data);
            return true;
         }
         aktuellerKnoten = aktuellerKnoten.next;
      }
      return false;
   }

   static protected class Knoten {
      Knoten next;
      long   data;

      Knoten(Knoten next, long data) { // Konstruktor
         this.next = next;
         this.data = data;
      }
   }
}