package br.com.reclamei.citizens.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "br.com.reclamei.citizens", importOptions = {
    ImportOption.DoNotIncludeArchives.class,
    ImportOption.DoNotIncludeJars.class,
    ImportOption.DoNotIncludeTests.class
})
public class LayerArchitectureTest {

    static String API_LAYER_PACKAGES = "br.com.reclamei.citizens.entrypoint.api..";
    static String CORE_LAYER_PACKAGES = "br.com.reclamei.citizens.core..";
    static String DATA_PROVIDER_LAYER_PACKAGES = "br.com.reclamei.citizens.dataprovider..";
    static String CONFIG_LAYER_PACKAGES = "br.com.reclamei.citizens.config..";

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
        .consideringAllDependencies()
        .layer(API_LAYER_PACKAGES).definedBy(API_LAYER_PACKAGES)
        .layer(CORE_LAYER_PACKAGES).definedBy(CORE_LAYER_PACKAGES)
        .layer(DATA_PROVIDER_LAYER_PACKAGES).definedBy(DATA_PROVIDER_LAYER_PACKAGES)
        .layer(CONFIG_LAYER_PACKAGES).definedBy(CONFIG_LAYER_PACKAGES)

        .whereLayer(API_LAYER_PACKAGES).mayNotBeAccessedByAnyLayer()
        .whereLayer(DATA_PROVIDER_LAYER_PACKAGES).mayNotBeAccessedByAnyLayer()
        .whereLayer(CONFIG_LAYER_PACKAGES).mayNotBeAccessedByAnyLayer()
        .whereLayer(CORE_LAYER_PACKAGES).mayOnlyBeAccessedByLayers(API_LAYER_PACKAGES, DATA_PROVIDER_LAYER_PACKAGES, CONFIG_LAYER_PACKAGES);

}
