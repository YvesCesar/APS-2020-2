package controllers.infra.fileGenerate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import controllers.CoordinateGenerator;

public class FileGenerate {

	private String path;

	public FileGenerate(String path) {
		setPath(path);
	}

	public void generateDisorderedCoordinatesFile(List<Double> coordenatesResults, String fileName) {
		Iterator<Double> itr = coordenatesResults.iterator();
		while (itr.hasNext()) {
			double latitude = (double) itr.next();
			double longitude = (double) itr.next();
			String coordenates = CoordinateGenerator.coordinateFormat(latitude, longitude);
			writeText(fileName, coordenates);
		}

	}

	public void generateOrderedCoordinatesFile(Double[] arrQuick, String fileName) {
		try {
			StringBuilder coordenates = new StringBuilder();
			int cont = 1;
			for (double arr : arrQuick) {
				coordenates.append(" "+arr);
				if (cont == 10) {
					writeText(fileName, coordenates.toString());
					coordenates.setLength(0);
					cont = 1;
				} else if (arrQuick[arrQuick.length - 1] == arr) {
					writeText(fileName, coordenates.toString());
					coordenates.setLength(0);
					cont = 1;
				}
				else {
					coordenates.append(",");					
					cont++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeText(String fileName, String text) {
		try (Writer writer = new BufferedWriter(new FileWriter(getPath() + fileName, true));) {
			writer.append(text + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
