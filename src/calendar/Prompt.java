package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+--------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+--------------------+");

	}

	public int parseDay(String week) {
		if (week.equals("SU")) {
			return 0;
		} else if (week.equals("MO")) {
			return 1;
		} else if (week.equals("TU")) {
			return 2;
		} else if (week.equals("WE")) {
			return 3;
		} else if (week.equals("TH")) {
			return 4;
		} else if (week.equals("FR")) {
			return 5;
		} else if (week.equals("SA")) {
			return 6;
		} else {
			return 0;
		}
	}

	public void runPROMPT() throws ParseException {

		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = new Calendar();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			if (cmd.equals("1")) {
				cmdRegister(scanner, calendar);
			} else if (cmd.equals("2")) {
				cmdSearch(scanner, calendar);
			} else if (cmd.equals("3")) {
				cmdCal(scanner, calendar);
			} else if (cmd.equals("h")) {
				printMenu();
			} else if (cmd.equals("q")) {
				break;
			}

		}
		System.out.println("Bye !");
		scanner.close();
	}

	private void cmdCal(Scanner s, Calendar c) {
		int month = 1;
		int year = 0;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = s.nextInt();
		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = s.nextInt();
		if (month > 12 || month < 0) {
			System.out.println("ERROR !");
			return;
		}
//		System.out.println("첫째 날의 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
//		System.out.print("WEEKDAY> ");
//		String str_weekday = scanner.next();
//		weekday = parseDay(str_weekday);

		c.printCalendar(year, month);
	}

	private void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요. (YYYY-MM-DD)");
		String date = s.next();
		String plan = "";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요. (YYYY-MM-DD)");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해주세요.");
		while (true) {
			String word = s.next();
			text += word + " ";
			if (word.endsWith(";")) {
				break;
			}
		}
		c.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {

		Prompt p = new Prompt();
		p.runPROMPT();
	}
}
