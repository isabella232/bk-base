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

from common.api.base import DataAPI, DataDRFAPISet, DRFActionAPI
from common.api.modules.utils import add_app_info_before_request
from django.utils.translation import ugettext_lazy as _

from dataflow.pizza_settings import BASE_MODEL_URL

from .test.test_call_model import TestModel


class _ModelApi(object):

    MODULE = "model"
    test_model = TestModel()

    def __init__(self):

        self.list_model_versions = DataAPI(
            method="GET",
            url_keys=["model_id"],
            url=BASE_MODEL_URL + "v2/model/{model_id}/version/",
            module=self.MODULE,
            description="获取模型版本列表",
            before_request=add_app_info_before_request,
        )
        self.get_model_version = DataAPI(
            method="GET",
            url_keys=["model_id", "model_version_id"],
            url=BASE_MODEL_URL + "v2/model/{model_id}/version/{model_version_id}/",
            module=self.MODULE,
            description=_("获取模型版本配置"),
            default_return_value=self.test_model.set_return_value("get_model_version"),
            before_request=add_app_info_before_request,
        )

        self.models = DataDRFAPISet(
            url=BASE_MODEL_URL + "v2/model/",
            primary_key="model_id",
            module=self.MODULE,
            description=_("算法模型操作"),
            default_return_value=self.test_model.set_return_value("models"),
            before_request=add_app_info_before_request,
            after_request=None,
        )

        self.model_instances = DataDRFAPISet(
            url=BASE_MODEL_URL + "v2/model_instance/",
            primary_key="processing_id",
            module=self.MODULE,
            description=_("算法实例操作"),
            default_return_value=self.test_model.set_return_value("model_instances"),
            before_request=add_app_info_before_request,
            after_request=None,
            custom_config={
                "start": DRFActionAPI(method="post"),
                "stop": DRFActionAPI(method="post"),
            },
        )


ModelApi = _ModelApi()
