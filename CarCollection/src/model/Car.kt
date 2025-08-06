package model

import java.io.Serializable

// ================================================
// Student Name: Kate Odabas
// Student ID: p288004
// File: Car.kt
// Description: This class stores details about a car,
// like its make, model, year, and how many km it has done.
// It can be saved to a file because it uses Serializable.
// ================================================

class Car : Serializable {

    // Basic details about the car
    var make: String                     // Car brand (e.g., Toyota)
    var model: String? = null           // Car model (e.g., Corolla)
    var year: String? = null            // Year it was made (e.g., 2020)
    var odometer = 0                    // How many kilometers it has travelled

    // Constructor 1: only make is required
    constructor(make: String) {
        this.make = make
    }

    // Constructor 2: full details
    constructor(make: String, model: String?, year: String?, odometer: Int) {
        this.make = make
        this.model = model
        this.year = year
        this.odometer = odometer
    }

    // Function to print the car's details
    fun display() {
        println("Make: $make, Model: $model, Year: $year,  km")
    }
}
