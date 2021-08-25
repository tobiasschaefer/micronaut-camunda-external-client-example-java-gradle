/*
 * Copyright 2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package client;

import info.novatec.micronaut.camunda.external.client.feature.ExternalTaskSubscription;
import jakarta.inject.Singleton;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This handler retrieves the "length" and "height" of a rectangle, solves the calculation,
 * and returns the result as the process variable "size".
 *
 * @author Tobias Schäfer
 */
@Singleton
@ExternalTaskSubscription(topicName = "calculation")
public class CalculationHandler implements ExternalTaskHandler {

    private static final Logger log = LoggerFactory.getLogger(CalculationHandler.class);

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        int length = externalTask.getVariable("length");
        int height = externalTask.getVariable("height");

        int size = length * height;

        log.info("External client calculated {}*{}={}", length, height, size);

        externalTaskService.complete(externalTask, Variables.putValue("size", size));
    }
}
