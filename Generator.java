import java.awt.Color;

import javax.swing.text.AttributeSet.ColorAttribute;

public class Generator {


	public void render(MandelbrotGUI gui) {
		gui.disableInput();
		Complex c;
		Complex[][] complex = mesh(gui.getMinimumReal(),gui.getMaximumReal(), gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(), gui.getHeight());
		Color[][] picture = new Color[gui.getHeight()] [gui.getWidth()];
		
		for(int i=0; i<gui.getHeight(); i++) {
			for(int j=0; j<gui.getWidth(); j++) {
				int it=0;//iterationer
				c= complex[i][j];
				Complex z0 = new Complex(0, 0);
				while(it<200 && z0.getAbs2()<=4) {//when the it is more than 200 and the value is under 4
					// ekva
					z0.mul(z0);
					z0.add(c);
//					z0.div(c);
//					z0.pow(c);
					it++;
				}
				switch(gui.getMode()) {
				
				case MandelbrotGUI.MODE_BW:
					if(it==200) {
						picture[i][j]= Color.black;
					}
					else if(it<200) {
						picture[i][j]= Color.white;
					}
					break;
					
				case MandelbrotGUI.MODE_COLOR:
				
					if(it==200) {
						picture[i][j]= Color.black;
					}
					
					else if(it<10) {
						picture[i][j]= Color.orange;
	
					}
					else if(it<50) {
						picture[i][j]= Color.red;
	
					}
					else if(it<75) {
						picture[i][j]= Color.gray;
	
					}
					else if(it<100) {
						picture[i][j]= Color.cyan;
	
					}
					else if(it<150) {
						picture[i][j]= Color.lightGray;
	
					}
					else if(it<175) {
						picture[i][j]= Color.red;
	
					}
					else if(it<200) {
						picture[i][j]= Color.blue;
	
					}
					break;
				

			}
		}
		}

		gui.putData(picture, 1,1);
		gui.enableInput();
	}


	private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm,int width, int height){
		//		real del stegen
		double Re=(maxRe-minRe)/(width-1);
		//		im del stegen
		double Im= (maxIm-minIm)/(height-1);
		Complex[][] surf= new Complex[height][width];

		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				double one= minRe+j*(Re);//steg på real
				double two= maxIm-i*(Im);//steg på imag
				surf[i][j]= new Complex(one, two);
			}
		}

		return surf;
	}

}
