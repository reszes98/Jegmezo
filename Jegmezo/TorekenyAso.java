package Jegmezo;

public class TorekenyAso implements Targy{

	
	/**
	 * Azt adja meg, hányszor lehet hasznáni mielõtt eltörik
	 */
	int tartossag;
	
	public TorekenyAso(int tartossag)
	{
		this.tartossag = tartossag;
	}
	/**
	 * Hozzaadja magát a játékos tárgyaihoz és visszatér azzal, hogy sikerült-e
	 */
	public boolean felvesz(Jatekos j) {
		
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
	 * A törékeny ásó használ tevékenységét valósítja meg. Csökkenti a a hó mennyiségét 2-vel annak
	 *Jégtáblának,ami abba az irányba van, amibe a Játékos, aki az ásót használja, néz. Es visszaadja, hogy sikerült-e.
	 *Ha sikerült csökkenti a tartósságát eggyel és ha nullára esik a tartóssága eltörik és eltávolítja magát a játékos tárgyai közül
	 */
	public boolean hasznal(Jatekos j) {
		Irany i = j.getIranyAmibeNez();
		Jegtabla jt = j.JegtablaLekerdez();
		Jegtabla szJegtabla = jt.szomszedKerdez(i);
		
		boolean sikeres = szJegtabla.asas(2);
		
		if(sikeres)
		{
			tartossag--;
			if(tartossag == 0)
			{
				System.out.println("A torekeny aso eltort");
				j.targyEltavolitasa(this);
			}
			System.out.println("Torekeny aso sikeresen hasznalva");
		}
		else
			System.out.println("Torekeny aso sikertelenul hasznalva");
		
		
		return sikeres;
	}

}
