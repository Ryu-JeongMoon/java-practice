package org.example;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;

@AutoService(Processor.class)
public class TransferAnnotationProcessor extends AbstractProcessor {

	private Types typeUtils;
	private Elements elementUtils;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnvironment) {
		super.init(processingEnvironment);

		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "우헤헤");

		typeUtils = processingEnv.getTypeUtils();
		elementUtils = processingEnv.getElementUtils();
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Set.of(TransferReceiver.class.getName());
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> transferReceivers = roundEnv.getElementsAnnotatedWith(TransferReceiver.class);

		Messager messager = processingEnv.getMessager();
		messager.printMessage(Diagnostic.Kind.NOTE, "Processing %s".formatted(this.getClass()));

		// todo, Class<?> clazz = Class.forName(className);
		int countOfReceivedColumns = 0, countOfSentColumns = 0;
		for (Element transferReceiver : transferReceivers) {
			TypeElement enclosingTypeElement = findEnclosingTypeElement(transferReceiver);
			messager.printMessage(Diagnostic.Kind.NOTE, "Enclosing type element: %s".formatted(enclosingTypeElement));



			List<? extends AnnotationMirror> annotationMirrors = transferReceiver.getAnnotationMirrors();
			annotationMirrors.forEach(
				annotationMirror -> messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "AnnotationMirror: %s".formatted(annotationMirror)));

			annotationMirrors.stream()
				.filter(annotationMirror -> annotationMirror.getAnnotationType().getAnnotation(TransferReceiver.class) != null)
				.map(AnnotationMirror::getElementValues)
				.flatMap(map -> map.values().stream())
				.map(AnnotationValue::getValue)
				.toList();

			List<? extends Element> enclosedElements = transferReceiver.getEnclosedElements();
			enclosedElements
				.forEach(element -> messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "Processing: %s".formatted(element)));

			long countOfTransferReceiverFields = enclosedElements.stream()
				.filter(element -> element.getKind().isField())
				.count();
			messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "Count of TransferReceiver fields: %s".formatted(countOfTransferReceiverFields));

			enclosedElements.stream()
				.filter(element -> !element.getKind().isField())
				.peek(element -> messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "AFTER FILTER: %s".formatted(element)))
				.map(Element::getEnclosedElements)
				.peek(elements -> messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "AFTER MAP: %s".formatted(elements)))
				.flatMap(List::stream)
				.forEach(element -> messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "FOREACH: %s".formatted(element)));

			int countOfTransferSenderFields = 0;
			messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "Count of TransferSender fields: %s".formatted(countOfTransferSenderFields));

			if (countOfTransferReceiverFields != countOfTransferSenderFields) {
				messager.printMessage(Diagnostic.Kind.ERROR, "Count of TransferReceiver fields and TransferSender fields are not equal.");
			}
		}

		return false;
	}

	public static TypeElement findEnclosingTypeElement(Element e) {
		while (e != null && !(e instanceof TypeElement)) {
			e = e.getEnclosingElement();
		}

		return (TypeElement)e;
	}
}
