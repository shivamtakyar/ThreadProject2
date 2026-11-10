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

		// Creates an ArrayList to store the Future returned by each task
		ArrayList<Future<Long>> futures = new ArrayList<>();

		// Records the starting time in nanoseconds
		long startTime = System.nanoTime();

		// Loops 1000 times to create 1000 Callable tasks
		for (int i = 0; i < numTasks; i++) {

			// Calculates the first number this task will count
			final long start = i * numbersPerTask + 1;

			// Calculates the last number this task will count
			final long end = start + numbersPerTask - 1;

			// Creates a Callable task that returns a Long
			Callable<Long> task = () -> {

				// Stores the number of integers counted by this task
				long count = 0;

				// Loops through the task's assigned range
				for (long j = start; j <= end; j++) {

					// Increments the count by 1 for each integer
					count++;
				}

				// Returns this task's final count
				return count;
			};

			// Submits the Callable task to the ExecutorService
			// The returned Future represents the task's eventual result
			Future<Long> future = executor.submit(task);

			// Adds the Future to the ArrayList
			futures.add(future);
        }
	}
}