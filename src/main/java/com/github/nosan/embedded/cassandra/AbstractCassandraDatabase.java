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

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Abstract base class for Cassandra database implementations, providing a framework for managing an embedded Cassandra
 * database process.
 *
 * @author Dmytro Nosan
 */
abstract class AbstractCassandraDatabase implements CassandraDatabase {

    private final String name;

    private final Version version;

    private final Path configurationFile;

    private final Path workingDirectory;

    private final Map<String, String> environmentVariables;

    private final Map<String, Object> configProperties;

    private final Map<String, String> systemProperties;

    private final Set<String> jvmOptions;

    private volatile ProcessWrapper process;

    AbstractCassandraDatabase(String name, Version version, Path configurationFile, Path workingDirectory, Map<String, String> environmentVariables, Map<String, Object> configProperties, Map<String, String> systemProperties, Set<String> jvmOptions) {
        this.name = name;
        this.version = version;
        this.configurationFile = configurationFile;
        this.workingDirectory = workingDirectory;
        this.environmentVariables = Collections.unmodifiableMap(new LinkedHashMap<>(environmentVariables));
        this.configProperties = Collections.unmodifiableMap(new LinkedHashMap<>(configProperties));
        this.systemProperties = Collections.unmodifiableMap(new LinkedHashMap<>(systemProperties));
        this.jvmOptions = Collections.unmodifiableSet(new LinkedHashSet<>(jvmOptions));
    }

    @Override
    public final synchronized void start() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final synchronized void stop() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Map<String, String> getEnvironmentVariables() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Map<String, Object> getConfigProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Map<String, String> getSystemProperties() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Set<String> getJvmOptions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final synchronized CompletableFuture<? extends CassandraDatabase> onExit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final synchronized boolean isAlive() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Version getVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Path getWorkingDirectory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final Path getConfigurationFile() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final synchronized ProcessWrapper.Output getStdOut() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final synchronized ProcessWrapper.Output getStdErr() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected abstract ProcessWrapper doStart() throws IOException;

    protected abstract void doStop(ProcessWrapper process) throws IOException;
}
