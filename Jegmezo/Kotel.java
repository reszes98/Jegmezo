package Jegmezo;

import java.util.List;

/**
 * @author Henrik
 * A játékban lévõ Kötelet reprezentálja
 */
public class Kotel implements Targy
{
	/**
	 * Létrehozza a kötelet
	 */
	public Kotel()
	{
		Global.out.print("Sikeresen letrehoztak egy kotelet. ");
	}
	
	/**
	 * Hozzáadja a kötelet a Játékos tárgyaihoz és visszaadja, hogy sikerült-e
	 */
	public boolean felvesz(Jatekos j) {
		
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			Global.out.print("Kotel sikeresen felveve. ");
		}
		else 
			Global.out.print("A Kotelet nem sikerult felvenni. ");	
		
		return sikeres;
	}

	
	/**
	 * Lekérdezi az irányt, amibenéz, majd lekéri a szomszédosjégtáblát és   
	 * elkezd végig menni a játékosok listáján, aki ott van és áthelyezi õket és visszaadja, hogy sikerült-e
	 */
	public boolean hasznal(Jatekos j) {
		Global.out.print("Ez egy kotel. ");
		
		int szog = j.getSzogAmibeNez(); 
		Jegtabla jt = j.JegtablaLekerdez();
		
		Jegtabla szJegtabla = jt.szomszedKerdez(szog);
		
		if(szJegtabla != null) {
			Global.out.print("A Jatekos "+ szog+"-be nez. A jegtablajan "+jt.getJatekosokSzama()+
					" jatekos all. A szomszedos jegtablan: "+ szJegtabla.getJatekosokSzama()+
					" jatekos all. ");
			List<Jatekos> jatekos = szJegtabla.jatekosokLekerdez();
			if(jatekos.size()!=0) {
				
				while(szJegtabla.jatekosokLekerdez().size()!=0)
					szJegtabla.jatekosokLekerdez().get(0).athelyez(SzogKezelo.szogTukrozveAzOrigora(szog));
				Global.out.print("A kotel hasznalata siekres. A jegtablajan "+
						jt.getJatekosokSzama()+
						" jatekos all. A szomszedos jegtablan: "+ szJegtabla.getJatekosokSzama()+
						" jatekos all. ");
				return true;
			}
		}
		else {
			Global.out.print(" Nem letezik a szomszed, ezert nem lehet jatekosokat athuzni rola. ");
			return false;
		}
		return false;
		
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Kotel";
	}
	
}
