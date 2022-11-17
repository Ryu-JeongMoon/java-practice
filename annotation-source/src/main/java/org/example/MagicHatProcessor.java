package org.example;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;

@AutoService(Processor.class)
public class MagicHatProcessor extends AbstractProcessor {

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);

		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "우헤헤");
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "우헤헤");
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "우헤헤");
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Magic.class);
		for (Element element : elements) {
			Name simpleName = element.getSimpleName();
			if (element.getKind() != ElementKind.INTERFACE) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Magic annotation can only be applied to interfaces " + simpleName);
			} else {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Magic annotation applied to interface " + simpleName);
			}
		}
		return false;
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Set.of(Magic.class.getName());
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public Set<String> getSupportedOptions() {
		return super.getSupportedOptions();
	}
}
