import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.omg.PortableServer.ThreadPolicyOperations;

public class CalculView extends JPanel {

	private JTextField tfa;
	private JTextField tfA;
	private JTextField tfb;
	private JTextField tfB;
	private JTextField saisieFct;
	private JTextField result;
	private JRadioButton bpDecomp33;
	private JRadioButton bpDecomp44;
	private JButton bpLancer;
	
	
	public CalculView() {
		
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
		fct.add(new JLabel("f(x)"));
		this.saisieFct = new JTextField();
		this.saisieFct.setPreferredSize(new Dimension(120, 25));
		fct.add(this.saisieFct);
		
		res.setLayout(new FlowLayout());
		res.add(new JLabel("res"));
		this.result = new JTextField();
		this.result.setPreferredSize(new Dimension(120, 25));
		this.result.setEnabled(false);
		res.add(this.result);
		
		//Panneau de décomposition
		decomp.setLayout(new GridLayout(2,1));

		
		this.bpDecomp33 = new JRadioButton("3 x 3");
		this.bpDecomp44 = new JRadioButton("5 x 5");
		
		decomp.add(this.bpDecomp33);
		decomp.add(this.bpDecomp44);
		
		//panneau lancement de calcul
		lancer.setLayout(new GridLayout(1, 1));
		
		this.bpLancer = new JButton ("Lancer le calcul");
		
		lancer.add(this.bpLancer);
	}
}
