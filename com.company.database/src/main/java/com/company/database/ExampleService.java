package com.company.database;

import com.company.core.Example;

import java.util.List;

/**
 * Example service to interact with the database
 */
public interface ExampleService {

    /**
     * Saves an example
     *
     * @param example
     */
    public void saveExample(Example example);

    /**
     * Gets all examples
     *
     * @return a list of example
     */
    public List<Example> getAllExamples();
}
