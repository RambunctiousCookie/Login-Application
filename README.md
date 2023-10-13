# Login Application
This is a simple login application based on a Spring-Boot backend. It uses interceptors to support security/role authentication and internationalization.

## Structure
The application is intentionally structured in a way that separates functionality into layers (model, repository, service, and controller).
This is done in order to demonstrate the Model-View-Controller (MVC) pattern, as well as reinforce modularity, future testability and separation of concerns.
Constructor injection is prioritized whenever possible so as to allow for effectively final fields and future testability.

### WebAppConfig
- This configuration file is responsible for supporting the two main interceptors, namely the security and locale change interceptors.

### Model/Object-Relational Mapping (ORM)
- All major entity classes inherit from the BaseModel so as to allow for soft-delete functionality and update traceability.
- Manager inherits from Employee and they share a single-table relationship. The assumption has been made that a manager will be in charge of the department they are in.
- Authority is determined using instanceof conditionals.

### Repository
- A case can be made to allow ManagerRepository to extend EmployeeRepository (As opposed to JpaRepository).
  - This is because a manager does not share significant independent attributes at the moment.
  - Inheritance would also allow for reduced duplication of code in Repository methods.
  - This would also constitute a form of polymorphism.
  - However, for simplicity's sake and given the scope of this exercise, this has not been implemented. However, it could be considered in future builds.

### Service
- Interface and Implementation Pattern is used here to support loose coupling.
- The ManagerService is not used but is included in the case that a future build might require it.

### Controller
- CommonController: Responsible for common login/logout functionality
- CustomErrorController: Responsible for overriding base White Label Error implementation, as well as other error displays.
- LanguageController: Responsible for internationalization (i18n)/mutliple language support.
- UserController: Responsible for endpoints accessible only to employees (users) and managers.

### View
- A fragment html file is used for code recyclability (css header tags, as well as navbar elements).
- Resource bundles are used to enable i18n/mutliple language support. For now, only English and Dutch language support has been implemented.

## Closing Comments
During the design process I considered using a reactive framework to support the backend logic. However, in the advent of project loom and virtual threads, it seems a more efficient choice to prioritize regular code over reactive code at present. 
Regular code is also more consistently debuggable, which makes for a superior development experience should this application ever be required to scale.
  
