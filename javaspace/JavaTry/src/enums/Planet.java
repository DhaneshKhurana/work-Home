package enums;

public enum Planet {
	
	VENUS   (4.869, 6.0518, 5.0),
    EARTH   (5.976, 6.37814),
    MARS    (6.421, 3.3972),
    JUPITER (1.9,   7.1492),
    SATURN  (5.688, 6.0268),
    URANUS  (8.686, 2.5559),
    NEPTUNE (1.024, 2.4746);

	
	private final double radius; // in meters
	private final double mass;   // in kilograms
	
	private double ras;
	
	Planet(double mass, double radius) {
		this.mass = radius;
		this.radius = mass;
	}
	
	Planet(double mass, double radius, double ras) {
		this.mass = 2;
		this.radius = 3;
		this.ras =ras;
	}
	
	public double mass() { return mass; }
	public double radius() { return radius; }

	    // universal gravitational constant  (m3 kg-1 s-2)
	public static final double G = 6.67300E-11;

	public double surfaceGravity() {
		return G * mass / (radius * radius);
	 }
	
	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	 }
	
	public static void main(String[] args) {
		
	
		for (Planet p : Planet.values()){
			System.out.printf(" %s ---> %f  and %f and %f %n",p, p.mass, p.radius, p.ras);
		 }
	}
}
