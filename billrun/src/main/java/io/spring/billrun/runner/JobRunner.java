package io.spring.billrun.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobRunner {

    private static final Logger logger = LoggerFactory.getLogger(JobRunner.class);


    private JobLauncher simpleJobLauncher;
    private Job demo11;

    @Autowired
    public JobRunner(Job demo11, JobLauncher jobLauncher) {
        this.simpleJobLauncher = jobLauncher;
        this.demo11 = demo11;
    }

    @Async
    public void runBatchJob() {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        runJob(demo11, jobParametersBuilder.toJobParameters());
    }


    public void runJob(Job job, JobParameters parameters) {
        try {

            JobExecution jobExecution = simpleJobLauncher.run(job, parameters);

        } catch (JobExecutionAlreadyRunningException e) {
            logger.error("JobExecutionAlreadyRunningException", e);
        } catch (JobRestartException e) {
            logger.error("JobRestartException", e);
        } catch (JobInstanceAlreadyCompleteException e) {
            logger.error("JobInstanceAlreadyCompleteException", e);
        } catch (JobParametersInvalidException e) {
            logger.error("JobParametersInvalidException", e);
        }
    }


}