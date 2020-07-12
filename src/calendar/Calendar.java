package calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {

//		System.out.println("Hello, Calendar");
//		String s;
//		
//		System.out.println(" 일  월  화  수  목  금  토");
//		System.out.println("--------------------------");
//
//		for (int day = 1; day <= 31; day++) {
//			s = Integer.toString(day);
//			if (s.length() == 1) {
//				System.out.print(" ");
//			}
//			System.out.print(day);
//			System.out.print("  ");
//			if (day % 7 == 0) {
//				System.out.println();
//			}
//		}
		
		//해당하는 달의 일 수 출력 프로그램
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("달을 입력하세요.");
		
		// 방법 1 swtitch, case
//		int month = scanner.nextInt();
//		int days = 0;
//		switch(month) {
//			case 1, 3, 5, 7, 8, 12 : days = 31;
//				break;
//			case 2 : days = 28;
//				break;
//			case 4, 6, 9, 10, 11 : days = 30;
//				break;
//		}
//		System.out.printf("%d월은 %d일까지 있습니다.", month, days);
		
		// 방법 2 array
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int i = scanner.nextInt();
		System.out.printf("%d월은 %d일까지 있습니다.", i, maxDays[i - 1]);
	}

}
