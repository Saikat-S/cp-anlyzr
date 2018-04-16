package gui;

import javafx.geometry.Side;
import java.util.*;
import java.util.Map;

import backend.Verdict;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;

public class PieChartForm {

     public static void display(String title, String usr) {
    	 Stage window = new Stage();
    	 Scene scene = new Scene(new Group());
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setWidth(600);
    	 window.setHeight(450);
         
    	 Verdict vr = new Verdict();
    	 vr.verdict(usr);
    	 
    	 Map<String,Integer> mp = vr.getMap();
    	 System.out.print("\t" + mp);
    	 
    	 ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    	 
    	 Set<Map.Entry<String, Integer>> st = mp.entrySet();
    	 
    	 for (Map.Entry<String, Integer> entry: st) {
    		 System.out.println(entry.getValue() + "\t" + entry.getKey());
    		 pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
         }
    	 
    	 //for(int i = 0; i<mp.size(); i++) {
    	//	 int st = mp.get("OK");
    	//	 int nm = mp.getValue();
    		 
    	//	 pieChartData.add(new PieChart.Data(mp.getKey(), mp.getValue()));
    	// }
    	 
    	 /*Create Pie Chart Data 
    	 //ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    	// pieChartData.add(new PieChart.Data("C++", 13));
    	// pieChartData.add(new PieChart.Data("C", 25));
    	// pieChartData.add(new PieChart.Data("C#", 10));
    	// pieChartData.add(new PieChart.Data("Java", 30));
    	// pieChartData.add(new PieChart.Data("Python", 22));*/
    	 
    	 //Create Pie Chart
    	 //final PieChart chart = new PieChart(pieChartData);
    	 
    	 /*//Create Pie Chart Data 
    	  ObservableList<PieChart.Data> pieChartData =
    			FXCollections.observableArrayList(
    			new PieChart.Data(	"C++", 13),
    			new PieChart.Data("C", 25),
                new PieChart.Data("Java", 10),
    		    new PieChart.Data("Python", 22),
    		    new PieChart.Data("C#", 30));
    	 final PieChart chart = new PieChart(pieChartData);*/
    	 
    	 final PieChart chart = new PieChart(pieChartData);
    	 chart.setTitle("           "+usr + " Verdicts Chart");
    	 
     	//Show names in left : 
     	 chart.setLabelLineLength(50);
     	 chart.setLegendSide(Side.LEFT);
     	 
        //Mouse Event Processing : 
    	 final Label caption = new Label("");
    	 caption.setTextFill(Color.WHITE);
    	 caption.setStyle("-fx-font: 18 arial;");
    	  
    	 
    	 for (final PieChart.Data data : chart.getData()) {
    	     data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
    	         new EventHandler<MouseEvent>() {
    	             @Override public void handle(MouseEvent e) {
    	                 caption.setTranslateX(e.getSceneX());
    	                 caption.setTranslateY(e.getSceneY());
    	                 //caption.setText(String.valueOf(data.getPieValue()) + "%");
    	                  caption.setText(String.valueOf(data.getPieValue()));
    	              }
    	         });
    	 }
         ((Group) scene.getRoot()).getChildren().add(chart);
         ((Group) scene.getRoot()).getChildren().add(caption);
    	 
    	 
    	 window.setScene(scene);
    	 window.show();

     }
}
