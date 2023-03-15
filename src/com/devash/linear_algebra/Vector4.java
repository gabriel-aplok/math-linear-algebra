package com.devash.linear_algebra;

public class Vector4 extends Vector {
	public static final int W = 0;
	public static final int X = 1;
	public static final int Y = 2;
	public static final int Z = 3;

	public Vector4(float w, float x, float y, float z) {
		super(new float[] {w, x, y, z});
	}

	public void setW(float w) {
		super.setValue(W, w);
	}

	public float getW() {
		return super.getValue(W);
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

	public void setZ(float z) {
		super.setValue(Z, z);
	}

	public float getZ() {
		return super.getValue(Z);
	}
}
