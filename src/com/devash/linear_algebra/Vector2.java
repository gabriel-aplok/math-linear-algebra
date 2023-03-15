package com.devash.linear_algebra;

public class Vector2 extends Vector {
	public static final Vector2 ZERO = new Vector2(0, 0);
	public static final Vector2 X_UNIT = new Vector2(1, 0);
	public static final Vector2 Y_UNIT = new Vector2(0, 1);
	public static final int X = 0;
	public static final int Y = 1;

	public Vector2(float x, float y) {
		super(new float[] {x, y});
	}

	public void setX(float x) {
		super.setValue(X, x);
	}

	public float getX() {
		return super.getValue(X);
	}

	public void setY(float y) {
		super.setValue(X, y);
	}

	public float getY() {
		return super.getValue(Y);
	}
}
