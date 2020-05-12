package Jegmezo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.*;


public class Controller {
	Menu menu;
	private Jegmezo jegmezo;
	private View view;
	private Osszerendeles koronlevo;
	private int koronlevoIdx;
	private ArrayList<Osszerendeles> jegtablak=new ArrayList<Osszerendeles>();
	private int jegtablakDB;
	private ArrayList<Osszerendeles> jegesmedvek=new ArrayList<Osszerendeles>();
	private ArrayList<Osszerendeles> satrak=new ArrayList<Osszerendeles>();
	private ArrayList<Osszerendeles> jatekosok=new ArrayList<Osszerendeles>();
	
	/**
	 * drawable objektum összerendelése a tényleges objektummal
	 *
	 */
	class Osszerendeles{
		public Drawable draw;
		public Object obj;
		public Osszerendeles(Drawable d, Object o) {
			draw=d; obj=o;
		}
	}
	
	public Controller(Menu m) {
		menu=m;
		
	}
	
	/**
	 * @param eszkimodb hány eszkimó legyen a pályán
	 * @param sarkkutato hány sarkkutató legyen
	 * @param tablakDB hány tábla legyen
	 * @param jegesmedvedb hány jegesmedve legyen
	 */
	public void palyaLetrehoz(int eszkimodb, int sarkkutato, int tablakDB, int jegesmedvedb) {
		view=new View(this, menu);
		jegmezo=new Jegmezo(5);
		Random rand=new Random();
		jegtablakDB=tablakDB;
		
		Jegtabla jgk[][] = new Jegtabla[jegtablakDB][jegtablakDB];

		for(int i=0;i<tablakDB;i++) {
			for(int j=0;j<tablakDB;j++) {
				int tartokepesseg=rand.nextInt(eszkimodb+sarkkutato);
				int ho=rand.nextInt(5)+1;
				boolean atforditva=false;
				if(tartokepesseg==0)atforditva=true;
				int szomszedok=4;
				Jegtabla jt=new Jegtabla(jegmezo,atforditva,ho,tartokepesseg,szomszedok);
				jgk[i][j] = jt;
			}
		}
		
		for(int i=0;i<tablakDB;i++) {
			for(int j=0;j<tablakDB;j++) {
				
				Jegtabla sz0 = j + 1 < jegtablakDB? jgk[i][j + 1] : null;
				Jegtabla sz1 = i - 1 >= 0? jgk[i - 1][j] : null;
				Jegtabla sz2 = j - 1 >= 0? jgk[i][j - 1] : null;
				Jegtabla sz3 = i + 1 < jegtablakDB? jgk[i + 1][j] : null;
				jgk[i][j].setSzomszed(sz0,0, 0);
				jgk[i][j].setSzomszed(sz1, 1,90);
				jgk[i][j].setSzomszed(sz2,2,180);
				jgk[i][j].setSzomszed(sz3, 3,270);

				
				DrawHo dho=new DrawHo();
				dho.setPosition(j, i);
				view.addDrawable(dho);
				
				Osszerendeles uj=new Osszerendeles(dho, jgk[i][j]);
				jegtablak.add(uj);
				

				jegmezo.addFrissitheto(jgk[i][j]);
			}
		}
		
		for(int i=0;i<eszkimodb;i++) {
			Eszkimo e=new Eszkimo(jegmezo,4,5);
			int x=rand.nextInt(tablakDB);
			int y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getJatekosokSzama()!=0||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getAtVanFordulva()) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			DrawEszkimo de=new DrawEszkimo();
			de.setPosition(x, y);
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).addJatekos(e);
			jatekosok.add(new Osszerendeles(de,e));
			view.addDrawable(de);
			view.AddTaska(new JComboBox<Object>());
		}
		for(int i=0;i<sarkkutato;i++) {
			Sarkkutato s=new Sarkkutato(jegmezo,4,5);
			int x=rand.nextInt(tablakDB);
			int y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getJatekosokSzama()!=0||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getAtVanFordulva()) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			DrawSarkkutato ds=new DrawSarkkutato();
			ds.setPosition(x, y);
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).addJatekos(s);
			jatekosok.add(new Osszerendeles(ds,s));
			view.addDrawable(ds);
			view.AddTaska(new JComboBox<Object>());
			
		}
		for(int i=0;i<jegesmedvedb;i++) {
			Jegesmedve jm=new Jegesmedve(jegmezo,true);
			int x=rand.nextInt(tablakDB);
			int y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getJatekosokSzama()!=0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			DrawJegesmedve djm=new DrawJegesmedve();
			djm.setPosition(x, y);
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).addJegesmedve(jm);
			jegesmedvek.add(new Osszerendeles(djm,jm));
			view.addDrawable(djm);
		}
		koronlevo=jatekosok.get(0);
		koronlevoIdx=0;
		view.setAktTaska(koronlevoIdx);
		view.setTestho(((Jatekos)koronlevo.obj).getTestho());
		view.setMunka(((Jatekos)koronlevo.obj).getMunkadb());
		view.drawAll();
		
	}
	
	/**
	 * ha a játékosnak elfogytak a munkái vagy tovább adta a körét
	 */
	public void korLeptet() {
		
		if(++koronlevoIdx>=jegmezo.GetJatekosSzam()) {
			koronlevoIdx=0;
			ujKor();
		}
		koronlevo=jatekosok.get(koronlevoIdx);
		view.setAktTaska(koronlevoIdx);
		view.setMunka(((Jatekos)koronlevo.obj).getMunkadb());
		view.setTestho(((Jatekos)koronlevo.obj).getTestho());
		view.drawAll();
	}
	
	/**
	 * minden játékos sorrakerült, új kör
	 */
	public void ujKor() {
		boolean drawho=false;
		ArrayList<Integer> nincsho=new ArrayList<Integer>();
		if(jegmezo.getHoviharCnt()==0) {
			drawho=true;
			
			for(int i=0;i<jegtablak.size();i++) {
				if(((Jegtabla)jegtablak.get(i).obj).getHo()<=0) nincsho.add(i);
			}
		}
		jegmezo.leptet();
		if(drawho==true) {
			for(int i=0;i<nincsho.size();i++) {
				DrawHo dh=new DrawHo();
				dh.setPosition(nincsho.get(i)-(nincsho.get(i)%jegtablakDB)*jegtablakDB, nincsho.get(i)%jegtablakDB);
				view.addDrawable(dh);
				view.eltavolitDrawable(jegtablak.get(nincsho.get(i)).draw);
				jegtablak.get(nincsho.get(i)).draw=dh;
			}
		}
		
		for(int i=0;i<satrak.size();i++) {
			if(((Sator)satrak.get(i).obj).tartossag==0)
				view.eltavolitDrawable(satrak.get(i).draw);
		}
		for(int i=0;i<jegesmedvek.size();i++) {
			Jegesmedve jm=(Jegesmedve)jegesmedvek.get(i).obj;
			Drawable djm=jegesmedvek.get(i).draw;
			if(jm.getLepett()) {
				for(int j=0;j<jegtablak.size();j++) {
					if(((Jegtabla)jegtablak.get(j).obj).equals(jm.getJegtabla())) {
						
						djm.setPosition(jegtablak.get(j).draw.getPositionX(), jegtablak.get(j).draw.getPositionY());
					}
				}
			}
		}
		view.drawAll();
	}
	
	public class TargyActionListener implements ActionListener {
		JComboBox<Object> JCtaska;
		public TargyActionListener(JComboBox<Object> taska) {
			JCtaska=taska;
		}
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Tárgy Használ")) {
				Targy acttargy = (Targy) JCtaska.getSelectedItem();
				if(acttargy!=null)
					acttargy.hasznal(((Jatekos)koronlevo.obj));
			}
			
			if (ae.getActionCommand().equals("Felvesz")) {
				((Jatekos)koronlevo.obj).targyFelvetel();
			}

		}
	}
	
	public class GombokActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			if (ae.getActionCommand().equals("Bal")) {
				((Jatekos)koronlevo.obj).Fordul(false);
			}
			
			if (ae.getActionCommand().equals("Jobb")) {

				((Jatekos)koronlevo.obj).Fordul(true);
			}
			
			if (ae.getActionCommand().equals("Lép")) {
				int szog=((Jatekos)koronlevo.obj).getSzogAmibeNez();
				boolean siker=((Jatekos)koronlevo.obj).lepes();
				if(siker) {
					
					Drawable dj=koronlevo.draw;
					
					Jegtabla jt=((Jatekos)koronlevo.obj).JegtablaLekerdez();
					
					for(int i=0;i<jegtablak.size();i++) {
						if(((Jegtabla)jegtablak.get(i).obj).equals(jt)) {
							dj.setPosition(jegtablak.get(i).draw.getPositionX(), jegtablak.get(i).draw.getPositionY());
							if(jt.getAtVanFordulva()){
								DrawViz dv=new DrawViz();
								if(jegtablak.get(i).draw!=null) {
									dv.setPosition(koronlevo.draw.getPositionX(), koronlevo.draw.getPositionY());
									view.eltavolitDrawable(jegtablak.get(i).draw);
								}
								
								jegtablak.get(i).draw=dv;
								view.addDrawable(dv);
							}
						}
					}
					
					
					view.setMunka(((Jatekos)koronlevo.obj).getMunkadb());
					view.drawAll();
				}
			}
			
			if (ae.getActionCommand().equals("Képesseg Használ")) {
				((Jatekos)koronlevo.obj).kepesseg();
			}

			if (ae.getActionCommand().equals("Jöhet a következõ")) {
				korLeptet();
			}
			if (ae.getActionCommand().equals("Ásás")) {
				Jegtabla jt=((Jatekos)koronlevo.obj).JegtablaLekerdez();
				if(!jt.getAtVanFordulva()) {
						((Jatekos)koronlevo.obj).asas();
						view.setMunka(((Jatekos)koronlevo.obj).getMunkadb());
					if(jt.getHo()<=0) {
						for(int i=0;i<jegtablak.size();i++) {
							if(((Jegtabla)jegtablak.get(i).obj).equals(jt)) {
								if(jegtablak.get(i).draw!=null) {
									view.eltavolitDrawable(jegtablak.get(i).draw);
								}
								DrawJegtabla djt=new DrawJegtabla();
								djt.setPosition(koronlevo.draw.getPositionX(), koronlevo.draw.getPositionY());
								jegtablak.get(i).draw=djt;
								view.addDrawable(djt);
							}
						}
					}
					view.drawAll();
				}
			}
		}
	}
	
	
	
	
}
