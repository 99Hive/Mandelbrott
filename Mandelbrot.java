
public class Mandelbrot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MandelbrotGUI gui = new MandelbrotGUI();
		Generator gen = new Generator();
		boolean rita= false;
		
		while (true) {

			switch (gui.getCommand()) {

			case MandelbrotGUI.RENDER: 
				
				gen.render(gui);
				rita=true;

				break;

			case MandelbrotGUI.RESET: 

				gui.resetPlane();
				gui.clearPlane();
				rita=false;
				break;

			case MandelbrotGUI.QUIT: 
				System.exit(0);
				rita=false;
				break;

			case MandelbrotGUI.ZOOM: 
				if(rita== true) {
					gen.render(gui);
				}
				break;
			}
		}



	}

}
