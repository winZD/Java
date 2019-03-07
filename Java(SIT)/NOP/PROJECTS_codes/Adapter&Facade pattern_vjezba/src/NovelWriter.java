
public class NovelWriter implements Writer {

	@Override
	public void writeNovel(int type) {
		switch (type) {
		case 1:
			System.out.println("Historic");
			break;
		case 2:
			System.out.println("Romantic");
			break;
		case 3:
			System.out.println("Triller");
			break;
		default:
			System.out.println("Unknown type");
		}

	}

}
