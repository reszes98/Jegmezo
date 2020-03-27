package Jegmezo;

import java.util.Scanner;

public class Menu {
	private
		int answer = 0;
		Scanner in = new Scanner(System.in);
	
	public
	void main () {		
		System.out.print("Mit szeretne? (nyomja meg a megfelelõ menüpontot)\n 1 - Játék indítás\n 2 - Kilépés\n 3 - Elõzõ játék betöltése");
		answer =  in.nextInt();
		
		switch(answer) {
			case 1:
				System.out.println("Játék indítása menü");								//3 menüpont, switch-case-zel, könnyen bõvíthetõ
		    	break;
			case 2:
				System.out.println("Kilépés menüpont");
		    	break;
			case 3:
				System.out.println("Elõzõ játék betöltése");
		    	break;
			default:
				System.out.println("Válasszon a megadott menüpontok közül");
		}
	}
	
	void jatekosszam () {	
		System.out.print("Hányan fogtok játszani?\n");
		
		boolean megfelelo = false;
		
		do {																			//do-while ciklus, mert addig kell a játékosokszámát
			answer =  in.nextInt();														//beütni, amígy a megfelelõ tartományon belül nincs
			if(answer < 3) {															
				System.out.println("Túl kevés! Legalább 3 játékos kell");				//a feltételek miatt nem lehetett switch - caset alkalmazni
			}
			
			if(answer > 10) {
				System.out.println("Túl sokan vagytok! Maximum 10-en játszhattok");
			}
			
			if(answer > 2 && answer < 9) {
				System.out.println("Elindítjuk a játékot");								//Itt megfelelõ a játékosszám, itt fogjuk elindítani a játékot
				megfelelo = true;
			}
		}
		while (megfelelo != true);
	}
}
