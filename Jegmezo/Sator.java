package Jegmezo;

import java.util.List;

public class Sator extends Vedelem implements Targy{

	int tartossag;
	
	/**
	 * L�trehoz egy s�trat a megadott param�terekkel
	 * @param tartossag - Azt adja meg, hogy h�ny k�r ut�n t�nj�n el a s�tor
	 */
	public Sator(int tartossag)
	{
		System.out.println("Letrehoztak egy satort");
		this.tartossag = tartossag;
	}
	
	
	/**
	 * Hozz�adja a s�trat a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
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
	 * A S�tor haszn�l f�ggv�nye elhelyez egy s�trat arra a j�gt�bl�ra, ami fel� a J�t�kos, aki haszn�lja, n�z
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
	 * Mindenk�rben cs�kkenti a tar�ss�g�t �s ha null�ra cs�kken, akkor elt�vol�tja mag�t a t�bl�r�l
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
	 * H�viharkor megv�di a vele egy j�gt�bl�n l�v� j�t�kosokat, ez�rt semmi b�nt�d�suk nem esik
	 */
	public void hovihar() {
		// TODO Auto-generated method stub
		System.out.println("A sator megvedte a jatekosokat a hovihartol");
	}

	
	/**
	 * Jegesmedve ellen nem v�d, ez�rt megh�vja a vele egy j�gt�bl�n l�v� j�t�kosokkal a j�gmez� meghalt f�ggv�ny�t
	 * �s elt�vol�tja mag�t a t�bl�r�l 
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
