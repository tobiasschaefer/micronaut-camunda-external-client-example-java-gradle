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
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

/**
 * @author Tobias Schäfer
 */
@Singleton
@ExternalTaskSubscription(topicName = "test-topic")
public class SimpleHandler implements ExternalTaskHandler {

    private static final Logger log = LoggerFactory.getLogger(SimpleHandler.class);

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        externalTaskService.complete(externalTask);
        log.info("Completed external task");
    }
}
