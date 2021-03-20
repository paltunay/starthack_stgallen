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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("USA", 17947195);
        PieChart.Data slice2 = new PieChart.Data("EU", 11540278);
        PieChart.Data slice3 = new PieChart.Data("China", 10982829);
        PieChart.Data slice4 = new PieChart.Data("Japan", 4116242);
        PieChart.Data slice5 = new PieChart.Data("Others", 28584442);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);

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


        root.getChildren().addAll(pieChart, caption);



        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void dashboardSetup(String[] args) {
        Application.launch(args);
    }
}