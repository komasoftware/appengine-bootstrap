package com.company.endpoints.wrapper;

import com.company.core.Example;

import java.util.List;

/**
 * Wrapper around a list of {@link Example}
 */
public class Examples {
    private List<Example> examples;

    /**
     * Constructs the object
     */
    public Examples() {
    }

    /**
     * Gets the list of example
     *
     * @return the list of example
     */
    public List<Example> getExamples() {
        return examples;
    }

    /**
     * Sets the list of example
     *
     * @param examples
     */
    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }
}
