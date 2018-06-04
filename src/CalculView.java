import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CalculView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfa;
	private JTextField tfA;
	private JTextField tfb;
	private JTextField tfB;
	private JTextField saisieFct;
	private JTextField result;
	private JRadioButton bpDecomp33;
	private JRadioButton bpDecomp44;
	private JButton bpLancer;
	private JRadioButton radFct1;
	private JRadioButton radFct2;
	
	
	public CalculView() {
		CalculControleur contr = new CalculControleur(this);
		
		this.setLayout(new GridLayout(2,2));
		
		JPanel entrees = new JPanel();
		JPanel decomp = new JPanel();
		JPanel fonction = new JPanel();
		JPanel lancer = new JPanel();
		
		entrees.setBorder(BorderFactory.createRaisedBevelBorder());
		decomp.setBorder(BorderFactory.createRaisedBevelBorder());
		fonction.setBorder(BorderFactory.createRaisedBevelBorder());
		lancer.setBorder(BorderFactory.createRaisedBevelBorder());
		
		this.add(entrees);
		this.add(decomp);
		this.add(fonction);
		this.add(lancer);
		
		//Panneau de saisie des entrées
		entrees.setLayout(new GridLayout(2,2));
		
		JPanel a = new JPanel();
		JPanel ga = new JPanel();
		JPanel b = new JPanel();
		JPanel gb = new JPanel();
		
		entrees.add(a);
		entrees.add(ga);
		entrees.add(b);
		entrees.add(gb);

		
		a.setLayout(new FlowLayout());
		a.add(new JLabel("a"));
		this.tfa = new JTextField();
		this.tfa.setPreferredSize(new Dimension(60, 25));
		a.add(this.tfa);
		
		ga.setLayout(new FlowLayout());
		ga.add(new JLabel("A"));
		this.tfA = new JTextField();
		this.tfA.setPreferredSize(new Dimension(60, 25));
		ga.add(this.tfA);
		
		b.setLayout(new FlowLayout());
		b.add(new JLabel("b"));
		this.tfb = new JTextField();
		this.tfb.setPreferredSize(new Dimension(60, 25));
		b.add(this.tfb);
		
		gb.setLayout(new FlowLayout());
		gb.add(new JLabel("B"));
		this.tfB = new JTextField();
		this.tfB.setPreferredSize(new Dimension(60, 25));
		gb.add(this.tfB);
		
		//Panneau de fonction
		fonction.setLayout(new GridLayout(2, 1));
		
		JPanel fct = new JPanel();
		fonction.add(fct);
		
		JPanel res = new JPanel();
		fonction.add(res);
		
		fct.setLayout(new FlowLayout());
		ButtonGroup groupFct = new ButtonGroup();
		
		this.radFct1 = new JRadioButton("dx/dy");
		this.radFct2 = new JRadioButton("sin(x)*cos(y)");
		
		groupFct.add(this.radFct1);
		fct.add(this.radFct1);
		this.radFct1.setMnemonic(1);
		this.radFct1.setSelected(true);
		
		groupFct.add(this.radFct2);
		fct.add(this.radFct2);
		this.radFct2.setMnemonic(2);
		
		res.setLayout(new FlowLayout());
		res.add(new JLabel("res"));
		this.result = new JTextField();
		this.result.setPreferredSize(new Dimension(120, 25));
		this.result.setEnabled(false);
		res.add(this.result);
		
		//Panneau de décomposition
		decomp.setLayout(new GridLayout(2,1));
		ButtonGroup group = new ButtonGroup();
		
		this.bpDecomp33 = new JRadioButton("3 x 3");
		this.bpDecomp44 = new JRadioButton("5 x 5");
		
		group.add(this.bpDecomp33);
		decomp.add(this.bpDecomp33);
		this.bpDecomp33.setMnemonic(1);
		this.bpDecomp33.setSelected(true);
		
		group.add(this.bpDecomp44);
		decomp.add(this.bpDecomp44);
		this.bpDecomp44.setMnemonic(2);
		
		//panneau lancement de calcul
		lancer.setLayout(new GridLayout(1, 1));
		
		this.bpLancer = new JButton ("Lancer le calcul");
		
		lancer.add(this.bpLancer);
		this.bpLancer.addActionListener(contr);
	}
	
	public void afficherResultat(float resultat) {
		this.result.setText(Float.toString(resultat));
	}
	
	public int radioSelected() {
		
		if(this.bpDecomp33.isSelected()) {
			return this.bpDecomp33.getMnemonic();
		} 
		
		if(this.bpDecomp44.isSelected()) {
			return this.bpDecomp44.getMnemonic();
		}
		
		return 0;
	}
	
	public int radioSelectedFct() {
		
		if(this.radFct1.isSelected()) {
			return this.bpDecomp33.getMnemonic();
		} 
		
		if(this.radFct2.isSelected()) {
			return this.bpDecomp44.getMnemonic();
		}
		
		return 0;
	}
	
	public Map<String, Object> rassemblerDonnees(){
		 Map<String, Object> map = new HashMap<String, Object>();
		 if(tfa.getText().equals("")) {
			tfa.setText("0"); 
		 }

		 if(tfA.getText().equals("")) {
			tfA.setText("0"); 
		 }
		 if(tfb.getText().equals("")) {
			tfb.setText("0"); 
		 }
		 if(tfB.getText().equals("")) {
			tfB.setText("0"); 
		 }
		 
		 map.put("a", Integer.parseInt(this.tfa.getText()));
		 map.put("A", Integer.parseInt(this.tfA.getText()));
		 map.put("b", Integer.parseInt(this.tfb.getText()));
		 map.put("B", Integer.parseInt(this.tfB.getText()));
		 
		 return map;
	}
	
}
