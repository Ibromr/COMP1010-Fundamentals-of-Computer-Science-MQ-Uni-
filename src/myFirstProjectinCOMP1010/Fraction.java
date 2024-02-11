package myFirstProjectinCOMP1010;

public class Fraction {

	
	public int num, den;

	public Fraction(int n, int d) { //assume d is not 0
		num = n;
		den = d;
	}
	
	public String toString() {
	    return num + "/" + den;
	}

    Fraction product(Fraction other ){
        Fraction result = new Fraction(this.num*other.num, this.den*other.den);
       
    
        return result;
    } 
	public static void main(String[] args) {
		Fraction a = new Fraction(4, 5);
		Fraction b = new Fraction(20, 30);
		
		//Fraction c = a.product(b);    it is the same with println
		System.out.println(a.product(b));
		

	}

}
