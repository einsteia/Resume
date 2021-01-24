//
//Written by Adam Einstein
//
import java.util.Scanner; 
 
public class MovieDBFrontEnd { 
 
  public static void main(String[] args) // Main string method 
    { 
        MovieDatabase movieDB = new MovieDatabase();       
        
        Scanner keyboard = new Scanner(System.in); 
        
        GenLinkedList<movie> instances; 
        String name, director, fileName; 
        int year, rating; 
        double gross; 
 
        System.out.println("Welcome to the movie database"); 
 
        boolean quit = false; 
 
        while(quit == false) // Cases for user to continue 
        { 
            System.out.println("\n>Enter 1: To Add a Movie"); 
            System.out.println(">Enter 2: To Remove a Movie by its Title"); 
            System.out.println(">Enter 3: To search for a Title"); 
            System.out.println(">Enter 4: To search for moves by a Director"); 
            System.out.println(">Enter 5: To search for movies of a given Year"); 
            System.out.println(">Enter 6: To search for movies of a certain Rating"); 
            System.out.println(">Enter 7: To print out all movies"); 
            System.out.println(">Enter 8: To print to a database file"); 
            System.out.println(">Enter 9: To load a database file"); 
            System.out.println(">Enter 0: To quit"); 
 
            System.out.print("Enter your choice: "); 
            int choice = keyboard.nextInt(); 
            keyboard.nextLine();  
 
// Loop of conditions for user when using the program containing program outputs and messages             
            switch(choice)  
            { 
                case 1: 
                    System.out.print("\nEnter the name of the movie: "); 
                    name = keyboard.nextLine(); 
 
                    System.out.print("Enter the year of the movie: "); 
                    year = keyboard.nextInt(); keyboard.nextLine(); 
 
                    System.out.print("Enter the rating of the movie [1-5]: "); 
                    rating = keyboard.nextInt(); keyboard.nextLine(); 
 
                    System.out.print("Enter the diector name of the movie: "); 
                    director = keyboard.nextLine(); 
 
                    System.out.print("Enter the gross of the movie (>=0): "); 
                    gross = keyboard.nextDouble(); keyboard.nextLine(); 
 
                    movieDB.addMovie(new movie(name, year, rating, director, gross)); 
                    break; 
 
                case 2: 
                    System.out.print("\nEnter the name of the movie: "); 
                    name = keyboard.nextLine(); 
 
                    if(movieDB.removeMovie(name) == false) 
                        System.out.println("Movie with title " + name + " is not found in the movies database!"); 
                    else 
                        System.out.println("One movie with title " + name + " is removed from the movies database!"); 
                    break; 
 
                case 3: 
                    System.out.print("\nEnter the name of the movie: "); 
                    name = keyboard.nextLine(); 
                    
                    instances = movieDB.searchByTitle(name); 
                    if(instances == null) 
                    { 
                        System.out.println("Movie with title " + name + " is not found in the movies database!"); 
                    } 
                    else 
                    { 
                        System.out.println("List of movies with the title: " + name); 
                        instances.printList(); 
                    } 
                    break; 
 
                case 4: 
                    System.out.print("\nEnter the director of the movie: "); 
                    director = keyboard.nextLine(); 
                    
                    instances = movieDB.searchByDirector(director); 
                    if(instances == null) 
                    { 
                        System.out.println("Movie with director " + director + " is not found in the movies database!"); 
                    } 
                    else 
                    { 
                        System.out.println("List of movies with the director: " + director); 
                        instances.printList(); 
                    } 
                    break; 
 
                case 5: 
                    System.out.print("\nEnter the year of the movie: "); 
                    year = keyboard.nextInt(); keyboard.nextLine(); 
                    
                    instances = movieDB.searchByYear(year); 
                    if(instances == null) 
                    { 
                        System.out.println("Movie with year " + year + " is not found in the movies database!"); 
                    } 
                    else 
                    { 
                        System.out.println("List of movies with the year: " + year); 
                        instances.printList(); 
                    } 
                    break; 
 
                case 6: 
                    System.out.print("\nEnter the rating of the movie: "); 
                    rating = keyboard.nextInt(); keyboard.nextLine(); 
                    
                    instances = movieDB.searchByRating(rating); 
                    if(instances == null) 
                    { 
                        System.out.println("Movie with rating " + rating + " is not found in the movies database!"); 
                    } 
                    else 
                    { 
                        System.out.println("List of movies with the rating: " + rating); 
                        instances.printList(); 
                    } 
                    break; 
 
                case 7: 
                    System.out.println("\nList of all movies in the database..."); 
                    movieDB.printMoviesToConsole(); 
                    break; 
 
                case 8: 
                    System.out.print("\nEnter the file name to write a MovieDB: "); 
                    fileName = keyboard.nextLine(); 
 
                    movieDB.writeMoviesToFile(fileName); 
                    break; 
                    
                case 9: 
                    System.out.print("\nEnter the file name to read a MovieDB: "); 
                    fileName = keyboard.nextLine(); 
 
                    movieDB.readMoviesFromFile(fileName); 
                    break; 
 
                case 0: 
                    quit = true; 
                    break; 
 
                default: 
                    System.out.println("Invalid input"); 
            } 
        } 
        keyboard.close(); 
        System.out.println("Good bye"); 
    } 
  
} 
