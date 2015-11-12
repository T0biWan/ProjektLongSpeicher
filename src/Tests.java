public class Tests extends Werkstatt {
   public Tests(boolean testen) {
      super(testen);
   }

   public static void main(String [] args) {
      Werkstatt w = new Werkstatt(true);
      Methoden meth = new Methoden();

      meth.pln("Werte einfügen:");
      for (int i = 1; i < 6; i++) {
         w.fuegeEin(i);
         meth.pln();
      }
      meth.pln();
      meth.pln("Speicher ausgeben:");
      meth.pln(w.toString());
      meth.pln();
      meth.pln("Werte löschen:");
      for (int i = 1; i < 6; i++) {
         w.loesche(i);
         meth.pln();
      }
      meth.pln();
      meth.pln("Speicher ausgeben:");
      meth.pln(w.toString());
      meth.pln();
      meth.pln("Werte einfügen:");
      for (int i = 1; i < 6; i++) {
         w.fuegeEin(i);
         meth.pln();
      }
      meth.pln();
      meth.pln("Speicher ausgeben:");
      meth.pln(w.toString());
      meth.pln();
      meth.pln("Werte in umgekehrter Reihenfolge löschen:");
      for (int i = 6; i > 0; i--) {
         w.loesche(i);
         meth.pln();
      }
      meth.pln();
      meth.pln("Speicher ausgeben:");
      meth.pln(w.toString());
      meth.pln();
      meth.pln("Werte einfügen:");
      w.fuegeEin(1);
      meth.pln();
      meth.pln();
      meth.pln("Speicher ausgeben:");
      meth.pln(w.toString());
      meth.pln();
      meth.pln("Werte löschen:");
      meth.pln("Werte die enthalten sind");
      meth.pln("\n" + w.loesche(1));
      meth.pln();
      meth.pln("Werte löschen:");
      meth.pln("Werte die nicht enthalten sind");
      meth.pln(w.loesche(5));
      meth.pln();
      meth.pln("Speicher ausgeben:");
      meth.pln(w.toString());
      meth.pln();
      meth.pln("Werte einfügen:");
      for (int i = 1; i < 6; i++) {
         w.fuegeEin(i);
         meth.pln();
      }
      meth.pln();
      meth.pln("Speicher ausgeben, mit ADK und EDK:");
      meth.pln(w.toStringMitDummyKnoten());
      meth.pln();
      for (int i = 1; i < 6; i++) {
         meth.pln("Voriger Wert von " + i + ":");
         meth.pln("vorgaenger:\t" + w.vorgaenger(i).data);
      }
      meth.pln();
      meth.pln("Vorgaenger von 5 ist ADK.");
      meth.pln();
      meth.pln("Voriger Wert einer nicht entahltenen Zahl, z.B. 6:");
      meth.pln("6 wird in EDK gespeichert und zurückgegeben wird der Wert vor EDK");
      meth.pln("vorgaenger:\t" + w.vorgaenger(6).data);
      meth.pln();
      meth.pln(w.toStringMitDummyKnoten());
      meth.pln();
      meth.pln("Zahl die enthalten ist: ");
      meth.pln(w.istDrin(2));
      meth.pln();
      meth.pln("Zahl die nicht enthalten ist: ");
      meth.pln(w.istDrin(20));
   }
}
