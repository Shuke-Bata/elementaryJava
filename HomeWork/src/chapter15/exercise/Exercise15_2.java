package chapter15.exercise;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Exercise15_2 extends Application
{
    private double angle = 0;
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setPadding(new Insets(20, 20, 20, 20));
        Rectangle re = new Rectangle(50, 50, 20, 40);
        re.setFill(Color.WHITE);
        re.setStroke(Color.BLACK);
        Button btRotate = new Button("Rotate");
        pane.getChildren().addAll(re, btRotate);
        pane.setAlignment(Pos.CENTER);

        btRotate.setOnAction(e -> {
            changeRectagle(re);
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("RotateARectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeRectagle(Rectangle re)
    {
        angle += 15;
        re.setRotate(angle);
    }
}

