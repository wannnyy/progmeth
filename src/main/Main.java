package main;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameLogic;
import pane.GolfCourse;
import pane.RootPane;
import pane.WelcomePage;
import sharedObject.RenderableHolder;

public class Main extends Application {
	private Scene welcomePageScene;
	private Scene gameScene;
	private Stage stage;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		WelcomePage welcomePage = new WelcomePage(stage, this);
		welcomePageScene = new Scene(welcomePage, 800, 640);

		GameLogic logic = new GameLogic();
		GolfCourse golfCourse = new GolfCourse();
		RootPane rootPane = new RootPane(golfCourse, this);
		gameScene = new Scene(rootPane, 800, 640);
		golfCourse.requestFocus();

		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				golfCourse.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
			}
		};
		animation.start();

		stage.setScene(welcomePageScene);
		stage.setTitle("MiniGolf");
		stage.setResizable(false);
		stage.show();

	}

	public Scene getWelcomePageScene() {
		return this.welcomePageScene;
	}

	public Scene getGameScene() {
		return this.gameScene;
	}

	public void setGameScene(Scene gameScene) {
		this.gameScene = gameScene;
	}

	public Stage getStage() {
		return this.stage;
	}

}