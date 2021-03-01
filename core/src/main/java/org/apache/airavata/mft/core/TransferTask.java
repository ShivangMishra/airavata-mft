/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.airavata.mft.core;

import org.apache.airavata.mft.common.AuthToken;
import org.apache.airavata.mft.core.api.Connector;

import java.util.concurrent.Callable;

public class TransferTask implements Callable<Integer> {

    private Connector connector;
    private ConnectorContext context;
    private String resourceId;
    private String credentialToken;
    private AuthToken authToken;

    public TransferTask(AuthToken authToken, String resourceId, String credentialToken,
                        ConnectorContext context, Connector connector) {
        this.connector = connector;
        this.context = context;
        this.resourceId = resourceId;
        this.authToken = authToken;
        this.credentialToken = credentialToken;
    }

    @Override
    public Integer call() throws Exception {
        this.connector.startStream(authToken, resourceId, credentialToken, context);
        return 0;
    }
}
