package pt.rigorcg.teste.util;

import java.util.Date;

public class ErrorDetails {

    private Date date;
    private String message;

	public ErrorDetails(Date date, String message) {
        this.date = date;
        this.message = message;
	}

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
