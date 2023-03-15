package com.devash.linear_algebra;

public class Matrix {
	private final int rows;
	private final int columns;
	private final float[][] values;

	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.values = new float[rows][columns];
	}

	public Matrix(int rows, int columns, float[][] values) {
		this.rows = rows;
		this.columns = columns;
		this.values = values;
	}

	public static Matrix identity(int d) {
		Matrix identity = new Matrix(d, d);

		for (int i = 0; i < d; i++) {
			identity.setValue(i, i, 1);
		}

		return identity;
	}

	public Matrix mul(Matrix m) {
		if (columns != m.rows) {
			throw new IllegalArgumentException("Matrices have incompatible dimensions for multiplication");
		}

		Matrix result = new Matrix(rows, m.columns);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < m.columns; j++) {
				float sum = 0;
				for (int k = 0; k < columns; k++) {
					sum += values[i][k] * m.values[k][j];
				}
				result.setValue(i, j, sum);
			}
		}

		return result;
	}

	public Matrix transpose() {
		Matrix transposed = new Matrix(columns, rows);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				transposed.setValue(j, i, values[i][j]);
			}
		}

		return transposed;
	}

	public float[] getRow(int row) {
		return values[row];
	}

	public float[] getColumn(int column) {
		float[] columnValues = new float[rows];

		for (int i = 0; i < rows; i++) {
			columnValues[i] = values[i][column];
		}

		return columnValues;
	}

	public void setValue(int row, int column, float value) {
		values[row][column] = value;
	}

	public float getValue(int row, int column) {
		return values[row][column];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sb.append(values[i][j]);

				if (j < columns - 1) {
					sb.append(", ");
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
