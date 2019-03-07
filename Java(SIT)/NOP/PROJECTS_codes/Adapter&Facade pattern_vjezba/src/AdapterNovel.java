
public class AdapterNovel implements Writer{

	SFNovelWriter writer;
	
	public AdapterNovel(SFNovelWriter wr) {
		this.writer=wr;
	}
	
	@Override
	public void writeNovel(int type) {
		writer.writeSFNovel();
		
	}

}
