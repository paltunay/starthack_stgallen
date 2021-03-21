package dashboard;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        PieChart pieChart = new PieChart();
/*
        PieChart.Data slice1 = new PieChart.Data("Advice center for parents of small children", 33.000);
        PieChart.Data slice2 = new PieChart.Data("Advice for mothers", 1000000);
        PieChart.Data slice3 = new PieChart.Data("Aids aid St. Gallen-Appenzell", 10000);
        PieChart.Data slice4 = new PieChart.Data("Child and Adolescent Psychiatric Services Foundation St. Gallen", 85000);
        PieChart.Data slice5 = new PieChart.Data("Help and care at home", 2550000);
        PieChart.Data slice6 = new PieChart.Data("St. Gallen Hospice Service", 35000);
        PieChart.Data slice7 = new PieChart.Data("Community palliative care", 59000);
*/
        File file = new File("chartdata");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;


        while((line = reader.readLine()) != null) {
            String[] arr = line.split(";");
            pieChart.getData().add(new PieChart.Data(arr[0], Integer.valueOf(arr[1])));
        }
/*
        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
*/
        pieChart.setPrefSize(1200, 600);

        pieChart.setLegendSide(Side.LEFT);
        pieChart.setStartAngle(30);

        final Label caption = new Label("");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 12 arial;");

        primaryStage.setTitle("Dashboard");
        AnchorPane root = new AnchorPane();

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    /*
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());
                    for(int j = 0; j < pieChart.getData().size(); j++) {
                        pieChart.getData().remove(j);

                    }

                    caption.setText(String.valueOf(data.getPieValue()));*/
                    PieChart pieChart2 = new PieChart();
                    PieChart.Data[] date = {new PieChart.Data("Test1", 2), new PieChart.Data("Test2", 2), new PieChart.Data("Test3", 2), new PieChart.Data("Test4", 2)};

                    for (int i = 0; i< date.length; i++) {
                        pieChart2.getData().add(date[i]);
                    }


                    root.getChildren().removeAll(pieChart);
                    root.getChildren().addAll(pieChart2);
                    for (final PieChart.Data data : pieChart2.getData()) {
                        data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {

                                PieChart pieChart3 = new PieChart();
                                PieChart.Data[] date2 = {new PieChart.Data("Test22222", 2), new PieChart.Data("Test2", 2), new PieChart.Data("Test3", 2), new PieChart.Data("Test4", 2)};

                                for (int i = 0; i< date2.length; i++) {
                                    pieChart3.getData().add(date2[i]);
                                }

                                root.getChildren().removeAll(pieChart2);
                                root.getChildren().addAll(pieChart3);

                            }
                        });
                    }

                }
            });
        }

        pieChart.setMinWidth(500);
        pieChart.setLabelsVisible(false);
        pieChart.setMinHeight(500);
        root.getChildren().addAll(pieChart, caption);



        Scene scene = new Scene(root, 1200, 600);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void dashboardSetup(String[] args) {
        Application.launch(args);
    }
}