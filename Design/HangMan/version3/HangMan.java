package version3;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * 当用户猜错 7 次，绞刑架上的人摆动。 
 * 当一个单词完成后，用户使用回车键继续猜下一个单词
 * HangMan游戏版本3
 * @author 周明华
 *
 */
public class HangMan extends Application{
	//开始界面gif效果
	public static int count = 0;
	
	//动画标志
	private boolean flag = true;
	private int num = 0;
	
	//随机单词
	private String guessWord = randomWord();
	private char[] word = hideWord(guessWord);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane mainPane = new Pane();//主要面板
		Pane personPane = new Pane();//存放人物的面板
		
		final double X = 200;
		Polyline line = new Polyline();
		ObservableList<Double> list = line.getPoints();

		list.add(X);
		list.add(3 * X);

		list.add(X);
		list.add(X / 3);

		list.add(2.5 * X);
		list.add(X / 3);
		
		Arc arc = new Arc(X, (X * 3 + X / 3), ((X / 3) * 2), (X / 3), 0, 180);
		arc.setFill(Color.WHITE);
		arc.setStroke(Color.BLACK);
		
		mainPane.getChildren().addAll(arc, line);
		
		personPane.setMaxSize(0, 0);
		personPane.setLayoutX(2.5 * X);
		personPane.setLayoutY(X / 3);
	
		Circle head = new Circle(0, X / 2, (X / 4));
		head.setFill(Color.WHITE);
		head.setStroke(Color.BLACK);
		
		Line headLine = new Line(head.getCenterX(), 0, head.getCenterX(), head.getCenterY() - head.getRadius());
		
		Line leftHand = new Line((head.getCenterX() - head.getRadius() * Math.sin(45)), (head.getCenterY() + head.getRadius() * Math.cos(45)),
				(head.getCenterX() - head.getRadius() * 3), (head.getCenterY() + head.getRadius() * 2));
		
		Line rightHand = new Line((head.getCenterX() + head.getRadius() * Math.sin(45)), (head.getCenterY() + head.getRadius() * Math.cos(45)),
				(head.getCenterX() + head.getRadius() * 3), (head.getCenterY() + head.getRadius() * 2));
		
		Line body = new Line(head.getCenterX(), (head.getCenterY() + head.getRadius()),	head.getCenterX(), (head.getCenterY() + head.getRadius() * 3));
		
		Line leftLeg = new Line(head.getCenterX(), (head.getCenterY() + head.getRadius() * 3),
				(head.getCenterX() - head.getRadius() * 2), (head.getCenterY() + head.getRadius() * 5));
		
		Line rightLeg = new Line(head.getCenterX(), (head.getCenterY() + head.getRadius() * 3),
				(head.getCenterX() + head.getRadius() * 2), (head.getCenterY() + head.getRadius() * 5));
		
		//将人的所有部件设为不可见
		headLine.setVisible(false);
		head.setVisible(false);
		leftHand.setVisible(false);
		rightHand.setVisible(false);
		body.setVisible(false);
		leftLeg.setVisible(false);
		rightLeg.setVisible(false);
		
		personPane.getChildren().addAll(headLine, head, leftHand, body, rightHand, leftLeg, rightLeg);
		
		//文字部件
		Text guessText = new Text(X * 2, X * 3, "Guess a word: " + String.valueOf(word));
		guessText.setFont(new Font("kaishu", 20));
		
		Text missedText = new Text(X * 2, X * 3 + 40, "Missed letters: ");
		missedText.setFont(new Font("kaishu", 20));
		
		Text missedLetters = new Text(X * 2.7, X * 3 + 40, "");
		missedLetters.setFont(new Font("kaishu", 20));
		
		mainPane.getChildren().addAll(guessText, missedText, missedLetters, personPane);
		
