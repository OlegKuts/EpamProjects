import entities.Text;

public class Main {

	public static void main(String[] args) {
		Text text = Text
				.getText("/home/oleg/Documents/Programming/Courses/Epam/2015/workspace/EpamProject2/lib/text");
		System.out.println();
		text.show();
		System.out
				.println("==============================Sorted in the ascending order======================================");
		Text sorted = Text.sort(text);
		sorted.show();

	}

}
