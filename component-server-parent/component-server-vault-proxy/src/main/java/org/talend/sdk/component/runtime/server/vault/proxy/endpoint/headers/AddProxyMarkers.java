/**
 * Copyright (C) 2006-2019 Talend Inc. - www.talend.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.talend.sdk.component.runtime.server.vault.proxy.endpoint.headers;

import static java.util.Optional.ofNullable;

import javax.enterprise.context.Dependent;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Dependent
@Provider
public class AddProxyMarkers implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext) {
        ofNullable(requestContext.getProperty("talendCacheStartTime")).map(Number.class::cast).ifPresent(start -> {
            final long duration = System.currentTimeMillis() - Number.class.cast(start).longValue();
            responseContext.getHeaders().putSingle("Talend-Vault-Cache-Time", duration);
        });
        if (!responseContext.getHeaders().containsKey("Talend-Vault-Cache")) {
            responseContext.getHeaders().putSingle("Talend-Vault-Cache", "true");
        }
    }
}
