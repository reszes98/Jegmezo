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
		Global.out.print("Sikeresen letrehoztak egy satort. Tartossaga: "+tartossag+". ");
		this.tartossag = tartossag;
	}
	
	
	/**
	 * Hozzáadja a sátrat a Játékos tárgyaihoz és visszaadja, hogy sikerült-e
	 */
	public boolean felvesz(Jatekos j) {
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			Global.out.print("Sator sikeresen felveve. ");
			
		}
		else 
			Global.out.print("A satrat nem sikerult felvenni. ");
	
		
		return sikeres;
	}
	
	/**
	 * Mindenkörben csökkenti a tarósságát és ha nullára csökken, akkor eltávolítja magát a tábláról
	 */
	public void frissit() {
		Global.out.print("A sator tatorssaga: "+tartossag+ ". ");
		tartossag--;
		if(tartossag == 0)
		{
			Global.out.print(" A sator tonkre ment, ezert el lett tavolitva a jegtablarol");
			jegtablaAminVan.jegtablaVedelmenekEltavolitasa();
		}
		Global.out.print("A sator frissitve. Tartossaga: "+tartossag+ ". ");
	}


	
	/**
	 * A Sátor használ függvénye elhelyez egy sátrat arra a jégtáblára, ami felé a Játékos, aki használja, néz
	 * Visszaadja, hogy sikeres volt az elhelyezes
	 */
	public boolean hasznal(Jatekos j) {
		
		//int szog =  j.getSzogAmibeNez();
		Jegtabla jt = j.JegtablaLekerdez();
		//Jegtabla sz = jt.szomszedKerdez(szog);
		//Global.out.print("A jatekos "+szog+"-be nez. ");
		
		if(jt != null)
		{
			
			jt.setjegtablaVedelme(this);
			Global.out.print("Sator sikeresen felallitva. ");
			j.targyEltavolitasa(this);
			
			return true;
		}
		else
		{
			Global.out.print("Nem letezik ez a szomszed ezert a felallitas siekrtelen. ");
			
			return false;
		}
		
		
	}
	
	
	/**
	 * Hóviharkor megvédi a vele egy jégtáblán lévõ játékosokat, ezért semmi bántódásuk nem esik
	 */
	public void hovihar() {
		// TODO Auto-generated method stub
		Global.out.print("A sator megvedte a jatekosokat a hovihartol. ");
	}

	
	/**
	 * Jegesmedve ellen nem véd, ezért meghívja a vele egy jégtáblán lévõ játékosokkal a jégmezõ meghalt függvényét
	 * és eltávolítja magát a tábláról 
	 */
	public void tamadas(Jegesmedve j) {
		
		
		List<Jatekos> jatekosok = jegtablaAminVan.jatekosokLekerdez();
		if(!jatekosok.isEmpty())
		{
			for(int i = 0; i < jatekosok.size(); i++)
			{
				
				jatekosok.get(i).getJegmezo().meghalt(jatekosok.get(i));
			}
			Global.out.print("A jegesmedve sikeresen megette a jatekosokat. ");
		}
		else
			Global.out.print("Nem volt jatekos a tablan. ");
		
		jegtablaAminVan.jegtablaVedelmenekEltavolitasa();
	}
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Sator";
	}

}
