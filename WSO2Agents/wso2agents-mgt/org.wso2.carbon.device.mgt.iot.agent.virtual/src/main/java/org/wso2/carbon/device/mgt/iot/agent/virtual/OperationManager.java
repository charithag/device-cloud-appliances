/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 *
 */

package org.wso2.carbon.device.mgt.iot.agent.virtual;

import org.wso2.carbon.device.mgt.iot.agent.virtual.ui.AgentUI;

import javax.swing.*;

public class OperationManager {

    private AgentUI agentUI;
    private static OperationManager operationManager = new OperationManager();

    private OperationManager(){

    }

    public static OperationManager getInstance(){
        return operationManager;
    }

    public void init (){
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                agentUI = new AgentUI();
                agentUI.setVisible(true);
            }
        });
    }

    public void changeBulbStatus(boolean status) {
        agentUI.setBulbStatus(status);
    }


}
