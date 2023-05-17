package pane;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import logic.GameLogic;
import main.Main;
import sharedObject.RenderableHolder;

public class WelcomePage extends VBox {
	private Button startButton;
	private Button exitButton;
	private RootPane rootPane;
	private Main myMain;

	public WelcomePage(Stage stage, Main main) {
		// Create a label to display the title of the game
		this.myMain = main;
		Label titleLabel = new Label("My Mini Golf Game");
		titleLabel.setStyle("-fx-font-size: 36px;");

		// Create a button to start the game
		startButton = new Button("Start Game");
		startButton.setStyle("-fx-font-size: 18px;");

		// Create a button to exit the game
		exitButton = new Button("Exit Game");
		exitButton.setStyle("-fx-font-size: 18px;");

		// Add event handlers to the buttons
		startButton.setOnAction(event -> {
			// Handle the start button click event
			// (e.g. start the game)
			stage.setScene(myMain.getGameScene());
		});
		exitButton.setOnAction(event -> Platform.exit());

		// Add the components to the pane
		setSpacing(20);
		setPadding(new Insets(40));
		setAlignment(Pos.CENTER);
		getChildren().addAll(titleLabel, startButton, exitButton);
	}

	// Getter methods for the start and exit buttons

	public Button getStartButton() {
		return startButton;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public RootPane getRootPane() {
		return rootPane;
	}
}