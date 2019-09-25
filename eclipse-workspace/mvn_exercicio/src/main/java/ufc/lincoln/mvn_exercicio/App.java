package ufc.lincoln.mvn_exercicio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * Hello world!
 *
 */
public class App 
{	
    public static void main( String[] args )
    {
    	HashMap<String, Set<String>> listaAdj;
    	
    	SpoonAPI spoonAPI = new Launcher();
    	spoonAPI.addInputResource("/home/385194/Documentos/bank-sys-master");
    	spoonAPI.buildModel();
    	
    	spoonAPI.addProcessor("ufc.lincoln.mvn_exercicio.LoCExtractor");
    	spoonAPI.process();
    	
    	CtModel model = spoonAPI.getModel();
    	
    	listaAdj = getAdjList(model);
        
    	/*
    	for(CtClass c: spoonAPI.getModel().getElements(new TypeFilter<CtClass>(CtClass.class)))
    	{
    		//System.out.println("Classes \n Pais: "+ c.getParent()+" & Filhos: "+ c.getQualifiedName());
    	}
    	*/
    	//System.out.println("<|===============================================|>");
    	//Collection<CtType<?>> types = spoonAPI.getModel().getAllTypes();
    	//Como obter as referencias de cada tipo do projeto que possui código fonte
//    	for(CtType<?> type : types)
//    	{
//    		if(!type.isShadow()) 
//    		{
//    			for (CtTypeReference<?> referredType : type.getReferencedTypes())
//    			{
//    				if(!referredType.isShadow())
//    				{
//    					System.out.println(referredType.getQualifiedName());
//    				}
//    			}
//    		}
//    	}
    }
    
    public static HashMap<String, Set<String>> getAdjList(CtModel model)
    {
		HashMap<String, Set<String>> listaAdj = null;
    	Set<String> clAdjacentes;
    	
    	Collection<CtType<?>> types = model.getAllTypes();
    	
    	for(CtClass c: model.getElements(new TypeFilter<CtClass>(CtClass.class)))
    	{
    		System.out.println(c.getQualifiedName());
    		for(CtType<?> type : types)
    	    {
    	    	if(!type.isShadow()) 
    	    	{
    	    		for (CtTypeReference<?> referredType : type.getReferencedTypes())
    	    		{
    	    			if(!referredType.isShadow())
    	    			{
    	    				System.out.println(referredType.getQualifiedName());
    	    			}
    	    		}
    	    	}
    	    }
    		
    	}
    	
    	return listaAdj;
    }
        
}
