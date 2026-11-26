# Servlet/JSP to Spring Boot and Thymeleaf Migration

## Status and purpose

This specification is the source of truth for tracking the application's migration from Java Servlets and JSP to Spring Boot 4 and Thymeleaf. Update its checkboxes and inventory whenever migration work is completed, deferred, or found to be unnecessary.

- **Overall status:** In progress
- **Current phase:** Foundation and public/authentication flows
- **Production database migration:** Explicitly deferred to a later project phase; a local-only compatibility patch supplies registration verification columns missing from the historical restore dump.
- **Legacy system baseline:** 63 annotated servlet endpoints and 46 JSP pages under `WebContent`

Checkboxes indicate migration completion, not whether a legacy feature exists. Keep legacy source until its replacement has been implemented and verified.

## Goals

- Replace servlet request handling with Spring MVC controllers and application/service code.
- Replace JSP views, directives, scriptlets, and includes with Thymeleaf templates and fragments.
- Preserve user-visible behavior and existing routes during the transition where compatibility is needed.
- Keep the existing JDBC DAOs, production MySQL schema, and database configuration contract unchanged for this migration; patch only the local restored fixture where the historical dump is missing fields already required by the registration DAO.
- Package and run as a Spring Boot executable JAR on Java 17 or newer.
- Keep secrets out of source control and make required external configuration explicit.
- Remove obsolete servlet/JSP dependencies and source only after each corresponding feature has been migrated and verified.

## Out of scope for this migration

- Redesigning or migrating the MySQL schema, data, or database engine.
- Replacing JDBC DAOs with JPA or another persistence framework.
- Changing business rules or intentionally changing existing product behavior.
- Reworking the existing visual design beyond changes required to remove JSP or make a migrated flow functional.

Record future database work separately after the application migration is stable.

## Current implementation

### Completed

- [x] Replaced the WAR/webapp-runner Maven build with a Spring Boot 4.2.0 executable JAR build.
- [x] Added the Spring Boot application entry point and Thymeleaf dependency.
- [x] Configured Maven to package existing `WebContent` assets as static resources and exclude JSP files.
- [x] Excluded legacy servlet classes from the current Spring Boot compilation/runtime.
- [x] Added Thymeleaf home, login, and signup templates.
- [x] Added Spring MVC routes for the home page, login/logout, signup options, and registration verification.
- [x] Kept the current DAOs and MySQL access in place.
- [x] Added Spring Boot `JavaMailSender` integration with external `SPRING_MAIL_*` and `EMAIL_FROM` configuration.
- [x] Added a local MariaDB Compose setup that restores `src/database/aumninw.sql` and applies the Phase 1 email-verification schema patch.
- [x] Updated the deployment `Procfile`, README, and signup date handling for this phase.
- [x] Built the executable JAR, ran the Maven test lifecycle, and smoke-tested the migrated pages and static resources over HTTP.
- [x] Added automated MVC coverage for public template rendering, login success/failure, registration validation and verification, and session behavior.

### Known migration gaps

- [ ] Most authenticated member, moderator, and admin workflows are not migrated; their JSPs and servlets are excluded from the Boot runtime.
- [ ] The JSP inventory below is retained in `WebContent` as source/reference; it is not a set of runnable Boot views.
- [ ] Automated controller/template coverage does not replace JDBC integration and end-to-end tests.
- [ ] Validate the complete legacy registration lifecycle and exact account approval/activation behavior before declaring signup fully migrated.
- [ ] Existing DAO patterns, connection management, and SQL remain legacy implementation details for now; address database/persistence separately.
- [ ] Authentication and registration have not been verified against the restored local database; Docker is not installed in the current environment.
- [ ] SMTP delivery has not been integration-tested because SMTP credentials/service configuration are unavailable; mail formatting and sender validation have unit coverage.
- [ ] Review and replace legacy static assets/dependencies only where needed as pages migrate.
- [ ] Ensure secrets and local configuration files remain excluded from version control.

## Migration work plan

## Phase delivery and repository workflow

