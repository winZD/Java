package view;
import javax.swing.undo.UndoManager;

public class CommandRedo implements Command {

	UndoManager redo;

	public CommandRedo(UndoManager redo) {
		this.redo = redo;
	}

	@Override
	public void execute() {

		redo.undo();

	}

}
