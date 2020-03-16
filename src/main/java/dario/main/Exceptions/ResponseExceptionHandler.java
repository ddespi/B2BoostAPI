//package dario.main.Exceptions;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@ControllerAdvice
//public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(PartnerNotFoundException.class)
//    public void springHandleNotFound(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.NOT_FOUND.value());
//    }
//    @ExceptionHandler(InternalServerErrorException.class)
//    public void springHandleInternalServerError(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
//    }
//    @ExceptionHandler(PartnerNotFoundException.class)
//    public void springHandleBadRequest(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value());
//    }
//}