- Implement one migration phase at a time; do not combine unrelated phases in the same checkpoint.
- Before a phase checkpoint, update this specification, run the applicable build/tests and route smoke checks, and document any remaining verification that depends on configured external services.
- Commit the completed phase with a descriptive phase-scoped message, then push that commit to the configured repository branch.
- Do not include unrelated workspace files or local IDE settings in a phase commit.
- If a phase is incomplete, blocked, or fails verification, record that status here and do not describe it as a completed migration checkpoint.

The initial Spring Boot foundation and public/authentication work is the first repository checkpoint. Automated MVC and mail-service tests are in place, but Phase 1 remains in progress until database integration can run and an SMTP service is configured for delivery verification.

### Phase 1 — Runtime and public/authentication foundation

- [x] Create the Spring Boot executable application and Thymeleaf runtime.
- [x] Package static assets from `WebContent` without packaging JSPs.
- [x] Migrate home, login, logout, signup form, and email verification endpoints.
- [x] Preserve the current JDBC business-object/DAO path for this phase.
- [x] Add automated tests for login success/failure, registration validation, verification success/failure, session behavior, and template rendering.
- [x] Add a local restore path from the existing MySQL dump and a targeted patch for the email-verification fields required by registration.
- [ ] Confirm authentication and registration behavior against the restored representative database without changing its existing business schema. Blocked until Docker is available to run the local database.

### Phase 2 — Member and community workflows

- [ ] Inventory and migrate profile display/edit/update and student/member views.
- [ ] Migrate member search and member directory.
- [ ] Migrate forum listing, creation, deletion, favorites, comments, likes, and comment deletion.
- [ ] Migrate messaging.
- [ ] Migrate jobs and profile job blocks.
- [ ] Migrate photo upload/display, gallery albums, image viewer, and album/photo deletion.
- [ ] Migrate document requests, user requests, moderator requests, and reporting/warnings.
- [ ] Replace member-facing JSP includes with shared Thymeleaf fragments.

### Phase 3 — Moderator and administration workflows

- [ ] Migrate moderator authentication/session flow and moderator dashboard.
- [ ] Migrate branch and pass-out-year management.
- [ ] Migrate user applications and moderator/user request queues.
- [ ] Migrate news and event creation, display, deletion, and visibility controls.
- [ ] Migrate help/support display, deletion, and replies.
- [ ] Apply and test authorization rules for every privileged action.
- [ ] Replace admin JSP header/sidebar includes with Thymeleaf fragments.

### Phase 4 — Cutover and legacy retirement

- [ ] Verify every route and rendered page in the route/view inventories below has a migrated implementation or an explicitly approved removal.
- [ ] Verify old URLs either resolve to a compatible Spring route or have an intentional redirect/retirement decision.
- [ ] Run automated tests and manual end-to-end checks for member, moderator, and admin roles.
- [ ] Verify uploads, image/static paths, sessions, error handling, and deployment configuration.
- [ ] Remove JSPs, servlet classes, `web.xml`, servlet/JSP/Tomcat legacy dependencies, and webapp-runner only after their replacements are verified.
- [ ] Update deployment and developer documentation for the completed cutover.
- [ ] Record the post-cutover database migration as a separate follow-up specification.

## Source inventory

### JSP pages (46)

The following pages were present in the legacy `WebContent` tree at specification creation.

**Public/member root pages (30):**

`DocApp.jsp`, `EditProfile.jsp`, `Gallery.jsp`, `GalleryDisplay.jsp`, `ImageViewer.jsp`, `Message.jsp`, `ModeratorRequest.jsp`, `MsgDemo.jsp`, `Noscript.jsp`, `Profile.jsp`, `Redirect.jsp`, `ReportedUser.jsp`, `UserRequest.jsp`, `contectus.jsp`, `demoSVN.jsp`, `footer.jsp`, `forum.jsp`, `header.jsp`, `index.jsp`, `indexJS.jsp`, `login.jsp`, `member.jsp`, `moderator.jsp`, `redirectCommentPage.jsp`, `redirectGellary.jsp`, `searchmember.jsp`, `signup.jsp`, `student.jsp`, `studenttest.jsp`, `tmpFAQ.jsp`.

**Admin pages (16):**

