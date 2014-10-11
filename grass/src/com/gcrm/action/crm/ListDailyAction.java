/**
 * Copyright (C) 2012 - 2013, Grass CRM Studio
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
package com.gcrm.action.crm;

import com.gcrm.domain.Campaign;
import com.gcrm.domain.Daily;
import com.gcrm.domain.TargetList;
import com.gcrm.domain.User;
import com.gcrm.service.IBaseService;

/**
 * Lists Daily
 * 
 */
public class ListDailyAction extends BaseListAction {

    private static final long serialVersionUID = -3404576552417042445L;

    private IBaseService<Daily> baseService;
    private IBaseService<User> userService;
    private IBaseService<Campaign> campaignService;
    private TargetList targetList;
    private Daily daily;

    private static final String CLAZZ = Daily.class.getSimpleName();

    /**
     * Gets the list data.
     * 
     * @return null
     */
    public String listFull() throws Exception {

        return null;
    }

    @Override
    public String list() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String getEntityName() {
        // TODO Auto-generated method stub
        return null;
    }

}
