package com.devash.linear_algebra;

import java.util.StringJoiner;

public class Vector {
	private final float[] values;

	public Vector(float[] values) {
		this.values = values.clone();
	}

	public Vector add(Vector v) {
		float[] values = new float[dimensions()];

		for (int i = 0; i < values.length; i++) {
			values[i] = values[i] + v.values[i];
		}

		return new Vector(values);
	}

	public Vector sub(Vector v) {
		return add(v.negate());
	}

	public Vector mul(float c) {
		float[] values = new float[dimensions()];

		for (int i = 0; i < values.length; i++) {
			values[i] = values[i] * c;
		}

		return new Vector(values);
	}

	public float dotProduct(Vector v) {
		float dotProduct = 0;

		for (int i = 0; i < values.length; i++) {
			dotProduct += values[i] * v.values[i];
		}

		return dotProduct;
	}

	public Vector hadamardProduct(Vector v) {
		float[] values = new float[dimensions()];

		for (int i = 0; i < values.length; i++) {
			values[i] = values[i] * v.values[i];
		}

		return new Vector(values);
	}

	public Vector negate() {
		float[] values = new float[dimensions()];

		for (int i = 0; i < values.length; i++) {
			values[i] = -values[i];
		}

		return new Vector(values);
	}

	public float magnitude() {
		float sum = 0;

		for (int i = 0; i < values.length; i++) {
			sum += Math.pow(values[i], 2);
		}

		return (float) Math.sqrt(sum);
	}

	public Vector normalize() {
		float[] values = new float[dimensions()];
		float m = magnitude();

		for (int i = 0; i < values.length; i++) {
			values[i] = values[i] / m;
		}

		return new Vector(values);
	}

	public Vector resize(float length) {
		return normalize().mul(length);
	}

	public float distance(Vector v) {
		return sub(v).magnitude();
	}

	public Vector lerp(Vector target, float r) {
		return add(target.sub(this).mul(r));
	}

	public int dimensions() {
		return values.length;
	}

	public Vector copy() {
		return new Vector(values.clone());
	}

	public void setValues(float[] v) {
		if (v.length != values.length) {
			throw new IllegalArgumentException("New values array must have same length as current values array.");
		}

		for (int i = 0; i < values.length; i++) {
			values[i] = v[i];
		}
	}

	public float[] getValues() {
		return values.clone();
	}

	public void setValue(int i, float v) {
		values[i] = v;
	}

	public float getValue(int i) {
		return values[i];
	}

	private Vector toVector(int n) {
		float[] values = new float[n];
		int len = values.length;
		int lim = Math.min(n, len);

		System.arraycopy(values, 0, values, 0, lim);

		return new Vector(values);
	}

	public Vector2 toVector2() {
		Vector v = toVector(2);

		return new Vector2(v.getValue(0), v.getValue(1));
	}

	public Vector3 toVector3() {
		Vector v = toVector(3);

		return new Vector3(v.getValue(0), v.getValue(1), v.getValue(2));
	}

	public Vector4 toVector4() {
		Vector v = toVector(4);

		return new Vector4(v.getValue(0), v.getValue(1), v.getValue(2), v.getValue(3));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < values.length; i++) {
			sb.append(values[i]);

			if (i < values.length - 1) {
				sb.append(", ");
			}
		}

		sb.append("]");

		return sb.toString();
	}
}
