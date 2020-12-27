package com.encountercalculator;

import com.encountercalculator.utils.ApplicationVariables;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Encounter Calculator Backend",
                version = ApplicationVariables.applicationVersion,
                description = "My API"
        )
)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
