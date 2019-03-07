package view;
import javax.swing.undo.UndoManager;

public class CommandUndo implements Command {

	UndoManager undo;

	public CommandUndo(UndoManager undo) {
		this.undo = undo;
	}

	@Override
	public void execute() {

		undo.undo();
		undo.setLimit(3);

	}

}
