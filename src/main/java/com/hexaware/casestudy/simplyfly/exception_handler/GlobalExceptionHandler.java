package com.hexaware.casestudy.simplyfly.exception_handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hexaware.casestudy.simplyfly.exception.AircraftModelNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.BookingNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.BookingSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightScheduleNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightSchedulePriceNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.FlightSeatNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.PaymentNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RefundNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.RouteNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.SeatNotFoundException;
import com.hexaware.casestudy.simplyfly.exception.ServiceNotAllowedException;
import com.hexaware.casestudy.simplyfly.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AircraftModelNotFoundException.class)
    public ResponseEntity<String> handleAircraftModelNotFoundException(AircraftModelNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> handleBookingNotFoundException(BookingNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingSeatNotFoundException.class)
    public ResponseEntity<String> handleBookingSeatNotFoundException(BookingSeatNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<String> handleFlightNotFoundException(FlightNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlightScheduleNotFoundException.class)
    public ResponseEntity<String> handleFlightScheduleNotFoundException(FlightScheduleNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlightSchedulePriceNotFoundException.class)
    public ResponseEntity<String> handleFlightSchedulePriceNotFoundException(FlightSchedulePriceNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlightSeatNotFoundException.class)
    public ResponseEntity<String> handleFlightSeatNotFoundException(FlightSeatNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<String> handlePaymentNotFoundException(PaymentNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RefundNotFoundException.class)
    public ResponseEntity<String> handleRefundNotFoundException(RefundNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<String> handleRouteNotFoundException(RouteNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<String> handleSeatNotFoundException(SeatNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceNotAllowedException.class)
    public ResponseEntity<String> handleServiceNotAllowedException(ServiceNotAllowedException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
