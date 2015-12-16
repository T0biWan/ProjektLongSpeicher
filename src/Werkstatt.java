public class Werkstatt {
   static protected class Knoten {
      // Die Reihungen lub und rub werden immer die Laenge 1 haben.
      // Sie ermöglichen es, die Referenzen von Knoten per Referenz
      // (auf die Reihung) an Methoden zu uebergeben.
      long      data;
      Knoten [] lub; // lub[0] ist der linke Unterbaum
      Knoten [] rub; // rub[0] ist der rechte Unterbaum

      Knoten(long data, Knoten lub, Knoten rub) { // Konstruktor
         this.data = data;
         this.lub = new Knoten [] { lub };
         this.rub = new Knoten [] { rub };
      }
   } // class Knoten

   public final Knoten    EDK = new Knoten(0, null, null);
   public final Knoten [] AR  = new Knoten [] { EDK };

   // ---------------------------------------------------------------------
   private Knoten [] vorgaenger(long n) {
      // Liefert eine Knoten-Reihung r (der Laenge 1), die Teil eines
      // Knotens dieser Sammlung ist, und fuer die gilt:
      // r[0] ist der n-Knoten (falls es einen solchen gibt) und sonst
      // der EDK.

      // Die gesuchte Zahl n in den End-Dummy-Knoten eintragen
      // (spaetestens dort wird sie dann gefunden)
      EDK.data = n;
      return vorgaengerR(n, AR);
   }

   private Knoten [] vorgaengerR(long n, Knoten [] hier) {
      // Eine rekursive Methode. Erledigt, was vorgaenger (ohne R)
      // versprochen hat (sollte nur von vorgaenger aufgerufen werden).

      return AR; // MUSS ERSETZT WERDEN
   }

   // ---------------------------------------------------------------------
   public String toString() {
      // Liefert eine String-Darstellung dieses Speichers. Beispiele:
      //
      // Zahl(en) im Ergebnis von:
      // Speicher toString
      // -- "[]"
      // 10 "[10]"
      // 10, 20, 30 "[10, 20, 30]"

      return "Noch nicht implementiert!"; // MUSS ERSETZT WERDEN
   }

   private void toStringR(Knoten [] hier, StringBuilder sb) {
      // Rekurisve Hilfsmethode fuer toString.

      return; // MUSS ERSETZT WERDEN
   }

   // ---------------------------------------------------------------------
   public boolean fuegeEin(long n) {
      // Liefert false, wenn n bereits in dieser Sammlung vorkommt.
      // Fuegt sonst n in diesen Speicher ein und liefert true.

      // AR[0] = new Knoten(5, EDK, EDK);
      // AR[0].lub[0] = new Knoten(3, EDK, EDK);

      return false; // MUSS ERSETZT WERDEN
   }

   // ---------------------------------------------------------------------
   public boolean loesche(long n) {
      // Liefert false, wenn n in diesem Speicher nicht vorkommt.
      // Loescht sonst den Knoten, der n enthaelt und liefert true.

      return false; // MUSS ERSETZT WERDEN
   }

   // ---------------------------------------------------------------------
   public boolean istDrin(long n) {
      // Liefert true wenn n in diesem Speicher vorkommt, sonst false.

      return false; // MUSS ERSETZT WERDEN
   }
}