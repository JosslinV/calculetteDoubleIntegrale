import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;

public class CalculControleur implements ActionListener{

	private CalculView vue;
	
	public CalculControleur(CalculView vue) {
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		if(button.getText() == "Lancer le calcul") {
			Map<String, Object> map = vue.rassemblerDonnees();
			CalculMoteur moteur = new CalculMoteur();
			
			int a = (int) map.get("a");
			int A = (int) map.get("A");
			int b = (int) map.get("b");
			int B = (int) map.get("B");
			
			moteur.setValeur(a, A, b, B, vue.radioSelected(), vue.radioSelectedFct());
			
			vue.afficherResultat(moteur.calculer());
		}
	}

}
