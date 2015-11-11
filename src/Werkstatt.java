public class Werkstatt {
   // Attribute
   boolean      testen    = true;
   Methoden     meth      = new Methoden();
   final Knoten EDK       = new Knoten(null, 0); // End-Dummy-Knoten
   final Knoten ADK       = new Knoten(EDK, 0); // Anfangs-Dummy-Knoten

   // Test Strings
   String       tFuegeEin = "";

   // Methoden
   public boolean fuegeEin(long n) {
      ADK.next = new Knoten(ADK.next, n);
      return true;
   }

   public String toString() {
      // Liefert eine String-Darstellung dieses Speichers.
      // Beispiele:
      // Anzahl der long-Werte im Speicher:
      // "[]" // 0
      // "[10]" // 1
      // "[20, 30, 10]" // 3

      // String ausgabeString = "[";
      // Knoten a = ADK.next;
      // ausgabeString += a.data + ", ";
      // a = a.next;
      // ausgabeString += a.data + ", ";
      // a = a.next;
      // ausgabeString += a.data + ", ";
      // a = a.next;
      // ausgabeString += a.data + ", ";
      // a = a.next;
      // ausgabeString += a.data;
      // ausgabeString += "]";^
      String ausgabeString = "[";
      Knoten a = ADK.next;
      while (a != EDK) {
         ausgabeString += a.data + ", ";
         a = a.next;
      }
      ausgabeString += "]";
      return ausgabeString;
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