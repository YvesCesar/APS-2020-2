package algorithms;

import controllers.RuntimeCalc;

public class MergeSort implements RuntimeCalc{

	private Double []v;
	private Double []w;
	
	public MergeSort(Double []vect) {
		setArray(vect);
	}
	
	public void mergeSort(Double[] v, Double[] w, int begin, int end) {
		if(begin < end) {
			int middle = (begin + end) / 2;
			mergeSort(v, w, begin, middle);
			mergeSort(v, w, middle + 1, end);
			interlayer(v, w, begin, middle, end);
		}
	}
	
	public void interlayer(Double[] v, Double[] w, int begin, int middle, int end) {
		for(int k = begin; k <= end; k++) {
			w[k] = v[k];
		}
		
		int i = begin;
		int j = middle + 1;
		
		for(int k = begin; k <= end; k++) {
			if(i > middle) v[k] = w[j++];
			else if (j > end) v[k] = w[i++];
			else if (w[i] < w[j]) v[k] = w[i++];
			else v[k] = w[j++];
		}
	}
	
	public long calculateAlgorithmTime() {
		 long initialTime = System.currentTimeMillis();
		 mergeSort(v, w, 0, v.length-1);

		 return  System.currentTimeMillis() - initialTime;
	}
	
	
	public void setArray(Double[] array) {
		v = array;
		w = new Double[v.length];
	}
	
	public Double[] getArray() {
		return v;
	}
	
}
