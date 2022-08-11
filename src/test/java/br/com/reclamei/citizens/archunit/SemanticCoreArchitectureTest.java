package br.com.reclamei.citizens.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "br.com.reclamei.citizens", importOptions = {
    ImportOption.DoNotIncludeArchives.class,
    ImportOption.DoNotIncludeJars.class,
    ImportOption.DoNotIncludeTests.class
})
public class SemanticCoreArchitectureTest {

    @ArchTest
    static final ArchRule domainClassesMustResideInDomainPackage =
        classes().that().haveNameMatching(".*Domain").should().resideInAPackage("..domain..")
            .as("Domain's class should reside inside domain package on core package ")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule useCaseClassesMustResideInUseCasePackage =
        classes().that().haveNameMatching(".*UseCase").should().resideInAPackage("..usecase..")
            .as("UseCase's class should reside inside use case package on core package ")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule exceptionClassesMustResideInExceptionPackage =
        classes().that().haveNameMatching(".*Exception").should().resideInAPackage("..exception..")
            .as("Exception's class should reside inside exception package on core package ")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule gatewayClassesMustResideInGatewayPackage =
        classes().that().haveNameMatching(".*Gateway").should().resideInAPackage("..gateway..")
            .andShould().beInterfaces().as("Gateway's interfaces should reside inside gateway package on core package as interfaces ")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule typeClassesMustResideInTypePackage =
        classes().that().haveNameMatching(".*Type").should().resideInAPackage("..type..")
            .as("Type's class should reside inside type package on core package ")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule mapperClassesMustResideInMapperPackage =
        classes().that().haveNameMatching(".*Mapper").should().resideInAPackage("..mapper..")
            .as("Type's class should reside inside type package on core package ")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule consumerClassesMustResideInConsumerPackage =
        classes().that().haveNameMatching(".*Consumer").should().resideInAPackage("..consumer..")
            .as("Consumer's class should reside inside type package on worker package ")
            .allowEmptyShould(true);

}
