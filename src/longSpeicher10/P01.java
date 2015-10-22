package longSpeicher10;

public class P01 {
	// Attribute
//	 long[] speicher = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 22 };
	long[] speicher = new long[3];
	private int lbi = -1; // letzter belegter Index

	// Methoden
	// Testen mit JUnit, ggf. return true und false ersetzen.
	public boolean fuegeEin(long n) {
		if (++lbi < speicher.length) {
			speicher[lbi] = n;
			return true;
		}
		lbi--;
		return false;
	}

	public int index(long n) {
//		for (int i = 0; i < speicher.length; i++) { durchsucht immer das ganze Array und
//													funktioniert nicht wenn das Array 0 ist.
		for (int i = 0; i <= lbi; i++) {
			if (speicher[i] == n) return i;
		}
		return -1;
	}

	public boolean istDrin(long n) {
		return index(n) != -1;
	}

	public boolean loesche(long n) {
		// Entfernt ein n aus diesem Speicher, und liefert true.
		// Liefert false falls n in diesem Speicher nicht vorkommt.

		// return false; // MUSS ERSETZT WERDEN
		int i = index(n);
		if (i == -1) return false;
		else {
			speicher[i] = speicher[i-1]; //der Wert wird überschrieben
			lbi--;
		}
		return true;
	}
	
	public boolean loescheThudi(long n) {
		if (index(n)!=-1) {
			speicher[index(n)] = speicher[lbi];
			--lbi;
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (lbi==-1) return "[]";
		sb.append("[" + speicher[0]);
		for (int index = 1; index <= lbi; index++) {
			//Geht nicht in Schleife, falls nur ein Wert im Array
			sb.append(", " + speicher[index]);
		}
		return sb.toString() + "]";
	}
}
