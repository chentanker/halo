package run.halo.app.core.extension;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import run.halo.app.extension.AbstractExtension;
import run.halo.app.extension.GVK;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@GVK(group = "my-plugin.halo.run",
    version = "v1alpha1",
    kind = "Person",
    plural = "persons",
    singular = "person")
public class Person extends AbstractExtension {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Spec spec;

    @Schema(name="PersonSpec")
    public static class Spec {
        @Schema(description = "The description on name field", maxLength = 100)
        private String name;

        @Schema(description = "The description on age field", maximum = "150", minimum = "0")
        private Integer age;

        @Schema(description = "The description on gender field")
        private Gender gender;

        private Person otherPerson;
    }

    public enum Gender {
        MALE, FEMALE,
    }
}