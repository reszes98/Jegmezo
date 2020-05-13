package Jegmezo;

public class TorekenyAso implements Targy{

	
	/**
	 * Azt adja meg, h�nyszor lehet haszn�ni miel�tt elt�rik
	 */
	int tartossag;
	
	public TorekenyAso(int tartossag)
	{
		Global.out.print("Sikeresen letrehoztak egy torekenyasot. Tartossaga: "+tartossag+". ");
		this.tartossag = tartossag;
	}
	/**
	 * Hozzaadja mag�t a j�t�kos t�rgyaihoz �s visszat�r azzal, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			Global.out.print("Torekeny aso sikeresen felveve. ");
			
		}
		else 
			Global.out.print("A torekeny asot nem sikerult felvenni. ");
	
		
		return sikeres;
	}

	
	/**
	 * A t�r�keny �s� haszn�l tev�kenys�g�t val�s�tja meg. Cs�kkenti a h� mennyis�g�t 2-vel annak
	 *J�gt�bl�nak,ami abba az ir�nyba van, amibe a J�t�kos, aki az �s�t haszn�lja, n�z. 
	 *Ha siker�lt cs�kkenti a tart�ss�g�t eggyel �s ha null�ra esik a tart�ss�ga elt�rik �s elt�vol�tja mag�t a j�t�kos t�rgyai k�z�l.
	 *�s visszaadja, hogy siker�lt-e.
	 */
	public boolean hasznal(Jatekos j) {
		
		Global.out.print("Ez egy torekeny aso. Tartossaga: "+tartossag +". ");
		//int szog = j.getSzogAmibeNez();
		
		Jegtabla jt = j.JegtablaLekerdez();
		
		//Jegtabla szJegtabla = jt.szomszedKerdez(szog);
		
		
		if(jt != null)
		{
			
			boolean sikeres = jt.asas(2);
			
			if(sikeres)
			{
				
				tartossag--;
				Global.out.print("Torekeny aso tartossaga sikeresen csokkentve. ");
				if(tartossag == 0)
				{
					Global.out.print("A torekenyaso tartossaga elerte a nullat. ");
					j.targyEltavolitasa(this);
				}
				
				Global.out.print("Torekeny aso sikeresen hasznalva");
			}
			else
				Global.out.print("Torekeny aso sikertelenul hasznalva. ");
			
			Global.out.print("Tartossaga: "+tartossag +". ");
			return sikeres;
		}
		else
		{
			Global.out.print("Nem letezik ez a szomszed, szoval nem lehet hasznalni a toreknyasot. ");
			Global.out.print("Tartossaga: "+tartossag +". ");
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
		Global.out.print("Tartossaga sikeresen beallitva. ");
	}
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "TorekenyAso";
	}

}
