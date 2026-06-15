package edu.jhuapl.sd.sig.vistool.vistoolwebservice.configuration.vistool;

public enum WebSocketTopic {
    SOCKET_ENDPOINT("/socket"),
    TOPIC_ENDPOINT("/topic"),
    API_ENDPOINT("/api"),
    WORK_ORDER_SAVED(TOPIC_ENDPOINT.value + "/workOrderSaved");

    private final String value;

    WebSocketTopic(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
