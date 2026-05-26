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
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.nosan.embedded.cassandra.commons.Resource;
import com.github.nosan.embedded.cassandra.commons.StringUtils;
import com.github.nosan.embedded.cassandra.commons.function.IOSupplier;
import com.github.nosan.embedded.cassandra.commons.web.JdkHttpClient;

/**
 * A builder that can be used to configure and create {@link Cassandra}.
 * <p>
 * <b>This class is not thread-safe and should not be shared across different threads!</b>
 * </p>
 *
 * @author Dmytro Nosan
 * @see #build()
 * @see CassandraBuilderConfigurator
 * @since 4.0.0
 */
public class CassandraBuilder {

    /**
     * Default Cassandra version.
     */
    public static final Version DEFAULT_VERSION = Version.parse("5.0.6");

    private static final AtomicInteger CASSANDRA_ID = new AtomicInteger();

    private final Map<String, Object> environmentVariables = new LinkedHashMap<>();

    private final Map<String, Object> configProperties = new LinkedHashMap<>();

    private final Map<String, Object> systemProperties = new LinkedHashMap<>();

    private final Set<String> jvmOptions = new LinkedHashSet<>();

    private final Set<WorkingDirectoryCustomizer> workingDirectoryCustomizers = new LinkedHashSet<>();

    private boolean registerShutdownHook = true;

    private String name;

    private Version version;

    private Duration startupTimeout;

    private Logger logger;

    private IOSupplier<? extends Path> workingDirectorySupplier;

    private WorkingDirectoryDestroyer workingDirectoryDestroyer;

    private WorkingDirectoryInitializer workingDirectoryInitializer;

    /**
     * Creates a new {@link  CassandraBuilder}.
     */
    public CassandraBuilder() {
    }

