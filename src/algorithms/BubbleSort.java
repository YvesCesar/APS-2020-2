package algorithms;

import controllers.RuntimeCalc;

public class BubbleSort implements RuntimeCalc {
	private Double[] numbers;

	public BubbleSort(Double[] numbers) {
		setNumbers(numbers);
	}
	
	public void bubbleSort(Double[] numbers) {
		for(int i = 1; i<numbers.length; i++){
			for(int j = 0; j<numbers.length - 1; j++){
				if(numbers[j] > numbers[j + 1]){
					double aux = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = aux;
				}
			}
		}
	}
	
	@Override
	public long calculateAlgorithmTime() {
		long initialTime = System.currentTimeMillis();
		bubbleSort(getNumbers());
		return System.currentTimeMillis() - initialTime;
	}
	
	public Double[] getNumbers() {
		return numbers;
	}

	public void setNumbers(Double[] numbers) {
		this.numbers = numbers;
	}
}
