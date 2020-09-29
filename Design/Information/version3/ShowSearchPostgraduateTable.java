package version3;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import version2.Postgraduate;
/**
 * 研究生信息查询展示
 * @author 周明华
 *
 */
public class ShowSearchPostgraduateTable extends Application{
    private final TableView<Postgraduate> table = new TableView<>();
    
	@SuppressWarnings("unchecked")
	public void start(Stage stage, ArrayList<Postgraduate> list) {
		
		ObservableList<Postgraduate> data = FXCollections.observableArrayList(list);
		
        Scene scene = new Scene(new Group());
        stage.setTitle("研究生信息管理");
        stage.setWidth(1000);
        stage.setHeight(500);

        table.setEditable(true);

        TableColumn<Postgraduate, String> nameCol = new TableColumn<>("姓名");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//数据关联到表格
        
        TableColumn<Postgraduate, String> adressCol = new TableColumn<>("地址");
        adressCol.setMinWidth(100);
        adressCol.setCellValueFactory(new PropertyValueFactory<>("address"));//数据关联到表格
        
        TableColumn<Postgraduate, String> phoneNumberCol = new TableColumn<>("电话号码");
        phoneNumberCol.setMinWidth(200);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));//数据关联到表格
        
        TableColumn<Postgraduate, String> emailCol = new TableColumn<>("电子邮件");
        emailCol.setMinWidth(250);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));//数据关联到表格
        
        TableColumn<Postgraduate, String> gradeCol = new TableColumn<>("年级");
        gradeCol.setMinWidth(100);
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));//数据关联到表格
        
        TableColumn<Postgraduate, String> study = new TableColumn<>("研究方向");
        study.setMinWidth(100);
        study.setCellValueFactory(new PropertyValueFactory<>("study"));//数据关联到表格
        
        TableColumn<Postgraduate, String> tutor = new TableColumn<>("导师");
        tutor.setMinWidth(100);
        tutor.setCellValueFactory(new PropertyValueFactory<>("tutor"));//数据关联到表格
        
        table.setItems(data);//向表中添加数据
        table.getColumns().addAll(nameCol, adressCol, phoneNumberCol, emailCol, gradeCol, study, tutor);     
        
        Button backButton = new Button("返回");
        backButton.setMinSize(50, 20);
        backButton.setOnAction(event -> {
        	PostgraduateTable postgraduateTable = new PostgraduateTable();
        	
        	stage.hide();//关闭
        	Stage newStage = new Stage();
    		newStage.setMinWidth(1000);
    		newStage.setMinHeight(500);
    		
        	try {
        		postgraduateTable.start(newStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(backButton);
        hBox.setAlignment(Pos.TOP_RIGHT);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 20));
        vbox.getChildren().addAll(hBox, table);   
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
}
