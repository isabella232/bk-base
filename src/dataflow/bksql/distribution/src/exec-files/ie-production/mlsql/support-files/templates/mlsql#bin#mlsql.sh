#!/bin/bash -l

# Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础平台 available.
#
# Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
#
# BK-BASE 蓝鲸基础平台 is licensed under the MIT License.
#
# License for BK-BASE 蓝鲸基础平台:
# --------------------------------------------------------------------
# Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
# documentation files (the "Software"), to deal in the Software without restriction, including without limitation
# the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
# and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all copies or substantial
# portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
# LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
# NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
# WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
# SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

cd ${BASH_SOURCE%/*} 2>/dev/null
WORK_DIR=$(pwd)
SERVICE_PATH="v3"
BKSQL_PATH="__BK_HOME__/bkdata/mlsql"
source $CTRL_DIR/utils.fc

cd $WORK_DIR
BKSQL_MLSQL_PORT=__BKSQL_MLSQL_PORT__

exec $JAVA_HOME/bin/java -DBKSQL_HOME=${BKSQL_PATH} \
    -Xms256m \
    -Xmx512m \
    -cp "${WORK_DIR}/../lib/*" com.tencent.bk.base.dataflow.bksql.exec.Boot \
    -b ${LAN_IP} -p ${BKSQL_MLSQL_PORT} \
    --path ${SERVICE_PATH} \
    -c ${WORK_DIR%/bin}/etc/