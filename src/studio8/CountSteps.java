package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.

public class CountSteps {
	
	public static void main(String[] args) {	
		String filePath = "data/stepsResearch.csv";
		File file = new File(filePath);
		
		double sum = 0;
		double numReadings = 0;
		
		double prevVal = Double.MAX_VALUE;
		double currentVal = Double.MAX_VALUE;
		double nextVal = Double.MAX_VALUE;
		int peakCounter = 0;
		
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.useDelimiter(",");
			while (inputStream.hasNext()) {
				String line = inputStream.nextLine();
				String[] coords = line.split(",");
				double zVal = Double.parseDouble(coords[2]);
				sum += zVal;
				numReadings++;
				System.out.println(zVal);
			}
			inputStream.close();
			double mean = sum/numReadings;
			System.out.println("Mean: " + mean);
			
			Scanner inputStream2 = new Scanner(file);
			inputStream2.useDelimiter(",");
			while (inputStream2.hasNext()) {
				String line = inputStream2.nextLine();
				String[] coords = line.split(",");
				prevVal = currentVal;
				currentVal = nextVal;
				nextVal = Double.parseDouble(coords[2]);
				if ((currentVal > prevVal) && (currentVal > nextVal) && (prevVal > mean) && (currentVal > mean) && (nextVal > mean)) {
					peakCounter++;
				}
			}
			inputStream2.close();
			System.out.println(peakCounter);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
}