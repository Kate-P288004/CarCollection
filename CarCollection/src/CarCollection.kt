import model.Car
import java.io.*
import java.util.*

// ================================================
// Student Name: Kate Odabas
// File: CarCollection.kt
// Description: This program lets the user add, view,
// search, sort, save, and load a list of Car objects.
// ================================================

fun main() {
    val cars = ArrayList<Car>()                  // List to store Car objects
    val scanner = Scanner(System.`in`)           // For user input
    val fileName = "cars.dat"                    // File name to save/load cars

    loop@ while (true) {
        println("\n--- Car Collection Menu ---")
        println("1. Add a new car")
        println("2. Display all cars")
        println("3. Sort cars by make")
        println("4. Search car by make")
        println("5. Save cars to binary file")
        println("6. Load cars from binary file")
        println("7. Exit")
        print("Choose an option: ")

        when (scanner.nextLine()) {

            // Option 1: Add a new car
            "1" -> {
                try {
                    print("Enter car make: ")
                    val make = scanner.nextLine()

                    print("Enter car model: ")
                    val model = scanner.nextLine()

                    print("Enter car year: ")
                    val year = scanner.nextLine()

                    print("Enter odometer reading (in km): ")
                    val odometer = scanner.nextLine().toInt()

                    val newCar = Car(make, model, year, odometer)
                    cars.add(newCar)

                    println("Car added successfully.")
                } catch (e: Exception) {
                    println("Error: Please enter a valid number for the odometer.")
                }
            }

            // Option 2: Display all cars
            "2" -> {
                if (cars.isEmpty()) {
                    println("No cars to display.")
                } else {
                    println("\n--- Car List ---")
                    for (car in cars) {
                        car.display()
                    }
                }
            }

            // Option 3: Sort cars by make
            "3" -> {
                if (cars.isEmpty()) {
                    println("No cars to sort.")
                } else {
                    cars.sortBy { it.make.lowercase() }
                    println("Cars sorted by make.")
                }
            }

            // Option 4: Search cars by make
            "4" -> {
                print("Enter make to search: ")
                val searchMake = scanner.nextLine().lowercase()

                val found = cars.filter { it.make.lowercase().contains(searchMake) }

                if (found.isEmpty()) {
                    println("No cars found with make \"$searchMake\".")
                } else {
                    println("--- Search Results ---")
                    for (car in found) {
                        car.display()
                    }
                }
            }

            // Option 5: Save cars to a binary file
            "5" -> {
                try {
                    ObjectOutputStream(FileOutputStream(fileName)).use { output ->
                        output.writeObject(cars)
                        println("Cars saved to $fileName")
                    }
                } catch (e: IOException) {
                    println("Error saving file: ${e.message}")
                }
            }

            // Option 6: Load cars from a binary file
            // Option 6: Load cars from a binary file
            "6" -> {
                try {
                    ObjectInputStream(FileInputStream(fileName)).use { input ->
                        @Suppress("UNCHECKED_CAST")
                        val loaded = input.readObject() as ArrayList<Car>
                        cars.clear()
                        cars.addAll(loaded)
                        println("Cars loaded from $fileName")
                    }
                } catch (e: Exception) {
                    println("Error loading file: ${e.message}")
                }
            }


            // Option 7: Exit program
            "7" -> {
                println("Goodbye.")
                break@loop
            }

            // Invalid input
            else -> {
                println("Invalid option. Please try again.")
            }
        }
    }
}
