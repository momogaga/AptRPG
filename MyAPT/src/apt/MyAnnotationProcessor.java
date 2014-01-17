package apt;
import java.util.Collection;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.Declaration;


public class MyAnnotationProcessor implements AnnotationProcessor{

	private AnnotationProcessorEnvironment	_env;
	
	MyAnnotationProcessor(AnnotationProcessorEnvironment env) {
			super()	;
			_env = env;
			}
	
	public void process(){

		AnnotationTypeDeclaration annotDecl = (AnnotationTypeDeclaration) _env.getTypeDeclaration("annotations.Menu");
		
		if(annotDecl == null) return;
		
		Collection<Declaration> decls = _env.getDeclarationsAnnotatedWith(annotDecl);
		
		if( decls == null) return;
		
		for(Declaration declaration : decls){
			declaration.accept(new MyVisitor(_env.getMessager()));
		}
		
	}
	
}
