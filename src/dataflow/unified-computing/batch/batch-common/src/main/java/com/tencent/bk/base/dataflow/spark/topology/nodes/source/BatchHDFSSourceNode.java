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

package com.tencent.bk.base.dataflow.spark.topology.nodes.source;

import com.tencent.bk.base.dataflow.spark.topology.BkFieldConstructor;
import com.tencent.bk.base.dataflow.spark.topology.HDFSPathConstructor;
import com.tencent.bk.base.dataflow.spark.topology.nodes.BatchPathListInput;
import com.tencent.bk.base.dataflow.spark.topology.nodes.AbstractBatchNodeBuilder;

import java.util.List;
import java.util.Map;

public class BatchHDFSSourceNode extends AbstractBatchSourceNode {

    protected BatchPathListInput hdfsInput;
    protected boolean isAccumulateNotInRange;

    public BatchHDFSSourceNode(BatchHDFSSourceNodeBuilder builder) {
        super(builder);
        this.hdfsInput = builder.hdfsInput;
        this.inputTimeRangeString = builder.inputTimeRangeString;
        this.isAccumulateNotInRange = builder.isAccumulateNotInRange;
    }

    public BatchPathListInput getHdfsInput() {
        return hdfsInput;
    }


    public boolean isAccumulateNotInRange() {
        return this.isAccumulateNotInRange;
    }


    public static class BatchHDFSSourceNodeBuilder extends AbstractBatchNodeBuilder {

        protected BatchPathListInput hdfsInput;
        protected String inputTimeRangeString;

        protected HDFSPathConstructor pathConstructor;
        protected BkFieldConstructor fieldConstructor;
        protected boolean isAccumulateNotInRange;

        public BatchHDFSSourceNodeBuilder(Map<String, Object> info) {
            super(info);
            this.pathConstructor = new HDFSPathConstructor();
            this.fieldConstructor = new BkFieldConstructor();
        }

        @Override
        public BatchHDFSSourceNode build() {
            this.buildParams();
            return new BatchHDFSSourceNode(this);
        }

        protected void buildParams() {
            this.fields = fieldConstructor.getRtField(this.nodeId);
            String root = pathConstructor.getHdfsRoot(this.nodeId);

            long startTimeMillis = (long)this.retrieveRequiredString(this.info,"start_time");
            long endTimeMillis = (long)this.retrieveRequiredString(this.info,"end_time");
            List<String> paths = pathConstructor.getAllTimePerHourAsJava(root, startTimeMillis, endTimeMillis, 1);
            this.hdfsInput = new BatchPathListInput(paths);

            this.inputTimeRangeString = String.format("%d_%d", startTimeMillis / 1000, endTimeMillis / 1000);
            this.isAccumulateNotInRange = false;
        }

        public void setPathConstructor(HDFSPathConstructor constructor) {
            this.pathConstructor = constructor;
        }

        public void setFieldConstructor(BkFieldConstructor constructor) {
            this.fieldConstructor = constructor;
        }
    }
}
