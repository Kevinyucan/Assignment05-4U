
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hadik9595
 */
public class Controller {

    private HHSSAdventureFrame gui;
    private Map map;
    private String currentPlace;
    private String currentDirection;
    private ArrayList<Location> locations = new ArrayList<>();
    
    private String[] directions;

    private Location currentLoc;

    public Controller(HHSSAdventureFrame gui, Map m) {
        this.gui = gui;
        this.map = m;
        this.currentPlace = map.getStartingPlace();
        this.currentDirection = map.getStartingDirection();
        
        System.out.println(this.currentPlace);
        System.out.println(this.currentDirection);
        
        directions = new String[] {"N","E","S","W"};
        
        //make sure the GUI can talk to you
        gui.setController(this);
        
        Screen start = map.getLocation(this.currentPlace, this.currentDirection);
        
        
       gui.setImage(start.getImage());
        
        gui.checkFront(start.isFrontClear(currentDirection));
        
       

     

        for(int i = 0; i < locations.size(); i++) {
           
             if(currentPlace.equals(locations.get(i).getLocationName())){
                currentLoc = locations.get(i);
            }
        
        }
        //set starting image 
        
    }

    public void goForward() {
        //get the screen we are on right now 
        Screen current = map.getLocation(currentPlace, currentDirection);

        System.out.println(currentDirection);
        

        //if we can move north
        if (!current.isFrontClear(currentDirection)) {
            
            currentPlace = current.getNextPlace();
            currentDirection = current.getNextDirection();
       
        
            
        }
      Screen newScreen = map.getLocation(currentPlace, currentDirection);
            

            // set the image
            gui.setImage(newScreen.getImage());
           
              gui.checkFront(newScreen.isFrontClear(currentDirection));

         

    }

    public void turnLeft() {

     
        
        //ask if we can move north
        
        for (int i = 0; i < directions.length; i++) {
          if(currentDirection.equals(directions[i])){
            if (currentDirection.equals("N")) {
                currentDirection = "W";
                break;

            } else {
                currentDirection = directions[i-1];
                break;
            }

             }

        }

        //Get new screen 
        Screen newScreen = map.getLocation(currentPlace, currentDirection);
        // set the image
       gui.setImage(newScreen.getImage());
      
        

    }

    public void turnRight() {

        
        for (int i = 0; i < directions.length; i++) {
             if(currentDirection.equals(directions[i])){
            if (currentDirection.equals("W")) {
                currentDirection = "N";
                break;
            } else {
                currentDirection = directions[i + 1];
                break;
            }
             }
        }
        //Get new screen 
        Screen newScreen = map.getLocation(currentPlace, currentDirection);
        // set the image
        gui.setImage(newScreen.getImage());
        //updates if the front is blocked or not for the CURRENt position
        
    }
    
    public static void main(String[] args) {
        
    }
}
