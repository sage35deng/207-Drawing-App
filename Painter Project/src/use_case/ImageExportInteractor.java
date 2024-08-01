package use_case;

import data_access.DataAccessObject;
import entity.canvas.CanvasManager;
import view.View;

/**
 * The ImageExportInteractor class implements the ImageExportInputBoundary interface
 * and provides functionality to export images using a DataAccessObject.
 */
public class ImageExportInteractor implements ImageExportInputBoundary {
    private final DataAccessObject dataAccessObject;

    /**
     * Instantiates a new ImageExportInteractor with a DataAccessObject.
     */
    public ImageExportInteractor() {
        this.dataAccessObject = new DataAccessObject();
    }

    // Constructor to support testing
    public ImageExportInteractor(DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    /**
     * Exports the image from the provided view using the DataAccessObject.
     *
     * @param view the view containing the image to be exported
     */
    @Override
    public void exportImage(CanvasManager canvasManager) {
        dataAccessObject.saveFile("Specify a file to save", canvasManager.getCanvasImage());
    }
}