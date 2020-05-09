package Jegmezo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class Controller {
	Menu menu;
	private Jegmezo jegmezo;
	private View view;
	private Jatekos koronlevo;
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
		
		for(int i=0;i<tablakDB;i++) {
			for(int j=0;j<tablakDB;j++) {
				DrawJegtabla djt=new DrawJegtabla();
				djt.setPosition(j, i);
				view.addDrawable(djt);
				DrawHo dho=new DrawHo();
				dho.setPosition(j, i);
				view.addDrawable(dho);
				int tartokepesseg=rand.nextInt(eszkimodb+sarkkutato);
				int ho=rand.nextInt(5)+1;
				boolean atforditva=false;
				if(tartokepesseg==0)atforditva=true;
				int szomszedok=4;
				if(i==0||i==tablakDB-1&&j==0||j==tablakDB-1) szomszedok=2;
				if(i==0||i==tablakDB-1&&!(j==0||j==tablakDB-1)) szomszedok=3;
				
				Jegtabla jt=new Jegtabla(jegmezo,atforditva,ho,tartokepesseg,szomszedok);
				Osszerendeles uj=new Osszerendeles(dho, jt);
				jegtablak.add(uj);
				if(i!=0) { //minden alsó sor beállítja a felsõt szomszédnak
					jt.setSzomszed((Jegtabla) jegtablak.get(jegtablak.size()-tablakDB-1).obj, 1, 90);
					Jegtabla jegt=(Jegtabla)jegtablak.get(jegtablak.size()-tablakDB-1).obj;
					jegt.setSzomszed(jt, 3, 270);
				}
				if(j!=0) {//minden jobb olsali oszlop beállítja a balt szomszédnak
					Jegtabla jegt=(Jegtabla)jegtablak.get(jegtablak.size()-2).obj;
					jegt.setSzomszed(jt, 0, 0);
					jt.setSzomszed((Jegtabla)jegtablak.get(jegtablak.size()-2).obj, 2, 180);
				}
				
					
				jegmezo.addFrissitheto(jt);
			}
		}
		for(int i=0;i<eszkimodb;i++) {
			Eszkimo e=new Eszkimo(jegmezo,4,5);
			int x=rand.nextInt(tablakDB);
			int y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getJatekosokSzama()!=0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			DrawEszkimo de=new DrawEszkimo();
			de.setPosition(x, y);
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).addJatekos(e);
			jatekosok.add(new Osszerendeles(de,e));
			view.addDrawable(de);
			view.AddTaska(new JComboBox<Object>());
			jegmezo.addJatekos(e);
		}
		for(int i=0;i<sarkkutato;i++) {
			Sarkkutato s=new Sarkkutato(jegmezo,4,5);
			int x=rand.nextInt(tablakDB);
			int y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getJatekosokSzama()!=0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			DrawSarkkutato ds=new DrawSarkkutato();
			ds.setPosition(x, y);
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).addJatekos(s);
			jatekosok.add(new Osszerendeles(ds,s));
			view.addDrawable(ds);
			view.AddTaska(new JComboBox<Object>());
			jegmezo.addJatekos(s);
		}
		for(int i=0;i<jegesmedvedb;i++) {
			Jegesmedve jm=new Jegesmedve(jegmezo,rand.nextBoolean());
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
			jegmezo.addFrissitheto(jm);
		}
		koronlevo=jegmezo.getJatekosok().get(0);
		koronlevoIdx=0;
		view.setTestho(koronlevo.getTestho());
		view.setMunka(koronlevo.getMunkadb());
		view.drawAll();
	}
	
	/**
	 * ha a játékosnak elfogytak a munkái vagy tovább adta a körét
	 */
	public void korLeptet() {
		if(++koronlevoIdx>=jegmezo.GetJatekosSzam()-1) {
			koronlevoIdx=0;
			ujKor();
		}
		koronlevo=jegmezo.getJatekosok().get(koronlevoIdx);
		view.setAktTaska(koronlevoIdx);
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
				int szog=jm.getSzog();
				if(szog==0) {
					djm.setPositionX(djm.getPositionX()+1);
				}
				else if(szog==90) {
					djm.setPositionY(djm.getPositionY()-1);
				}
				else if(szog==180) {
					djm.setPositionX(djm.getPositionX()-1);
				}
				else if(szog==270) {
					djm.setPositionY(djm.getPositionY()+1);
				}
			}
		}
	}
	
	public class TargyActionListener implements ActionListener {
		JComboBox<Object> JCtaska;
		public TargyActionListener(JComboBox<Object> taska) {
			JCtaska=taska;
		}
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Tárgy Használ")) {
				Targy acttargy = (Targy) JCtaska.getSelectedItem();
				acttargy.hasznal(koronlevo);
			}
			
			if (ae.getActionCommand().equals("Felvesz")) {
				koronlevo.targyFelvetel();
			}

		}
	}
	
	public class GombokActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			if (ae.getActionCommand().equals("Bal")) {
				koronlevo.Fordul(false);
			}
			
			if (ae.getActionCommand().equals("Jobb")) {
				koronlevo.Fordul(true);
			}
			
			if (ae.getActionCommand().equals("Lep")) {
				koronlevo.lepes();
			}
			
			if (ae.getActionCommand().equals("Kepesseg Hasznal")) {
				koronlevo.kepesseg();
			}
			
			if (ae.getActionCommand().equals("Jöhet a következõ")) {
				korLeptet();
			}
		}
	}
	
	
	
	
}
