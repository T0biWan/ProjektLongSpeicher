// Datei LongSpeicher60.java
/* ------------------------------------------------------------------------
 Jedes Objekt der Klasse LongSpeicher40 ist ein Speicher, in dem man
 long-Werte sammeln (einfuegen, entfernen, suchen) kann.
 Doppelgaenger sind erlaubt.
 ---------------------------------------------------------------------------
 Implementierung: Als Hash-Tabelle
 ------------------------------------------------------------------------ */

class LongSpeicher60 extends AbstractLongSpeicher {
   // ---------------------------------------------------------------------
   // Zum Ein-/Ausschalten von Testbefehlen:
   static final boolean    TST1 = false;
   // ---------------------------------------------------------------------
   final LongSpeicher30 [] TAB;         // Die Hash-Tabelle, bestehend aus
                                         // einer Reihung von LS30-Listen

   public LongSpeicher60(int len) {
      // Initialisiert TAB mit einer Reihung der Laenge len.
      // Falls len unsinnig klein ist wird 2 als Laenge genommen.

      if (len < 2) {
         printf("TAB.length ist gleich %d und damit zu klein.%n", len);
         printf("Statt dessen wird 2 genommen!%n%n");
         len = 2;
      }
      TAB = new LongSpeicher30 [len];
      for (int i = 0; i < TAB.length; i++)
         TAB[i] = new LongSpeicher30();
   } // Konstruktor
     // ---------------------------------------------------------------------

   private int hashFunktion(long n) {
      // F E R T I G
      // Liefert einen Index fuer die Reihung TAB. Dieser Index haengt
      // nur von n ab.
      return (int) Math.abs(n % TAB.length);
   }

   // ---------------------------------------------------------------------
   private LongSpeicher30 zustaendigeListe(long n) {
      // F E R T I G
      // Liefert die Liste TAB[i], die f�r den Schluessel n zustaendig ist:
      return TAB[hashFunktion(n)];
   }

   // ---------------------------------------------------------------------
   @Override
   public String toString() {
      // Liefert eine String-Darstellung dieses Speichers. Beispiele:
      //
      // Zahl(en) im Ergebnis von:
      // Speicher toString
      // -- "[]"
      // 10 "[10]"
      // 20, 30, 10 "[20, 30, 10]"

      // Achtung: Diese Methode zu schreiben ist ziemlich SCHWIERIG!
      // Hier ein paar Hinweise, welche Faelle man behandeln sollte:
      // 1. Wenn alle Listen TAB[i] leer sind: "[]" als Ergebnis liefern.
      // 2. Sonst einen StringBuilder sb vereinbaren und "[" und
      // die Daten der ersten nicht-leeren Liste TAB[i] anhaengen.
      // 3. Dann fuer jede weitere nicht-leere Liste TAB[i] die
      // Trennzeichen ", " und die Daten der Liste TAB[i] an
      // sb anhaengen.
      // 4. Schliesslich noch "]" an sb anhaengen und
      // sb.toString() als Ergebnis liefern.
      //
      // Mit "die Daten der Liste TAB[i]" ist folgender String gemeint:
      // remove2(TAB[i].toString())

      return "toString: Noch nicht implementiert!"; // MUSS ERSETZT WERDEN
   }

   private String remove2(String s) {
      // F E R T I G
      // Erwartet, dass s.length groesser oder gleich 2 ist. Liefert
      // eine Kopie von s ohne den ersten und letzten char-Wert.
      //
      // Beispiele:
      // convert("[]") ist gleich ""
      // convert("[10]") ist gleich "10"
      // convert("[20, 30, 10]") ist gleich "20, 30, 10"
      String s2 = s;
      if (s.length() > 1) s2 = s.substring(1, s.length() - 1);
      return s2;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean fuegeEin(long n) {
      // F E R T I G
      // Fuegt n in diesen Speicher ein und liefert true.
      zustaendigeListe(n).fuegeEin(n);
      return true;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean loesche(long n) {
      // F E R T I G
      // Entfernt n aus diesem Speicher, und liefert true.
      // Liefert false falls n nicht in diesem Speicher vorkommt.
      if (!istDrin(n)) return false;
      zustaendigeListe(n).loesche(n);
      return true;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean istDrin(long n) {
      // F E R T I G
      // Liefert true wenn n in diesem Speicher vorkommt, und sonst false.
      return zustaendigeListe(n).istDrin(n);
   }

   // ---------------------------------------------------------------------
   // Zum Testen:
   private void print(String name) {
      // Gibt den name und diese Sammlung in lesbarer Form
      // zur Standardausgabe aus:

      printf("%s.toString(): %s%n", name, this.toString());
   }

   // ---------------------------------------------------------------------
   static public void main(String [] sonja) {
      printf("LongSpeicher60: Jetzt geht es los!%n");
      printf("-----------------------------------%n");
      LongSpeicher60 lsa = new LongSpeicher60(10);

      lsa.print("lsa"); // Enthaelt 0 long-Zahlen
      printf("-----------------------------------%n");
      LongSpeicher60 lsb = new LongSpeicher60(10);

      lsb.fuegeEin(25);
      lsb.print("lsb"); // Enthaelt 1 long-Zahl
      printf("-----------------------------------%n");
      LongSpeicher60 lsc = new LongSpeicher60(10);

      lsc.fuegeEin(25);
      lsc.fuegeEin(35);
      lsc.fuegeEin(15);
      lsc.print("lsc"); // Enthaelt 3 long-Zahlen
      printf("-----------------------------------%n");

      // Hier sollen Sie weitere aehnliche Testbefehle einfuegen

      printf("-----------------------------------%n");
      printf("LongSpeicher60: Das war's erstmal!%n%n");
   } // main
     // ---------------------------------------------------------------------
} // class LongSpeicher60
