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

import java.io.*;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        PieChart pieChart = new PieChart();
        File file = new File("chartdata");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;


        while((line = reader.readLine()) != null) {
            String[] arr = line.split(";");
            pieChart.getData().add(new PieChart.Data(arr[0], Integer.valueOf(arr[1])));

        }

        pieChart.setPrefSize(1200, 600);

        pieChart.setLegendSide(Side.LEFT);
        pieChart.setStartAngle(30);

        final Label caption = new Label("");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 24 arial;");

        primaryStage.setTitle("Dashboard");
        AnchorPane root = new AnchorPane();

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    caption.setTranslateX(event.getSceneX());
                    caption.setTranslateY(event.getSceneY());

                    caption.setText(String.valueOf(data.getPieValue()));
                }
            });
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {


                    PieChart pieChart2 = new PieChart();
                    pieChart2.setMinWidth(500);
                    pieChart2.setLabelsVisible(false);
                    pieChart2.setMinHeight(500);

                    File file = new File("layer1");
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader(file));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    String line = null;


                    while(true) {
                        try {
                            if (!((line = reader.readLine()) != null)) break;
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        String[] arr = line.split(";");
                        pieChart2.getData().add(new PieChart.Data(arr[0], Integer.valueOf(arr[1])));
                    }



                    root.getChildren().removeAll(pieChart);
                    root.getChildren().addAll(pieChart2);
                    for (final PieChart.Data data : pieChart2.getData()) {
                        data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {

                                PieChart pieChart3 = new PieChart();

                                pieChart3.setMinWidth(500);
                                pieChart3.setLabelsVisible(false);
                                pieChart3.setMinHeight(500);

                                File file = new File("layer2");
                                BufferedReader reader = null;
                                try {
                                    reader = new BufferedReader(new FileReader(file));
                                } catch (FileNotFoundException fileNotFoundException) {
                                    fileNotFoundException.printStackTrace();
                                }
                                String line = null;

                                while(true) {
                                    try {
                                        if (!((line = reader.readLine()) != null)) break;
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                    String[] arr = line.split(";");
                                    pieChart3.getData().add(new PieChart.Data(arr[0], Integer.valueOf(arr[1])));
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