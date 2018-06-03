
public class CalculMoteur {

	private float a;
	private float ga;
	private float b;
	private float gb;
	private int[][] matriceSelect;
	
	private final int[][] MATRICE_2 = {{1,4,1},{4,16,4},{1,4,1}};
	private final int[][] MATRICE_4 = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
	
	public void setValeur(float a, float ga, float b, float gb, int matrice) {
		this.a = a;
		this.ga = ga;
		this.b = gb;
		this.gb = b;
		this.matriceSelect = this.setMatrice(matrice);
	}
	
	public int[][] setMatrice(int matrice) {
		if(matrice == 1) {
			return this.MATRICE_2;
		} else if(matrice == 2) {
			return this.MATRICE_4;
		}
		
		return this.MATRICE_2;
	}
	
	public float calculer () {
    

	    float aCal = this.a; 
	    float gaCal = this.ga;
	
	
	    float bCal = this.b;
	    float gbCal = this.gb;
	
	    float h = (gaCal - aCal)/2 ;
	    float k = (gbCal - bCal)/2 ;
	
	    int[][] matrice = this.matriceSelect;
	
	    float res = 0.0F;
	
	    for (int l = 0 ; l<this.matriceSelect.length ; l++) {
	        for (int m = 0 ; m<this.matriceSelect.length ; m++) {
	            res = res + h*k/9*matrice[l][m]*(a+l*h)*(b + m*k) ;
	        }
	    }
	    return res;
	}
}
