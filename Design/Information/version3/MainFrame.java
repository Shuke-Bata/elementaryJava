package version3;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * 主菜单窗口界面
 * @author 周明华
 *
 */
public class MainFrame extends Application {
	public static int num = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button studentButton = new Button("学生信息管理");
		studentButton.setMinSize(300, 50);
		
		Button employeetButton = new Button("雇员信息管理");
		employeetButton.setMinSize(300, 50);
		
		Button facultyButton = new Button("教员信息管理");
		facultyButton.setMinSize(300, 50);
		
		Button staffButton = new Button("职员信息管理");
		staffButton.setMinSize(300, 50);
		
		Button postgraduateButton = new Button("研究生信息管理");
		postgraduateButton.setMinSize(300, 50);
		
		Button exitButton = new Button("退出");
		exitButton.setMinSize(100, 40);
		
		VBox pane = new VBox();
		
		studentButton.setOnAction(event -> {
			StudentTable studentTable = new StudentTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(800);
    		newStage.setMinHeight(500);
    		
        	try {
				studentTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		employeetButton.setOnAction(event -> {
			EmployeeTable employeeTable = new EmployeeTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1000);
    		newStage.setMinHeight(500);
    		
        	try {
        		employeeTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		facultyButton.setOnAction(event -> {
			FacultyTable facultyTable = new FacultyTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1200);
    		newStage.setMinHeight(500);
    		
        	try {
        		facultyTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		staffButton.setOnAction(event -> {
			StaffTable staffTable = new StaffTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1100);
    		newStage.setMinHeight(500);
    		
        	try {
        		staffTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		postgraduateButton.setOnAction(event -> {
			PostgraduateTable postgraduateTable = new PostgraduateTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1000);
    		newStage.setMinHeight(500);
    		
        	try {
        		postgraduateTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		exitButton.setOnAction(event -> {
			ExitFrame exit = new ExitFrame();
			primaryStage.hide();//关闭
        	Stage newStage = new Stage();
        	newStage.setMinWidth(400);
			newStage.setMinHeight(100);
    		
        	try {
        		exit.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
        	Timer myTimer = new Timer();
			TimerTask tt = new TimerTask() {
				@Override
				public void run() {
					System.exit(0);
				}
			};
			myTimer.schedule(tt, 900);//1秒后执行
		});
		
		pane.setSpacing(10);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(studentButton, employeetButton, facultyButton, staffButton, postgraduateButton, exitButton);
		
		
		Scene scene = new Scene(pane, 350, 350);
		primaryStage.setTitle("人员信息管理系统");
		primaryStage.setScene(scene);
		
		if (num==0) {
			WelcomeFrame welcomeFrame = new WelcomeFrame();
			Stage stage = new Stage();
			try {
				welcomeFrame.start(stage);
				num++;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Timer myTimer = new Timer();
			TimerTask tt = new TimerTask() {
				@Override
				public void run() {
					//在其他线程更新JavaFX的线程上的信息的时候,就可能报这种错误
					//解决办法
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					    	stage.hide();
							primaryStage.show();		
							primaryStage.setResizable(false);
					    }
					});
					myTimer.cancel();		
				}
			};
			myTimer.schedule(tt, 1000);//1秒后执行
		} else {
			primaryStage.show();		
			primaryStage.setResizable(false);
		}	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
