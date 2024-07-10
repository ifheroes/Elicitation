package de.idev.tools.math;

/*
 * Linear Function for the base building and fly speed
 * 
 * might need to be updated for a more general purpose
 */

public class LinearFunction {

	private double m;
	private double b;

	public LinearFunction(double m, double b) {
		this.m = m;
		this.b = b;
	}

	public float f(double x) {
		float value = (float) (m * (x+40) + b);
		if (value > 1) return 1;
		if (value < 0.1) return 0.1f;
		return value;
	}

}
