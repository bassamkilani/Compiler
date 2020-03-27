import java.util.ArrayList;
import java.util.List;

public class Generate extends AbstractGenerate {

    List<Variable> variables = new ArrayList<>();

    public Generate(){

    }

    public Generate(String st){

    }

    public String identifier = null;

    public void reportError( Token token, String explanatoryMessage ) throws CompilationException {
        CompilationException ex = new CompilationException(explanatoryMessage, token.lineNumber);
        System.out.println(ex.toString() + "ON LINE: " + ex.getLineNumber());
        throw ex;
    }

    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }

    public Variable makeVariable(String t){
        Variable.Type type = Variable.Type.valueOf(t);
        Variable variable = new Variable(identifier, type);
        identifier = null;
        return variable;
    }

    public Variable getVariable( String identifier ) {
        for (Variable v : variables) {
            if(v.identifier.equals(identifier)){
                return v;
            }
        }
        return null;
    }

    public void addVariable( Variable v ) {
        if(getVariable(v.identifier) == null) {
            variables.add(v);
//            System.out.println("Created a variable '" + v.identifier + "' of type " + v.type);
            System.out.println( "rggDECL " + v );
        }
        else {
//            System.out.println("'" + v.identifier + "' already exists and is of type " + v.type);
        }
        return;
    }

    public void removeVariable( Variable v ) {
        for (Variable var : variables) {
            if(v.identifier == var.identifier && v.type == var.type){
                variables.remove(v);
                System.out.println( "rggDROP " + v );
                return;
            }
        }
        System.out.println("       / / / / / / / / / / / / / / / / / / / / / VARIABLE DOESN'T EXIST!");
    }
}
