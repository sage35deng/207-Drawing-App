package data_access.api;

import java.io.IOException;

/**
 * The MathAPI interface defines the contract for interacting with a text generation API.
 */
public interface MathAPI {
    /**
     * Sends a LaTeX formatted equation to the API and retrieves a list of instructions for solving it.
     *
     * @param latex the LaTeX formatted equation to be solved
     * @return a list of instructions for solving the given LaTeX equation
     * @throws IOException if an error occurs during the API request
     */
    String solveEquation(String latex) throws IOException;
}
