package io.spring.billrun.scheduler;

import io.spring.billrun.runner.JobRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class JobScheduler {

    private JobRunner jobRunner;

    public JobScheduler(JobRunner jobRunner){
        this.jobRunner = jobRunner;
    }

    @Scheduled(fixedRate = 5000)
    public void jobSchduled(){
        System.out.println("Job triggered");
        jobRunner.runBatchJob();
    }
}