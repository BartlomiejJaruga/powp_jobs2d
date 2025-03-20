package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.factories.FiguresFactory;
import edu.kis.powp.jobs2d.Job2dTestsEnum;
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
		if(Objects.equals(e.getActionCommand(), Job2dTestsEnum.FIGURE_JOE_1.toString())){
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		} else if(Objects.equals(e.getActionCommand(), Job2dTestsEnum.FIGURE_JOE_2.toString())) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		} else if(Objects.equals(e.getActionCommand(), Job2dTestsEnum.FIGURE_JANE_1.toString())) {
			FiguresJane.figureScript(new Job2dDriverToAbstractDriverAdapter(driverManager.getCurrentDriver()));
		} else if(Objects.equals(e.getActionCommand(), Job2dTestsEnum.FIGURE_RECTANGLE_1.toString())) {
			FiguresFactory figuresFactory = new FiguresFactory(0, 0);
			figuresFactory.rectangleScript(100, 100).execute(driverManager.getCurrentDriver());
		} else if(Objects.equals(e.getActionCommand(), Job2dTestsEnum.FIGURE_TRIANGLE_1.toString())) {
			FiguresFactory figuresFactory = new FiguresFactory(0, 0);
			figuresFactory.triangleScript(100, 100).execute(driverManager.getCurrentDriver());
		}
	}
}
