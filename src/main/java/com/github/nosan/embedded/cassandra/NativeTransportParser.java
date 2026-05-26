/*
 * Copyright 2020-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.nosan.embedded.cassandra;

import java.io.Closeable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The NativeTransportParser class monitors and parses output from a Cassandra database instance to detect the state of
 * the native transport service, handle address and port binding, and determine if the service has started, failed, or
 * been disabled.
 *
 * @author Dmytro Nosan
 */
class NativeTransportParser implements Consumer<String>, Closeable {

    private static final Pattern TRANSPORT_START_PATTERN = Pattern.compile("Starting listening for CQL clients on .*/(.+):(\\d+)", Pattern.CASE_INSENSITIVE);

    private static final Pattern TRANSPORT_NOT_START = Pattern.compile("Not starting native transport as requested", Pattern.CASE_INSENSITIVE);

    private static final Pattern TRANSPORTS_NOT_START = Pattern.compile("Not starting client transports", Pattern.CASE_INSENSITIVE);

    private static final Pattern FAILED_TO_BIND = Pattern.compile("Failed to bind port (\\d+) on .+", Pattern.CASE_INSENSITIVE);

    private static final String ENCRYPTED = "(encrypted)";

    private final CassandraDatabase database;

    private volatile InetAddress address;

    private volatile Integer sslPort;

    private volatile Integer port;

    private volatile boolean disabled;

    private volatile boolean failed;

    NativeTransportParser(CassandraDatabase database) {
        this.database = database;
        this.disabled = database.getVersion().getMajor() < 2;
        database.getStdOut().attach(this);
        database.getStdErr().attach(this);
    }

    @Override
    public void accept(String line) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    boolean isFailed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    boolean isComplete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    boolean isStarted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    InetAddress getAddress() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Integer getPort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Integer getSslPort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static InetAddress getAddress(String address) {
        try {
            return InetAddress.getByName(address);
        } catch (UnknownHostException ex) {
            throw new IllegalStateException(String.format("Could not parse an address: '%s'", address), ex);
        }
    }

    private static Integer getSslPort(CassandraDatabase database) {
        Object value = database.getConfigProperties().get("native_transport_port_ssl");
        return (value != null) ? Integer.parseInt(value.toString()) : null;
    }
}
