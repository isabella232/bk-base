��    G      T  a   �                !     7     E     [     p     }     �     �     �     �     �     �     �     �          2     E     d     w  	   �     �     �     �  	   �     �     �  -   �          ;     H     O     \     o     v  ;   }     �     �     �     �  -   �     	     (	     5	     K	     f	     v	  	   }	     �	     �	     �	  -   �	     �	     �	  0   
     3
  )   @
  &   j
  	   �
     �
  4   �
     �
     �
     �
     
          )  U   <  S   �     �    �          !     9     I     c     z  
   �     �     �     �     �     �     �  	   �     �  !        0     C  	   c     m     {     �  
   �     �     �     �     �     �  '     
   7     B     H     ]     n     u  _   {  	   �     �  	   �     �  :        G     Y     f     u     �     �     �     �  
   �  $   �  >   �     3     ;  1   R  
   �  3   �  -   �     �     �  Q        f     x  	   �     �     �     �  l   �  z   D     �     1   :          +               <          #   E          6   -                       @          C      ?   D          5       )                  G             *   	   $      2                 >   =              '   F   A   B   7   "                 %          9      ,       /      4   0   3           &         !          8      .   ;   
             (    API返回为空 API返回格式错误 cron表达式 scheduler检查异常 tags 字段必填。 事件信息 事件名称 任务入口 任务描述 任务改变状态 任务是否可自愈 任务标识 任务环境配置 任务类型 任务系统环境依赖 任务调度接口调用异常 任务调度时间 任务调度集群信息异常 任务运行模式 任务运行语言 依赖值 依赖值类型 依赖关系 依赖规则 创建人 创建后执行 前序节点执行失败 前序节点未执行，请等待下个周期 可运行的最大任务数 启动时间 周期 周期单位 地域标签信息 失败 延迟 当前可用的runner数小于2个，存活runner列表: %s 成功 截止时间 时区 是否下发到存储 是否可以从当前时间之前执行任务 是否可恢复 是否可用 是否重算子节点 没有JobNavi集群信息. 父任务标识 版本 等待中 统计频率 节点标签 获取runner信息异常 获取执行结果目前仅支持field=status 警告 请求参数异常 调用%(api_name)s失败(%(code)s) - %(message)s 起始时间 过滤条件只支持[limit] 和 [status] 过滤条件必须包含[schedule_id]. 运行中 退服超时时间 配置jobnavi集群信息失败，请联系管理员 重试次数 重试策略 间隔时间 集群不存在%s 集群名称 集群连接信息 非法任务运行模式: %(task_mode)s，目前仅支持以下模式[%(task_modes)s] 非法任务运行语言: %(language)s，目前仅支持以下语言[%(languages)s] 非预期异常 Project-Id-Version: PACKAGE VERSION
Report-Msgid-Bugs-To: 
PO-Revision-Date: YEAR-MO-DA HO:MI+ZONE
Last-Translator: FULL NAME <EMAIL@ADDRESS>
Language-Team: LANGUAGE <LL@li.org>
Language: 
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
 API return is null API return format error Cron expression Scheduler check exception tags field is required Event information Event name Task main entry Task description Task change status Recoverable Task identification Task env Task type Task system env schedule interface call exception Task schedule time schedule cluster info exception Task mode Task language Dependency value Dependency value type Dependency Dependency rule Creator Execute after creation preorder nodes failed preorder nodes not scheduled Maximum number of tasks that can be run Start time Cycle Count frequency unit geographical tag failed Delay The number of currently available runners is less than 2, and the list of surviving runners: %s succeeded Deadline Time zone dispatch to storage Is it possible to perform the task before the current time Is it recoverable Is it usable rerun children No JobNavi cluster information. Parent task ID Version waiting Count frequency Node label Get the runner information exception Getting execution results currently only supports field=status warning request argument error Call %(api_name)s failed (%(code)s) - %(message)s Start time Filter conditions only support [limit] and [status] Filter conditions must contain [schedule_id]. running Service withdrawal timeout Failed to configure jobnavi cluster information. Please contact the administrator Number of retries Retry strategy Intervals Cluster does not exist %s Cluster name Cluster connection information Illegal task mode:（%(task_mode)s）. Currently only the following modes are supported:（%(task_modes)s） Illegal task runtime language:（%(language)s）. Currently only the following languages are supported:（%(languages)s） unexpected exception 