package longSpeicher20;

public class P02 {

   static final boolean  TST1         = true;
   private long[]        speicher;
   private int           lbi          = -1;            // letzter belegter index
   private static long[] meinSpeicher = { 1, 2, 3, 4 };
   private static int    meinLbi      = 3;
   private static int    gesucht      = 3;

   public static void main(String[] args) {
      System.out.println(index(gesucht));
   }

   private static int index(long n) {
      int von = 0;
      int bis = meinLbi;

      while (von <= bis) {
         int mitte = von + (bis - von) / 2;

         if (n < meinSpeicher[mitte]) {
            von = ++mitte; // rechts weitersuchen
         } else if (n > meinSpeicher[mitte]) {
            bis = --mitte; // links weitersuchen
         } else {
            return mitte; // hier gilt: eq(n, speicher[mitte])
         }
      }
      return von; // n steht nicht im speicher
   }

}
