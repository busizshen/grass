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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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
    public String listFull() throws Exception {System.out.println("aaaaaaaaaa");
//        UserUtil.permissionCheck("view_targetList");
//
//        Map<String, String> fieldTypeMap = new HashMap<String, String>();
//        fieldTypeMap.put("created_on", Constant.DATA_TYPE_DATETIME);
//        fieldTypeMap.put("updated_on", Constant.DATA_TYPE_DATETIME);
//
//        User loginUser = UserUtil.getLoginUser();
//        SearchCondition searchCondition = getSearchCondition(fieldTypeMap,
//                loginUser.getScope_targetList(), loginUser);
//        SearchResult<Daily> result = baseService.getPaginationObjects(
//                CLAZZ, searchCondition);
//        Iterator<Daily> dailyLists = result.getResult().iterator();
//        long totalRecords = result.getTotalRecords();
//        getListJson(dailyLists, totalRecords, searchCondition, true);
        return null;
    }
    
    /**
     * Gets the list JSON data.
     * 
     * @return list JSON data
     */
    public static void getListJson(Iterator<Daily> dailyLists,
            long totalRecords, SearchCondition searchCondition, boolean isList)
            throws Exception {

        StringBuilder jsonBuilder = new StringBuilder("");
        jsonBuilder.append(getJsonHeader(totalRecords, searchCondition, isList));

        String assignedTo = null;
        while (dailyLists.hasNext()) {
            Daily instance = dailyLists.next();
            int id = instance.getId();
            String name = CommonUtil.fromNullToEmpty(instance.getName());
            User user = instance.getAssigned_to();
            if (user != null) {
                assignedTo = user.getName();
            } else {
                assignedTo = "";
            }

            if (isList) {
                User createdBy = instance.getCreated_by();
                String createdByName = "";
                if (createdBy != null) {
                    createdByName = CommonUtil.fromNullToEmpty(createdBy
                            .getName());
                }
                User updatedBy = instance.getUpdated_by();
                String updatedByName = "";
                if (updatedBy != null) {
                    updatedByName = CommonUtil.fromNullToEmpty(updatedBy
                            .getName());
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat(
                        Constant.DATE_TIME_FORMAT);
                Date createdOn = instance.getCreated_on();
                String createdOnName = "";
                if (createdOn != null) {
                    createdOnName = dateFormat.format(createdOn);
                }
                Date updatedOn = instance.getUpdated_on();
                String updatedOnName = "";
                if (updatedOn != null) {
                    updatedOnName = dateFormat.format(updatedOn);
                }

                jsonBuilder.append("{\"cell\":[\"").append(id).append("\",\"")
                        .append(name).append("\",\"").append(assignedTo)
                        .append("\",\"").append(createdByName).append("\",\"")
                        .append(updatedByName).append("\",\"")
                        .append(createdOnName).append("\",\"")
                        .append(updatedOnName).append("\"]}");
            } else {
                jsonBuilder.append("{\"id\":\"").append(id)
                        .append("\",\"name\":\"").append(name)
                        .append("\",\"assigned_to.name\":\"")
                        .append(assignedTo).append("\"}");
            }
            if (targetLists.hasNext()) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]}");

        // Returns JSON data back to page
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(jsonBuilder.toString());
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

    public IBaseService<Daily> getbaseService() {
        return baseService;
    }

    public void setbaseService(IBaseService<Daily> baseService) {
        this.baseService = baseService;
    }
}
