package search;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoSearch {
	InfoGet infoGet;
	VoiceGetting voiceGetting;

	public InfoSearch(InfoGet infoGet) {
		this.infoGet = infoGet;
	}

	void outPutAllStack() {
		System.out.println("\n=== List of people ===");
		for (int i = 0; i < infoGet.info.length; i++) {
			System.out.println(infoGet.info[i]);
		}
		System.out.println();
	}

	void operationNone(String findIt) {
		int flag = 0;
		String[] vars = findIt.split(" ");
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < infoGet.info.length; i++) {
			int count = 0;
			String tmp = infoGet.info[i].toLowerCase();
			for (int j = 0; j < vars.length; j++) {
				String thisVar = vars[j];
				Pattern p = Pattern.compile(thisVar.toLowerCase());
				Matcher m = p.matcher(tmp);
				if (m.find()) {
					count++;
				}
			}
			if (count == 0) {
				flag++;
				out.append(infoGet.info[i]);
				out.append("\n");
			}
		}
		if (flag > 0) {
			System.out.printf("\n%d persons found:\n%s", flag, out);
		} else if (flag == 0) {
			System.out.println("No matching people found.\n");
		}
		System.out.println();
	}

	void operationAny(String findIt) {
		int flag = 0;
		String[] vars = findIt.split(" ");
		StringBuilder out = new StringBuilder();
		for (int j = 0; j < vars.length; j++) {
			String thisVar = vars[j];
			for (int i = 0; i < infoGet.info.length; i++) {
				String tmp = infoGet.info[i].toLowerCase();
				Pattern p = Pattern.compile(thisVar.toLowerCase());
				Matcher m = p.matcher(tmp);
				if (m.find()) {
					out.append(infoGet.info[i]);
					out.append("\n");
					flag++;
				}
			}
		}
		if (flag > 0) {
			System.out.printf("\n%d persons found:\n%s", flag, out);
		} else if (flag == 0) {
			System.out.println("No matching people found.\n");
		}
		System.out.println();
	}

	void startGettingInfo(Scanner scanner, String operation) {
		switch (operation) {
			case "ALL":
				voiceGetting.findPerson();
				operationAll(scanner.nextLine());
				break;
			case "ANY":
				voiceGetting.findPerson();
				operationAny(scanner.nextLine());
				break;
			case "NONE":
				voiceGetting.findPerson();
				operationNone(scanner.nextLine());
				break;
			default:
				voiceGetting.incorrectOption();
		}
	}

	void operationAll(String findIt) {
		int flag = 0;
		StringBuilder out = new StringBuilder();
		String[] findArr = findIt.split("\\+");
		for (int i = 0; i < infoGet.info.length; i++) {
			String[] tmp = infoGet.info[i].toLowerCase().split("\\s+");
			int check = 0;
			for (int k = 0; k < findArr.length; k++) {
				Pattern p = Pattern.compile(findArr[k].toLowerCase());
				for (int j = 0; j < tmp.length; j++) {
					Matcher m = p.matcher(tmp[j]);
					if (m.matches()) {
						check++;
					}
				}
				if (check == findArr.length) {
					out.append(infoGet.info[i]);
					out.append("\n");
					flag++;
				}
			}
		}
		if (flag > 0) {
			System.out.printf("%d persons found:\n%s", flag, out);
		} else if (flag == 0) {
			System.out.println("No matching people found.\n");
		}
		System.out.println();
	}

	void doOperation(Scanner scanner) {
		boolean oper = false;
		voiceGetting = new VoiceGetting();
		while (oper == false) {
			voiceGetting.enterMenu();
			String getNum = scanner.nextLine();
			switch (getNum) {
				case "1":
					voiceGetting.getTypeOperation();
					String operation = scanner.nextLine();
					startGettingInfo(scanner, operation);
					break;
				case "2":
					outPutAllStack();
					break;
				case "0":
					voiceGetting.byeBye();
					oper = true;
					break;
				default:
					voiceGetting.incorrectOption();
					break;
			}
		}
	}
}
