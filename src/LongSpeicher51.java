import java.util.Arrays;

// Datei LongSpeicher51.java
/* ------------------------------------------------------------------------
Jedes Objekt der Klasse LongSpeicher51 ist ein Speicher, in dem man
long-Werte sammeln (einfuegen, entfernen, suchen) kann.
Vereinfachte Version: Doppelgaenger sind NICHT erlaubt (d.h. werden
nicht eingefuegt).
TERMINOLOGIE: Als "n-Knoten" wird hier ein Knoten bezeichnet, der in seinem
data-Attribut n enthaelt. Welcher (long-) Wert mit n gemeint ist, muss aus
dem Kontext folgen. Dummy-Knoten zaehlen nicht als n-Knoten (auch wenn sie
n enthalten).
---------------------------------------------------------------------------
Implementierung: Als binaerer Baum
Jedes Knoten-Objekt enthaelt ein long Attribut und zwei Knoten[]-Attribute.
Die Knoten[]-Attribute zeigen auf Reihungen der Laenge 1.
Uebergibt man einer Methode eine solche Reihung r, so kann die Methode den
Wert der Variable r[0] veraendern (z.B. auf einen anderen Knoten zeigen
lassen). Mit diesem "Trick" wird eine Parameteruebergabe per Referenz
(die es in Java offiziell nicht gibt) nachgeahmt.
------------------------------------------------------------------------ */
class LongSpeicher51 extends AbstractLongSpeicher {
   // ---------------------------------------------------------------------
   // Zum Ein-/Ausschalten von Testbefehlen:
   static final boolean TST1 = false;

   // ---------------------------------------------------------------------
   // Eine (statische) geschachtelte Klasse (nested static class),
   // keine innere Klasse!
   // Jedes Objekt dieser Klasse kann als Knoten eines binaeren Baums
   // verwendet werden.
   static protected class Knoten {
      // Die Reihungen lub und rub werden immer die Laenge 1 haben.
      // Sie ermöglichen es, die Referenzen von Knoten per Referenz
      // (auf die Reihung) an Methoden zu uebergeben.
      long     data;
      Knoten[] lub; // lub[0] ist der linke  Unterbaum
      Knoten[] rub; // rub[0] ist der rechte Unterbaum

      Knoten(long data, Knoten lub, Knoten rub) { // Konstruktor
         this.data = data;
         this.lub = new Knoten[] { lub };
         this.rub = new Knoten[] { rub };
      }
   } // class Knoten
   // ---------------------------------------------------------------------
   // Ein leerer Baum besteht aus einem End-Dummy-Knoten EDK und einer
   // Knoten-Reihung AR (der Laenge 1). AR[0] ist anfangs gleich dem EDK
   // und ist spaeter der erste "richtige Knoten" (die Wurzel) des Baums

   private final Knoten   EDK = new Knoten(0, null, null);
   private final Knoten[] AR  = new Knoten[] { EDK };

   // ---------------------------------------------------------------------
   Knoten[] vorgaenger(long n) {
      // Liefert eine Knoten-Reihung r (der Laenge 1), die Teil eines
      // Knotens dieser Sammlung ist, und fuer die gilt:
      // r[0] ist der n-Knoten (falls es einen solchen gibt) und sonst
      // der EDK.
      // Die gesuchte Zahl n in den End-Dummy-Knoten eintragen
      // (spaetestens dort wird sie dann gefunden)
      EDK.data = n;
      return vorgaengerR(n, AR);
   }

   private Knoten[] vorgaengerR(long n, Knoten[] hier) {
      // Eine rekursive Methode. Erledigt, was vorgaenger (ohne R)
      // versprochen hat (sollte nur von vorgaenger aufgerufen werden).
      
      if(lt(n, hier[0].data)) return vorgaengerR(n, hier[0].lub);
      if(gt(n, hier[0].data)) return vorgaengerR(n, hier[0].rub);
      return hier;
   }

   // ---------------------------------------------------------------------
   @Override
   public String toString() {
      // Liefert eine String-Darstellung dieses Speichers. Beispiele:
      //
      // Zahl(en) im      Ergebnis von:
      // Speicher         toString
      //   --               "[]"
      //   10               "[10]"
      //   10, 20, 30       "[10, 20, 30]"
      StringBuilder builder = new StringBuilder();
      builder.append('[');
      toStringR(AR, builder);
      builder.append(']');
      return builder.toString();
   }

