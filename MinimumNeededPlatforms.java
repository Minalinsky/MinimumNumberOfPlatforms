/*
 * Developed by Alyson Matheus Maruyama Nascimento
 */
import java.util.*;
import java.util.Stack;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;

public class MinimumNeededPlatforms {
	// Function to find minimum number of platforms needed in the station so to avoid any delay in arrival of any train.
	public static int getMinimumNumberOfPlatforms(double[] arrival, double[] departure) {
		// index for departure and arrival times
		int departureIdx = 0;
		int arrivalIdx = 0;
		// Since the problem states that the minimum platform number is 2, we are setting it 
		int NumberOfPlatforms = 0;
		// count of trains
		int currentTrains = 0;

		// run till train is scheduled to arrive
		while (arrivalIdx < arrival.length) {
			// if train is scheduled to arrive next (arrival[i] < departure[departureIdx])
			if (arrival[arrivalIdx] < departure[departureIdx]) {
				// increase the count of trains and update minimum
				// platforms if required
        currentTrains++;
				NumberOfPlatforms = Integer.max(NumberOfPlatforms, currentTrains);
        arrivalIdx++;
			}
			// if train is scheduled to depart next (departure[j] < arrival[i]), or two trains are arriving and departing at the same time (arrival[i] == departure[j])
			// then depart first
			else {
				currentTrains--;
				departureIdx++;
			}
		}
		return NumberOfPlatforms;
	}

public static double[] convertStringArrayToDouble(String[] timesArray) {
  double[] doubleNumbersArray = Arrays.stream(timesArray).mapToDouble(Double::parseDouble).toArray();
  return doubleNumbersArray;
}

	public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new BufferedReader(new FileReader("trainTimesInput.txt")));
 		// arrival and departure times are float numbers, in format 'H.MM' -> Hours.Minutes
    while (sc.hasNextLine()) {
      double[] arrivalTime = convertStringArrayToDouble(sc.nextLine().trim().split(","));
      double[] departureTime = convertStringArrayToDouble(sc.nextLine().trim().split(","));
      System.out.println("Arrival Time: " + Arrays.toString(arrivalTime));
      System.out.println("Departure Time: " + Arrays.toString(departureTime));

      // sort arrival and departure times of trains
		  Arrays.sort(arrivalTime);
		  Arrays.sort(departureTime);
      
		  System.out.print("Minimum number of platforms: " + getMinimumNumberOfPlatforms(arrivalTime, departureTime) + "\n\n");
    }
	}
}