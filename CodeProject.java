import java.util.concurrent.*; // Imports ExecutorService, Executors, Callable, and Future
import java.util.ArrayList;     // Imports ArrayList to store the Futures

public class CodeProject
{
	public static void main(String [] args)
	{
		// Number of counting tasks we want to create
		int numTasks = 1000;

		// Total number of integers we want to count
		long maxNumber = 1_000_000_000L;

		// Each task will count 1,000,000 numbers
		long numbersPerTask = maxNumber / numTasks;

		// Creates a pool of 10 worker threads
		// These threads will execute our 1000 tasks
		ExecutorService executor = Executors.newFixedThreadPool(10);


	}
}