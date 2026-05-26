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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UnixCassandraDatabase is implementation of {@link AbstractCassandraDatabase} that provides management for a Cassandra
 * database process specifically tailored for Unix-like environments.
 *
 * @author Dmytro Nosan
 */
class UnixCassandraDatabase extends AbstractCassandraDatabase {

    private static final Logger log = LoggerFactory.getLogger(UnixCassandraDatabase.class);

    UnixCassandraDatabase(String name, Version version, Path configurationFile, Path workingDirectory, Map<String, String> environmentVariables, Map<String, Object> configProperties, Map<String, String> systemProperties, Set<String> jvmOptions) {
        super(name, version, configurationFile, workingDirectory, environmentVariables, configProperties, systemProperties, jvmOptions);
    }

    @Override
    protected ProcessWrapper doStart() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void doStop(ProcessWrapper process) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void setExecutable(Path executable) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ProcessWrapper start(String name, ProcessBuilder processBuilder) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    int exec(String name, ProcessBuilder processBuilder) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int kill(ProcessBuilder processBuilder, long pid) throws IOException {
        String name = getName() + ":kill";
        List<String> command = new ArrayList<>();
        command.add("kill");
        command.add("-SIGINT");
        command.add(Long.toString(pid));
        return exec(name, processBuilder.command(command));
    }

    private int sigkill(ProcessBuilder processBuilder, long pid) throws IOException {
        String name = getName() + ":kill";
        List<String> command = new ArrayList<>();
        command.add("kill");
        command.add("-SIGKILL");
        command.add(Long.toString(pid));
        return exec(name, processBuilder.command(command));
    }
}
