package algorithms;

import controllers.RuntimeCalc;

public class QuickSort implements RuntimeCalc {

	private Double[] numbers;

	public QuickSort(Double[] array) {
		setNumbers(array);
	}

	private int partition(Double[] array, int left, int right) {
		int i = left;
		int j = right;
		Double time;
		Double pivot = array[((left + right) / 2)];

		while (i <= j) {

			while (array[i] < pivot)
				i++;

			while (array[j] > pivot)
				j--;

			if (i <= j) {

				time = array[i];
				array[i] = array[j];
				array[j] = time;
				i++;
				j--;
			}
		}
		return i;
	}

	private void quickSort(Double[] array, int left, int right) {

		int key = partition(array, left, right);
		if (left < key - 1)
			quickSort(array, left, key - 1);

		if (key < right)
			quickSort(array, key, right);
	}

	public long calculateAlgorithmTime() {
		long initialTime = System.currentTimeMillis();
		quickSort(getNumbers(), 0, getNumbers().length - 1);

		return System.currentTimeMillis() - initialTime;
	}

	public void setNumbers(Double[] numbers) {
		this.numbers = numbers;
	}

	public Double[] getNumbers() {
		return numbers;
	}
}
