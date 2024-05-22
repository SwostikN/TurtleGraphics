package oopfinal;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import static java.lang.Integer.parseInt;
import uk.ac.leedsbeckett.oop.OOPGraphics;



public class TurtleGraphics extends OOPGraphics
{                                                     //Variables used for managing commands and state
    private ArrayList<String> commands;               
    private boolean writeCommand;                     //List to store entered commands
    private boolean saved;                            //Flag to indicate if an image is saved
    private boolean saveWarn;                         //Flag to display warning about unsaved image

    public TurtleGraphics()
    {
        JFrame MainFrame = new JFrame("OOP TurtleGraphics Project - Swostik Nepal");  //Creates a frame for the turtle to be displayed on
        MainFrame.setLayout(new FlowLayout());                                        //sets the frame's layout to FlowLayout (not necessary)
        MainFrame.add(this);                                                          //adds the turtle panel to the frame
        MainFrame.pack();                                                             //Resizes the frame/window to optimal size user to see
        MainFrame.setVisible(true);                                                   //Shows the frame window
       // super.about();
        penDown();
        this.commands = new ArrayList<String>();         //Initializes variables
        writeCommand = true;
        saved = false;
        saveWarn = false;
    
    
    }

    public static void main(String[] args)
    {
        new TurtleGraphics();                                                            //Creates a new instance of the class extended by LBUGraphics
    }

    @Override
    public void about()					                                                 //Overrides the about() method to display my name
    {

    	// Method to display the author name overriding about method
   
    	    
    	    // Set starting position for drawing
    	    setxPos(90);
    	    setyPos(150);
    	    penUp();
    	    setStroke(10);

    	   //  Drawing letter S
    	    setPenColour(Color.YELLOW);
    	    turnRight(90);
    	    penDown();
    	    forward(60);
    	    turnLeft(90);
    	    forward(50);
    	    turnLeft(90);
    	    forward(60);
    	    turnRight(90);
    	    forward(50);
    	    turnRight(90);
    	    forward(60);
    	    penUp();

    	    // Drawing letter W
    	    setPenColour(Color.white);
    	    setxPos(120);
    	    setyPos(150);
    	    penDown();
    	    turnLeft(90);
    	    forward (100);
    	    turnLeft(130);
    	    forward(50);
    	    turnRight(85);
    	    forward(50);
    	    turnLeft(135);
    	    forward(100);
       	    penUp();

    	    // Drawing letter O
       	 setPenColour(Color.cyan);
   	        setxPos(285);
    	    setyPos(150);
    	    turnLeft(90);
    	    penDown();
    	    forward(60);
    	    turnLeft(90);
    	    forward(100);
    	    turnLeft(90);
    	    forward(60);
    	    turnLeft(90);
    	    forward(100);
    	    penUp();

//    	    // Drawing letter S
    	    setPenColour(Color.magenta);
    	    setxPos(380);
    	    setyPos(150);
    	    penDown();
    	    turnLeft(90);
    	    forward(60);
    	    turnLeft(90);
    	    forward(50);
    	    turnLeft(90);
    	    forward(60);
    	    turnRight(90);
    	    forward(50);
    	    turnRight(90);
    	    forward(60);
    	    penUp();
//
//    	    // Drawing letter T
    	    setPenColour(Color.green);
    	    setxPos(450);
    	    setyPos(150);
    	    turnLeft(90);
    	    penDown();
    	    forward(100);
    	    penUp();
    	    setxPos(410);
    	    setyPos(150);
    	    penDown();
    	    turnLeft(90);
    	    forward(90);
    	    penUp();

//    	    // Drawing letter I
    	    setPenColour(Color.blue);
    	    setxPos(560);
    	    setyPos(150);
    	    turnRight(90);
    	    penDown();
    	    forward(100);
    	    penUp();
    	    setxPos(520);
    	    setyPos(150);
    	    penDown();
    	    turnLeft(90);
    	    forward(90);
    	    penUp();
    	    setxPos(520);
    	    setyPos(250);
    	    penDown();
    	    forward(90);
    	    penUp();
    	    
    	 // letter K 
    	    setPenColour(Color.red);
    		setxPos(640);
    	    setyPos(150); 
    	    
    	    turnRight(90);
    	    penDown();
    	    forward(100);
    	    penUp();
    	    setxPos(640);
    	    setyPos(200); 
    	    turnLeft(50);
    	    penDown();
    	    forward(80);
    	    penUp();
    	    setxPos(640);
    	    setyPos(200); 
    	    turnLeft(80);
    	    penDown();
    	    forward(80);
    	    penUp();

    	    
        displayMessage("Swostik Nepal");
    }
    
