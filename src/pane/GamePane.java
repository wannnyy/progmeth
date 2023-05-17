package pane;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.Main;

public class GamePane extends VBox {
	BorderPane topGamePane = new BorderPane();

	public GamePane(Main main) {
		topGamePane.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));
		topGamePane.setPrefWidth(800);
		topGamePane.setPrefHeight(75);
		topGamePane.setPadding(new Insets(15));
		BackButton btn1 = new BackButton(main);
		Text shotCount = new Text("0");
		topGamePane.setLeft(btn1);
		topGamePane.setRight(shotCount);

	}
}
