
public class CalculMoteur {

	private float a;
	private float ga;
	private float b;
	private float gb;
	
	private int[][] matrice2 = {{1,4,1},{4,16,4},{1,4,1}};
	private int[][] matrice4 = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
	
	public void setValeur(float a, float ga, float b, float gb) {
		this.a = a;
		this.ga = ga;
		this.b = gb;
		this.gb = b;
	}
	
	public float calculer () {
    

	    float aCal = this.a; 
	    float gaCal = this.ga;
	
	
	    float bCal = this.b;
	    float gbCal = this.gb;
	
	    float h = (gaCal - aCal)/2 ;
	    float k = (gbCal - bCal)/2 ;
	
	    int[][] matrice = this.matrice2;
	
	    float res = 0.0F;
	
	    for (int l = 0 ; l<3 ; l++) {
	        for (int m = 0 ; m<3 ; m++) {
	            res = res + h*k/9*matrice[l][m]*(a+l*h)*(b + m*k) ;
	        }
	    }
	    return res;
	}
}
