package net.earelin.boxes.mapper;

public class TargetClassException extends RuntimeException {
    public TargetClassException(String message, Exception exception) {
        super(message, exception);
    }
}
