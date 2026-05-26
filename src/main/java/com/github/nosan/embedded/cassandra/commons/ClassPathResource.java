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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownServiceException;
import java.util.Objects;
import java.util.Optional;

/**
 * {@link Resource} implementation for class path resources.
 *
 * @author Dmytro Nosan
 * @since 4.0.0
 */
public class ClassPathResource implements Resource {

    private final String path;

    private final ClassLoader classLoader;

    /**
     * Constructs a new {@link ClassPathResource} with the specified resource name.
     *
     * @param path the resource name
     */
    public ClassPathResource(String path) {
        this(path, null);
    }

    /**
     * Constructs a new {@link ClassPathResource} with the specified resource name and class loader.
     *
     * @param path the resource path
     * @param classLoader class loader used to load a resource
     */
    public ClassPathResource(String path, ClassLoader classLoader) {
        Objects.requireNonNull(path, "Name must not be null");
        if (!StringUtils.hasText(path)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.path = clean(path);
        this.classLoader = (classLoader != null) ? classLoader : getClass().getClassLoader();
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
    public URL toURL() throws FileNotFoundException {
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

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private URL getURL() {
        ClassLoader cl = this.classLoader;
        return (cl != null) ? cl.getResource(this.path) : ClassLoader.getSystemResource(this.path);
    }

    private String getFilename() {
        String name = this.path;
        int index = name.lastIndexOf('/');
        return (index != -1) ? name.substring(index + 1) : name;
    }

    private static String clean(String name) {
        String path = name.trim().replace('\\', '/');
        return path.startsWith("/") ? path.substring(1) : path;
    }
}
