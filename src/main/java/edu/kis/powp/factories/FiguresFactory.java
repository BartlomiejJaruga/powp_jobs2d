package edu.kis.powp.factories;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;

public class FiguresFactory {
    private int startingPointX;
    private int startingPointY;

    public FiguresFactory(int startingPointX, int startingPointY) {
        this.startingPointX = startingPointX;
        this.startingPointY = startingPointY;
    }

    public void setStartingPoints(int startingPointX, int startingPointY) {
        this.startingPointX = startingPointX;
        this.startingPointY = startingPointY;
    }

    public ComplexCommand rectangleScript(int width, int height) {
        ComplexCommand command = new ComplexCommand();

        command.addCommand(new SetPositionCommand(startingPointX, startingPointY));
        command.addCommand(new OperateToCommand(startingPointX + width, startingPointY));
        command.addCommand(new OperateToCommand(startingPointX + width, startingPointY + height));
        command.addCommand(new OperateToCommand(startingPointX, startingPointY + height));
        command.addCommand(new OperateToCommand(startingPointX, startingPointY));

        return command;
    }

    public ComplexCommand triangleScript(int width, int height) {
        ComplexCommand command = new ComplexCommand();

        command.addCommand(new SetPositionCommand(startingPointX, startingPointY));
        command.addCommand(new OperateToCommand(startingPointX + width, startingPointY));
        command.addCommand(new OperateToCommand(startingPointX + width/2, startingPointY - height));
        command.addCommand(new OperateToCommand(startingPointX, startingPointY));

        return command;
    }
}
