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

import java.net.InetAddress;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Default implementation of the {@link Settings} interface.
 *
 * @author Dmytro Nosan
 */
class DefaultSettings implements Settings {

    private final String name;

    private final Version version;

    private final InetAddress address;

    private final boolean nativeTransportEnabled;

    private final Integer port;

    private final Integer sslPort;

    private final Path configurationFile;

    private final Path workingDirectory;

    private final Set<String> jvmOptions;

    private final Map<String, String> systemProperties;

    private final Map<String, String> environmentVariables;

    private final Map<String, Object> configProperties;

    DefaultSettings(String name, Version version, InetAddress address, boolean nativeTransportEnabled, Integer port, Integer sslPort, Path configurationFile, Path workingDirectory, Set<String> jvmOptions, Map<String, String> systemProperties, Map<String, String> environmentVariables, Map<String, Object> configProperties) {
        this.name = name;
        this.version = version;
        this.nativeTransportEnabled = nativeTransportEnabled;
        this.configurationFile = configurationFile;
        this.environmentVariables = readOnly(environmentVariables);
        this.systemProperties = readOnly(systemProperties);
        this.jvmOptions = readOnly(jvmOptions);
        this.configProperties = readOnly(configProperties);
        this.address = address;
        this.port = port;
        this.sslPort = sslPort;
        this.workingDirectory = workingDirectory;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Version getVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isNativeTransportEnabled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public InetAddress getAddress() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getPort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Path getConfigurationFile() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Integer getSslPort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Path getWorkingDirectory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> getJvmOptions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, String> getSystemProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, String> getEnvironmentVariables() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, Object> getConfigProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private static <T> T readOnly(T object) {
        if (object instanceof Map<?, ?>) {
            Map<Object, Object> result = new LinkedHashMap<>();
            ((Map<Object, Object>) object).forEach((name, value) -> result.put(name, readOnly(value)));
            return (T) Collections.unmodifiableMap(result);
        }
        if (object instanceof List<?>) {
            List<Object> result = new ArrayList<>();
            ((List<?>) object).forEach(each -> result.add(readOnly(each)));
            return (T) Collections.unmodifiableList(result);
        }
        if (object instanceof Set<?>) {
            Set<Object> result = new LinkedHashSet<>();
            ((Set<?>) object).forEach(each -> result.add(readOnly(each)));
            return (T) Collections.unmodifiableSet(result);
        }
        return object;
    }
}