    /**
     * Build a new {@link Cassandra} instance.
     *
     * @return a {@link Cassandra} instance.
     */
    public Cassandra build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra instance name.
     * <p> Defaults to "cassandra-0", "cassandra-1", and so on.
     *
     * @param name the Cassandra instance name
     * @return this builder
     */
    public CassandraBuilder name(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the currently configured Cassandra instance name.
     *
     * @return the Cassandra instance name, or {@code null} if not configured
     */
    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra version.
     * <p> Defaults to {@link #DEFAULT_VERSION}.
     *
     * @param version the Cassandra version to set
     * @return this builder
     */
    public CassandraBuilder version(String version) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra version.
     * <p> Defaults to {@link #DEFAULT_VERSION}.
     *
     * @param version the Cassandra version to be set
     * @return this builder instance
     */
    public CassandraBuilder version(Version version) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the currently configured Cassandra version.
     * <p> Defaults to {@link #DEFAULT_VERSION} if no version is explicitly set.
     *
     * @return the configured Cassandra version, never {@code null}
     */
    public Version getVersion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra logger. This logger will capture and consume Cassandra's stdout and stderr outputs.
     * <p> Defaults to {@code LoggerFactory.getLogger(Cassandra.class)}.
     *
     * @param logger the logger to be used for Cassandra
     * @return this builder instance
     */
    public CassandraBuilder logger(Logger logger) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Specifies whether the created {@link Cassandra} instance should have a shutdown hook registered.
     * <p> Defaults to {@code true}.
     *
     * @param registerShutdownHook {@code true} to register a shutdown hook, {@code false} otherwise
     * @return this builder instance
     */
    public CassandraBuilder registerShutdownHook(boolean registerShutdownHook) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the startup timeout.
     * <p>Defaults to 2 minutes.
     *
     * @param startupTimeout the startup timeout
     * @return this builder
     */
    public CassandraBuilder startupTimeout(Duration startupTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra configuration file path.
     * <p>
     * This is equivalent to:
     * <pre>
     * {@code
     * addSystemProperty("cassandra.config", configFile);
     * }
     * </pre>
     *
     * @param configFile the path to the Cassandra configuration file, must not be {@code null}
     * @return this builder instance
     */
    public CassandraBuilder configFile(Resource configFile) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the {@code Supplier} for the working directory, which will be invoked each time {@link #build()} is called.
     * <p> The supplied directory will be initialized by {@link WorkingDirectoryInitializer} and used as the Cassandra
     * home directory.
     * <p> At the end of the process, the provided working directory may be fully or partially deleted by
     * {@link WorkingDirectoryDestroyer}.
     * <p> Defaults to {@code Files.createTempDirectory("")}.
     *
     * @param workingDirectorySupplier the supplier providing the working directory, must not be {@code null}
     * @return this builder instance
     * @see IOSupplier#wrap(Supplier)
     */
    public CassandraBuilder workingDirectory(IOSupplier<? extends Path> workingDirectorySupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the {@link WorkingDirectoryInitializer} to be used for initializing the working directory.
     * <p> Defaults to {@link DefaultWorkingDirectoryInitializer}, which uses the underlying
     * {@link WebCassandraDirectoryProvider}.
     *
     * @param workingDirectoryInitializer the initializer responsible for setting up the working directory, must not be
     * {@code null}
     * @return this builder instance
     * @see DefaultWorkingDirectoryInitializer
     */
    public CassandraBuilder workingDirectoryInitializer(WorkingDirectoryInitializer workingDirectoryInitializer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the {@link WorkingDirectoryDestroyer} to handle the cleanup of the working directory.
     * <p> Defaults to {@code WorkingDirectoryDestroyer.deleteAll()}.
     *
     * @param workingDirectoryDestroyer the destroyer responsible for managing the cleanup of the working directory,
     * must not be {@code null}
     * @return this builder instance
     * @see WorkingDirectoryDestroyer#doNothing()
     * @see WorkingDirectoryDestroyer#deleteOnly(String...)
     * @see WorkingDirectoryDestroyer#deleteAll()
     */
    public CassandraBuilder workingDirectoryDestroyer(WorkingDirectoryDestroyer workingDirectoryDestroyer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the {@link WorkingDirectoryCustomizer} to customize the working directory. Setting this value will replace
     * any previously configured customizers.
     *
     * @param workingDirectoryCustomizers the customizers to use for configuring the working directory, must not be
     * {@code null}
     * @return this builder instance
     * @see WorkingDirectoryCustomizer#addResource(Resource, String)
     * @see #workingDirectoryCustomizers(Collection)
     * @see #addWorkingDirectoryCustomizers(WorkingDirectoryCustomizer...)
     * @see #addWorkingDirectoryCustomizers(Collection)
     */
    public CassandraBuilder workingDirectoryCustomizers(WorkingDirectoryCustomizer... workingDirectoryCustomizers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the {@link WorkingDirectoryCustomizer} instances to customize the working directory. This operation will
     * replace any previously configured customizers.
     *
     * @param workingDirectoryCustomizers the customizers to configure the working directory, must not be {@code null}
     * @return this builder instance
     * @see WorkingDirectoryCustomizer#addResource(Resource, String)
     * @see #workingDirectoryCustomizers(WorkingDirectoryCustomizer...)
     * @see #addWorkingDirectoryCustomizers(WorkingDirectoryCustomizer...)
     * @see #addWorkingDirectoryCustomizers(Collection)
     */
    public CassandraBuilder workingDirectoryCustomizers(Collection<? extends WorkingDirectoryCustomizer> workingDirectoryCustomizers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds one or more {@link WorkingDirectoryCustomizer} instances to customize the working directory.
     *
     * @param workingDirectoryCustomizers the customizers to add, must not be {@code null}
     * @return this builder instance
     * @see WorkingDirectoryCustomizer#addResource(Resource, String)
     * @see #addWorkingDirectoryCustomizers(Collection)
     * @see #workingDirectoryCustomizers(WorkingDirectoryCustomizer...)
     * @see #workingDirectoryCustomizers(Collection)
     */
    public CassandraBuilder addWorkingDirectoryCustomizers(WorkingDirectoryCustomizer... workingDirectoryCustomizers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds one or more {@link WorkingDirectoryCustomizer} instances to the current configuration.
     *
     * @param workingDirectoryCustomizers the customizers to add, must not be {@code null} or empty
     * @return this builder instance for chaining
     * @see WorkingDirectoryCustomizer#addResource(Resource, String)
     * @see #addWorkingDirectoryCustomizers(WorkingDirectoryCustomizer...)
     * @see #workingDirectoryCustomizers(WorkingDirectoryCustomizer...)
     * @see #workingDirectoryCustomizers(Collection)
     */
    public CassandraBuilder addWorkingDirectoryCustomizers(Collection<? extends WorkingDirectoryCustomizer> workingDirectoryCustomizers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra environment variables. This operation will replace any previously configured environment
     * variables.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * Map<String, Object> environmentVariables = new LinkedHashMap<>();
     * environmentVariables.put("TZ", "Europe/London");
     * builder.environmentVariables(environmentVariables);
     * }</pre>
     *
     * @param environmentVariables a map containing the Cassandra environment variables, must not be {@code null}
     * @return this builder instance for method chaining
     * @see #addEnvironmentVariable(String, Object)
     * @see #addEnvironmentVariables(Map)
     */
    public CassandraBuilder environmentVariables(Map<String, ?> environmentVariables) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds a Cassandra environment variable to the current configuration.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * builder.addEnvironmentVariable("TZ", "Europe/London");
     * }</pre>
     *
     * @param name the name of the Cassandra environment variable, must not be {@code null} or empty
     * @param value the value of the Cassandra environment variable, must not be {@code null}
     * @return this builder instance for method chaining
     * @see #addEnvironmentVariables(Map)
     * @see #environmentVariables(Map)
     */
    public CassandraBuilder addEnvironmentVariable(String name, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds multiple Cassandra environment variables to the current configuration.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * Map<String, Object> environmentVariables = new LinkedHashMap<>();
     * environmentVariables.put("TZ", "Europe/London");
     * builder.addEnvironmentVariables(environmentVariables);
     * }</pre>
     *
     * @param environmentVariables a map containing Cassandra environment variables, must not be {@code null} or empty
     * @return this builder instance for method chaining
     * @see #addEnvironmentVariable(String, Object)
     * @see #environmentVariables(Map)
     */
    public CassandraBuilder addEnvironmentVariables(Map<String, ?> environmentVariables) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra native Java Virtual Machine (JVM) system properties. This action replaces any previously
     * configured system properties.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * Map<String, Object> systemProperties = new LinkedHashMap<>();
     * systemProperties.put("cassandra.config", new ClassPathResource("cassandra.yaml"));
     * systemProperties.put("cassandra.native_transport_port", 9042);
     * systemProperties.put("cassandra.jmx.local.port", 7199);
     * builder.systemProperties(systemProperties);
     * }</pre>
     *
     * @param systemProperties a map of Cassandra system properties, must not be {@code null} or empty
     * @return this builder instance for method chaining
     * @see #addSystemProperty(String, Object)
     */
    public CassandraBuilder systemProperties(Map<String, ?> systemProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds a single Cassandra native Java Virtual Machine (JVM) system property to the current configuration.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * builder.addSystemProperty("cassandra.config", new ClassPathResource("cassandra.yaml"));
     * builder.addSystemProperty("user.timezone", "Europe/London");
     * }</pre>
     *
     * @param name the name of the Cassandra system property, must not be {@code null} or empty
     * @param value the value of the Cassandra system property, must not be {@code null}
     * @return this builder instance for method chaining
     * @see #addSystemProperties(Map)
     */
    public CassandraBuilder addSystemProperty(String name, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds multiple Cassandra native Java Virtual Machine (JVM) system properties to the current configuration. This
     * method can be used to set or override existing system properties.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * Map<String, Object> systemProperties = new LinkedHashMap<>();
     * systemProperties.put("cassandra.config", new ClassPathResource("cassandra.yaml"));
     * systemProperties.put("cassandra.native_transport_port", 9042);
     * systemProperties.put("cassandra.jmx.local.port", 7199);
     * builder.addSystemProperties(systemProperties);
     * }</pre>
     *
     * @param systemProperties a map of Cassandra system properties, must not be {@code null} or empty
     * @return this builder instance for method chaining
     * @see #addSystemProperty(String, Object)
     */
    public CassandraBuilder addSystemProperties(Map<String, ?> systemProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets Cassandra native Java Virtual Machine (JVM) Options. Setting this value will replace any previously
     * configured options.
     *
     * @param jvmOptions the JVM options to set
     * @return this builder
     * @see #jvmOptions(Collection)
     * @see #addJvmOptions(Collection)
     * @see #addJvmOptions(String...)
     */
    public CassandraBuilder jvmOptions(String... jvmOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra native Java Virtual Machine (JVM) options. This method replaces any previously configured JVM
     * options with the specified values.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * builder.setJvmOptions(Arrays.asList("-Xmx1024m", "-Xms512m"));
     * }</pre>
     *
     * @param jvmOptions a collection of JVM options to set, must not be {@code null} or contain {@code null} elements
     * @return this builder instance for method chaining
     * @see #jvmOptions(Collection)
     * @see #addJvmOptions(Collection)
     * @see #addJvmOptions(String...)
     */
    public CassandraBuilder jvmOptions(Collection<String> jvmOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds Cassandra native Java Virtual Machine (JVM) options to the current configuration. This method appends the
     * specified options to the existing list without replacing them.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * builder.addJvmOptions("-Xmx1024m", "-Xms512m");
     * }</pre>
     *
     * @param jvmOptions the JVM options to add, must not be {@code null} or contain {@code null} elements
     * @return this builder instance for method chaining
     * @see #addJvmOptions(Collection)
     * @see #jvmOptions(Collection)
     * @see #jvmOptions(String...)
     */
    public CassandraBuilder addJvmOptions(String... jvmOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the specified Cassandra native Java Virtual Machine (JVM) options to the existing configuration. This method
     * appends the given options rather than replacing any previously configured ones.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * builder.addJvmOptions(Arrays.asList("-Xmx2048m", "-Xms1024m"));
     * }</pre>
     *
     * @param jvmOptions a collection of JVM options to add; must not be {@code null} or contain {@code null} elements
     * @return this builder instance for method chaining
     * @see #addJvmOptions(String...)
     * @see #jvmOptions(Collection)
     * @see #jvmOptions(String...)
     */
    public CassandraBuilder addJvmOptions(Collection<String> jvmOptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the Cassandra configuration properties to be merged with the properties defined in the `cassandra.yaml`
     * file. Setting this value replaces any previously configured properties.
     *
     * <p>For example:</p>
     * <pre>{@code
     * Map<String, Object> properties = new LinkedHashMap<>();
     * properties.put("client_encryption_options.enabled", true);
     * properties.put("cluster_name", "MyCluster");
     * builder.configProperties(properties);
     * }</pre>
     *
     * This will produce the following YAML output:
     * <pre>
     * ...
     * cluster_name: "MyCluster"
     * client_encryption_options:
     *    enabled: true
     *    ...
     * ...
     * </pre>
     *
     * <p>Note that this method fully replaces any previously set configuration
     * properties. To add or modify specific properties incrementally, use {@link #addConfigProperty(String, Object)} or
     * {@link #addConfigProperties(Map)}.</p>
     *
     * @param configProperties the Cassandra configuration properties to set; must not be {@code null}
     * @return this builder instance for method chaining
     * @see #addConfigProperty(String, Object)
     * @see #addConfigProperties(Map)
     */
    public CassandraBuilder configProperties(Map<String, ?> configProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets a single Cassandra configuration property, which will be merged with properties defined in the
     * `cassandra.yaml` file.
     *
     * <p>For example:</p>
     * <pre>{@code
     * builder.configProperty("client_encryption_options.enabled", true)
     *        .configProperty("cluster_name", "MyCluster");
     * }</pre>
     *
     * <p>This will produce the following YAML output:</p>
     * <pre>
     * ...
     * cluster_name: "MyCluster"
     * client_encryption_options:
     *    enabled: true
     *    ...
     * ...
     * </pre>
     *
     * <p>This method allows for fine-grained updates of individual configuration
     * properties. If multiple updates are needed, consider using {@link #addConfigProperties(Map)} for efficiency.</p>
     *
     * @param name the name of the configuration property (e.g., {@code native_transport_port},
     * {@code client_encryption_options.enabled}); must not be {@code null} or empty
     * @param value the value of the configuration property
     * @return this builder instance for method chaining
     * @see #addConfigProperties(Map)
     * @see #configProperties(Map)
     */
    public CassandraBuilder addConfigProperty(String name, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds multiple Cassandra configuration properties to the current configuration, merging them with the properties
     * defined in the `cassandra.yaml` file. This method allows for bulk updates of configuration settings.
     *
     * <p>For example:</p>
     * <pre>{@code
     * Map<String, Object> properties = new LinkedHashMap<>();
     * properties.put("client_encryption_options.enabled", true);
     * properties.put("cluster_name", "MyCluster");
     * builder.configProperties(properties);
     * }</pre>
     *
     * <p>This will result in the following YAML structure:</p>
     * <pre>
     * ...
     * cluster_name: "MyCluster"
     * client_encryption_options:
     *    enabled: true
     *    ...
     * ...
     * </pre>
     *
     * <p>Note that this method replaces any previously configured properties with
     * the provided ones. If granular updates are needed, consider using
     * {@link #addConfigProperty(String, Object)}.</p>
     *
     * @param configProperties a map of Cassandra configuration properties to add
     * @return this builder instance for method chaining
     * @see #addConfigProperty(String, Object)
     * @see #configProperties(Map)
     */
    public CassandraBuilder addConfigProperties(Map<String, ?> configProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Copies a resource to a specified target path within the working directory.
     *
     * <p>This method is equivalent to the following:</p>
     * <pre>{@code
     * addWorkingDirectoryCustomizers(WorkingDirectoryCustomizer.addResource(resource, path));
     * }</pre>
     *
     * <p>Use this method to place files like configuration files, such as
     * {@code conf/cassandra.yaml}, into the appropriate location within the working directory.</p>
     *
     * @param path the target path (file only) within the working directory (e.g., {@code conf/cassandra.yaml}); must
     * not be {@code null} or empty
     * @param resource the resource to copy; must not be {@code null}
     * @return this builder instance for method chaining
     * @see WorkingDirectoryCustomizer#addResource(Resource, String)
     */
    public CassandraBuilder addWorkingDirectoryResource(Resource resource, String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies the specified configurator to customize this builder.
     *
     * <p>This method provides a way to modify the builder using the logic defined
     * in the given configurator. Configurators can encapsulate reusable configuration logic, making it easier to apply
     * pre-defined settings to multiple builders.</p>
     *
     * @param configurator the configurator to apply to this builder; must not be {@code null}
     * @return this builder instance for method chaining
     * @see SimpleSeedProviderConfigurator for an example configurator
     */
    public CassandraBuilder configure(CassandraBuilderConfigurator configurator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private static <T> T deepCopy(T object) {
        if (object instanceof Map<?, ?>) {
            Map<Object, Object> result = new LinkedHashMap<>();
            ((Map<?, ?>) object).forEach((name, value) -> {
                if (StringUtils.hasText(Objects.toString(name, null))) {
                    result.put(name, deepCopy(value));
                }
            });
            return (T) Collections.unmodifiableMap(result);
        }
        if (object instanceof Collection<?>) {
            List<Object> result = new ArrayList<>();
            ((Iterable<?>) object).forEach(each -> result.add(deepCopy(each)));
            return (T) Collections.unmodifiableList(result);
        }
        if (object instanceof Object[]) {
            List<Object> result = new ArrayList<>();
            for (Object each : ((Object[]) object)) {
                result.add(deepCopy(each));
            }
            return (T) Collections.unmodifiableList(result);
        }
        return object;
    }
}
