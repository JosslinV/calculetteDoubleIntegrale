
public class CalculMoteur {

	private float a;
	private float ga;
	private float b;
	private float gb;
	private int[][] matriceSelect;
	private int choixFonction;
	
	private final int[][] MATRICE_2 = {{1,4,1},{4,16,4},{1,4,1}};
	private final int[][] MATRICE_4 = {{1,4,2,4,1},{4,16,8,16,4},{2,8,16,8,2},{4,16,8,16,4},{1,4,2,4,1}};
	private int diviseur;
	
	public void setValeur(float a, float ga, float b, float gb, int matrice, int choixFonction) {
		this.a = a;
		this.ga = ga;
		this.b = gb;
		this.gb = b;
		this.setMatrice(matrice);
		this.choixFonction = choixFonction;
	}
	
	public void setMatrice(int matrice) {
		if(matrice == 1) {
			this.diviseur = 2;
			this.matriceSelect = this.MATRICE_2;
		} else if(matrice == 2) {
			this.diviseur = 4;
			this.matriceSelect = this.MATRICE_4;
		}
	}
	
	public float calculer () {
		
	    float aCal = this.a; 
	    float gaCal = this.ga;
	
	
	    float bCal = this.b;
	    float gbCal = this.gb;
	
	    float h = (gaCal - aCal)/this.diviseur ;
	    float k = (gbCal - bCal)/this.diviseur ;
	
	    int[][] matrice = this.matriceSelect;
	
	    float res = 0.0F;
		
		if(choixFonction == 1) {
		    for (int l = 0 ; l<this.matriceSelect.length ; l++) {
		        for (int m = 0 ; m<this.matriceSelect.length ; m++) {
		            res = res + h*k/9*matrice[l][m]*(a+l*h)*(b + m*k) ;
		        }
		    }
		    return res;
		    
	    } else if(choixFonction == 2) {
		    for (int l = 0 ; l<this.matriceSelect.length ; l++) {
		        for (int m = 0 ; m<this.matriceSelect.length ; m++) {
		            res = res + (float) (1 / 1 + (a+l*h) * Math.cos(b+m*k)) ;
		        }
		    } 
		    return res;
	    }
	    return 0;
	}
}
