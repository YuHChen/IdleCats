//package ychen.games.IdleCats;

import java.math.BigInteger;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class IdleCats extends Application {

    @Override
    public void start(Stage primaryStage) {
	// create content
	BorderPane root = new BorderPane();
	// create currency ribbon
	BigInteger total_currency = BigInteger.valueOf(100);
	Text total_currency_text = new Text(total_currency.toString());
	HBox top_ribbon = new HBox(10);
	top_ribbon.setPadding(new Insets(10, 20, 10, 20));
	top_ribbon.setAlignment(Pos.CENTER_LEFT);
	top_ribbon.getChildren().add(total_currency_text);
	root.setTop(top_ribbon);
	// create main arena
	HBox arena = new HBox(10);
	arena.setPadding(new Insets(0, 5, 0, 5));
	arena.setAlignment(Pos.CENTER_LEFT);
	ImageView tower = new ImageView(new Image("img/Tower_cropped.png"));
	arena.getChildren().add(tower);
	root.setCenter(arena);
	// create units menu
	GridPane units_menu = new GridPane();
	ImageView units[] = new ImageView[1];
	units[0] = new ImageView(new Image("img/Macho_cat_cropped.png"));
	units[0].setPreserveRatio(true);
	units[0].setSmooth(true);
	units[0].setCache(true);
	units[0].setFitWidth(100);
	units_menu.add(units[0], 0, 0);
	Button level_up = new Button("Level Up");
	level_up.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		ImageView macho_cat_unit = new ImageView(new Image("img/Macho_cat_cropped.png"));
		arena.getChildren().add(macho_cat_unit);
		TranslateTransition tt = new TranslateTransition(Duration.millis(2000), macho_cat_unit);
		//tt.setFromX();
		tt.setByX(400f);
		tt.setCycleCount(1);
		tt.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
			arena.getChildren().remove(macho_cat_unit);
		    }
		});

		tt.play();
		//arena.getChildren().remove(macho_cat_unit);
	    }
	});
	units_menu.add(level_up, 0, 1);
	units_menu.setPadding(new Insets(10, 5, 5, 5));
	root.setBottom(units_menu);

	// add content to scene container
	Scene scene = new Scene(root, 800, 500, Color.WHITE);
	// add scene to stage container
	primaryStage.setTitle("IdleCats");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }
}