`admin/HelpandSupportDisplaySERVELT.jsp`, `admin/branch.jsp`, `admin/createEvents.jsp`, `admin/createNews.jsp`, `admin/eventdisplayservlet.jsp`, `admin/events.jsp`, `admin/header.jsp`, `admin/helpSupp.jsp`, `admin/index.jsp`, `admin/initMod.jsp`, `admin/initUser.jsp`, `admin/news.jsp`, `admin/newsdisplayservlet.jsp`, `admin/passoutYear.jsp`, `admin/sidebar.jsp`, `admin/userApp.jsp`.

### Servlet endpoints (63)

The entries below are legacy `@WebServlet` mappings, grouped by source package. Migrate each behavior and record any route rename/redirect alongside the replacement.

**Member/community package (`com.alumni.servlet`, 39):**

| Legacy mapping | Legacy class |
|---|---|
| `/AddJobInProfile` | `AddJobInProfileSERVLET` |
| `/BranchDrpSERVLET` | `BranchDrpSERVLET` |
| `/CommentDeleteSERVLET` | `CommentDeleteSERVLET` |
| `/CommentSERVLET` | `CommentSERVLET` |
| `/DeleteAlbumSERVLET` | `DeleteAlbumSERVLET` |
| `/DeleteJobBlockSERVLET` | `DeleteJobBlockSERVLET` |
| `/DeletePicServlet` | `DeletePicServlet` |
| `/DocRequestAppSERVLET` | `DocRequestAppSERVLET` |
| `/EditProfileSERVLET` | `EditProfileSERVLET` |
| `/EmailVerificationCodeSERVLET` | `EmailVerificationCodeSERVLET` |
| `/EmailVerificationSERVLET` | `EmailVerificationSERVLET` |
| `/FavForumSERVLET` | `FavForumSERVLET` |
| `/ForumCreateSERVLET` | `ForumCreateSERVLET` |
| `/ForumDeleteSERVLET` | `ForumDeleteSERVLET` |
| `/ForumSERVLET` | `ForumSERVLET` |
| `/GalleryAlbumDisplaySERVLET` | `GalleryAlbumDisplaySERVLET` |
| `/GalleryAlbumUploadSERVLET` | `GalleryAlbumUploadSERVLET` |
| `/LikeCommentSERVLET` | `LikeCommentSERVLET` |
| `/Login` | `LoginSERVLET` |
| `/LogoutSERVLET` | `LogoutSERVLET` |
| `/ModeratorReqDisplaySERVLET` | `ModeratorReqDisplaySERVLET` |
| `/ModeratorRequestSERVLET` | `ModeratorRequestSERVLET` |
| `/MsgSERVLET` | `MsgSERVLET` |
| `/PassoutYrDrpSERVLET` | `PassoutYrDrpSERVLET` |
| `/PermisionDrpSERVLET` | `PermisionDrpSERVLET` |
| `/PhotoDisplaySERVLET` | `PhotoDisplaySERVLET` |
| `/PhotosUplodSERVELET` | `PhotosUplodSERVELET` |
| `/profileSERVLET` | `profileSERVLET` |
| `/RemoveFavForumSERVLET` | `RemoveFavForumSERVLET` |
| `/ReportedUserViewSERVLET` | `ReportedUserViewSERVLET` |
| `/ReportedUserWarnSERVLET` | `ReportedUserWarnSERVLET` |
| `/ReportstudentSERVLET` | `ReportstudentSERVLET` |
| `/SearchMembersSERVLET` | `SearchMembersSERVLET` |
| `/SendRequestToBecomeMod` | `SendRequestToBecomeMod` |
| `/SignupSERVLET` | `SignupSERVLET` |
| `/StudentSERVLET` | `StudentSERVLET` |
| `/UpdateProfileSERVLET` | `UpdateProfileSERVLET` |
| `/UserReqDisplaySERVLET` | `UserReqDisplaySERVLET` |
| `/UserRequestServlet` | `UserRequestServlet` |

**Admin package (`com.alumni.admin.servlet`, 24):**

