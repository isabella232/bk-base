/*
 * Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础平台 available.
 *
 * Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-BASE 蓝鲸基础平台 is licensed under the MIT License.
 *
 * License for BK-BASE 蓝鲸基础平台:
 * --------------------------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bk.base.dataflow.spark.sql.udf;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.apache.spark.SparkEnv$;
import org.apache.spark.sql.api.java.UDF2;

public class BatchScheduleTime implements UDF2<String, String, String> {

    @Override
    public String call(String timeFormat, String timeZone) throws Exception {
        String scheduleTimeStr = SparkEnv$.MODULE$.get().conf().get("spark.bkdata.scheduletime", null);
        if (scheduleTimeStr != null) {
            SimpleDateFormat timeFormater = new SimpleDateFormat(timeFormat);
            timeFormater.setTimeZone(TimeZone.getTimeZone(timeZone));
            Long scheduleTime = Long.parseLong(scheduleTimeStr);
            return timeFormater.format(scheduleTime);
        }
        return null;
    }
}
