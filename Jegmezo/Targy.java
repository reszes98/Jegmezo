package Jegmezo;


/**
 * @author Henrik
 * A j�t�kban l�v� T�rgyak interf�sze
 */
public interface Targy
{
	
	
	/**
	 * A t�rgynak azt a tev�kenys�g�t jelk�pezi, amikor felveszik
	 * @param j - a j�t�kos, aki felveszi a t�rgyat
	 * @return Visszat�r azzal, hogy sikeres volt-e a felv�tel
	 */
	public boolean felvesz(Jatekos j);
	
	
	/**
	 * A t�rgynak azt a tev�kenys�g�t jelk�pezi, amikor haszn�lj�k
	 * @param j - a j�t�kos, aki haszn�lja a t�rgyat
	 * @return Visszat�r azzel, hogy sikeres volt-e a haszn�lat
	 */
	public boolean hasznal(Jatekos j);
	
	
}
