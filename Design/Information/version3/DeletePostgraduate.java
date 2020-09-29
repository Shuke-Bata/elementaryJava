package version3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version2.Postgraduate;

/**
 * 删除研究生信息界面
 * @author 周明华
 *
 */
public class DeletePostgraduate extends Application {
	
	public void start(Stage primaryStage, ArrayList<Postgraduate> list, int index) throws Exception {
		
		TextField addName = new TextField();
        addName.setText(list.get(index).getName());
        addName.setMaxSize(200, 50);
        
        TextField addAddress = new TextField();
        addAddress.setText(list.get(index).getAddress());
        addAddress.setMaxSize(200, 50);
        
        TextField addPhoneNumber = new TextField();
        addPhoneNumber.setText(list.get(index).getPhoneNumber());
        addPhoneNumber.setMaxSize(200, 50);
        
        TextField addEmai = new TextField();
        addEmai.setText(list.get(index).getEmail());
        addEmai.setMaxSize(200, 50);
        
        TextField addGrade = new TextField();
        addGrade.setText(list.get(index).getGrade());
        addGrade.setMaxSize(200, 50);
        
        TextField addStudy = new TextField();
        addStudy.setText(list.get(index).getStudy());
        addStudy.setMaxSize(200, 50);
        
        TextField addTutor = new TextField();
        addTutor.setText(list.get(index).getTutor());
        addTutor.setMaxSize(200, 50);
        
        Button saveButton = new Button("删除");
        saveButton.setMinSize(50, 20);
        saveButton.setOnAction(event -> {
        	list.remove(index);
        	
        	try {
				saveToFile(list,list.size());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        	
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
        
        Button backButton = new Button("返回");
        backButton.setMinSize(50, 20);
        backButton.setOnAction(event -> {
        	PostgraduateTable postgraduateTable = new PostgraduateTable();
        	
        	primaryStage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1080);
    		newStage.setMinHeight(500);
    		
        	try {
        		postgraduateTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        HBox box = new HBox(100);
        box.getChildren().addAll(backButton, saveButton);
        box.setAlignment(Pos.CENTER);
        
        
        VBox addBox = new VBox(10);
        addBox.getChildren().addAll(addName, addAddress, addPhoneNumber, addEmai, addGrade, addStudy, addTutor, box);
        addBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(addBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("删除研究生信息");
        primaryStage.show();
        primaryStage.setResizable(false);
	}
	
	/**
	 * 写入文件
	 * @param postgraduates
	 * @param size
	 * @throws FileNotFoundException
	 */
	public static void saveToFile(ArrayList<Postgraduate> postgraduates,int size) throws FileNotFoundException {
		String[][] str = new String[size][7] ;
		int i = 0;
		for (Postgraduate postgraduate : postgraduates) {
			if (i==0) {
				str[i][0] = "," + postgraduate.getName();
				str[i][1] = postgraduate.getAddress();
				str[i][2] = postgraduate.getPhoneNumber();
				str[i][3] = postgraduate.getEmail();
				str[i][4] = postgraduate.getGrade();
				str[i][5] = postgraduate.getStudy();
				str[i][6] = postgraduate.getTutor();				
			}
			else {
				str[i][0] = postgraduate.getName();
				str[i][1] = postgraduate.getAddress();
				str[i][2] = postgraduate.getPhoneNumber();
				str[i][3] = postgraduate.getEmail();
				str[i][4] = postgraduate.getGrade();	
				str[i][5] = postgraduate.getStudy();
				str[i][6] = postgraduate.getTutor();
			}
			i++;
		}
		try(PrintWriter output = new PrintWriter(new FileOutputStream("postgraduate.txt"));){
			for (int j = 0; j < str.length; j++) {
				for (int k = 0; k < str[j].length; k++) {
					output.print(str[j][k] + "\t");
				}
				output.println();
			}
		}		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
/**
 * 查询删除研究生界面
 * @author 周明华
 *
 */
class DeletePostgraduateSearch extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
	Text text = new Text("请输入要删除的姓名");
	
	TextField searchName = new TextField();
	searchName.setPromptText("姓名");
	searchName.setMaxSize(200, 50);
    
    Button searchButton = new Button("查询");
    searchButton.setMinSize(50, 20);
    searchButton.setOnAction(event -> {
    	PostgraduateTable postgraduateTable = new PostgraduateTable();
    	ArrayList<Postgraduate> list = new ArrayList<>();
    	int index = -1;
		try {
			list = postgraduateTable.readFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < list.size(); i++) {
			String name =  list.get(i).getName();
			String search = searchName.getText();			
			if ((name).equals(search)) {
				index = i;
				break;
			}
		}
		
    	primaryStage.hide();//关闭
    	Stage newStage = new Stage();
		newStage.setMinWidth(400);
		newStage.setMinHeight(300);
		if (index >= 0) {
			try {
				DeletePostgraduate deletePostgraduate = new DeletePostgraduate();
				deletePostgraduate.start(newStage, list, index);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			SearchWrongFrame searchWrongFrame = new SearchWrongFrame();
			try {
				searchWrongFrame.start(newStage);
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
					    	newStage.hide();//关闭
					    	Stage stage = new Stage();
							stage.setMinWidth(800);
							stage.setMinHeight(500);			
					    	try {
					    		postgraduateTable.start(stage);
							} catch (Exception e) {
								e.printStackTrace();
							}
					    }
					});
					myTimer.cancel();		
				}
			};
			myTimer.schedule(tt, 1000);//1秒后执行
		}
    	
	    });
	    
	    Button backButton = new Button("返回");
	    backButton.setMinSize(50, 20);
	    backButton.setOnAction(event -> {
	    	PostgraduateTable postgraduateTable = new PostgraduateTable();
	    	
	    	primaryStage.hide();//关闭
	    	Stage newStage = new Stage();
			newStage.setMinWidth(1080);
			newStage.setMinHeight(500);
			
	    	try {
	    		postgraduateTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
		}
	    });
	    
	    HBox box = new HBox(100);
	    box.getChildren().addAll(backButton, searchButton);
	    box.setAlignment(Pos.CENTER);
	    
	    
	    VBox addBox = new VBox(10);
	    addBox.getChildren().addAll(text,searchName, box);
	    addBox.setAlignment(Pos.CENTER);
	    Scene scene = new Scene(addBox);
	    
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("研究生信息查询");
	    primaryStage.show();
	    primaryStage.setResizable(false);
	}
}