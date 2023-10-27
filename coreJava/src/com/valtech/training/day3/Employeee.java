package com.valtech.training.day3;

import java.util.Random;

public class Employeee {
	    private String name;
	    private int age;
	    private String level;
	    private int experience;

	    public Employeee() {
	        Random random = new Random();

	        // Generate a random name
	        this.name = generateRandomName(random);

	        // Generate a random age between 18 and 60
	        this.age = random.nextInt(43) + 18;

	        // Generate a random level (Junior, Intermediate, Senior)
	        this.level = generateRandomLevel(random);

	        // Generate random experience based on level
	        this.experience = generateRandomExperience(random, this.level);
	    }

	    private String generateRandomName(Random random) {
	        String[] firstNames = {"Ankita", "Bhuvan", "Chaitanya", "Dhruv", "Elizabeth", "Francis", "Gaman", "Harshitha", "Indushree", "Jay", "Kruttika", "Lucy"};
	        String[] lastNames = {"Naik", "Bhat", "Shetty", "Gowda", "Jones", "Smith", "Hegde", "Gaonkar", "Rao", "Martinez"};

	        String firstName = firstNames[random.nextInt(firstNames.length)];
	        String lastName = lastNames[random.nextInt(lastNames.length)];

	        return firstName + " " + lastName;
	    }

	    private String generateRandomLevel(Random random) {
	        String[] levels = {"Junior", "Intermediate", "Senior"};
	        return levels[random.nextInt(levels.length)];
	    }

	    private int generateRandomExperience(Random random, String level) {
	        int minExperience = switch (level) {
	            case "Junior" -> random.nextInt(3);
	            case "Intermediate" -> random.nextInt(7) + 3;
	            case "Senior" -> random.nextInt(10) + 10;
	            default -> 0;
	        };
	        return minExperience + random.nextInt(3);
	    }

	    public void displayInfo() {
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.println("Level: " + level);
	        System.out.println("Experience: " + experience + " years");
	    }

	    public static void main(String[] args) {
	        Employeee employeee = new Employeee();
	        employeee.displayInfo();
	    }
	}



