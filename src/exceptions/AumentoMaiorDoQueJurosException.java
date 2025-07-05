package exceptions;

public class AumentoMaiorDoQueJurosException extends RuntimeException{  // unchecked para evitar a necessidade de declarar throws e sobrescrever método pai
    public AumentoMaiorDoQueJurosException(String msg) {
        super(msg);
    }
}
