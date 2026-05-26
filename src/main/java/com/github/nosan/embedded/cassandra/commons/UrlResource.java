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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

/**
 * {@link Resource} implementation for {@link URL} resources.
 *
 * @author Dmytro Nosan
 * @since 4.0.0
 */
public class UrlResource implements Resource {

    private final URL url;

    /**
     * Constructs a new {@link UrlResource} with the specified URL.
     *
     * @param url the {@link URL}
     */
    public UrlResource(URL url) {
        Objects.requireNonNull(url, "URL must not be null");
        this.url = url;
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
    public InputStream getInputStream() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public URL toURL() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object other) {
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

    private boolean isFile() {
        return "file".equals(this.url.getProtocol());
    }

    private FileSystemResource getFile() throws IOException {
        return new FileSystemResource(Paths.get(toURI()));
    }
}
