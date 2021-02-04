package my_package.acceptance.config;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;

public class DataTableConfigurator implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(AClass.class,
                        (TableEntryTransformer<AClass>) entry ->
                                new AClass(
                                        Integer.valueOf(entry.get("first")),
                                        entry.get("second")
                                )
                )
        );
    }

    public static class AClass {
        private final Integer first;
        private final String second;

        public AClass(Integer first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
