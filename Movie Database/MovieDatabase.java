//
//Written by Adam Einstein
//
   
 import java.io.*; 
 import java.util.Scanner; 
  
 public class MovieDatabase { 
   
// Constants 
    private static final String DELIMITER = "\t"; 
    private static final int FIELD_AMT = 5; 
    
// Movie List 
    private GenLinkedList<movie> movies; 
  
// Default constructor 
    public MovieDatabase() 
    { 
        movies = new GenLinkedList<movie>(); 
    } 
  
// Adds a movie to selection 
    public void addMovie(movie aMovie) 
    { 
        movies.addItem(aMovie); 
    } 
    
// Removes a movie by its title 
    public boolean removeMovie(String aTitle) 
    { 
        movies.moveToHead(); 
        int size = movies.getSize(); 
        
        for(int i = 0; i < size; i++) 
        { 
            movie m = movies.getCurrent(); 
            if(m.getName().equalsIgnoreCase(aTitle)) 
            { 
                movies.removeItem(); 
                return true; 
            } 
            
            movies.moveForward();                   
        } 
        
        return false; 
    } 
    
// Searches for a title of movie 
    public GenLinkedList<movie> searchByTitle(String aTitle) 
    { 
        GenLinkedList<movie> instances = new GenLinkedList<movie>(); 
        int count = 0; 
        
        movies.moveToHead(); 
        int size = movies.getSize(); 
        
        for(int i = 0; i < size; i++) 
        { 
            movie m = movies.getCurrent(); 
            if(m.getName().equalsIgnoreCase(aTitle)) 
            { 
                instances.addItem(m); 
                count++; 
            } 
            
            movies.moveForward();                   
        } 
        
        if(count == 0) 
            return null; 
        else 
            return instances; 
    } 
    
// Searches for movies by director 
    public GenLinkedList<movie> searchByDirector(String aDirector) 
    { 
        GenLinkedList<movie> instances = new GenLinkedList<movie>(); 
        int count = 0; 
        
        movies.moveToHead(); 
        int size = movies.getSize(); 
        
        for(int i = 0; i < size; i++) 
        { 
          movie m = movies.getCurrent(); 
            if(m.getDirector().equalsIgnoreCase(aDirector)) 
            { 
                instances.addItem(m); 
                count++; 
            } 
            
            movies.moveForward();                   
        } 
        
        if(count == 0) 
            return null; 
        else 
            return instances; 
    } 
    
// Searches for movies of a given year 
    public GenLinkedList<movie> searchByYear(int aYear) 
    { 
        GenLinkedList<movie> instances = new GenLinkedList<movie>(); 
        int count = 0; 
        
        movies.moveToHead(); 
        int size = movies.getSize(); 
        
        for(int i = 0; i < size; i++) 
        { 
            movie m = movies.getCurrent(); 
            if(m.getYear() == aYear) 
            { 
                instances.addItem(m); 
                count++; 
            } 
            
            movies.moveForward();                   
        } 
        
        if(count == 0) 
            return null; 
        else 
            return instances; 
    } 
    
// Searches for movies of a certain rating 
    public GenLinkedList<movie> searchByRating(int aRating) 
    { 
        GenLinkedList<movie> instances = new GenLinkedList<movie>(); 
        int count = 0;       
        
        movies.moveToHead(); 
        int size = movies.getSize(); 
                
        for(int i = 0; i < size; i++) 
        { 
            movie m = movies.getCurrent(); 
            if(m.getRating() == aRating) 
            { 
                instances.addItem(m); 
                count++; 
            } 
            
            movies.moveForward();               
        } 
        
        if(count == 0) 
            return null; 
        else 
            return instances; 
    } 
    
// Prints out all movies 
    public void printMoviesToConsole() 
    { 
        movies.moveToHead(); 
        int size = movies.getSize();       
        for(int i = 0; i < size; i++) 
        { 
            movie m = movies.getCurrent(); 
            
            System.out.println("Title: " + m.getName() + ", Year: " + m.getYear() + ", Rating: " + m.getRating() + ", Director: " + m.getDirector() + ", Box Office Gross: " + m.getGross()); 
            
            movies.moveForward();               
        } 
    } 
    
// Prints to a database file 
    public void writeMoviesToFile(String aFileName) 
    { 
        try 
        { 
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aFileName)); 
            movies.moveToHead(); 
            int size = movies.getSize(); 
            
            for(int i = 0; i < size; i++) 
            { 
                movie m = movies.getCurrent(); 
                
                fileWriter.println(m.getName() + DELIMITER + m.getYear() + DELIMITER + m.getRating() + DELIMITER + m.getDirector() + DELIMITER + m.getGross()); 
                
                movies.moveForward();                       
            } 
            fileWriter.close(); 
            System.out.println("Writing to file succussfully."); 
        } 
        catch(Exception e) 
        { 
            System.out.println("Exception" + e.getMessage()); 
        } 
    } 
    
// Loads a database file to program 
    public void readMoviesFromFile(String aFileName) 
    { 
        try 
        { 
            movies = new GenLinkedList<movie>(); 
            Scanner fileScanner = new Scanner(new File(aFileName)); 
            
            while(fileScanner.hasNextLine()) 
            { 
                String fileLine = fileScanner.nextLine(); 
                String[] splitLines = fileLine.split(DELIMITER); 
                if(splitLines.length == FIELD_AMT) 
                { 
                    String name = splitLines[0]; 
                    int year = Integer.parseInt(splitLines[1]); 
                    int rating = Integer.parseInt(splitLines[2]); 
                    String diector = splitLines[3]; 
                    double gross = Double.parseDouble(splitLines[4]); 
  
                    movie aMovie = new movie(name, year, rating, diector, gross); 
  
                    addMovie(aMovie); 
                } 
                else 
                { 
                    System.out.println("One row is not well formed. So, ignored this row."); 
                } 
            } 
            fileScanner.close(); 
            System.out.println("Reading from file succussfully.");           
        } 
        catch(Exception e) 
        { 
            System.out.println("Exception" + e.getMessage()); 
        } 
    }   
 }  
