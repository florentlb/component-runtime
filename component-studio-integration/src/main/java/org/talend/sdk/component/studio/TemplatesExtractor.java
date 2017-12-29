/**
 * Copyright (C) 2006-2017 Talend Inc. - www.talend.com
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

package org.talend.sdk.component.studio;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TemplatesExtractor {

    private final String templatesPath;

    private final String destinationFolder;

    public void extract() throws IOException, URISyntaxException {
        Bundle bundle = FrameworkUtil.getBundle(this.getClass());
        final URL templateEntry = bundle.getEntry(templatesPath);
        final File destDir = new File(destinationFolder, "tacokit/jet_stub");
        String templateFolderPath = FileLocator.toFileURL(templateEntry).getPath();
        File templateFolder = new File(templateFolderPath);
        org.talend.utils.io.FilesUtils.copyDirectory(templateFolder, destDir);
    }

}
