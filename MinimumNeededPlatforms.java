/*
 * Developed by Alyson Matheus Maruyama Nascimento - 8532269
 */
import java.util.*;
import java.util.Stack;

public class MinimumNeededPlatforms {
	// Function to find minimum number of platforms needed in the station so to avoid any delay in arrival of any train.
	public static int getMinimumNumberOfPlatforms(double[] arrival, double[] departure) {
		// index for departure time
		int departureIdx = 0;
		// Since the problem states that the minimum platform number is 2, we are setting it 
		int NumberOfPlatforms = 2;
		// count of trains
		int currentTrains = 0;

		// run till train is scheduled to arrive
		for (int i = 0; i < arrival.length; i++) {
			// if train is scheduled to arrive next (arrival[i] < departure[departureIdx])
			if (arrival[i] < departure[departureIdx]) {
				// increase the count of trains and update minimum
				// platforms if required
				NumberOfPlatforms = Integer.max(NumberOfPlatforms, ++currentTrains);
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

	public static void main(String[] args) {
 		// arrival and departure times are float numbers, in format 'H.MM' -> Hours.Minutes
		double[] arrivalTime = { 2.00, 2.10, 3.00, 3.20, 3.50, 5.00 };
		double[] departureTime = { 2.30, 3.40, 3.20, 4.30, 4.00, 5.20 };

		// sort arrival and departure times of trains
		Arrays.sort(arrivalTime);
		Arrays.sort(departureTime);
		
		System.out.print("Minimum number of platforms: " + getMinimumNumberOfPlatforms(arrivalTime, departureTime));
	}
}