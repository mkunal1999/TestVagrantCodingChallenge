// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.lang.*;

class Planet{
    public String name;
    public List<String> surfaceGasses = new ArrayList<String>();
    public int noOfMoons;
    public boolean hasRings;
    
    Planet(String name, List<String> surfaceGasses, int noOfMoons, boolean hasRings){
        this.name = name;
        this.surfaceGasses = surfaceGasses;
        this.noOfMoons = noOfMoons;
        this.hasRings = hasRings;
    }
    
    public String getName(){
        return name;
    }
    
    public List<String> getSurfaceGasses(){
        return surfaceGasses;
    }
    
    public int getNoOfMoons(){
        return noOfMoons;
    }
    
    public boolean getHasRings(){
        return hasRings;
    }
}

class SolarSystem{
    public int getCountOfMoonsPlanetsHavingRings(List<Planet> planets){
        int count = 0;
        for(Planet p: planets){
            if(p.getHasRings()){
                count += p.getNoOfMoons();        
            }
        }
        return count;
    }
    
    public String getGasFoundMaximumPlanets(List<Planet> planets){
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        for(Planet p: planets){
            List<String> t = p.getSurfaceGasses();
            for(String s:t){
                Integer count = freq.get(s);
                if (count == null) {
                    freq.put(s, 1);
                }
                else {
                    freq.put(s, count + 1);
                }
            }
            
        }
        return Collections.max(freq.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    }
}

class HelloWorld {
    public static void main(String[] args) {
        List<String> surfaceGasses = new ArrayList<String>();
        Planet p1 = new Planet("Mercury", surfaceGasses, 0, false);
        surfaceGasses.add("Carbon Dioxide");
        surfaceGasses.add("Nitrogen");
        Planet p2 = new Planet("Venus", surfaceGasses, 0, false);
        List<String> surfaceGasses2 = new ArrayList<String>();
        surfaceGasses2.add("Nitrogen");
        surfaceGasses2.add("Oxygen");
        Planet p3 = new Planet("Earth", surfaceGasses2, 1, false);
        List<String> surfaceGasses3 = new ArrayList<String>();
        surfaceGasses3.add("Hydrogen");
        surfaceGasses3.add("Helium");
        Planet p4 = new Planet("Jupitor", surfaceGasses3, 79, true);
        Planet p5 = new Planet("Saturn", surfaceGasses3, 83, true);
        surfaceGasses3.add("Methane");
        Planet p6 = new Planet("Uranus", surfaceGasses3, 27, true);
        
        List<Planet> planets = new ArrayList<Planet>();
        planets.add(p1);
        planets.add(p2);
        planets.add(p3);
        planets.add(p4);
        planets.add(p5);
        planets.add(p6);
        
        SolarSystem ss = new SolarSystem();
        System.out.println(ss.getCountOfMoonsPlanetsHavingRings(planets));
        System.out.println(ss.getGasFoundMaximumPlanets(planets));
        
    }
}