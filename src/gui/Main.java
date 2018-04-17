package gui;
	
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text; 

public  class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		try {
			Text userName = new Text("Handle   ");
			TextField textField1 = new TextField();
			
			Button button1 = new Button("Click"); 
			//Action Handler in Click Button:
			button1.setOnAction(e -> {
				PieChartForm.display("Verdicts Pie Chart", textField1.getText());
		    });
			
			GridPane gridPane = new GridPane();
			gridPane.setMinSize(600, 450);
			gridPane.setPadding(new Insets(10, 10, 10, 80)); 
			
			gridPane.setVgap(5); 
		    gridPane.setHgap(5);  
			
		    gridPane.add(userName, 9, 3);
		    gridPane.add(textField1, 10, 3);
		    gridPane.add(button1, 10, 5);
		    
		    
		    userName.setStyle("-fx-font: normal  15px 'serif' ");
		    //button1.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		    
		    Scene scene = new Scene(gridPane);
		    stage.setTitle("Competitive Programmer's Analyzer");
		    stage.setScene(scene);
		    stage.show(); 
		    
			//BorderPane root = new BorderPane();	
			//Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);
			//primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
