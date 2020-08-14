package search;

public class VoiceGetting implements Voice{
	@Override
	public void entry() {
		System.out.println("Enter the number of people:");
	}

	@Override
	public void enterInfo() {
		System.out.println("Enter all people:");
	}

	@Override
	public void enterQueries() {
		System.out.println("\nEnter the number of search queries:");
	}

	@Override
	public void enterDataSearch() {
		System.out.println("\nEnter data to search people:");
	}

	@Override
	public void enterMenu() {
		System.out.println("=== Menu ===\n" +
				"1. Find a person\n" +
				"2. Print all persons\n" +
				"0. Exit");
	}

	@Override
	public void findPerson() {
		System.out.println("\nEnter a name or email to search all suitable people.");
	}

	@Override
	public void incorrectOption() {
		System.out.println("\nIncorrect option! Try again.\n");
	}

	@Override
	public void byeBye() {
		System.out.println("\nBye!");
	}

	@Override
	public void getTypeOperation() {
		System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
	}
}
