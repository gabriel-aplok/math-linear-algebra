import com.devash.linear_algebra.Matrix;
import com.devash.linear_algebra.Quaternion;
import com.devash.linear_algebra.Vector2;
import com.devash.linear_algebra.Vector3;
import com.devash.linear_algebra.Vector4;

public class Main {

	public static void main(String... args) {
		testMatrix();
		testQuaternion();
		testVector2();
		testVector3();
		testVector4();
	}

	private static void testMatrix() {
		Matrix m1 = new Matrix(2, 2, new float[][] {{1, 2},{3, 4}});
		Matrix m2 = new Matrix(2, 2, new float[][] {{5, 6},{7, 8}});

		m1 = m1.mul(m2);

		System.out.println("Matrix:");
		System.out.println(m1.toString());

		// Matrix mm = new Matrix(4, 4);
		// Matrix vm = new Matrix(4, 4);
		// Matrix pm = new Matrix(4, 4);
		// Matrix mvp = pm.mul(vm.mul(mm));

		// System.out.println(mvp.toString());
	}

	private static void testQuaternion() {
		Quaternion q = new Quaternion(1, 2, 3, 4);

		System.out.println("\nQuaternion:");
		System.out.println(q.toString());
		System.out.println(q.conjugate().toString());
		System.out.println(q.fromAxisAngle(new Vector3(5, 6, 7), 8).toString());
		System.out.println(q.hamiltonProduct(q));
		System.out.println(q.toEulerAngles().toString());
		System.out.println(q.vector().toString());
	}

	private static void testVector2() {
		Vector2 v1 = new Vector2(1, 2);
		Vector2 v2 = new Vector2(3, 4);

		System.out.println("\nVector2:");
		System.out.println(v1.add(v2).toString());
		System.out.println(v1.dimensions());
		System.out.println(v1.distance(v2));
		System.out.println(v1.dotProduct(v2));
		System.out.println(v1.hadamardProduct(v2).toString());
		System.out.println(v1.lerp(v2, 5).toString());
		System.out.println(v1.magnitude());
		System.out.println(v1.mul(6).toString());
		System.out.println(v1.negate().toString());
		System.out.println(v1.normalize().toString());
		System.out.println(v1.resize(7).toString());
		System.out.println(v1.sub(v2).toString());
	}

	private static void testVector3() {
		Vector3 v1 = new Vector3(1, 2, 3);
		Vector3 v2 = new Vector3(4, 5, 6);

		System.out.println("\nVector3:");
		System.out.println(v1.add(v2).toString());
		System.out.println(v1.dimensions());
		System.out.println(v1.distance(v2));
		System.out.println(v1.dotProduct(v2));
		System.out.println(v1.hadamardProduct(v2).toString());
		System.out.println(v1.lerp(v2, 7).toString());
		System.out.println(v1.magnitude());
		System.out.println(v1.mul(8).toString());
		System.out.println(v1.negate().toString());
		System.out.println(v1.normalize().toString());
		System.out.println(v1.resize(9).toString());
		System.out.println(v1.sub(v2).toString());
		System.out.println(v1.crossProduct(v2).toString());
		System.out.println(v1.angle(v2));
		System.out.println(v2.rotate(v2, 10).toString());
		System.out.println(v1.toMatrix4x1().toString());
		System.out.println(v1.toQuaternion().toString());
	}

	private static void testVector4() {
		Vector4 v1 = new Vector4(1, 2, 3, 4);
		Vector4 v2 = new Vector4(5, 6, 7, 8);

		System.out.println("\nVector4:");
		System.out.println(v1.add(v2).toString());
		System.out.println(v1.dimensions());
		System.out.println(v1.distance(v2));
		System.out.println(v1.dotProduct(v2));
		System.out.println(v1.hadamardProduct(v2).toString());
		System.out.println(v1.lerp(v2, 5).toString());
		System.out.println(v1.magnitude());
		System.out.println(v1.mul(6).toString());
		System.out.println(v1.negate().toString());
		System.out.println(v1.normalize().toString());
		System.out.println(v1.resize(7).toString());
		System.out.println(v1.sub(v2).toString());
	}
}
