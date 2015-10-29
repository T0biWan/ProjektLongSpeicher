public class Tests extends Werkstatt {

   public Tests(int arrayLaenge) {
      super(arrayLaenge);
      // TODO Auto-generated constructor stub
   }

   public static void main(String [] args) {
      // Attribute
      Werkstatt a = new Werkstatt(5);

      // Tests
      // Nicht im Speicher
      // 0 liefert n = 0 zurück
      // 9 liefert 6, nächster freier speicher zurück...?
      // Ich habe hier getestet bevor es die einfuegen Methode gab, also mit
      // einem vordefinierten Array
      // pln("Nicht im Speicher");
      // pln(a.index(-3));
      // pln(a.index(0));
      // pln(a.index(1));
      // pln(a.index(9));
      // pln(a.index(25));
      // pln();
      // pln("Im Speicher");
      // pln(a.index(2));
      // pln(a.index(3));
      // pln(a.index(4));
      // pln(a.index(5));

      pln(a.toString());
      a.fuegeEin(1);
      pln(a.toString());

      a.fuegeEin(2);
      pln(a.toString());

      a.fuegeEin(3);
      pln(a.toString());

      a.fuegeEin(4);
      pln(a.toString());

      a.fuegeEin(5);
      pln(a.toString());

   }

}
