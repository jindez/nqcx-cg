/*
 * Copyright 2018 nqcx.org All right reserved. This software is the
 * confidential and proprietary information of nqcx.org ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with nqcx.org.
 */

package org.nqcx.cg.service;

import org.junit.Test;
import org.nqcx.cg.AutoInject;
import org.nqcx.cg.provide.o.table.Table;
import org.nqcx.cg.service.conn.ConnService;
import org.nqcx.cg.service.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author naqichuan Feb 8, 2014 11:02:54 AM
 */
public class TableServiceTest extends AutoInject {

    @Autowired
    private ConnService connService;
    @Autowired
    private TableService tableService;

    @Test
    public void listTables() {
        String jdbcUrl = "localhost:3306/passport";
        String username = "nqcx";
        String password = "nqcx";

        boolean connNum = connService.connect(jdbcUrl, username, password);

        List<Table> list = tableService.listTables().getList();

        System.out.println("#####################################");
        for (Table t : list) {
            System.out.println(t.getName());
        }
        System.out.println("#####################################");

        connService.destroy();
    }
}
