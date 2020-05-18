package Jegmezo;


/**
 * @author Henrik
 * A játékban lévõ Tárgyak interfésze
 */
public interface Targy
{
	
	
	/**
	 * A tárgynak azt a tevékenységét jelképezi, amikor felveszik
	 * @param j - a játékos, aki felveszi a tárgyat
	 * @return Visszatér azzal, hogy sikeres volt-e a felvétel
	 */
	public boolean felvesz(Jatekos j);
	
	
	/**
	 * A tárgynak azt a tevékenységét jelképezi, amikor használják
	 * @param j - a játékos, aki használja a tárgyat
	 * @return Visszatér azzel, hogy sikeres volt-e a használat
	 */
	public boolean hasznal(Jatekos j);
	
	
}
