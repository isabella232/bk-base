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

use bkdata_jobnavi;
delete from jobnavi_task_type_info where type_id = "spark_sql";
INSERT INTO jobnavi_task_type_info(type_id,main,env,sys_env,language,task_mode,description) VALUES ("spark_sql","com.tencent.bk.base.dataflow.jobnavi.adaptor.sparksql.SparkSQLSubmitTask","spark_2.4.7_sql",null,"java","process","spark sql");
delete from jobnavi_task_type_info where type_id = "one_time_sql";
INSERT INTO jobnavi_task_type_info(type_id,main,env,sys_env,language,task_mode,description) VALUES ("one_time_sql","com.tencent.bk.base.dataflow.jobnavi.adaptor.sparksql.SparkSQLSubmitTask","spark_2.4.7_one_time_sql",null,"java","process","spark one time sql");
delete from jobnavi_task_type_info where type_id = "spark_interactive_python_server";
INSERT INTO jobnavi_task_type_info(type_id,main,env,sys_env,language,task_mode,description) VALUES ("spark_interactive_python_server","com.tencent.bk.base.dataflow.jobnavi.adaptor.livyserver.LivyServerTask","spark_2.4.7_interactive_python_server",NULL,"java","process","spark interactive python server");
delete from jobnavi_task_type_info where type_id = "spark_python_code";
INSERT INTO jobnavi_task_type_info(type_id,main,env,sys_env,language,task_mode,description) VALUES ("spark_python_code","bkbase.dataflow.one_code.batch_python_adaptor.SparkPythonCodeJobNaviTask","spark_2.4.7_python_code","bkdata-sparkcode","python","process","spark python code");
