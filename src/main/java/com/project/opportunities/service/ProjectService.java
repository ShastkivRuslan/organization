package com.project.opportunities.service;

import com.project.opportunities.dto.project.CreateProjectRequestDto;
import com.project.opportunities.dto.project.ProjectResponseDto;
import com.project.opportunities.dto.project.UpdateProjectStatusDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    ProjectResponseDto getProjectById(Long id);

    Page<ProjectResponseDto> getAllProjects(Pageable pageable);

    Page<ProjectResponseDto> getActiveProjects(Pageable pageable);

    Page<ProjectResponseDto> getSuccessfulProjects(Pageable pageable);

    ProjectResponseDto createProject(CreateProjectRequestDto createProjectRequestDto);

    ProjectResponseDto updateProjectStatus(Long id,
                                           UpdateProjectStatusDto statusDto);
}
