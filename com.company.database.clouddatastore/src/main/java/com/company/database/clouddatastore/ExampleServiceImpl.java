package com.company.database.clouddatastore;

import com.company.core.Example;
import com.company.database.ExampleService;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link ExampleService} specific for
 * Google Cloud DataStore
 */
public class ExampleServiceImpl implements ExampleService {

    private final static String EXAMPLE_ENTITY = "Example";
    private final static String EXAMPLE_NAME = "Name";

    /**
     * Transforms an entity to an {@link Example}
     *
     * @param exampleEntity
     * @return the example
     */
    private static Example entityToExample(Entity exampleEntity) {
        Example example = new Example();
        example.setName((String) exampleEntity.getProperty(EXAMPLE_NAME));
        return example;
    }

    @Override
    public void saveExample(Example example) {
        Entity exampleEntity = new Entity(EXAMPLE_ENTITY);
        exampleEntity.setProperty(EXAMPLE_NAME, example.getName());

        DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
        dataStore.put(exampleEntity);
    }

    @Override
    public List<Example> getAllExamples() {
        List<Example> examples = new ArrayList<Example>();
        DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query(EXAMPLE_ENTITY);
        for (Entity exampleEntity : dataStore.prepare(query).asIterable())
            examples.add(entityToExample(exampleEntity));
        return examples;
    }
}
