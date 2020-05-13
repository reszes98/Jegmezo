package Jegmezo;

public class TorekenyAso implements Targy{

	
	/**
	 * Azt adja meg, hányszor lehet hasznáni mielõtt eltörik
	 */
	int tartossag;
	
	public TorekenyAso(int tartossag)
	{
		Global.out.print("Sikeresen letrehoztak egy torekenyasot. Tartossaga: "+tartossag+". ");
		this.tartossag = tartossag;
	}
	/**
	 * Hozzaadja magát a játékos tárgyaihoz és visszatér azzal, hogy sikerült-e
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
	 * A törékeny ásó használ tevékenységét valósítja meg. Csökkenti a hó mennyiségét 2-vel annak
	 *Jégtáblának,ami abba az irányba van, amibe a Játékos, aki az ásót használja, néz. 
	 *Ha sikerült csökkenti a tartósságát eggyel és ha nullára esik a tartóssága eltörik és eltávolítja magát a játékos tárgyai közül.
	 *És visszaadja, hogy sikerült-e.
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
	 * @return Visszaadja a TörékenyÁsó tartosság attribútumát
	 */
	public int getTartossag()
	{
		return tartossag;
	}
	/**
	 * Átállítja a magadott paraméterre a TörékenyÁsó tartósságát
	 * @param i - amire át akarjuk változtatni a tartósságot
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
