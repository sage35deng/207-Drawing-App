package use_case.update_tool;

import entity.tool.EraserTool;
import use_case.InputBoundary;
import use_case.InputData;

public class UpdateEraserTool implements UpdateTool<EraserTool>{
    public void update(EraserTool tool, InputData inputData, InputBoundary interactor) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();

        if (inputData.getMouseIsActive()) {
            // Draw the line from the last point to the current point
            interactor.getCanvasManager().paintLine(
                    inputData.getLastXCoord(), inputData.getLastYCoord(), x, y,
                    tool.getColor(), tool.getSize());
        }
        inputData.setLastXCoord(x);
        inputData.setLastYCoord(y);
    }
}
