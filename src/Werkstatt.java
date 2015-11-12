public class Werkstatt {
   // Attribute
   boolean      testen;
   Methoden     meth = new Methoden();
   final Knoten EDK  = new Knoten(null, 0); // End-Dummy-Knoten
   final Knoten ADK  = new Knoten(EDK, 0); // Anfangs-Dummy-Knoten

   public Werkstatt(boolean testen) {
      this.testen = testen;
   }

   // Methoden
   public boolean fuegeEin(long n) {
      // F E R T I G
      ADK.next = new Knoten(ADK.next, n);
      meth.testPrint(testen, "fuegeEin:\tWert: " + n + " wurde eingefügt.");
      return true;
   }

   public String toString() {
      // F E R T I G
      meth.testPrint(testen, "toString:\t");
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

   public String toStringMitDummyKnoten() {
      // F E R T I G
      String ausgabeString = "[ADK][";
      Knoten aktuellerKnoten = ADK.next;
      while (aktuellerKnoten != EDK) {
         ausgabeString += aktuellerKnoten.data;
         aktuellerKnoten = aktuellerKnoten.next;
         if (aktuellerKnoten != EDK) ausgabeString += ", ";
      }
      ausgabeString += "][EDK]";
      ausgabeString += "\n\t\t[ " + ADK.data + " ]" + toString() + "[ " + EDK.data + " ]";
      return ausgabeString;
   }

   public Knoten vorgaenger(long n) {
      // F E R T I G
      Knoten aktuellerKnoten = ADK;
      while (aktuellerKnoten != EDK) {
         if (aktuellerKnoten.next.data == n) return aktuellerKnoten;
         aktuellerKnoten = aktuellerKnoten.next;
      }
      EDK.data = n;
      return vorgaenger(EDK.data);
   }

   public boolean loesche(long n) {
      // F E R T I G
      Knoten aktuellerKnoten = ADK;
      while (aktuellerKnoten != EDK) {
         if (aktuellerKnoten.data == n) {
            vorgaenger(aktuellerKnoten.data).next = aktuellerKnoten.next;
            meth.testPrint(testen, "loesche:\tWert: " + n + " wurde entfernt.");
            return true;
         }
         aktuellerKnoten = aktuellerKnoten.next;
      }
      return false;
   }

   public boolean istDrin(long n) {
      // F E R T I G
      meth.testPrint(testen, "istDrin:\t");
      Knoten aktuellerKnoten = ADK;
      while (aktuellerKnoten != EDK) {
         if (aktuellerKnoten.data == n) return true;
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