/*
 * Licensed to STRATIO (C) under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  The STRATIO (C) licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.stratio.cassandra.lucene;

import org.junit.Rule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andres de la Pena {@literal <adelapena@stratio.com>}
 */
public class BaseTest {

    public static final Logger logger = LoggerFactory.getLogger("TEST");

    @Rule
    public TestWatchman watcher = new TestWatchman() {

        long startTime;

        @Override
        public void succeeded(FrameworkMethod method) {
            long time = System.currentTimeMillis() - startTime;
            logger.info(String.format("Test %s succeeded in %d ms", method.getName(), time));
        }

        @Override
        public void failed(Throwable e, FrameworkMethod method) {
            long time = System.currentTimeMillis() - startTime;
            logger.info(String.format("Test %s failed in %d ms", method.getName(), time));
        }

        @Override
        public void starting(FrameworkMethod method) {
            startTime = System.currentTimeMillis();
        }
    };
}