package org.hilmi.packett.api.events;

import org.hilmi.packett.api.Connection;

public class EstablishConnectionEvent extends Event<EstablishConnectionEvent> {

    private final Connection connection;

    public EstablishConnectionEvent(Connection connection) {
        super(Type.CONNECT);
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

}
