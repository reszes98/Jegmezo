package Jegmezo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	private ArrayList<Osszerendeles> targyak=new ArrayList<Osszerendeles>();
	
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
		int lyuk=0;
		for(int i=0;i<tablakDB;i++) {
			for(int j=0;j<tablakDB;j++) {
				int tartokepesseg=rand.nextInt(eszkimodb+sarkkutato+1);
				if(lyuk>10)
					while(tartokepesseg==0)
						tartokepesseg=rand.nextInt(eszkimodb+sarkkutato+2);
				if(tartokepesseg==0)lyuk++;
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
			view.addDrawableJatekos(de);
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
			view.addDrawableJatekos(ds);
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
		
		//jelzõpisztoly darabok
		//patron
		Jelzopisztoly jp=new Jelzopisztoly();
		DrawPatron dp=new DrawPatron();
		int x=rand.nextInt(tablakDB);
		int y=rand.nextInt(tablakDB);
		while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
		}
		((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(jp);
		dp.setPosition(x, y);
		Osszerendeles jpossz=new Osszerendeles(dp,jp);
		targyak.add(jpossz);
		//pisztoly
		Jelzopisztoly jp1=new Jelzopisztoly();
		DrawPisztoly dpi=new DrawPisztoly();
		while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
		}
		((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(jp1);
		dpi.setPosition(x, y);
		Osszerendeles jpossz1=new Osszerendeles(dpi,jp1);
		targyak.add(jpossz1);
		//raketa
		Jelzopisztoly jp2=new Jelzopisztoly();
		DrawRaketa dr=new DrawRaketa();
		x=rand.nextInt(tablakDB);
		y=rand.nextInt(tablakDB);
		while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
		}
		((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(jp2);
		dr.setPosition(x, y);
		Osszerendeles jpossz2=new Osszerendeles(dr,jp2);
		targyak.add(jpossz2);
		
		//búvárruhák
		for(int i=0;i<5;i++) {
			Buvarruha br=new Buvarruha();
			DrawBuvarruha dbr=new DrawBuvarruha();
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(br);
			dbr.setPosition(x, y);
			Osszerendeles brossz=new Osszerendeles(dbr,br);
			targyak.add(brossz);
		}
		
	 //élelem
		for(int i=0;i<20;i++) {
			Elelem el=new Elelem(1);
			DrawElelem del=new DrawElelem();
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(el);
			del.setPosition(x, y);
			Osszerendeles eossz=new Osszerendeles(del,el);
			targyak.add(eossz);
		}
		
		//aso
		for(int i=0;i<7;i++) {
			Aso a=new Aso();
			DrawAso da=new DrawAso();
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(a);
			da.setPosition(x, y);
			Osszerendeles dossz=new Osszerendeles(da,a);
			targyak.add(dossz);
		}
		
		//torekenyaso
		for(int i=0;i<7;i++) {
			TorekenyAso ta=new TorekenyAso(rand.nextInt(7)+1);
			DrawTorekenyAso dta=new DrawTorekenyAso();
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(ta);
			dta.setPosition(x, y);
			Osszerendeles daossz=new Osszerendeles(dta,ta);
			targyak.add(daossz);
		}
		
		//sator
		for(int i=0;i<7;i++) {
			Sator s=new Sator(rand.nextInt(5)+1);
			DrawSator ds=new DrawSator();
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
			}
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(s);
			ds.setPosition(x, y);
			Osszerendeles dsossz=new Osszerendeles(ds,s);
			targyak.add(dsossz);
		}
		
		//kotel
		for(int i=0;i<5;i++) {
			Kotel k=new Kotel();
			DrawKotel dk=new DrawKotel();
			x=rand.nextInt(tablakDB);
			y=rand.nextInt(tablakDB);
			int breakcnt=0;
			while(((Jegtabla)jegtablak.get(y*tablakDB+x).obj).getTargy()!=null||((Jegtabla)jegtablak.get(y*tablakDB+x).obj).gettartokepesseg()==0) {
				x=rand.nextInt(tablakDB);
				y=rand.nextInt(tablakDB);
				breakcnt++;
				if(breakcnt>54)break;
			}
			((Jegtabla)jegtablak.get(y*tablakDB+x).obj).setTargy(k);
			dk.setPosition(x, y);
			Osszerendeles dkossz=new Osszerendeles(dk,k);
			targyak.add(dkossz);
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
				JCtaska=view.getAktTaska();
				Targy acttargy = (Targy) JCtaska.getSelectedItem();
				if(acttargy!=null) {
					Osszerendeles targy=null;
					for(int i=0;i<targyak.size();i++) {
						if(((Targy)targyak.get(i).obj).equals(acttargy))
							targy=targyak.get(i);
					}
					boolean siker=(((Jatekos)koronlevo.obj).targyHasznalat(JCtaska.getSelectedIndex()));
					if(siker) {
						if(acttargy.toString().equals("Elelem")) {
							view.setTestho(((Jatekos)koronlevo.obj).getTestho());
							JCtaska.removeItem(acttargy);
						}
						if(acttargy.toString().equals("Sator")) {
							JCtaska.removeItem(acttargy);
							view.addDrawableVedelem(targy.draw);
						}
						if(acttargy.toString().equals("Buvarruha")) {
							Drawable dj=koronlevo.draw;
							
							Jegtabla jt=((Jatekos)koronlevo.obj).JegtablaLekerdez();
							
							for(int j=0;j<jegtablak.size();j++) {
								if(((Jegtabla)jegtablak.get(j).obj).equals(jt)) {
									dj.setPosition(jegtablak.get(j).draw.getPositionX(), jegtablak.get(j).draw.getPositionY());
									if(jt.getAtVanFordulva()){
										DrawViz dv=new DrawViz();
										if(jegtablak.get(j).draw!=null) {
											dv.setPosition(koronlevo.draw.getPositionX(), koronlevo.draw.getPositionY());
											view.eltavolitDrawable(jegtablak.get(j).draw);
										}
										
										jegtablak.get(j).draw=dv;
										view.addDrawable(dv);
									}
								}
							}
						}
						if(acttargy.toString().equals("Aso")) {
							Jegtabla jt=((Jatekos)koronlevo.obj).JegtablaLekerdez();
							if(!jt.getAtVanFordulva()) {
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
											if(jt.getHo()<=-1&&jt.getTargy()!=null) {
												for(int j=0;j<targyak.size();j++) {
													if(((Targy)targyak.get(j).obj).equals(jt.getTargy())) {
														view.eltavolitDrawableTargy(targyak.get(j).draw);
														view.addDrawableTargy(targyak.get(j).draw);
													}
												}
											}
										}
									}
								}
							}
						}
						if(acttargy.toString().equals("TorekenyAso")) {
							if(((TorekenyAso)acttargy).getTartossag()==0)
								JCtaska.removeItem(acttargy);
							Jegtabla jt=((Jatekos)koronlevo.obj).JegtablaLekerdez();
							if(!jt.getAtVanFordulva()) {
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
											if(jt.getHo()<=-1&&jt.getTargy()!=null) {
												for(int j=0;j<targyak.size();j++) {
													if(((Targy)targyak.get(j).obj).equals(jt.getTargy())) {
														view.eltavolitDrawableTargy(targyak.get(j).draw);
														view.addDrawableTargy(targyak.get(j).draw);
													}
												}
											}
										}
									}
								}
							}
						}
						if(acttargy.toString().equals("Kotel")) {
							Jegtabla jt=((Jatekos)koronlevo.obj).JegtablaLekerdez();
							Jegtabla jtsz=jt.szomszedKerdez(((Jatekos)koronlevo.obj).getSzogAmibeNez());
							ArrayList<Osszerendeles> jossz=new ArrayList<Osszerendeles>();
							List<Jatekos> jat=jtsz.jatekosokLekerdez();
							for(int i=0;i<jatekosok.size();i++) {
								for(int j=0;j<jat.size();j++) {
									if(((Jatekos)jatekosok.get(i).obj).equals(jat.get(j))) {
										jossz.add(jatekosok.get(i));
									}
								}
							}
							for(int i=0;i<jossz.size();i++) {
								jossz.get(i).draw.setPosition(koronlevo.draw.getPositionX(), koronlevo.draw.getPositionY());
							}
						}
						if(acttargy.toString().equals("Jelzopisztoly")) {
							view.gameWon();
						}
						view.setMunka(((Jatekos)koronlevo.obj).getMunkadb());
						view.drawAll();
					}
				}
			}
			
			if (ae.getActionCommand().equals("Felvesz")) {
				JCtaska=view.getAktTaska();
				Targy t=null;
				for(int i=0;i<jegtablak.size();i++) {
					if(((Jegtabla)jegtablak.get(i).obj).equals(((Jatekos)koronlevo.obj).JegtablaLekerdez())) {
						t=((Jegtabla)jegtablak.get(i).obj).getTargy();
					}
				}
				Osszerendeles targy=null;
				if(t!=null) {
					
					for(int i=0;i<targyak.size();i++) {
						if(((Targy)targyak.get(i).obj).equals(t))
							targy=targyak.get(i);
					}
					boolean sikeres=((Jatekos)koronlevo.obj).targyFelvetel();
					if(sikeres) {
						JCtaska.addItem(t);
						view.eltavolitDrawableTargy(targy.draw);
					}
					view.setMunka(((Jatekos)koronlevo.obj).getMunkadb());
					view.drawAll();
					
				}
				
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
								if(jt.getHo()<=-1&&jt.getTargy()!=null) {
									for(int j=0;j<targyak.size();j++) {
										if(((Targy)targyak.get(j).obj).equals(jt.getTargy())) {
											view.eltavolitDrawableTargy(targyak.get(j).draw);
											view.addDrawableTargy(targyak.get(j).draw);
										}
									}
								}
							}
						}
					}
					view.drawAll();
				}
			}
		}
	}
	
	
	
	
}
