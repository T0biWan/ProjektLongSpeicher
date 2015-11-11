public class Methoden {
   public void testPrintf(boolean testen, String testString, Object ob) {
      if (testen) pf(testString, ob);
   }

   public void testPrintln(boolean testen, String testString) {
      if (testen) pln(testString);
   }

   public void pf(String s, Object... ob) {
      System.out.printf(s, ob);
   }

   public void pln(Object ob) {
      System.out.println(ob);
   }

   public void pln() {
      System.out.println();
   }

   public void p(Object ob) {
      System.out.print(ob);
   }

   // long-Werte, die in einen long-Speicher eingefuegt werden, sollen
   // nicht mit den Operatoren <, <=, == etc, verglichen werden, sondern
   // mit den folgenden Funktionen lt, le, eq etc.
   // Dadurch wird es leichter, den Typ long (spaeter einmal) durch einen
   // anderen Typ (z.B. int oder String oder ...) zu ersetzen.
   public boolean lt(long a, long b) {
      return a < b;
   } // less then

   public boolean le(long a, long b) {
      return a <= b;
   } // less or equal

   public boolean eq(long a, long b) {
      return a == b;
   } // equal

   public boolean ge(long a, long b) {
      return a >= b;
   } // greater or equal

   public boolean gt(long a, long b) {
      return a > b;
   } // greater

   public boolean ne(long a, long b) {
      return a != b;
   } // not equal

}