    public void setRGB(int redValue, int greenValue, int blueValue)                      // Sets the pen color to the specified RGB values
    {
        Color rgbColour = new Color(redValue, greenValue, blueValue);
        setPenColour(rgbColour);
    }
 
    public void square(int length)
    {
        setStroke(3);
        forward(length);
        turnRight(90);
        forward(length);
        turnRight(90);
        forward(length);
        turnRight(90);
        forward(length);
        reset();

    }

    public void equilateralTriangle(int sideLength)
    {
        setStroke(3);
        turnLeft(60);
        forward(sideLength);
        turnLeft(120);
        forward(sideLength);
        turnLeft(120);
        forward(sideLength);

    }
    
    public void drawTriangle(int s1, int s2, int s3) {
        // Check if the given side lengths form a valid triangle
        if ((s1 + s2 > s3) && (s1 + s3 > s2) && (s2 + s3 > s1)) {
            // Calculate the angles of the triangle using the law of cosines
            int angle1 = (int) Math.toDegrees(Math.acos((s2 * s2 + s3 * s3 - s1 * s1) / (2.0 * s2 * s3)));
            int angle2 = (int) Math.toDegrees(Math.acos((s1 * s1 + s3 * s3 - s2 * s2) / (2.0 * s1 * s3)));
            int angle3 = 180 - angle1 - angle2;
            //displayMessage(angle1 + " " + angle2 + " " + angle3);

            // Draw the triangle
            //turnLeft(angle2/2);
            turnRight(angle2);
            forward(s1);
            turnLeft(180 - angle3);
            forward(s2);
            turnLeft(180 - angle1); 
            forward(s3);
        }
        else {
            // Show a warning message if the side lengths do not form a valid triangle
            JOptionPane.showMessageDialog(null, "Invalid side lengths: They do not form a valid triangle.\n" +
                    "Sum of two  should be greater than another side.\n" 
                      ,"Parameter Error", JOptionPane.WARNING_MESSAGE);
        }
    }  
    


