import java.math.*;
import java.util.Scanner;

public class Calcul1c {

    public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Entrer a : ");
    float a = sc.nextFloat(); 
    System.out.println("Entrer A : ");
    float ga = sc.nextFloat();

    System.out.println("Entrer b : ");
    float b = sc.nextFloat();
    System.out.println("Entrer B : ");
    float gb = sc.nextFloat();

    float h = (ga - a)/2 ;
    float k = (gb - b)/2 ;

    int[][] matrice = { {1,4,1},
    					{4,16,4},
    					{1,4,1} } ;

    float res = 0.0F;

    for (int l = 0 ; l<3 ; l++) {
        for (int m = 0 ; m<3 ; m++) {
            res = res + h*k/9*matrice[l][m]*(a+l*h)*(b + m*k) ;
        }
    }
    sc.close();
    System.out.println(res);


}
}