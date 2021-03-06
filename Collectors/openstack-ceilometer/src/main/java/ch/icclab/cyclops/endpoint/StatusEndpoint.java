package ch.icclab.cyclops.endpoint;

import ch.icclab.cyclops.util.APICallCounter;
import org.restlet.resource.Get;
import ch.icclab.cyclops.util.PrettyGson;
import org.restlet.resource.ServerResource;

import java.util.HashMap;

/**
 * Copyright (c) 2015. Zuercher Hochschule fuer Angewandte Wissenschaften
 * All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 * <p>
 * Created by Manu Perez on 30/05/16.
 */

public class StatusEndpoint extends ServerResource {
    // used as counter
    private APICallCounter counter = APICallCounter.getInstance();

    public static String ENDPOINT = "/status";

    /**
     * This method will return JSON stats for APICallCounter object
     * @return JSON
     */
    @Get
    public String processCommand() {
        // first get running statistics
        HashMap<String, Integer> stats = counter.getRunningStats();

        // and return
        return PrettyGson.toJson(stats);
    }
}