   private void toStringR(Knoten[] hier, StringBuilder sb) {
      // Rekurisve Hilfsmethode fuer toString.
      Knoten knoten = hier[0];
      if (knoten == EDK) return;

      sb.append(knoten.data);
      if (knoten.lub[0] != EDK) sb.append(", ");
      toStringR(knoten.lub, sb);
      if (knoten.rub[0] != EDK) sb.append(", ");
      toStringR(knoten.rub, sb);
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean fuegeEin(long n) {
      // Liefert false, wenn n bereits in dieser Sammlung vorkommt.
      // Fuegt sonst n in diesen Speicher ein und liefert true.

      Knoten[] vorgaengerReferenz = vorgaenger(n); // anfangs AR, zeigt auf ein Array, nicht mehr auf den Index 0
      if(vorgaengerReferenz[0] != EDK) return false; // Wenn die Zahl schon vorhanden ist, dann füge sie nicht ein

      Knoten neuerKnoten = new Knoten(n, EDK, EDK);  // n als Knoten mit linkem und rechtem Unterbaum, die noch leer sind -> neues Blatt mit leeren Unterbäumen -> EDK
      vorgaengerReferenz[0] = neuerKnoten; // vorgaengerReihung[0] ist jetzt nicht mehr AR, sondern der neue Knoten
      return true;
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean loesche(long n) {
      // Liefert false, wenn n in diesem Speicher nicht vorkommt.
      // Loescht sonst den Knoten, der n enthaelt und liefert true.

      Knoten[] knotenReferenz = vorgaenger(n);
      Knoten knoten = knotenReferenz[0];

      // Wenn n gar nicht im Baum vorkommt, false zurückgeben
      if(knoten == EDK) return false;

      // Einfacher Fall - unser Knoten ist ein Blatt (hat keine Unterbäume)
      // Referenz auf EDK setzen.
      if(knoten.lub[0] == EDK && knoten.rub[0] == EDK) {
         knotenReferenz[0] = EDK;
         return true;
      }

      // Fall Teilbaum (1) - unser Knoten hat nur einen Teilbaum rechts, links ist EDK
      // rechten Knoten "hochziehen"
      if(knoten.lub[0] == EDK) {
         knotenReferenz[0] = knoten.rub[0]; // Die Zahl, die gelöscht werden soll, wird überschrieben
         return true;
      }

      // Fall Teilbaum (2) - unser Knoten hat nur einen Teilbaum links, rechts ist EDK
      // linken Knoten "hochziehen"
      if(knoten.rub[0] == EDK) {
         knotenReferenz[0] = knoten.lub[0]; // überschreiben
         return true;
      }

      // Komplizierter Fall: Knoten hat einen linken und einen rechten Unterbaum
      // Linker Teilbaum wird umgehängt; rechter Teilbaum neu hinzugefügt.
      
      Knoten[] vorgaengerReferenz = knoten.lub; // zum linken Unterbaum gehen
      while (vorgaengerReferenz[0].rub[0] != EDK) { // Prüft, ob noch ein rechter Unterbaum dran hängt
         vorgaengerReferenz = vorgaengerReferenz[0].rub; // überschreiben bis zum Maximum
      }
      
      knotenReferenz[0].data = vorgaengerReferenz[0].data; // Daten aus MAX in den L Knoten kopieren
      vorgaengerReferenz[0] = vorgaengerReferenz[0].lub[0];  
//      if(vorgaengerReferenz[0].lub[0] != EDK) {
//         vorgaengerReferenz[0] = vorgaengerReferenz[0].lub[0];
//      } else {
//         vorgaengerReferenz[0] = EDK; // Löschen
//      }
      return true;  
   }

   // ---------------------------------------------------------------------
   @Override
   public boolean istDrin(long n) {
      // Liefert true wenn n in diesem Speicher vorkommt, sonst false.
      return vorgaenger(n)[0] != EDK;
   }

   // ---------------------------------------------------------------------
   // Zum Testen
   private void print() {
      // Gibt den Baum, auf den AR zeigt, in lesbarer Form aus:
      // Pro Zeile ein Knoten, Unterbaeume sind eingerueckt, z.B. so
      //
      //         90
      //      80
      //         80
      //   60
      //      50
      //         40
      //            30
      //
      // Diese Darstellungen sollte man sich um 90 Grad nach rechts gedreht
      // vorstellen (so dass die Wurzel 60 ganz oben ist).
      printf("+--------------------------%n"); // Anfangs-Zeile
      if (AR[0] == EDK) {
         printf("| Leerer Baum!%n");
      } else {
         printR(AR, "| "); // Alle normalen Zeilen beginnen mit "| "
      }
      printf("+--------------------------%n"); // Ende-Zeile
   }

   private void printR(Knoten[] hier, String einrueck) {
      // Rekursive Hilfsmethode fuer print
      // Eine Einrueck-Stufe:
      final String EINRUECK = "   "; // Eine Stufe gleich 3 Leerzeichen
      // Ein Ende des Baumes erreicht?
      if (hier[0] == EDK) return;
      // Gib den linken Unterbaum aus:
      printR(hier[0].rub, einrueck + EINRUECK);
      // Gib den aktuellen Knoten aus:
      printf("%s", einrueck);
      printf("%2d%n", hier[0].data);
      // Gib den rechten Unterbaum aus:
      printR(hier[0].lub, einrueck + EINRUECK);
   }

   // ---------------------------------------------------------------------
   // Eine alternative print-Methode printB:
   private void printB(String name) {
      // Gibt den name und den Baum, auf den AR zeigt, in lesbarer Form aus
      // (alle Komponenten auf einer Zeile, durch Kommas getrennt in
      // eckige Klammern eingeschlossen).
      printf("%s: %s%n", name, this.toString());
   }

   // ---------------------------------------------------------------------
   static public void main(String[] sonja) {
      printf("LongSpeicher51: Jetzt geht es los!%n");
      printf("A ------------------------------ A%n");
      printf("Positive Tests mit fuegeEin:%n%n");
      LongSpeicher51 fsa = new LongSpeicher51();
      fsa.print();
      printf("fsa.fuegeEin(65): %-5b%n", fsa.fuegeEin(65));
      fsa.print();
      printf("fsa.fuegeEin(45): %-5b%n", fsa.fuegeEin(45));
      fsa.print();
      printf("fsa.fuegeEin(35): %-5b%n", fsa.fuegeEin(35));
      fsa.print();
      printf("fsa.fuegeEin(85): %-5b%n", fsa.fuegeEin(85));
      fsa.print();
      printf("fsa.fuegeEin(75): %-5b%n", fsa.fuegeEin(75));
      fsa.print();
      printf("fsa.fuegeEin(55): %-5b%n", fsa.fuegeEin(55));
      fsa.print();
      printf("fsa.fuegeEin(95): %-5b%n", fsa.fuegeEin(95));
      fsa.print();
      fsa.printB("fsa");
      printf("B ------------------------------ B%n");
      
      // Doppelgänger sind nicht erlaubt. Dieser Befehl muss false liefern.
      printf("fsa.fuegeEin(95): %-5b%n", fsa.fuegeEin(95));
      fsa.print();
      
      // Die 95 wird gelöscht und dann wieder eingefügt, muss true liefern.
      printf("fsa.loesche(95): %-5b%n", fsa.loesche(95));
      fsa.print();
      printf("fsa.fuegeEin(95): %-5b%n", fsa.fuegeEin(95));
      fsa.print();
      
      // Die 95 wurde hinzugefügt, der Befehl muss true liefern.
      printf("fsa.istDrin(95): %-5b%n", fsa.istDrin(95));
      fsa.print();
      
      // Test istDrin mit einer Zahl, die nicht im Speicher ist.
      printf("fsa.istDrin(97): %-5b%n", fsa.istDrin(97));
      fsa.print();
      
      // Wurzelknoten löschen
      printf("fsa.loesche(65): %-5b%n", fsa.loesche(65));
      fsa.print();
      
      // Vorgaenger testen am Wurzelknoten
      printf("fsa.vorgaenger(55): %s%n", fsa.vorgaenger(55)[0].data);
      fsa.print();
      
      // Vorgaenger testen bei vorhandenen Einträgen
      printf("fsa.vorgaenger(35): %s%n", fsa.vorgaenger(35)[0].data);
      fsa.print();
      
      // Vorgaenger testen bei nicht vorhandenen Einträgen
      printf("fsa.vorgaenger(100): %s%n", fsa.vorgaenger(100)[0].data);
      fsa.print();
 
      printf("H ------------------------------ H%n");
      printf("LongSpeicher51: Das war's erstmal!%n%n");
   } // main
   // ---------------------------------------------------------------------
} // class LongSpeicher51