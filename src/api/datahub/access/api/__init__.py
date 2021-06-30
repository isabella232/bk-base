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
from __future__ import absolute_import, unicode_literals

from django.utils.functional import SimpleLazyObject
from django.utils.module_loading import import_string


def new_api_module(module_name, api_name):
    mod = "datahub.access.api.{mod}.{api}".format(mod=module_name, api=api_name)
    return import_string(mod)()


MetaApi = SimpleLazyObject(lambda: new_api_module("meta", "_MetaApi"))
DataManageApi = SimpleLazyObject(lambda: new_api_module("datamanage", "_DataManageApi"))
AuthApi = SimpleLazyObject(lambda: new_api_module("auth", "_AuthApi"))
DataRouteApi = SimpleLazyObject(lambda: new_api_module("data_route", "_DataRouteApi"))
BKNodeApi = SimpleLazyObject(lambda: new_api_module("bk_node", "_BKNodeApi"))
StoreKitApi = SimpleLazyObject(lambda: new_api_module("storekit", "_StoreKitApi"))
CC3Api = SimpleLazyObject(lambda: new_api_module("cc_v3", "_CC3Api"))
PaasApi = SimpleLazyObject(lambda: new_api_module("paas", "_PaasApi"))
PaasEEApi = SimpleLazyObject(lambda: new_api_module("paas_ee", "_PaasEEApi"))
JobApi = SimpleLazyObject(lambda: new_api_module("job", "_JobApi"))

__all__ = [
    "MetaApi",
    "DataManageApi",
    "AuthApi",
    "DataRouteApi",
    "BKNodeApi",
    "StoreKitApi",
    "CC3Api",
    "PaasApi",
    "PaasEEApi",
    "JobApi",
]
