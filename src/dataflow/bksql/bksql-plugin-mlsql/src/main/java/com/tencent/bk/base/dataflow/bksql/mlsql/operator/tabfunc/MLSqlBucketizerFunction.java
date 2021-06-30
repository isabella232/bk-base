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

package com.tencent.bk.base.dataflow.bksql.mlsql.operator.tabfunc;

import java.util.ArrayList;
import java.util.List;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.sql.type.SqlTypeName;

/**
 * ref:http://spark.apache.org/docs/latest/ml-features.html#bucketizer
 */
public class MLSqlBucketizerFunction extends MLSqlModelFunction {

    public MLSqlBucketizerFunction(String modelName,
            List<RelDataType> outputTypeList,
            List<String> outputNameList,
            List<RelDataType> inputTypeList,
            List<String> inputNameList,
            List<String> needInterpreterCols,
            String outputColName) {
        super(modelName, outputTypeList, outputNameList, inputTypeList, inputNameList, needInterpreterCols,
                outputColName);
    }

    /**
     * 创建Bucketizer算法对象
     */
    public static MLSqlBucketizerFunction createFunction() {
        List<String> inputNames = new ArrayList<>();
        inputNames.add("input_col");
        inputNames.add("input_cols");
        inputNames.add("splits");
        inputNames.add("splits_arrau");
        List<RelDataType> inputTypes = new ArrayList<>();
        inputTypes.add(typeFactory.createSqlType(SqlTypeName.DOUBLE));
        inputTypes.add(typeFactory.createArrayType(typeFactory.createSqlType(SqlTypeName.DOUBLE), -1));
        inputTypes.add(typeFactory.createArrayType(typeFactory.createSqlType(SqlTypeName.DOUBLE), -1));
        inputTypes.add(typeFactory.createArrayType(typeFactory.createSqlType(SqlTypeName.DOUBLE), -1));
        List<String> outputNames = new ArrayList<>();
        outputNames.add("output_col");
        outputNames.add("output_cols");
        List<RelDataType> outputTypes = new ArrayList<>();
        outputTypes.add(typeFactory.createSqlType(SqlTypeName.DOUBLE));
        outputTypes.add(typeFactory.createArrayType(typeFactory.createSqlType(SqlTypeName.ANY), -1));
        List<String> needInterpreterCols = new ArrayList<>();
        String outputCol = "output_col";
        String modelName = "Bucketizer";
        return new MLSqlBucketizerFunction(modelName, outputTypes, outputNames, inputTypes, inputNames,
                needInterpreterCols, outputCol);
    }
}
