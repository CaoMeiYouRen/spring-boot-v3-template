package ltd.cmyr.demo.entity;

import java.util.Objects;

/**
 * 返回数据格式
 *
 * @author CaoMeiYouRen
 */
public class ResponseData<T extends Object> {

    private int statusCode;
    private String message;
    private T data;

    public ResponseData(int statusCode) {
        this.statusCode = statusCode;
    }

    public ResponseData(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseData(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResponseData() {

    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseData<?> that = (ResponseData<?>) o;
        return statusCode == that.statusCode && Objects.equals(message, that.message) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, message, data);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ResponseData<T> setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseData<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseData<T> setData(T data) {
        this.data = data;
        return this;
    }
}
