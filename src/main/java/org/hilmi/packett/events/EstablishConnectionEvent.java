package org.hilmi.packett.events;

import org.hilmi.packett.Connection;

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
