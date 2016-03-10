/*
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.device.mgt.iot.agent.kura.firealarm.core.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.device.mgt.iot.agent.kura.firealarm.core.operation.AgentOperationManager;

/**
 * @scr.component name="org.wso2.carbon.device.mgt.iot.agent.kura.firealarm.core" immediate="true"
 * @scr.reference name="org.wso2.carbon.device.mgt.iot.agent.kura.firealarm.impl"
 * interface="org.wso2.carbon.device.mgt.iot.agent.kura.firealarm.core.operation.AgentOperationManager"
 * cardinality="1..1"
 * policy="dynamic"
 * bind="setImplService"
 * unbind="unsetImplService"
 */

public class AgentServiceComponent {
    private static final Log log = LogFactory.getLog(AgentServiceComponent.class);


    protected void activate(ComponentContext componentContext) {
        AgentManager.getInstance().init();
        log.info("===================");
        log.info("Agent Core Bundle has started!");
        log.info("===================");
    }

    protected void deactivate(ComponentContext componentContext) {
        log.info("===================");
        log.info("Agent Core Bundle has stopped!");
        log.info("===================");
    }

    /**
     * Sets Agent Operations.
     *
     * @param agentOperationManager An instance of AgentOperationManager
     */
    protected void setImplService(AgentOperationManager agentOperationManager) {
        log.info("===================");
        log.info("Agent Operations has Bound Successfully!");
        log.info("===================");
        AgentManager.getInstance().setAgentOperationManager(agentOperationManager);
    }

    /**
     * Un sets Agent Operations.
     *
     * @param agentOperationManager An instance of AgentOperationManager
     */
    protected void unsetImplService(AgentOperationManager agentOperationManager) {
        log.info("===================");
        log.info("Agent Operations Un-binned!");
        log.info("===================");
        AgentManager.getInstance().setAgentOperationManager(null);
    }
}
