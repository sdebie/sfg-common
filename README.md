# sfg-common

The shared SFG data model, published as a Maven library: `org.sfg.common:sfg-common`.
It owns the Java side of the database model. The SQL schema itself lives in
[sfg-infra](https://github.com/sdebie/sfg-infra) as Flyway migrations, and the entities here must match it.

| Package | Contents |
|---|---|
| `org.sfg.common.enums` | Domain enums (e.g. `WorkspaceType`) |
| `org.sfg.common.entity` | JPA entities mapped to the sfg-infra tables |
| `org.sfg.common.dto` | Request/response records shared by the REST and GraphQL APIs |
| `org.sfg.common.repository` | Panache repositories (`@ApplicationScoped` CDI beans) |

The jar carries a Jandex index, so a Quarkus app that depends on it discovers the entities and repository beans
automatically.

## Using it

```xml
<dependency>
    <groupId>org.sfg.common</groupId>
    <artifactId>sfg-common</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

with the repository `https://maven.pkg.github.com/sdebie/sfg-common` (id `github-common`). GitHub Packages needs
authentication even for public packages: in CI use `GITHUB_TOKEN` with `packages: read`; locally either run
`./mvnw install` in this repo first, or add a `github-common` server with a token that has `read:packages`
to `~/.m2/settings.xml`.

## Build and publish

```bash
./mvnw install          # build and install into ~/.m2 for local use
```

- `build.yml` (every PR): builds the library.
- `publish-common.yml` (push to `main`): deploys the jar to GitHub Packages.

## Rules

- Schema changes start in sfg-infra (a new migration); then update the entity here to match.
- No business logic here: services, mappers and API resources stay in the apps.
