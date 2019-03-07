package view;

public class CommandClearView implements Command {

	TextPanel dp;

	public CommandClearView(TextPanel dp) {
		this.dp = dp;
	}

	@Override
	public void execute() {

		dp.textArea.setText("");

	}

}
