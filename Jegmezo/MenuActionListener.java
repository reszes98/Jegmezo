package Jegmezo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * @author Henrik
 * A Men� gombok actionlistenerjei vannak itt megval�s�tva
 */
public class MenuActionListener implements ActionListener{
	private JFrame jf;
	private JTextField eszkimoTf;
	private JTextField sarkkutatoTf;
	private JLabel utasitas;
	Menu menu = new Menu();

	public MenuActionListener(JFrame jf, JTextField et, JTextField st, JLabel ul ) {
		this.jf = jf;
		this.eszkimoTf = et;
		this.sarkkutatoTf = st;
		this.utasitas = ul;
	}

	/**
	 * A men�n t�rt�n� esem�nyket kezeli le
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Kil�p�s")) {
			jf.setVisible(false);
			System.out.println("kil�p�s");
			System.exit(0);
		}
		
		if (ae.getActionCommand().equals("J�t�k!")) {
			int enumb = Integer.parseInt(eszkimoTf.getText());
			int snumb = Integer.parseInt(sarkkutatoTf.getText());
			int osszeg = enumb+snumb;
			if(osszeg > 10) {
				utasitas.setFont(new Font("Curier New", Font.BOLD, 15));
				utasitas.setText("T�l sok j�t�kos! (Maximum 10)");
			}
			if(osszeg < 3) {
				utasitas.setFont(new Font("Curier New", Font.BOLD, 15));
				utasitas.setText("T�l kev�s j�t�kos! (Minimum 3)");
			}
			if(osszeg > 2 && osszeg < 6) {
				Controller cont = new Controller (this.menu);
				cont.palyaLetrehoz(enumb, snumb, 8, 1);
				jf.setVisible(false);
			} 
			
			if(osszeg > 5 && osszeg < 11) {
				Controller cont = new Controller (this.menu);
				cont.palyaLetrehoz(enumb, snumb, 8, 1);
				jf.setVisible(false);
			} 
		}
		
		if (ae.getActionCommand().equals("J�t�kra fel!")) {

			jf.dispose();
			menu.Game();
		}
		
		if (ae.getActionCommand().equals("Tov�bb")) {
			jf.dispose();
			menu.MenuDisplay();
		}
		
	}
}
