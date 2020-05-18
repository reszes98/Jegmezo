package Jegmezo;

/**
 * @author Henrik
 * A j�t�kban l�v� V�delmek abstract �soszt�lya
 */
public abstract class Vedelem implements Frissitheto{

	protected Jegtabla jegtablaAminVan;
	
	/**
	 * Minden k�r elej�n kell megh�vni, hogy friss�thesse mag�t a V�delem
	 */
	public abstract void frissit();

	
	/**
	 * Akkor kell megh�vni, amikor h�vihar van, hogy a V�delem elv�gezzhesse a sz�ks�ges teend�ket
	 */
	public abstract void hovihar();
	
	
	/**
	 * Akkor h�v�dik meg, ha egy Jegesmedve t�madja meg
	 * @param j - A jegesmedve, aki t�madja a v�delmet
	 */
	public abstract void tamadas(Jegesmedve j);
	

	/**
	 * Be�ll�tja a jegtabla, amin van atrrib�tumot
	 */
	public void setJegtablaAminVan(Jegtabla j)
	{
		this.jegtablaAminVan = j;
	}

}
