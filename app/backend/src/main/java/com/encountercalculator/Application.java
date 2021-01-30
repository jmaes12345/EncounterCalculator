package com.encountercalculator;

import com.encountercalculator.utils.ApplicationVariables;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Encounter Calculator Backend",
                version = ApplicationVariables.applicationVersion,
                description = "Backend API",
                license = @License(name = "GNU General Public License v3.0", url = "https://www.gnu.org/licenses/gpl-3.0.en.html"),
                contact = @Contact(name = "jmaes12345", url = "https://github.com/jmaes12345/EncounterCalculator")
        )
)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
