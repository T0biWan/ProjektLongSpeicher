public class Werkstatt {
   public String remove2(String s) {
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
}