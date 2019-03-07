
public class CommandClearView implements Command {

	DataPanel dp;

	public CommandClearView(DataPanel dp) {
		this.dp = dp;
	}

	@Override
	public void execute() {

		dp.textArea.setText("");

	}

}
