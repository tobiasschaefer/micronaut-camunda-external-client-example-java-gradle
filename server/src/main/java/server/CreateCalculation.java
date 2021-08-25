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

package server;

import jakarta.inject.Singleton;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Creates a random calculation and saves "length" and "height" as process variables.
 *
 * @author Tobias Schäfer
 */
@Singleton
public class CreateCalculation implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(CreateCalculation.class);

    private final Random random = new Random();

    @Override
    public void execute(DelegateExecution execution) {
        int length = random.nextInt(100);
        int height = random.nextInt(100);
        execution.setVariable("length", length);
        execution.setVariable("height", height);
        log.info("Created calculation: {}*{}=?", length, height);
    }
}
