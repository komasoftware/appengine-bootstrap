package com.company.core;

/**
 * This is an example class
 */
public class Example {
    // The example name
    private String name;

    /**
     * Constructs an Example
     */
    public Example() {
        this.name = "";
    }

    /**
     * Constructs an Example
     *
     * @param name
     */
    public Example(String name) {
        this.name = name;
    }

    /**
     * Gets the name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
