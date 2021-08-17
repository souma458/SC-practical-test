package pt.rigorcg.teste.util;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ServiceError {
    
    private ErrorDetails details;
    private HttpStatus status;

    public ServiceError(String message, HttpStatus status) {
        this.details = new ErrorDetails(new Date(), message);
        this.status = status;
    }

    public ErrorDetails getDetails() {
        return this.details;
    }

    public void setDetails(ErrorDetails details) {
        this.details = details;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }


}
