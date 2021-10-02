package com.example.LIFTR;
import java.util.ArrayList;
import java.util.LinkedList;

public class user {

    public static int age;
    public static int weight;
    public static int height;
    public static String name;
    public static String type;
    public static String goal;
    public static String fitness;
    public static String sex;
    public static int calorieGoal;
    //public static LinkedList<Food> foods = new LinkedList<>();
    public static ArrayList<String> tracker = new ArrayList<String>();
    public static ArrayList<Food> foodList = new ArrayList<Food>();
    public static boolean init;

    public user(int age, int weight, int height, String name, String type, String goal, String fitness,
                String sex) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.type = type;
        this.goal = goal;
        this.fitness = fitness;
        this.sex = sex;
    }


    public static int getAge(){
        return age;
    }
    public static int getWeight(){
        return weight;
    }
    public static int getHeight(){
        return height;
    }
    public static String getName(){
        return name;
    }
    public static String getType(){
        return type;
    }
    public static String getGoal(){
        return goal;
    }
    public static String getFitness(){
        return fitness;
    }
    public static String getSex(){
        return sex;
    }
    public static String getAgeString(){
        return String.valueOf(age);
    }
    /*public static Food getFood(int index){
        Food ret = new Food();
        for(int i=0; i!=index-1;i++){
            ret = foods.get(i);
        }
        return ret;
    }*/


    public static void setName(String aName){
        name = aName;
    }
    public static void setAge(int anAge){
        age=anAge;
    }
    public static void setHeight(int aHeight){
        height = aHeight;
    }
    public static void setWeight(int aWeight){
        weight = aWeight;
    }
    public static void setType(String aType){
        type = aType;
    }
    public static void setGoal(String aGoal){
        goal = aGoal;
    }
    public static void setFitness(String aFitness){
        fitness = aFitness;
    }
    public static void setSex(String aSex){
        sex = aSex;
    }
   /* public static void addFood(Food newFood){foods.addLast(newFood);}
    public static void removeFood(int index){
        foods.remove(index-1);
    }*/
    public static double calculateCalories() {
        double calories;
        double atype, agoal, asex, aage, aheight;

        if (type.equals("Ectomorph"))
            atype = 0.95;
        else if (type.equals("Endomorph"))
            atype = 1.05;
        else
            atype = 1;
        if (sex.equals("Female"))
            asex = 1.1;
        else if (sex.equals("Male"))
            asex = 1;
        else
            asex = 1.05;
        if (age > 11 && age < 20)
            aage = 0.9;
        else if (age > 19 && age < 30)
            aage = 1;
        else if (age > 29 && age < 40)
            aage = 1.05;
        else if (age > 39 && age < 50)
            aage = 1.1;
        else if (age > 49 && age < 60)
            aage = 1.15;
        else
            aage = 1.2;
        aheight = 1 + (0.02*(height-70));
        calories = (1/(asex*aage*atype*aheight/(11.7*weight)));
        if (goal.equals("Lose Weight"))
            calories = calories * 0.9;
        else if (goal.equals("Bulk Up"))
            calories = calories * 1.1;
        return calories;
    }
    public static double calculateBurn(){
        if (goal.equals("Lose Weight"))
            return (calculateCalories() * 0.12);
        else if (goal.equals("Bulk Up"))
            return (calculateCalories() * 0.05);
        else
            return (calculateCalories() * 0.09);
    }
    public static double calculateCarbs(){
        return (calculateCalories() * 0.55 / 4);
    }
    public static double calculateProtein(){
        return (calculateCalories() * 0.125 / 4);
    }
}
