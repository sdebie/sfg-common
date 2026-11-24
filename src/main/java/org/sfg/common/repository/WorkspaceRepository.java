package org.sfg.common.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.sfg.common.entity.Workspace;

import java.util.UUID;

@ApplicationScoped
public class WorkspaceRepository implements PanacheRepositoryBase<Workspace, UUID>
{
}
