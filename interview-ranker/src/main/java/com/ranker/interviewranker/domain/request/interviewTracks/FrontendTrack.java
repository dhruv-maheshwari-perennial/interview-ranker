package com.ranker.interviewranker.domain.request.interviewTracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FrontendTrack {
    private Long logical;
    private Long html5;
    private Long css3;
    private Long bootstrap;
    private Long cssPreprocessor;
    private Long dataStructures;
    private Long javaScript;
    private Long typeScript;
    private Long frameworks;
    private String stateManagement;
    private String hybridMobileApplicationFramework;
    private Long apis;
    private Long nodeJS;
    private String git;
    private String pmTools;
    private String ide;
    private String testingTools;
}
