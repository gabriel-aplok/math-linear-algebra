package com.devash.linear_algebra;

public class Quaternion {
	private final float w, x, y, z;

	public Quaternion(float w, float x, float y, float z) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Quaternion(float scalar, Vector3 vector) {
		this(scalar, vector.getX(), vector.getY(), vector.getZ());
	}

	public Quaternion hamiltonProduct(Quaternion q) {
		Vector3 pv = vector();
		Vector3 qv = q.vector();

		float s = w * q.w - pv.dotProduct(qv);
		Vector3 v = qv.mul(w).add(pv.mul(q.w)).add(pv.crossProduct(qv)).toVector3();

		return new Quaternion(s, v);
	}

	public Quaternion conjugate() {
		return new Quaternion(w, -x, -y, -z);
	}

	public Vector3 vector() {
		return new Vector3(x, y, z);
	}

	public static Quaternion fromAxisAngle(Vector3 axis, float angle) {
		float cos = (float)Math.cos(Math.toRadians(angle / 2));
		float sin = (float)Math.sin(Math.toRadians(angle / 2));

		return new Quaternion(cos, axis.mul(sin).toVector3());
	}

	public Vector3 toEulerAngles() {
		float t = 2 * (w * y - x * z);
		t = Math.max(-1, Math.min(t, 1));

		float rotX = (float) Math.atan2(2 * (w * x + y * z), 1 - 2 * (x * x + y * y));
		float rotY = (float) Math.asin(t);
		float rotZ = (float) Math.atan2(2 * (w * z + x * y), 1 - 2 * (y * y + z * z));

		return new Vector3(
		(float) Math.toDegrees(rotX),
		(float) Math.toDegrees(rotY),
		(float) Math.toDegrees(rotZ)
		);
	}

	@Override
	public String toString() {
		return "[" + w + ", " + x + ", " + y + ", " + z + "]";
	}
}
