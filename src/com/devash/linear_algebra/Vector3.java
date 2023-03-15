package com.devash.linear_algebra;

public class Vector3 extends Vector {
	public static final Vector3 ZERO = new Vector3(0, 0, 0);
	public static final Vector3 X_UNIT = new Vector3(1, 0, 0);
	public static final Vector3 Y_UNIT = new Vector3(0, 1, 0);
	public static final Vector3 Z_UNIT = new Vector3(0, 0, 1);
	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;

	public Vector3(float x, float y, float z) {
		super(new float[] {x, y, z});
	}

	public void setX(float x) {
		super.setValue(X, x);
	}

	public float getX() {
		return super.getValue(X);
	}

	public void setY(float y) {
		super.setValue(Y, y);
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

	public Vector3 crossProduct(Vector3 v) {
		float x = getY() * v.getZ() - getZ() * v.getY();
		float y = getZ() * v.getX() - getX() * v.getZ();
		float z = getX() * v.getY() - getY() * v.getX();

		return new Vector3(x, y, z);
	}

	public float angle(Vector3 v) {
		float magnitudeProduct = magnitude() * v.magnitude();

		if (magnitudeProduct == 0) {
			return 0;
		}

		float dotProduct = normalize().dotProduct(v.normalize());
		dotProduct = Math.min(Math.max(dotProduct, -1), 1);

		return (float) Math.toDegrees(Math.acos(dotProduct));
	}

	public Vector3 rotate(Vector3 axis, float angle) {
		Vector3 axis_ = axis.normalize().toVector3();
		float angle_ = angle % 360;
		Quaternion q = Quaternion.fromAxisAngle(axis_, angle_);
		Quaternion rotated = q.hamiltonProduct(toQuaternion()).hamiltonProduct(q.conjugate());

		return rotated.vector();
	}

	public Vector3 transform(Matrix m) {
		Matrix vm = toMatrix4x1();
		Matrix result = m.mul(vm);

		return new Vector3(
			result.getValue(0, 0),
			result.getValue(1, 0),
			result.getValue(2, 0)
		);
	}

	public Matrix toMatrix4x1() {
		return new Matrix(4, 1, new float[][] {{getX()}, {getY()}, {getZ()}, {1}});
	}

	public Quaternion toQuaternion() {
		return new Quaternion(0, this);
	}
}

