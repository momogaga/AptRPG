package apt;
import com.sun.mirror.apt.Messager;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.util.SimpleDeclarationVisitor;


public class MyVisitor extends SimpleDeclarationVisitor{
	
	Messager messager;
	
	public MyVisitor(Messager m) {
		// TODO Auto-generated constructor stub
		messager = m;
		
	}

	public void visitMethodDeclaration(MethodDeclaration m){
		
		if(m.getParameters().size() != 0){
			messager.printError("la method ne peut pas accepter de parametres");
		}
	}
}