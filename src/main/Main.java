package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.GameLogic;
import pane.GolfCourse;
import pane.RootPane;

public class Main extends Application {
	public static void main(String[] args) {
		launch();
	}
	
	@Override
    public void start(Stage stage) {
        // TODO: FILL CODE HERE
		GolfCourse golfCourse = new GolfCourse();
    	RootPane rootPane = new RootPane(golfCourse);
		GameLogic logic = new GameLogic();
    	Scene scene = new Scene(rootPane, 800, 640);
    	stage.setScene(scene);
    	stage.setTitle("MiniGolf");
    	stage.setResizable(false);
    	stage.show();
    	AnimationTimer animation = new AnimationTimer() {
    		public void handle(long now) {
				golfCourse.paintComponent();
//				logic.logicUpdate();
//				RenderableHolder.getInstance().update();
//				InputUtility.updateInputState();
    		}
    	};
    	animation.start();
    }
		
}
