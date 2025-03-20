package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDriverToAbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Objects.equals(e.getActionCommand(), "Figure Joe 1")){
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		} else if(Objects.equals(e.getActionCommand(), "Figure Joe 2")) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		} else if(Objects.equals(e.getActionCommand(), "Figure Jane 1")) {
			FiguresJane.figureScript(new Job2dDriverToAbstractDriverAdapter(driverManager.getCurrentDriver()));
		} else if(Objects.equals(e.getActionCommand(), "Custom Command 1")) {
			DriverCommand setPositionCommand = new SetPositionCommand(0, 0);
			DriverCommand operateToCommand = new OperateToCommand(120, 0);
			DriverCommand operateToCommand2 = new OperateToCommand(120, 120);
			DriverCommand operateToCommand3 = new OperateToCommand(0, 120);
			DriverCommand operateToCommand4 = new OperateToCommand(0, 0);

			setPositionCommand.execute(driverManager.getCurrentDriver());
			operateToCommand.execute(driverManager.getCurrentDriver());
			operateToCommand2.execute(driverManager.getCurrentDriver());
			operateToCommand3.execute(driverManager.getCurrentDriver());
			operateToCommand4.execute(driverManager.getCurrentDriver());
		}
	}
}
