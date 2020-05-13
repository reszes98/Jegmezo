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
		Global.out.print("Sikeresen letrehoztak egy satort. Tartossaga: "+tartossag+". ");
		this.tartossag = tartossag;
	}
	
	
	/**
	 * Hozz�adja a s�trat a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
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
	 * Mindenk�rben cs�kkenti a tar�ss�g�t �s ha null�ra cs�kken, akkor elt�vol�tja mag�t a t�bl�r�l
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
	 * A S�tor haszn�l f�ggv�nye elhelyez egy s�trat arra a j�gt�bl�ra, ami fel� a J�t�kos, aki haszn�lja, n�z
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
	 * H�viharkor megv�di a vele egy j�gt�bl�n l�v� j�t�kosokat, ez�rt semmi b�nt�d�suk nem esik
	 */
	public void hovihar() {
		// TODO Auto-generated method stub
		Global.out.print("A sator megvedte a jatekosokat a hovihartol. ");
	}

	
	/**
	 * Jegesmedve ellen nem v�d, ez�rt megh�vja a vele egy j�gt�bl�n l�v� j�t�kosokkal a j�gmez� meghalt f�ggv�ny�t
	 * �s elt�vol�tja mag�t a t�bl�r�l 
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
