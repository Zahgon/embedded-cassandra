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
package com.github.nosan.embedded.cassandra.cql;

import java.util.Objects;

/**
 * A {@link CqlScript} implementation that encapsulates a CQL script as a plain string.
 *
 * @author Dmytro Nosan
 * @since 4.0.0
 */
public class StringCqlScript extends AbstractCqlScript {

    private final String script;

    /**
     * Constructs a new {@link StringCqlScript} using the given CQL script.
     *
     * @param script the CQL script as a string (must not be {@code null})
     * @throws NullPointerException if {@code script} is {@code null}
     */
    public StringCqlScript(String script) {
        Objects.requireNonNull(script, "Script must not be null");
        this.script = script;
    }

    /**
     * Retrieves the raw CQL script as a string.
     *
     * @return the raw CQL script as a string
     */
    @Override
    protected String getScript() {
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
}
