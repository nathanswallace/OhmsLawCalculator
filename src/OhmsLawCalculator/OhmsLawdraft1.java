package OhmsLawCalculator;
//Tinkering around learning Java programming 
//Nov 7 2016

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OhmsLawdraft1 extends Application{
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Ohm's Law");
		GridPane grid = new GridPane();				//creates a GridPane object and assigns it to the variable named grid
		grid.setAlignment(Pos.CENTER);		//default position is top left, this changes it to the center
		grid.setHgap(10);				//spacing between the rows and columns
		grid.setVgap(10);		
		grid.setPadding(new Insets(25, 25, 25, 25)); //space around the edge of the grid pane, insets: top, right, bottom, left. in pixels
		
		Label Vl = new Label("Voltage="); 
		grid.add(Vl, 0, 1);
		
		Label Rl = new Label("Resistance="); 
		grid.add(Rl, 0, 2);
		
		Label Il = new Label("Current="); 
		grid.add(Il, 0, 3);
		
		Label Vu = new Label("Volts"); 
		grid.add(Vu, 2, 1);
		
		Label Ru = new Label("Ohms"); 
		grid.add(Ru, 2, 2);
		
		Label Iu = new Label("Amps"); 
		grid.add(Iu, 2, 3);
		
		TextField Vin = new TextField();
		grid.add(Vin, 1, 1);
		
		TextField Rin = new TextField();
		grid.add(Rin, 1, 2);
		
		Label Iout = new Label(""); 
		grid.add(Iout, 1, 3);
		
		Button btn = new Button("Calculate");
		HBox hbBtn = new HBox(10); // creates and HBox layout pane named hbBtn with space of 10 pixels 
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);  //positions a node at the bottom of the space vertically and at the right edge of the space horizontally. 
		hbBtn.getChildren().add(btn); //The button is added as a child of the HBox pane, and the HBox pane is added to the grid in column 1, row 4.
		grid.add(hbBtn, 1, 4);
		
		Vin.lengthProperty().addListener(new ChangeListener<Number>(){
	     public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {              
	           if(newValue.intValue() > oldValue.intValue()){
	               char ch = Vin.getText().charAt(oldValue.intValue());
	               System.out.println("User Entered Vin= "+ch);                   

	               //Check if the new character is the number or other's
	               if(!(ch >= '0' && ch <= '9')){       
	                    //if it's not number then just setText to previous one
	                    Vin.setText(Vin.getText().substring(0,Vin.getText().length()-1)); 
	               }
	          }
	     }
		     
		});
		
		Rin.lengthProperty().addListener(new ChangeListener<Number>(){
		     public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {              
		           if(newValue.intValue() > oldValue.intValue()){
		               char ch = Rin.getText().charAt(oldValue.intValue());
		               System.out.println("User Entered Rin= "+ch);                   

		               //Check if the new character is the number or other's
		               if(!(ch >= '0' && ch <= '9' )){       
		                    //if it's not number then just setText to previous one
		                    Rin.setText(Rin.getText().substring(0,Rin.getText().length()-1)); 
		               }
		          }
		     }
			     
			});
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				System.out.println("Calculating");
				float v = Float.valueOf(Vin.getText()); 
				float r = Float.valueOf(Rin.getText());
				float I = v/r; 
				System.out.println(I);
				String current = Float.toString(I);
				Iout.setText(current);
			}
		});
		//grid.setGridLinesVisible(true); //added for debugging purposes, uncomment to see grid layout
		Scene scene = new Scene(grid, 400, 275); // scene created with grid being the root node
		primaryStage.setTitle("Ohms Law");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
public static void main(String[] args) {	// extends the Applications class
	launch(args);
	}

}