		//动画事件
		EventHandler<ActionEvent> eventHandler = e -> {
			int rotate = 50;
			if(flag) {
				personPane.setRotate(num++);
				if(num > rotate)
					flag = false;
			}
			else {
				personPane.setRotate(num--);
				if(num < -rotate)
					flag = true;
			}
		};
		
		Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(30), eventHandler));
		
		Scene scene = new Scene(mainPane, 900, 700);
		
		try {
			//为场景设置一个键盘事件
			scene.setOnKeyPressed(event -> {
				if (event.getCode() == KeyCode.ENTER) {
					guessWord = randomWord();
					word = hideWord(guessWord);
					guessText.setText("Guess a word: " + String.valueOf(word));
					missedText.setText("Missed letters: ");
					missedLetters.setText("");
					
					//将所有已经可见的人物部件重新隐藏
					for (int i = 0; i < personPane.getChildren().size(); i++) {
						if (personPane.getChildren().get(i).isVisible()) {
							personPane.getChildren().get(i).setVisible(false);
						}
					}
					
					//停止动画
					animation.stop();
					personPane.setRotate(0);
					this.num = 0;
				} else {
					//检测键盘输入是否已经显示出来
					boolean already = false;
					for (int i = 0; i < word.length; i++) {
						if (event.getText().charAt(0) == word[i]) {
							already = true;
							break;
						}
					}
					
					//检测键盘输入是否是要猜的单词的字母				
					boolean isFind = false;
					for (int i = 0; i < guessWord.length(); i++) {
						if (event.getText().charAt(0) == guessWord.charAt(i)) {
							word[i]= event.getText().charAt(0);//替换猜中的单词
							isFind = true;
						}
					}
					
					if (isFind == false || already == true) {
						missedLetters.setText(missedLetters.getText() + event.getText());
					}
					
					
					if (missedLetters.getText().length() < 7) {
						//单词全部猜出
						if ((String.valueOf(word)).equals(guessWord)) {
							guessText.setText("the word is: " + String.valueOf(word));
							missedText.setText("To continue the game, press ENTER");
							missedLetters.setVisible(false);
						} else {
							guessText.setText("Guess a word: " + String.valueOf(word));
							missedText.setText("Missed letters: ");
							missedLetters.setVisible(true);
						}
					}
					
					//根据猜错的次数显示人物部件或者动画
					switch (missedLetters.getText().length()) {
					case 1:
						headLine.setVisible(true);
						break;
					case 2:
						head.setVisible(true);
						break;
					case 3:
						leftHand.setVisible(true);
						break;
					case 4:
						rightHand.setVisible(true);
						break;
					case 5:
						body.setVisible(true);
						break;
					case 6:
						leftLeg.setVisible(true);
						break;
					case 7:
						rightLeg.setVisible(true);
						guessText.setText("the word is: " + guessWord);
						missedText.setText("To continue the game, press ENTER");
						missedLetters.setVisible(false);
						animation.setCycleCount(Timeline.INDEFINITE);
						animation.play();
						break;
					}
				}
			});
		} catch (Exception e) {
			
		}
		
		if (count==0) {
			Welcome welcome = new Welcome();
			Stage stage = new Stage();
			try {
				welcome.start(stage);
				count++;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("GassWord");
			
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
			myTimer.schedule(tt, 2500);//1秒后执行
		} else {
			primaryStage.show();		
			primaryStage.setResizable(false);
		}	

	}
	
	/**
	 * 产生随机单词
	 * @return 随机选择的单词
	 */
	private String randomWord() {
		Random random = new Random();
		String[] words = {"many", "experts", "call", "it", "the", "best",
				"personal", "computer", "apple", "system", "orange", "earth"};
		int key = random.nextInt(words.length);//返回一个0(包括)到words.length(不包括)的随机整数	
		return words[key];
	}
	
	/**
	 * 将需要猜测的单词进行转化，变成*
	 * @param word 要转化的单词
	 * @return 带星号的字符数组
	 */
	private char[] hideWord(String word) {
		char[] newWord = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			newWord[i] = '*';
		}
		return newWord;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
