//
//Written by Adam Einstein
//
  
 public class movie { 
  
// attributes 
     private String name; 
     private int year; 
     private int rating; 
     private String director; 
     private double gross; 
  
// default constructors 
     public movie() 
     { 
         name = "no"; 
         year = 0; 
         rating = 0; 
         director = "no"; 
         gross = 0.0; 
     }  
  
// parameterized constructors 
     public movie(String aName, int aYear, int aRating, String aDirector, double aGross) 
     { 
         name = aName;       
         year = aYear; 
         
         if(aRating >= 1 && aRating <= 5) 
             rating = aRating; 
         else 
             rating = 1; 
         
         director = aDirector;       
         gross = aGross; 
     }  
  
// Takes in instance of selection for program to run 
     public boolean equals(movie other) 
     { 
         if(name.equals(other.name) && year == other.year && rating == other.rating && director.equals(other.director) 
                 && gross == other.gross) 
         { 
             return true; 
         } 
         else 
         { 
             return false; 
         } 
     }  
  
// Takes in instance of selection at "0" 
     public int compareTo(movie other) 
     { 
         if(other.name.equals("no") && other.year == 0 && other.rating == 0 && other.director.equals("no") && other.gross == 0) 
         { 
             return 0; 
         } 
         else 
         { 
             return 1; 
         } 
     }  
     
// Returns attributes 
     public String toString() 
     { 
         return "Title: " + name + ", Year: " + year + ", Rating: " + rating + ", Director: " + director + ", Box Office Gross: " + gross; 
     }  
  
// Returns name of the movie 
     public String getName() 
     { 
         return name; 
     } 
  
// Returns year of the movie 
     public int getYear() 
     { 
         return year; 
     } 
  
// Returns rating of the movie 
     public int getRating() 
     { 
         return rating; 
     } 
  
// Returns director of the movie 
     public String getDirector() 
     { 
         return director; 
     } 
  
// Returns gross of the movie 
     public double getGross() 
     { 
         return gross; 
     } 
   
 }