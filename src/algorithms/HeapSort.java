package algorithms;

import controllers.RuntimeCalc;

public class HeapSort implements RuntimeCalc {
	private Double[] numbers;

	public HeapSort(Double[] arr) {
		setNumbers(arr);
	}

	public void heapSort(Double[] arr) {
		int length = arr.length;

		for (int i = length / 2 - 1; i >= 0; i--)
			heapify(arr, length, i);

		for (int i = length - 1; i >= 0; i--) {
			double x = arr[0];
			arr[0] = arr[i];
			arr[i] = x;

			heapify(arr, i, 0);
		}
	}

	void heapify(Double[] arr, int heapSize, int i) {
		int higher = i;
		int leftKnot = 2 * i + 1;
		int rightKnot = 2 * i + 2;

		if (leftKnot < heapSize && arr[leftKnot] > arr[higher])
			higher = leftKnot;

		if (rightKnot < heapSize && arr[rightKnot] > arr[higher])
			higher = rightKnot;

		if (higher != i) {
			double aux = arr[i];
			arr[i] = arr[higher];
			arr[higher] = aux;

			heapify(arr, heapSize, higher);
		}
	}

	public long calculateAlgorithmTime() {
		long initialTime = System.currentTimeMillis();
		heapSort(getNumbers());
		return System.currentTimeMillis() - initialTime;
	}

	private void setNumbers(Double[] arr) {
		numbers = arr;
	}

	public Double[] getNumbers() {
		return numbers;
	}
}
