package Jegmezo;

public class TorekenyAso implements Targy{

	
	/**
	 * Azt adja meg, h�nyszor lehet haszn�ni miel�tt elt�rik
	 */
	int tartossag;
	
	public TorekenyAso(int tartossag)
	{
		this.tartossag = tartossag;
	}
	/**
	 * Hozzaadja mag�t a j�t�kos t�rgyaihoz �s visszat�r azzal, hogy siker�lt-e
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
	 * A t�r�keny �s� haszn�l tev�kenys�g�t val�s�tja meg. Cs�kkenti a a h� mennyis�g�t 2-vel annak
	 *J�gt�bl�nak,ami abba az ir�nyba van, amibe a J�t�kos, aki az �s�t haszn�lja, n�z. Es visszaadja, hogy siker�lt-e.
	 *Ha siker�lt cs�kkenti a tart�ss�g�t eggyel �s ha null�ra esik a tart�ss�ga elt�rik �s elt�vol�tja mag�t a j�t�kos t�rgyai k�z�l
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
