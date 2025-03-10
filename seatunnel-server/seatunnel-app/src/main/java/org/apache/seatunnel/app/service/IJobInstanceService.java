/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.app.service;

import org.apache.seatunnel.app.dal.entity.JobLine;
import org.apache.seatunnel.app.dal.entity.JobTask;
import org.apache.seatunnel.app.domain.request.job.JobExecParam;
import org.apache.seatunnel.app.domain.response.executor.JobExecutorRes;
import org.apache.seatunnel.engine.core.job.JobResult;

import lombok.NonNull;

import java.util.List;

public interface IJobInstanceService {
    JobExecutorRes createExecuteResource(@NonNull Long jobDefineId, JobExecParam executeParam);

    String generateJobConfig(
            Long jobId,
            List<JobTask> tasks,
            List<JobLine> lines,
            String envStr,
            JobExecParam executeParam);

    JobExecutorRes getExecuteResource(@NonNull Long jobEngineId);

    void complete(@NonNull Long jobInstanceId, @NonNull String jobEngineId, JobResult jobResult);
}
