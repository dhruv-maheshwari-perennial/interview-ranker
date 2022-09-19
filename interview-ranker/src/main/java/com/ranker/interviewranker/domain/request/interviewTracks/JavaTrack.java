package com.ranker.interviewranker.domain.request.interviewTracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JavaTrack {
    private String typeOfWork;
    private String complexity;
    private String projectUnderstanding;
    private String technicalProblemSolving;
    private String learningAbilityUnderstanding;
    private String techSkills;
    private String databaseSkills;
    private Long coreJava;
    private Long j2EE;
    private Long oOPS;
    private Long mySQL;
    private Long springFramework;
    private Long javascript;
    private Long css3;
    private Long html5;
    private Long webServices;
    private Long logical;
    private Long git;
    private String pmTools;
    private String ide;
    private String testingTools;
    private String comments;
}
