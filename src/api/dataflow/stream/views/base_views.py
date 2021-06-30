# -*- coding: utf-8 -*-
"""
Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础平台 available.

Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.

BK-BASE 蓝鲸基础平台 is licensed under the MIT License.

License for BK-BASE 蓝鲸基础平台:
--------------------------------------------------------------------
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
"""

from common.errorcodes import ErrorCode
from common.views import APIViewSet
from rest_framework.response import Response

from dataflow.shared.utils.error_codes import get_codes
from dataflow.stream.check.check_driver import check
from dataflow.stream.exceptions.comp_execptions import StreamCode


class BaseViewSet(APIViewSet):
    """
    格式化返回
    """

    def return_ok(self, data=None):
        return Response(data)


class HealthCheckView(BaseViewSet):
    def healthz(self, request):
        """
        @api {get} /dataflow/stream/healthz/ 测试
        @apiName healthz
        @apiGroup Stream
        @apiParamExample {json} 参数样例:
            {
            }
        @apiSuccessExample {json} Success-Response:
            HTTP/1.1 200 OK
                {
                    "message": "ok",
                    "code": "1500200",
                    "data": null,
                    "result": true
                }
        """
        data = check()
        return Response(data)


class StreamErrorCodesView(BaseViewSet):
    def get(self, request):
        """
        @api {post} /dataflow/stream/errorcodes/ 获取stream的errorcodes
        @apiName errorcodes
        @apiGroup udf
        @apiParamExample {json} 参数样例:
            {
            }
        @apiSuccessExample {json} Success-Response:
            HTTP/1.1 200 OK
                {
                    "message": "ok",
                    "code": "1500200",
                    "data": [[
                        {
                        message: "实时任务启动异常",
                        code: "1571020",
                        name: "SUBMIT_FLINK_JOB_ERR",
                        solution: "-",
                        }]
                    "result": true
                }
        """
        return self.return_ok(get_codes(StreamCode, ErrorCode.BKDATA_DATAAPI_STREAM))
