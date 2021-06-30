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

package com.tencent.bk.base.datalab.queryengine.validator.optimizer;


import com.tencent.bk.base.datalab.bksql.util.DeParsingMatcher;
import com.tencent.bk.base.datalab.bksql.validator.OptimizerTestSupport;
import org.junit.Test;

public class DruidTimeIntervalOptimizerTest extends OptimizerTestSupport {

    @Test
    public void testToday() throws Exception {
        assertThat(
                new DruidTimeIntervalOptimizer(),
                "SELECT col FROM tab WHERE `time` = 'today'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE time = (TIME_FLOOR(CURRENT_TIMESTAMP, 'P1D', "
                                + "CAST(null AS TIMESTAMP), '+0800'))"));
    }

    @Test
    public void testD() throws Exception {
        assertThat(
                new DruidTimeIntervalOptimizer(),
                "SELECT col FROM tab WHERE `time` > '1d'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE time > (CURRENT_TIMESTAMP - INTERVAL '1' DAY)"));
    }

    @Test
    public void testH() throws Exception {
        assertThat(
                new DruidTimeIntervalOptimizer(),
                "SELECT col FROM tab WHERE `time` > '1h'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE time > (CURRENT_TIMESTAMP - INTERVAL '1' HOUR)"
                ));
    }

    @Test
    public void testM() throws Exception {
        assertThat(
                new DruidTimeIntervalOptimizer(),
                "SELECT col FROM tab WHERE `time` > '1m'",
                new DeParsingMatcher(
                        "SELECT col FROM tab WHERE time > (CURRENT_TIMESTAMP - INTERVAL '1' "
                                + "MINUTE)"));
    }
}