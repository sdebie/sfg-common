package org.sfg.common.dto;

import org.eclipse.microprofile.graphql.Type;
import org.sfg.common.enums.WorkspaceType;

import java.time.OffsetDateTime;
import java.util.UUID;

@Type("Workspace")
public record WorkspaceDto(UUID id, String name, WorkspaceType type, OffsetDateTime createdAt, OffsetDateTime updatedAt)
{
}