    public void processCommand(String command)    												 //This method is called when a command is entered in the LBUGraphics JTextField.
    {
							
        boolean invalid = false;                                                                 //Flag to Checks if the command is valid                                       

        String[] commandsEntered = command.toLowerCase().split(" ");							 //Makes all commands entered lower-case and splits the commands into individual words
        if(commandsEntered[0].matches("forward|backward|save|load|savecommands|loadcommands" ))	 //Checks for commands that require additional values
        {
            if(commandsEntered.length!=2)                                                        //Checks if the command is missing a parameter                                                   
            {
                displayMessage("Parameter is missing!");
                invalid = true;
            }

            else if(commandsEntered[0].matches("forward|backward" ))
            {
                try
                {
                    int distance = parseInt(commandsEntered[1]);                                 //Convets the value to an integer
                    if(distance<0||distance>100)                                                 //Checks if the value is within bounds
                    {
                        displayMessage("Please enter value 1-100");                              
                        invalid = true;
                    }
                }

                catch(Exception e)                                                               //Checks if the parameter is non-numeric
                {
                    displayMessage("Non- numeric data for a paramter");
                    invalid = true;
                }
            }
        }

        
        if(!invalid)
        {
            switch (commandsEntered[0]) 
            {
		        // PEN COMMANDS
                case "penup":
                    penUp();
                    displayMessage("Pen's up turtle won't draw");
                    break;

                case "pendown":
                    penDown();
                    displayMessage("Pen's down Turtle will draw");
                    break;          
                    
	            // TURTLE MOVEMENTS
                case "forward":
                    forward(parseInt(commandsEntered[1]));
                    displayMessage("Turtle moved forwards");
                    break;

                case "backward":
                    turnLeft(180); // Turn the turtle's head 180 degrees to the left
                    forward((1) * parseInt(commandsEntered[1])); // Move backward
                    turnLeft(180); // Turn the turtle's head back to the original position
                    displayMessage("Turtle moved backwards");
                    break;

                case "turnleft":
                    if (commandsEntered.length != 2)
                    {
                        turnLeft();
                        displayMessage("Turtle turned left!");
                    }
                    
                    else
                    {
                        turnLeft(parseInt(commandsEntered[1]));
                        displayMessage("Command successful");
                    }
                    break;

                case "turnright":
                    if (commandsEntered.length != 2)
                    {
                        turnRight();
                        displayMessage("Turtle turned right!");
                    }

                    else

                    {
                        turnRight(parseInt(commandsEntered[1]));
                        displayMessage("Command successful");
                    }
                    break;

                case "about":
                    about();
                    break;
                    
                    
						// PEN COLOR SETTINGS
                case "black":
                    setPenColour(Color.black);
                    displayMessage("Pen colour set to black");
                    break;

                case "green":
                    setPenColour(Color.green);
                    displayMessage("Pen colour set to green");
                    break;

                case "red":
                    setPenColour(Color.red);
                    displayMessage("Pen colour set to red");
                    break;

                case "white":
                    setPenColour(Color.white);
                    displayMessage("Pen colour set to white");
                    break;
                    
                case "blue":
                    setPenColour(Color.blue);
                    displayMessage("Pen colour set to blue");
                    break;
                    

                case "pen":
                    if (commandsEntered.length != 4) {
                        displayMessage("Please input valid RGB values");
                        invalid = true;
                    } else {
                        try {
                            int red = Integer.parseInt(commandsEntered[1]);
                            int green = Integer.parseInt(commandsEntered[2]);
                            int blue = Integer.parseInt(commandsEntered[3]);
                            setRGB(red, green, blue);
                            displayMessage("Pen colour set to RGB value");
                        } catch (NumberFormatException e) {
                            displayMessage("Please input valid RGB values");
                            invalid = true;
                        } catch (IllegalArgumentException e) {
                            displayMessage("Illegal RGB value. RGB values must be between 0 and 255." );
                            invalid = true;
                        }
                    }
                    break;

                	

                                     
                case "penwidth":
                	if (commandsEntered.length != 2)
                	{
                		displayMessage("Please input a valid pen width");
                		invalid = true;
                	}
                	else {
                		try {
                			int width =(parseInt(commandsEntered[1]));
                			setStroke(width);
                			displayMessage("Pen width set to" + width);
                		}
                		catch (NumberFormatException e)
                		{
                			displayMessage("Please input a valid pen width");
                			invalid = true;
                		}
                	}
                	break;

                	               	
                case "reset":
                    reset();
                    penDown();
                    displayMessage("Turtle returned to starting position");
                    break;


                    
					     
                case "square":
                	if (commandsEntered.length !=2)
                	{
                		displayMessage("Please input a valid side length");
                		invalid = true;
                	}
                	else {
                		try {
                			int length = parseInt(commandsEntered[1]);
                			square(length);
                			displayMessage("Square drawn with side length given");
                		}
                		catch (NumberFormatException e)
                		{
                			displayMessage("Please input a valid side length");
                			invalid = true;
                		}	
                	}
                	break;

                case "triangle":
                    if (commandsEntered.length == 2) {
                        try {
                            int length = parseInt(commandsEntered[1]);
                            equilateralTriangle(length);
                            displayMessage("Equilateral triangle drawn with side length given");
                        } catch (NumberFormatException e) {
                            displayMessage("Please input a valid side length");
                        }
                    } else if (commandsEntered.length == 4) {
                        try {
                            int side1 = parseInt(commandsEntered[1]);
                            int side2 = parseInt(commandsEntered[2]);
                            int side3 = parseInt(commandsEntered[3]);
                            drawTriangle(side1, side2, side3);
                            displayMessage("Scalene triangle drawn with side lengths given");
                        } catch (NumberFormatException e) {
                            displayMessage("Please input valid side lengths");
                        }
                    } else {
                        displayMessage("Please input either one or three side lengths");
                    }
                    break;
                	
                	
                	
				      //LOADING, SAVING AND EXITING
                	
                case "save":
                	if(commandsEntered.length==2)
                	{
                		saveImage(commandsEntered[1]);
                	}
                	else 
                	{
                		displayMessage("Please give filename!");
                	}
                	
                	
                	break;
                	
                case "load":
                	loadImage(commandsEntered[1]);
                	break;
                	
                case "savecommand":
                	if(commandsEntered.length==2)
                	{
                		saveCommands(commandsEntered[1]);
                	}
                	else 
                	{
                		displayMessage("Please give filename!");
                	}
                	
                	break;
                	
                case "loadcommand":
                	loadCommands(commandsEntered[1]);
                	break;
                	
                case "clear":
                	clearCanvas();
                	break;
                	
                case "confirm":
                	confirmClear();
                	break;
                	
                default:
                	displayMessage ("Invalid command");
                	invalid = true;
                	
            }
                	
            if(!invalid && !commandsEntered[0].equals("clear") && !commandsEntered[0].equals("loadcommand") && !commandsEntered[0].equals("savecommand") && !commandsEntered[0].equals("load") && !commandsEntered[0].equals("save") && writeCommand)
            {
                commands.add(command);
            }
        }
    }

