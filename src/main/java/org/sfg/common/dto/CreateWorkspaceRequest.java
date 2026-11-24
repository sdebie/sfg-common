package org.sfg.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.eclipse.microprofile.graphql.Input;
import org.sfg.common.enums.WorkspaceType;

@Input("CreateWorkspaceInput")
public record CreateWorkspaceRequest(
        @NotBlank @Size(max = 200) String name,
        @NotNull WorkspaceType type)
{
}
