package doit.blog.exception;

public record ErrorResponseBody (
        int detailStatusCode,
        String message
){
}
