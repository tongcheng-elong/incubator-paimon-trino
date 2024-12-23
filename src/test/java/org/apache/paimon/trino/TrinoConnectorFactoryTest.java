/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.paimon.trino;

import org.apache.paimon.shade.guava30.com.google.common.collect.ImmutableMap;

import io.trino.spi.connector.Connector;
import io.trino.spi.connector.ConnectorFactory;
import io.trino.testing.TestingConnectorContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/** Test for {@link TrinoConnectorFactory}. */
public class TrinoConnectorFactoryTest {

    @TempDir java.nio.file.Path tempFile;

    @Test
    public void testCreateConnector() {
        Map<String, String> config = ImmutableMap.of("warehouse", tempFile.toString());
        ConnectorFactory factory = new TrinoConnectorFactory();
        Connector connector = factory.create("paimon", config, new TestingConnectorContext());
        assertThat(connector).isNotNull();
    }
}
