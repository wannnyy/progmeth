package main;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import pane.GolfCourse;
import pane.RootPane;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
    public void start(Stage stage) {
        // TODO: FILL CODE HERE
		GameLogic logic = new GameLogic();
		GolfCourse golfCourse = new GolfCourse();
    	RootPane rootPane = new RootPane(golfCourse);
    	Scene scene = new Scene(rootPane, 800, 640);
//		StackPane root = new StackPane();
//		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MiniGolf");
    	
//		GameLogic logic = new GameLogic();
//		GolfCourse golfCourse = new GolfCourse();
//		root.getChildren().add(golfCourse);
    	
    	stage.setResizable(false);
    	
    	golfCourse.requestFocus();
    	stage.show();
    	
    	AnimationTimer animation = new AnimationTimer() {
    		public void handle(long now) {
				golfCourse.paintComponent();
				logic.logicUpdate();
//				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
    		}
    	};
    	animation.start();
    }
		
}
