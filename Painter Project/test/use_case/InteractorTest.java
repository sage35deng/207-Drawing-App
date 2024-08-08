package use_case;

import data_access.api.GoogleGeminiMathAPI;
import data_access.api.SimpleTexLatexAPI;
import entity.canvas.Canvas;
import entity.canvas.CanvasManager;
import entity.tool.PaintTool;
import entity.tool.Tool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.mockito.Mockito.*;

public class InteractorTest {

    private Interactor interactor;
    private OutputBoundary mockOutputBoundary;
    private InputData mockInputData;
    private OutputData mockOutputData;
    private CanvasManager mockCanvasManager;
    private Tool mockTool;

    @BeforeEach
    void setUp() {
        mockOutputBoundary = mock(OutputBoundary.class);
        mockInputData = mock(InputData.class);
        mockOutputData = mock(OutputData.class);
        mockCanvasManager = mock(CanvasManager.class);
        mockTool = mock(PaintTool.class);

        when(mockInputData.getCanvasManager()).thenReturn(mockCanvasManager);
        when(mockInputData.getCurrentTool()).thenReturn(mockTool);

        // Ensure collapseLayers() returns a non-null Canvas object
        Canvas mockCanvas = mock(Canvas.class);
        when(mockCanvasManager.collapseLayers()).thenReturn(mockCanvas);
        when(mockCanvas.getCanvasImage()).thenReturn(mock(BufferedImage.class)); // Mock the image

        interactor = new Interactor(mockOutputBoundary, mockInputData, mockOutputData);
    }

    @Test
    void testSwitchTool() {
        Tool newTool = new PaintTool();
        interactor.switchTool(newTool);
        verify(mockInputData).setCurrentTool(newTool);
    }

    @Test
    void testUpdate() {
        interactor.update();
        verify(mockOutputData).update(mockCanvasManager, mockTool, mockInputData.getCurrentColor());
    }

//    @Test
//    void testLatexOCR() throws Exception {
//        SimpleTexLatexAPI mockLatexAPI = mock(SimpleTexLatexAPI.class);
//        GoogleGeminiMathAPI mockGeminiAPI = mock(GoogleGeminiMathAPI.class);
//        String mockLatexResponse = "Mock LaTeX Response";
//        String mockGeminiResponse = "Mock Gemini Response";
//
//        when(mockLatexAPI.OCR(any())).thenReturn(mockLatexResponse);
//        when(mockGeminiAPI.solveEquation(anyString())).thenReturn(mockGeminiResponse);
//
//        interactor.latexOCR();
//
//        verify(mockLatexAPI).OCR(any());
//        verify(mockGeminiAPI).solveEquation(mockLatexResponse);
//    }
}
