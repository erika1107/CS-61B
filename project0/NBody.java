
public class NBody {
	public static double readRadius(String file){
		In in = new In(file);
		int numberofplanets=in.readInt();
		double radius = in.readDouble();	
		return radius;
	}
	
	public static Planet[] readPlanets(String file) {
		In in = new In(file);
		int numberofplanets=in.readInt();
		double radius = in.readDouble();
		Planet[] allPlanets = new Planet[numberofplanets];
		for(int i=0; i<numberofplanets; i++) {
			double xP= in.readDouble();
			double yP= in.readDouble();
			double xV= in.readDouble();
			double yV= in.readDouble();
			double m= in.readDouble();
			String img=in.readString();
			allPlanets[i]= new Planet(xP, yP, xV, yV, m, img);
		}
		return allPlanets;
	}
	
	public static void main(String[]args) {
		double T=Double.parseDouble(args[0]);
		double dt=Double.parseDouble(args[1]);
		String filename= args[2];
		double radius=readRadius(filename);
		Planet[] planets=readPlanets(filename);
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius,radius);
		StdDraw.clear();
		
		for(double time=0.0; time<T; time+=dt) {
			double[] xForces=new double[planets.length];
			double[] yForces=new double[planets.length];
			for(int i=0; i<planets.length; i++) {
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
				
			}
			for(int i=0; i<planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(int i=0; i<planets.length; i++) {
				planets[i].draw();
			}
		
		StdDraw.show();
		StdDraw.pause(10);
		}
				
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}	
	}

	
}
		
		

