//Author:David Lakes
//Date: 11/14/2021
//Purpose: The program creates GUI that allows the user to enter an investment amount, interest rate,
//number of years of building interest, then outputs the total amount of money they have

package Investment;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Investment extends Application{
	//Create variables that correspond to the text fields
	  private TextField tfInvestmentAmount = new TextField();
	  private TextField tfNumberOfYears = new TextField();
	  private TextField tfInterestRate = new TextField();
	  private TextField tfTotalAmount = new TextField();
	  private Button btCalculate = new Button("Calculate");
	  
	  @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {
		
		 
		 
	  // Create UI
	  GridPane gridPane = new GridPane();
	  gridPane.setHgap(5);
	  gridPane.setVgap(5);
	  gridPane.add(new Label("Investment Amount:"), 0, 0);
	  gridPane.add(tfInvestmentAmount, 1, 0);
	  gridPane.add(new Label("Number of Years:"), 0, 1);
	  gridPane.add(tfNumberOfYears, 1, 1);
	  gridPane.add(new Label("Monthly Interest Rate:"), 0, 2);
	  gridPane.add(tfInterestRate, 1, 2);
	  gridPane.add(new Label("Total Amount:"), 0, 3);
	  gridPane.add(tfTotalAmount, 1, 3);
	  gridPane.add(btCalculate, 1, 5);
	  
	  // Set properties for UI
	  gridPane.setAlignment(Pos.CENTER);
	  tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
	  tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
	  tfTotalAmount.setAlignment(Pos.BOTTOM_RIGHT);
	  tfTotalAmount.setEditable(false);
	  GridPane.setHalignment(btCalculate, HPos.RIGHT);
	  
	  // Process events
	  btCalculate.setOnAction(e -> calculateInvestment());
	  
	 
	  
	  // Create a scene and place it in the stage
	  Scene scene = new Scene(gridPane, 400, 250);
	  primaryStage.setTitle("Investment Calculator"); // Set title
	  primaryStage.setScene(scene); // Place the scene in the stage
	  primaryStage.show(); // Display the stage
	  }

	
	
	 
//Method that corresponds to the button being clicked
private void calculateInvestment() {
	
	//Gets user input and turns it into variable
	double investAmount=Double.parseDouble(tfInvestmentAmount.getText());
	double interest =Double.parseDouble(tfInterestRate.getText());
	double year= Double.parseDouble(tfNumberOfYears.getText());
	
	//Math to figure out total amount
	double yearToPower = 12*year;
	double almostDone = Math.pow(1 + (interest/12),yearToPower);
	double total = investAmount*almostDone;
	
	
	tfTotalAmount.setText(String.format("$%.2f",total));

		
	}


public static void main(String[] args) {
		launch(args);
		
	}
}
