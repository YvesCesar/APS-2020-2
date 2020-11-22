package controllers;

import java.io.File;
import java.util.List;

import algorithms.BubbleSort;
import algorithms.HeapSort;
import algorithms.MergeSort;
import algorithms.QuickSort;
import controllers.infra.fileGenerate.FileGenerate;

public class OrderingProcess {

	private int qtCoord;
	private String fileName;
	private static final String SORTEDPATH = "/home/yves/Documentos/APS/files/ordenado/" + 
			"";
	private static final String CLUTTEREDPATH = "/home/yves/Documentos/APS/files/desordenado/";

	public OrderingProcess(String inputFileName, int inputFileLength) {
		setFileName(inputFileName);
		setQtCoord(inputFileLength);
	}

	public String start() {

		File folders = new File(SORTEDPATH);
		folders.mkdirs();
		File directory = new File(CLUTTEREDPATH);
		directory.mkdirs();

		FileGenerate clutteredFileGenerate = new FileGenerate(CLUTTEREDPATH);
		FileGenerate sortedFileGenerate = new FileGenerate(SORTEDPATH);

		CoordinateGenerator coordenateGenerator = new CoordinateGenerator(getQtCoord());

		coordenateGenerator.generateCoordinates();
		List<Double> coordenatesResults = coordenateGenerator.getCoordenates();

		clutteredFileGenerate.generateDisorderedCoordinatesFile(coordenatesResults, getFileName());

		Double[] arr = listToArray(coordenatesResults);
		Double[] arrQuick = arr.clone();
		Double[] arrMerge = arr.clone();
		Double[] arrHeap = arr.clone();
		Double[] arrBubb = arr.clone();

		QuickSort quickSort = new QuickSort(arrQuick);
		MergeSort mergeSort = new MergeSort(arrMerge);
		HeapSort heapSort = new HeapSort(arrHeap);
		BubbleSort bubbleSort = new BubbleSort(arrBubb);

		long tempoExecQuickSort = quickSort.calculateAlgorithmTime();
		long tempoExecMergeSort = mergeSort.calculateAlgorithmTime();
		long tempoExecHeapSort = heapSort.calculateAlgorithmTime();
		long tempoExecBubbleSort = bubbleSort.calculateAlgorithmTime();

		sortedFileGenerate.generateOrderedCoordinatesFile(arrQuick, getFileName() + "QuickSort");
		sortedFileGenerate.generateOrderedCoordinatesFile(arrMerge, getFileName() + "MergeSort");
		sortedFileGenerate.generateOrderedCoordinatesFile(arrHeap, getFileName() + "HeapSort");
		sortedFileGenerate.generateOrderedCoordinatesFile(arrBubb, getFileName() + "BubbleSort");

		StringBuilder runtimeResults = new StringBuilder();
		String ms = "ms \n";
		runtimeResults.append("QuickSort: " + tempoExecQuickSort + ms);
		runtimeResults.append("MergeSort: " + tempoExecMergeSort + ms);
		runtimeResults.append("HeapSort: " + tempoExecHeapSort + ms);
		runtimeResults.append("BubbleSort: " + tempoExecBubbleSort + ms);

		return runtimeResults.toString();
	}

	private String getFileName() {
		return fileName;
	}

	private static Double[] listToArray(List<Double> coordenatesResults) {
		Double[] arrDouble = coordenatesResults.toArray(new Double[coordenatesResults.size()]);
		return arrDouble;
	}

	private int getQtCoord() {
		return qtCoord;
	}

	private void setQtCoord(int inputFileLength) {
		qtCoord = inputFileLength;
	}

	private void setFileName(String inputFileName) {
		fileName = inputFileName;
	}
}
