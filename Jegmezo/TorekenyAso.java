package Jegmezo;

public class TorekenyAso implements Targy{

	
	/**
	 * Azt adja meg, h�nyszor lehet haszn�ni miel�tt elt�rik
	 */
	int tartossag;
	
	public TorekenyAso(int tartossag)
	{
		System.out.println("Letrehoztak egy torekenyasot");
		this.tartossag = tartossag;
	}
	/**
	 * Hozzaadja mag�t a j�t�kos t�rgyaihoz �s visszat�r azzal, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
		System.out.println("Torekenyaso: most megprobalnak felvenni");
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			System.out.println("Torekeny aso sikeresen felveve");
			
		}
		else 
			System.out.println("A torekeny asot nem sikerult felvenni");
	
		
		return sikeres;
	}

	
	/**
	 * A t�r�keny �s� haszn�l tev�kenys�g�t val�s�tja meg. Cs�kkenti a h� mennyis�g�t 2-vel annak
	 *J�gt�bl�nak,ami abba az ir�nyba van, amibe a J�t�kos, aki az �s�t haszn�lja, n�z. 
	 *Ha siker�lt cs�kkenti a tart�ss�g�t eggyel �s ha null�ra esik a tart�ss�ga elt�rik �s elt�vol�tja mag�t a j�t�kos t�rgyai k�z�l.
	 *�s visszaadja, hogy siker�lt-e.
	 */
	public boolean hasznal(Jatekos j) {
		System.out.println("Torekenyaso: most megprobalnak hasznalni");
		System.out.println("Torekenyaso: most lekerdezem a jatekosnak, aki hasznal, az iranyAmibeNez-et");
		int szog = j.getSzogAmibeNez();
		System.out.println("Torekenyaso: most lekerdezem a jatekosnak, aki hasznal, a jegtablajat");
		Jegtabla jt = j.JegtablaLekerdez();
		System.out.println("Torekenyaso: most lekerdezem a jegtablanak az abban az iranyban levo szomszedjat, amerre a jatekos nez");
		Jegtabla szJegtabla = jt.szomszedKerdez(szog);
		
		
		if(szJegtabla != null)
		{
			System.out.println("Torekenyaso: Letezik ez a szomszed, szoval megproblaok asni rajta kettot");
			boolean sikeres = szJegtabla.asas(2);
			
			if(sikeres)
			{
				System.out.println("Torekenyaso: Sikerult asni ezert csokkentem a tartossagom");
				tartossag--;
				if(tartossag == 0)
				{
					System.out.println("Torekenyaso: tartossag elerte a nullat,  ezert eltortem");
					j.targyEltavolitasa(this);
				}
				System.out.println("Torekeny aso sikeresen hasznalva");
			}
			else
				System.out.println("Torekeny aso sikertelenul hasznalva");
			return sikeres;
		}
		else
		{
			System.out.println("Torekenyaso: Nem letezik ez a szomszed, szoval nem lehet hasznalni a toreknyasot");
			return false;
		}
		
	}
	
	
	/**
	 * @return Visszaadja a T�r�keny�s� tartoss�g attrib�tum�t
	 */
	public int getTartossag()
	{
		return tartossag;
	}
	/**
	 * �t�ll�tja a magadott param�terre a T�r�keny�s� tart�ss�g�t
	 * @param i - amire �t akarjuk v�ltoztatni a tart�ss�got
	 */
	public void setTartossag(int i)
	{
		tartossag = i;
	}
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "TorekenyAso";
	}

}
