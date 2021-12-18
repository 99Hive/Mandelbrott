
public class Complex {
	double re,  im;

	//    / Skapar en komplex variabel med realdelen re och imagin�rdelen im */
	Complex(double re, double im){

		this.re = re;
		this.im = im;

	}

	//    / Tar reda p� realdelen */
	double getRe() {

		return re;
	}

	//    / Tar reda p� imagin�rdelen */
	double getIm() {

		return im;
	}

	//    / Tar reda p� talets absolutbelopp i kvadrat */
	double getAbs2() {

		return Math.pow(re, 2)+ Math.pow(im, 2);

	}


	public void add(Complex c) {

		this.re+=c.getRe();
		this.im+=c.getIm();
		//a = new Complex (Newre,Newim);
	}



	//    / Multiplicerar detta tal med det komplexa talet c /
	public void mul(Complex c) {

		double newRe = (re*c.getRe() -im*c.getIm());
		double newIm= (im*c.getRe() + re*c.getIm());
		re = newRe;
		im = newIm;
	}
	
//	test**** anv�nds ej******
	public void div(Complex c) {

		double newRe = (re*c.getRe() -im/Math.abs(im)*getIm());
		double newIm= (im*Math.getExponent(im)*getRe() + re/c.getIm());
		re = newRe;
		im = newIm;
	}

	public void pow(Complex c) {

		double newRe = (im/Math.abs(im)*getIm());
		double newIm= (im*Math.getExponent(im)*getRe() + re/c.getIm());
		re = newRe;
		im = newIm;
	}



}
