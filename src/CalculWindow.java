import javax.swing.JFrame;

public class CalculWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private CalculView appli;
	
	public CalculWindow() {
		this.setTitle("Calculatrice de double intégrale");
		this.appli = new CalculView();
		this.setResizable(false);
		this.add(this.appli);
		this.pack();
		this.setVisible(true);
		this.setSize(500, 500);
	}

}
