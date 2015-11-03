public class Werkstatt {
   // Konstruktor
   public Werkstatt(int arrayLaenge) {
      speicher = new long[arrayLaenge];
   }

   // Attribute
   // private long [] speicher = { 2, 3, 5, 6};
   private long[] speicher;
   // lbi ist nicht der tatsächlcih belegte index.
   // lbi ist jetzt die füllhöhe des arrays
   public int     lbi = -1;



   // Methoden
   public String toString() {

      // Liefert eine String-Darstellung dieses Speichers. Beispiele:
      // // Anzahl der long-Werte im Speicher:
      // "[]" // 0
      // "[10]" // 1
      // "[20, 30, 10]" // 3

      if (lbi == -1)
         return "[]";
      StringBuilder sb = new StringBuilder();
      sb.append("[" + speicher[0]);
      for (int i = 1; i <= lbi; i++) {
         sb.append(", " + speicher[i]);
      }
      sb.append("]");

      return sb.toString();
   }



   public int index(long n) {
      int von = 0;
      int bis = lbi;
      while (von <= bis) {
         int mitte = von + (bis - von) / 2;
         if (gt(n, speicher[mitte])) {
            von = mitte + 1; // rechts weitersuchen
         } else if (lt(n, speicher[mitte])) {
            bis = mitte - 1;// links weitersuchen
         } else {
            return mitte; // hier gilt: eq(n, speicher[mitte])
         }
      }
      return von; // n steht nicht im speicher
   }



   public boolean fuegeEin(long n) {
      // idee:
      // das array vom letzten belegten index an bis zum ersten durchgehen
      // wenn die enthaltene Zahl größer ist als die einzufuegende Zahl
      // dann wird sie um einen index nach rechts, in plus richtung, verschoben
      // ist die nächst zahl kleiner als die einzufuegende zahl, kann eingefuegt
      // werden am frei gewordenen index
      if (lbi + 1 < speicher.length) {
         if (lbi == -1) {
            speicher[lbi + 1] = n;
         } else {
            for (int i = lbi; i > -1; i--) {
               if (lt(n, speicher[i])) {
                  speicher[i + 1] = speicher[i];
                  speicher[i] = n;
               } else if (ge(n, speicher[i])) {
                  speicher[i + 1] = n;
                  lbi++;
                  return true;
               }
            }
         }
         lbi++;
         return true;
      }
      return false;
   }



   public boolean istDrin(long n) {
      // Liefert true wenn n in diesem Speicher vorkommt, und sonst false.
      int index = index(n);
      if (index <= lbi && speicher[index] == n)
         return true;
      return false;
   }



   public boolean loesche(long n) {
      //      Achtung: Inga benutzt nicht istDrin um zu prüfen!
      if (istDrin(n)) {
         int index = index(n);
         for (int i = index; i <= lbi; i++) {
            if (i + 1 <= lbi) {
               speicher[i] = speicher[i + 1];
            }
         }

         lbi--;
         return true;
      }
      return false;
   }



   // Geerbte Methoden aus AbstractLongSpeicher
   // Methoden mit kurzen Namen:
   // Hier ist nur eine Zeile pro Methode vorteilhaft
   static void printf(String s, Object... ob) {
      System.out.printf(s, ob);
   }



   static void pln(Object ob) {
      System.out.println(ob);
   }



   static void p(Object ob) {
      System.out.print(ob);
   }



   static void pln() {
      System.out.println();
   }



   // long-Werte, die in einen long-Speicher eingefuegt werden, sollen
   // nicht mit den Operatoren <, <=, == etc, verglichen werden, sondern
   // mit den folgenden Funktionen lt, le, eq etc.
   // Dadurch wird es leichter, den Typ long (spaeter einmal) durch einen
   // anderen Typ (z.B. int oder String oder ...) zu ersetzen.
   static boolean lt(long a, long b) {
      return a < b;
   } // less then



   static boolean le(long a, long b) {
      return a <= b;
   } // less or equal



   static boolean eq(long a, long b) {
      return a == b;
   } // equal



   static boolean ge(long a, long b) {
      return a >= b;
   } // greater or equal



   static boolean gt(long a, long b) {
      return a > b;
   } // greater



   static boolean ne(long a, long b) {
      return a != b;
   } // not equal
}
