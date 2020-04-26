package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Jelzopisztoly.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//

import java.util.List;

public class Jelzopisztoly implements Targy
{
	
	public Jelzopisztoly()
	{
		Global.out.print("Sikeresen letrehoztak egy jelzopisztolyt. ");
	}
	
	/**
	 *	Hozz�adja a jelz�pisztoly darabot a J�t�koshoz �s n�veli a jelz�pisztoly darabjainak a sz�m�t �s visszaadja, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
	
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			Global.out.print("Jelzopisztoly sikeresen felveve. ");
			j.jelzopisztolyDarabokNovelese();
		}
		else 
			Global.out.print("A jelzopisztolyt nem sikerult felvenni. ");	
		
		return sikeres;
	}

	/**
	 *	A jelz�pisztoly haszn�l tev�kenys�g�t val�s�tja meg. Megpr�b�lja �sszeszerelni a jelz�pisztoly �s �s visszaadja, hogy siker�lt-e
	 */
	public boolean hasznal(Jatekos j) {
		
		Global.out.print("Ez egy jelzopisztoly. ");
		int jelzopisztolyDB = 0;
		
		List<Jatekos> jatekosok = j.JegtablaLekerdez().jatekosokLekerdez();
		
		for(int i = 0; i < jatekosok.size(); i++)
		{
			
			jelzopisztolyDB += jatekosok.get(i).getjelzopisztolydb();
		}
		Global.out.print("JelzopisztolyDB-ok szama: "+jelzopisztolyDB+". ");
		if(jelzopisztolyDB >= 3)
		{
			Global.out.print("Sikeres �sszeszerel�s (pew pew). ");
			j.getJegmezo().jatekvege(true);
			return true;
		}
		else
		{
			System.out.println("Sikertelen �sszeszerel�s :/. ");
			return false;
		}
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Jelzopisztoly";
	}
}
