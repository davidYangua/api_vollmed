package med.voll.api.domain;

public class ValidacionException extends RuntimeException {

    public ValidacionException(String mensje) {
        super(mensje);
    }
}