/*
 * Copyright 2020-2024 the original author or authors.
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
package com.github.nosan.embedded.cassandra.commons;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

/**
 * {@link Resource} implementation for file system resources.
 *
 * @author Dmytro Nosan
 * @since 4.0.0
 */
public class FileSystemResource implements Resource {

    private final Path file;

    /**
     * Constructs a new {@link FileSystemResource} with the specified {@link Path}.
     *
     * @param file the {@link Path}
     */
    public FileSystemResource(Path file) {
        Objects.requireNonNull(file, "Path must not be null");
        this.file = file;
    }

    /**
     * Constructs a new {@link FileSystemResource} with the specified {@link File}.
     *
     * @param file the {@link File}
     */
    public FileSystemResource(File file) {
        Objects.requireNonNull(file, "File must not be null");
        this.file = file.toPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public URL toURL() throws MalformedURLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public URI toURI() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> getFileName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean exists() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isWritable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isReadable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the file.
     *
     * @return the file
     */
    public Path getFile() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
