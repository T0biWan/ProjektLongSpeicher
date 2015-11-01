public class Tests extends Werkstatt {

   public Tests(int arrayLaenge) {
      super(arrayLaenge);
      // TODO Auto-generated constructor stub
   }



   public static void main(String[] args) {
      // Attribute
      Werkstatt w = new Werkstatt(5);
      int zuVielFürsArray = 6;

      // Tests
      // int a = 1;
      // int b = 2;
      // int c = 3;
      // int d = 4;
      // int e = 5;

      // int a = 5;
      // int b = 4;
      // int c = 3;
      // int d = 2;
      // int e = 1;

      int a = 5;
      int b = 3;
      int c = 1;
      int d = 5;
      int e = 7;

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

      pln("Array vor dem Einfügen: " + w.toString());
      w.fuegeEin(a);
      pln("Array nach dem Einfügen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      pln("Array vor dem Einfügen: " + w.toString());
      w.fuegeEin(b);
      pln("Array nach dem Einfügen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      pln("Array vor dem Einfügen: " + w.toString());
      w.fuegeEin(c);
      pln("Array nach dem Einfügen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      pln("Array vor dem Einfügen: " + w.toString());
      w.fuegeEin(d);
      pln("Array nach dem Einfügen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      pln("Array vor dem Einfügen: " + w.toString());
      w.fuegeEin(e);
      pln("Array nach dem Einfügen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      pln("Array vor dem Einfügen: " + w.toString());
      w.fuegeEin(zuVielFürsArray);
      pln("Array nach dem Einfügen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      // a.fuegeEin(2);
      // pln(a.toString());
      // System.out.println("lbi: " + a.lbi);
      //
      // a.fuegeEin(5);
      // pln(a.toString());
      // System.out.println("lbi: " + a.lbi);
      //
      // a.fuegeEin(4);
      // pln(a.toString());
      // System.out.println("lbi: " + a.lbi);
      //
      // a.fuegeEin(5);
      // pln(a.toString());
      // System.out.println("lbi: " + a.lbi);
      //
      // a.fuegeEin(5);
      // pln(a.toString());
      // System.out.println("lbi: " + a.lbi);

      pln("Array vor dem Löschen: " + w.toString());
      w.loesche(5);
      pln("Array nach dem Löschen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      pln("Array vor dem Löschen: " + w.toString());
      w.loesche(5);
      pln("Array nach dem Löschen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();

      pln("Array vor dem Einfügen: " + w.toString());
      w.fuegeEin(e);
      pln("Array nach dem Einfügen: " + w.toString());
      pln("lbi: " + w.lbi);
      pln();
   }

}
