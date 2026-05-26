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
package com.github.nosan.embedded.cassandra.commons.web;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A subclass of {@link HttpHeaders} that provides a read-only view of HTTP headers.
 *
 * @author Dmytro Nosan
 */
final class ReadOnlyHttpHeaders extends HttpHeaders {

    ReadOnlyHttpHeaders(HttpHeaders httpHeaders) {
        super(httpHeaders.headers);
    }

    @Override
    public void add(String name, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void set(String name, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<String> getFirst(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean containsKey(Object name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<String> put(String key, List<String> values) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<String> remove(Object key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void putAll(Map<? extends String, ? extends List<String>> headers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<String> get(Object key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Collection<List<String>> values() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<Entry<String, List<String>>> entrySet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <C, IC extends C> C toUnmodifiable(C collection, Function<C, IC> constructor) {
        return (collection != null) ? constructor.apply(collection) : null;
    }
}
