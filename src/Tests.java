public class Tests extends Werkstatt {
   public static void main(String [] args) {
      Werkstatt w = new Werkstatt();
      Methoden meth = new Methoden();

      for (int i = 0; i < 5; i++) {
         w.fuegeEin(i);
      }

      meth.pln(w.toString());
   }
}
