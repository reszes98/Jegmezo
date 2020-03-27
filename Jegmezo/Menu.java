package Jegmezo;

import java.util.Scanner;

public class Menu {
	private
		int answer = 0;
		Scanner in = new Scanner(System.in);
	
	public
	void main () {		
		System.out.print("Mit szeretne? (nyomja meg a megfelel� men�pontot)\n 1 - J�t�k ind�t�s\n 2 - Kil�p�s\n 3 - El�z� j�t�k bet�lt�se");
		answer =  in.nextInt();
		
		switch(answer) {
			case 1:
				System.out.println("J�t�k ind�t�sa men�");								//3 men�pont, switch-case-zel, k�nnyen b�v�thet�
		    	break;
			case 2:
				System.out.println("Kil�p�s men�pont");
		    	break;
			case 3:
				System.out.println("El�z� j�t�k bet�lt�se");
		    	break;
			default:
				System.out.println("V�lasszon a megadott men�pontok k�z�l");
		}
	}
	
	void jatekosszam () {	
		System.out.print("H�nyan fogtok j�tszani?\n");
		
		boolean megfelelo = false;
		
		do {																			//do-while ciklus, mert addig kell a j�t�kosoksz�m�t
			answer =  in.nextInt();														//be�tni, am�gy a megfelel� tartom�nyon bel�l nincs
			if(answer < 3) {															
				System.out.println("T�l kev�s! Legal�bb 3 j�t�kos kell");				//a felt�telek miatt nem lehetett switch - caset alkalmazni
			}
			
			if(answer > 10) {
				System.out.println("T�l sokan vagytok! Maximum 10-en j�tszhattok");
			}
			
			if(answer > 2 && answer < 9) {
				System.out.println("Elind�tjuk a j�t�kot");								//Itt megfelel� a j�t�kossz�m, itt fogjuk elind�tani a j�t�kot
				megfelelo = true;
			}
		}
		while (megfelelo != true);
	}
}