| Legacy mapping | Legacy class |
|---|---|
| `/AdminLoginSERVLET` | `AdminLoginSERVLET` |
| `/AdminLogoutSERVLET` | `AdminLogoutSERVLET` |
| `/BecomemInitModSERVLET` | `BecomemInitModSERVLET` |
| `/BranchAddSERVLET` | `BranchAddSERVLET` |
| `/BranchDisplaySERVLET` | `BranchDisplaySERVLET` |
| `/DelBranchSERVLET` | `DelBranchSERVLET` |
| `/DelPassoutYearSERVLET` | `DelPassoutYearSERVLET` |
| `/DeleteUserAppSERVLET` | `DeleteUserAppSERVLET` |
| `/DeteteHelpandSupportSERVELET` | `DeteteHelpandSupportSERVELET` |
| `/EventCreateSERVLET` | `EventCreateSERVLET` |
| `/EventDeleteSERVLET` | `EventDeleteSERVLET` |
| `/EventDisplaySERVLET` | `EventDisplaySERVLET` |
| `/EventVisibilitySERVLET` | `EventVisibilitySERVLET` |
| `/HelpandSupportDisplaySERVELT` | `HelpandSupportDisplaySERVELT` |
| `/InitModDisplaySERVLET` | `InitModDisplaySERVLET` |
| `/InitUserSERVLET` | `InitUserSERVLET` |
| `/NewsCreateSERVLET` | `NewsCreateSERVLET` |
| `/NewsDisplaySERVLET` | `NewsDisplaySERVLET` |
| `/PassoutYearAddSERVLET` | `PassoutYearAddSERVLET` |
| `/PassoutYearDisplaySERVLET` | `PassoutYearDisplaySERVLET` |
| `/SendReplySERVELET` | `SendReplySERVELET` |
| `/UpdateUserAppSERVLET` | `UpdateUserAppSERVLET` |
| `/UserAppDeleteSERVLET` | `UserAppDeleteSERVLET` |
| `/UserAppDiaplySERVLET` | `UserAppDiaplySERVLET` |

## Target architecture and implementation rules

- Use Spring MVC `@Controller` for rendered pages and `@RestController`/`@ResponseBody` only for intentional asynchronous/API responses.
- Use Thymeleaf templates under `src/main/resources/templates`; use reusable fragments for shared navigation, headers, sidebars, and footers.
- Keep static resources under `src/main/resources/static` (or a deliberate resource mapping) and use Thymeleaf URL expressions so context paths work.
- Keep HTTP/controller concerns out of business logic; preserve DAO responsibilities until the separately planned persistence work.
- Use constructor injection for Spring-managed services/controllers as new service classes are introduced.
- Validate user input server-side; never rely only on browser validation.
- Do not log passwords, verification codes, tokens, or other sensitive values.
- Keep database, SMTP, and deployment secrets in environment/configuration, never literals committed to source.
- Make database/mail/service failures explicit to users and logs; do not silently return success-shaped results.
- Use POST for state-changing operations and ensure session/authentication checks are applied consistently.
- Preserve important existing URL aliases during migration, then remove compatibility routes only at cutover.

## Acceptance criteria for declaring migration complete

- All retained, user-facing behavior is available through Spring MVC and Thymeleaf; no required request depends on a legacy servlet or JSP runtime.
- Every legacy endpoint and JSP in the inventories above is marked migrated, intentionally retired, or explicitly excluded with an owner/reason.
- There are no JSP scriptlets, directives, or `jsp:include` dependencies in the active runtime.
- All supported page flows render under the executable JAR and static resources load correctly.
- Member, moderator, and admin access is verified for both allowed and denied operations.
- Automated tests cover normal flows, validation failures, persistence failures, session behavior, and relevant role boundaries.
- Build, test, and deployment instructions work from a clean checkout with configuration supplied externally.
- The database remains on the existing schema for this cutover; any planned schema/data changes are separately documented and approved.

## Change log

| Date | Update |
|---|---|
| 2026-11-25 | Created the migration specification and recorded the initial Boot 4/Thymeleaf foundation and public/authentication implementation. |
| 2026-11-25 | Added automated Phase 1 MVC tests; database authentication and mail-delivery integration verification remain outstanding. |
| 2026-11-25 | Added local MariaDB restore/verification schema setup and moved verification email delivery to configurable Spring Mail; external database and mail integration checks remain outstanding. |
