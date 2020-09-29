package chapter08.exercise;

public class Exercise8_3 {
	public static void main(String[] args) {
		char answer[][] = {
				{'A','B','A','C','C','D','E','E','A','D'},	
				{'D','B','A','B','C','A','E','E','A','D'},
				{'E','D','D','A','C','B','E','E','A','D'},	
				{'C','B','A','E','D','C','E','E','A','D'},	
				{'A','B','D','C','C','D','E','E','A','D'},	
				{'B','B','E','C','C','D','E','E','A','D'},	
				{'B','B','A','C','C','D','E','E','A','D'},		
				{'E','B','E','C','C','D','E','E','A','D'}
				};
		char keys[] = {'D','B','D','C','C','D','A','E','A','D'};
		int[] student = new int[answer.length];
		
		for(int i = 0; i < answer.length; ++i){
			int correctCount = 0;		
			for(int j = 0; j < answer[i].length; ++j){	
				if(answer[i][j] == keys[j])		
					++correctCount;		
				}	
			student[i] = correctCount;
		}
		java.util.Arrays.sort(student);
		for(int i = 0; i < student.length; ++i)
			System.out.println(student[i]);
	}
}
