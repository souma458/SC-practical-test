package pt.rigorcg.teste.util;

public class ServiceResponse<T> {

    private T data;
    private ServiceError error;

    public ServiceResponse(T data) {
        this.data = data;
    }

    public ServiceResponse(ServiceError error) {
        this.error = error;
    }
    
    public T data() {
        return data;
    }

    public ServiceError error() {
        return error;
    }

    public boolean hasError() {
        return this.error != null;
    }

}
