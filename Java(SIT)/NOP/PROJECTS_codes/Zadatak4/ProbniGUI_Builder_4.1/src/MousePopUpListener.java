import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MousePopUpListener extends MouseAdapter {

	PopUpMenu pop;

	DataPanel dp;
	
	
	
	public MousePopUpListener(PopUpMenu pop) {
		this.pop = pop;
	}

	public void mousePressed(MouseEvent mev) {

		if (mev.isPopupTrigger()) {
			doCommand(mev);
		}
			
	}

	public void mouseReleased(MouseEvent mev) {
		if (mev.isPopupTrigger()) {
			doCommand(mev);
		}
			
	}

	public void doCommand(MouseEvent mev) {

		if (mev.isPopupTrigger()) {
			pop.show(mev.getComponent(),mev.getX(), mev.getY());
			
		}

	}
}
