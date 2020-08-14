package search;

import java.util.LinkedList;
import java.util.Scanner;

public class InfoGet {
	String[] info;
	int		numInfo;
	int 	numQueries;


	public void setInfo(String[] info) {
		this.info = info;
	}

	void getInfo(Scanner scanner) {
		info = new String[numInfo];
		for (int i = 0; i < numInfo; i++) {
			info[i] = scanner.nextLine();
		}
	}

	void getQeries(Scanner scanner) {
		try {
			numQueries = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("some error");
			System.exit(1);
		}
	}
	void getNumInfo(Scanner scanner) {
		try {
			numInfo = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("some error");
			System.exit(1);
		}
	}

	void start(Scanner scanner) {
		LinkedList<String> linkedList = new LinkedList<>();
		while (scanner.hasNext()) {
			linkedList.add(scanner.nextLine());
		}
		info = new String[linkedList.size()];
		for (int i = 0; i < linkedList.size(); i++) {
			info[i] = linkedList.get(i);
		}
	}
}
