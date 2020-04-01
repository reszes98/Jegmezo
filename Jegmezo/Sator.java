package Jegmezo;

import java.util.List;

public class Sator extends Vedelem implements Targy{

	int tartossag;
	
	/**
	 * Létrehoz egy sátrat a megadott paraméterekkel
	 * @param tartossag - Azt adja meg, hogy hány kör után tûnjön el a sátor
	 */
	public Sator(int tartossag)
	{
		System.out.println("Letrehoztak egy satort");
		this.tartossag = tartossag;
	}
	
	
	/**
	 * Hozzáadja a sátrat a Játékos tárgyaihoz és visszaadja, hogy sikerült-e
	 */
	public boolean felvesz(Jatekos j) {
		System.out.println("Sator: epp fel akarnak venni");
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			System.out.println("Sator sikeresen felveve");
			
		}
		else 
			System.out.println("A satrat nem sikerult felvenni");
	
		
		return sikeres;
	}

	
	/**
	 * A Sátor használ függvénye elhelyez egy sátrat arra a jégtáblára, ami felé a Játékos, aki használja, néz
	 * Visszaadja, hogy sikeres volt az elhelyezes
	 */
	public boolean hasznal(Jatekos j) {
		System.out.println("Sator: epp hasznalni akarnak");
		System.out.println("Sator: most lekerdezem a jatekosnak az iranyAmibeNezet");
		Irany i =  j.getIranyAmibeNez();
		System.out.println("Sator: most lekerdezem a jatekosnak a jegtablajat");
		Jegtabla jt = j.JegtablaLekerdez();
		System.out.println("Sator: most lekerdezem a jatekosnak a jegtablajanak az abban az iranyban levo szomszedjat, amibe a jatekos nez");
		Jegtabla sz = jt.szomszedKerdez(i);
		
		if(sz != null)
		{
			System.out.println("Sator: letezi ez a szomszed ezert felallitom magam");
			sz.setjegtablaVedelme(this);
			System.out.println("Sator sikeresen felallitva");
			j.targyEltavolitasa(this);
			System.out.println("Sator eltavolitva");
			return true;
		}
		else
		{
			System.out.println("Sator: nem letezik ez a szomszed");
			System.out.println("A satort nem sikerult felallitani");
			return false;
		}
		
		
	}

	
	/**
	 * Mindenkörben csökkenti a tarósságát és ha nullára csökken, akkor eltávolítja magát a tábláról
	 */
	public void frissit() {
		
		tartossag--;
		if(tartossag == 0)
		{
			System.out.println("A sator tonkre ment, ezert el lett tavolitva a jegtablarol");
			jegtablaAminVan.jegtablaVedelmenekEltavolitasa();
		}
		System.out.println("A sator frissitve");
	}

	
	/**
	 * Hóviharkor megvédi a vele egy jégtáblán lévõ játékosokat, ezért semmi bántódásuk nem esik
	 */
	public void hovihar() {
		// TODO Auto-generated method stub
		System.out.println("A sator megvedte a jatekosokat a hovihartol");
	}

	
	/**
	 * Jegesmedve ellen nem véd, ezért meghívja a vele egy jégtáblán lévõ játékosokkal a jégmezõ meghalt függvényét
	 * és eltávolítja magát a tábláról 
	 */
	public void tamadas(Jegesmedve j) {
		System.out.println("A sator nem vedi a jatekosokat a jegesmedvetol");
		
		List<Jatekos> jatekosok = jegtablaAminVan.jatekosokLekerdez();
		if(!jatekosok.isEmpty())
		{
			for(int i = 0; i < jatekosok.size(); i++)
			{
				System.out.println("A jegesmedve megevett egy jatekost");
				jatekosok.get(i).getJegmezo().meghalt(jatekosok.get(i));
			}
		}
		else
			System.out.println("A jegesmedve nem evett meg senkit :'/ ");
		
		jegtablaAminVan.jegtablaVedelmenekEltavolitasa();
	}
	
	
	

}
