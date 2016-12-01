package com.pffair.compiler;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import com.example.AutoAddTestClass;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PRIVATE;

@SupportedAnnotationTypes("com.example.AutoAddTestClass")
public class AutoAddTestClassProcessor extends AbstractProcessor {


    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment env) {
        Collection<? extends Element> annotatedElements =
                env.getElementsAnnotatedWith(AutoAddTestClass.class);
        List<TypeElement> types =
                new ImmutableList.Builder<TypeElement>()
                        .addAll(ElementFilter.typesIn(annotatedElements))
                        .build();

        for (TypeElement type : types) {
            processType(type);
        }
        return true;
    }

    private void processType(TypeElement type) {
        AutoAddTestClass autoAddSetter = type.getAnnotation(AutoAddTestClass.class);
        if (autoAddSetter == null) {
            //Error
        }
        if (type.getKind() != ElementKind.CLASS) {
           //Error
        }

        // get the fully-qualified class name
        String fqClassName = generatedSubclassName(type, 0);
        // class name
        String className = TypeUtil.simpleNameOf(fqClassName);
        String source = generateClass(type, className, type.getSimpleName().toString());
        writeSourceFile(fqClassName,source,type);
    }

    private String generatedSubclassName(TypeElement type, int depth) {
        return generatedClassName(type, Strings.repeat("$", depth)+"TEST_");
    }


    private String generatedClassName(TypeElement type, String prefix) {
        String name = type.getSimpleName().toString();
        while (type.getEnclosingElement() instanceof TypeElement) {
            type = (TypeElement) type.getEnclosingElement();
            name = type.getSimpleName() + "_" + name;
        }
        String pkg = TypeUtil.packageNameOf(type);
        String dot = pkg.isEmpty() ? "" : ".";
        return pkg + dot + prefix + name;
    }


    private String generateClass(TypeElement type, String className, String classToExtend) {

        String pkg = TypeUtil.packageNameOf(type);
        TypeSpec.Builder subClass = TypeSpec.classBuilder(className)
                .addField(TypeName.INT, "version", PRIVATE)
                .addModifiers(FINAL)
                .superclass(ClassName.get(pkg, classToExtend));


        JavaFile javaFile = JavaFile.builder(pkg, subClass.build()).build();
        return javaFile.toString();
    }

    private void writeSourceFile(String className, String text, TypeElement originatingType) {
        try {
            JavaFileObject sourceFile =
                    processingEnv.getFiler().createSourceFile(className, originatingType);
            Writer writer = sourceFile.openWriter();
            try {
                writer.write(text);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
                    "Could not write generated class " + className + ": " + e);
        }
    }


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}
