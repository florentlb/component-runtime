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
package org.talend.sdk.component.api.service.update;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.sdk.component.api.meta.Documentation;
import org.talend.sdk.component.api.service.ActionType;

/**
 * Mark a method as returning a new instance of part of the form/configuration.
 */
@ActionType(value = "update")
@Target(METHOD)
@Retention(RUNTIME)
@Documentation("This class marks an action returning a new instance replacing part of a form/configuration.")
public @interface Update {

    /**
     * @return the value of the component family this action relates to.
     */
    String family() default "";

    /**
     * @return the name of this update action.
     */
    String value();
}
