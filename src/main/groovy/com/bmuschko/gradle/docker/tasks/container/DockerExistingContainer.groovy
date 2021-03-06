/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bmuschko.gradle.docker.tasks.container

import com.bmuschko.gradle.docker.tasks.AbstractDockerRemoteApiTask
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input

import java.util.concurrent.Callable

abstract class DockerExistingContainer extends AbstractDockerRemoteApiTask {
    /**
     * Container ID used to perform operation. The container for the provided ID has to be created first.
     */
    @Input
    final Property<String> containerId = project.objects.property(String)

    void targetContainerId(String containerId) {
        this.containerId.set(containerId)
    }

    void targetContainerId(Callable<String> containerId) {
        targetContainerId(project.provider(containerId))
    }

    void targetContainerId(Provider<String> containerId) {
        this.containerId.set(containerId)
    }
}
