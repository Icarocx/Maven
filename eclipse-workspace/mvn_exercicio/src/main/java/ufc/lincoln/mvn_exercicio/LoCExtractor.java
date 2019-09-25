package ufc.lincoln.mvn_exercicio;

import java.util.HashMap;
import java.util.Set;

import spoon.processing.AbstractProcessor;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.TypeFilter;

public class LoCExtractor extends AbstractProcessor<CtClass<?>> 
{
	public void process(CtClass<?> element)
	{
		String qualifiedName = element.getQualifiedName();
		int startLine = element.getPosition().getLine();
		int endLine = element.getPosition().getEndLine();
		int totalLoC = endLine -startLine;
		
		System.out.println("Classe: "+ qualifiedName + "Número de linhas: "+totalLoC);
	}
}