    private void saveImage(String filename)                                   //Saves the current drawing to an image file
    {

        try                                         
        {
            BufferedImage bufferedImage = getBufferedImage();                 //Create a new BufferedImage with the current turtle panel dimensions
            File outputfile = new File(filename + ".png");                    //Saves the image to the specified file
            ImageIO.write(bufferedImage, "png", outputfile);        
            saved = true;
            displayMessage("Image saved successfully!");;
        }

        catch (IOException e)
        {
            displayMessage("Failed to save image");
        }
    }

    private void loadImage(String filename) {
        if (!saved) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to continue loading the image?", "Warning", JOptionPane.YES_NO_OPTION);
            if (option != JOptionPane.YES_OPTION) {
                return; // If user selects No, return from the method without loading the image
            }
        }

        try {
            File inputFile = new File(filename + ".png");
            BufferedImage bufferedImage = ImageIO.read(inputFile);
            setBufferedImage(bufferedImage);
            displayMessage("Command was successful: Your canvas has been loaded");
        } catch (IOException e) {
            displayMessage("Load command has failed: File does not exist");
        }
    }


    private void saveCommands (String filename)
    {
    	
        try
        {
            FileWriter myWriter = new FileWriter(filename + ".txt");
            for(String str: commands)
            {
                myWriter.write(str + System.lineSeparator());
            }

            myWriter.close();
            saved = true;
            displayMessage("Command was successful");
        }

        catch (Exception e)
        {
            displayMessage("SaveCommand Error");
        }
    }

    private void loadCommands(String filename) {
        if (!saved) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to continue loading the commands?", "Warning", JOptionPane.YES_NO_OPTION);
            if (option != JOptionPane.YES_OPTION) {
                return; // If user selects No, return from the method without loading the commands
            }
        }

        try {
            File comoutputfile = new File(filename + ".txt");
            Scanner myReader = new Scanner(comoutputfile);
            writeCommand = false;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                commands.add(data);
                processCommand(data);
            }
            writeCommand = true;
            myReader.close();
            displayMessage("Command was successful");
        } catch (FileNotFoundException e) {
            displayMessage("Load Failed: File never existed!");
        }
    }

        
        
    private void clearCanvas()
    {
        if(saved)
        {
            clear();
            commands = new ArrayList<String>();
            displayMessage("Canvas cleared");
        }

        else
        {
        	 saveWarn = true;
             JOptionPane.showMessageDialog(null, "\"Warning: Current Image/commands has not been saved\" \r\n"
             		+ "                    \"Type 'confirm' if you wish to clear the frame\"\n" 
                       ,"Parameter Error", JOptionPane.WARNING_MESSAGE);
        }
    }
        

    private void confirmClear()
    {
        if(saveWarn)
        {
            clear();
            saveWarn = false;
            displayMessage("Command successful");
        }
        else
        {
            displayMessage("Confirmation not required");
        }
    }


}
