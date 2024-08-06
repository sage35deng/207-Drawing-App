package use_case.update_tool;

import entity.tools.EraserTool;
import use_case.InputBoundary;
import use_case.InputData;

public class UpdateEraserTool implements UpdateTool<EraserTool>{

    /**
     * Updates the eraser tool with the current input data.
     *
     * @param tool the eraser tool to update
     * @param inputData the current input data
     * @param interactor the input boundary
     */
    public void update(EraserTool tool, InputData inputData, InputBoundary interactor) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();

        if (inputData.getMouseIsActive()) {
            // Draw the line from the last point to the current point
            interactor.getPresenter().getViewModel().getCanvasManager().paintLine(
                    inputData.getLastXCoord(), inputData.getLastYCoord(), x, y,
                    tool.getColor(), tool.getSize());
        }
        inputData.setLastXCoord(x);
        inputData.setLastYCoord(y);
    }
}
