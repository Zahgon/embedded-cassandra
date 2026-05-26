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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A wrapper for managing and interacting with a {@link Process}.
 *
 * @author Dmytro Nosan
 */
final class DefaultProcessWrapper implements ProcessWrapper {

    private final String name;

    private final Process process;

    private final ProcessOutput stdout;

    private final ProcessOutput stderr;

    DefaultProcessWrapper(String name, Process process) {
        this.name = name;
        this.process = process;
        this.stdout = new ProcessOutput(name + ":OUT", process.getInputStream());
        this.stderr = new ProcessOutput(name + ":ERR", process.getErrorStream());
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long getPid() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProcessWrapper destroy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProcessWrapper destroyForcibly() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isAlive() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int waitFor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean waitFor(int timeout, TimeUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CompletableFuture<? extends ProcessWrapper> onExit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Output getStdOut() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Output getStdErr() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class ProcessOutput extends Thread implements Output {

        private static final Logger log = LoggerFactory.getLogger(ProcessOutput.class);

        private final List<Consumer<? super String>> consumers = new CopyOnWriteArrayList<>();

        private final AtomicBoolean started = new AtomicBoolean(false);

        private final InputStream is;

        ProcessOutput(String name, InputStream is) {
            super(name);
            this.is = is;
            setDaemon(true);
            setUncaughtExceptionHandler((thread, ex) -> log.error("Exception in thread: ''{}''", thread, ex));
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void attach(Consumer<? super String> consumer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void detach(Consumer<? super String> consumer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void doStart() {
            if (this.started.compareAndSet(false, true)) {
                start();
            }
        }

        private static String readLine(BufferedReader reader) throws IOException {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                if (Objects.toString(ex.getMessage(), "").contains("Stream closed")) {
                    return null;
                }
                throw ex;
            }
        }
    }
}
