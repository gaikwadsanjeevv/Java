## Characteristics of Client  
- User Interface
- Request Services
- Receives Data

  ## Server:
  - Device or app that provides resources and services to clients.
  - can host website and respond to request.
  - Always On
  - Handle multiple request
  - Send Data
  <img width="1529" height="829" alt="image" src="https://github.com/user-attachments/assets/384fac97-9a76-4019-8651-7b48d2354af8" />

  ## API
  - Application programme interface.
  - Example:
  - Customer - Application
  - Kitchen - Another system service
  - Menu - API Specification
  - Waiter - API
  - Food - Response

  - API can be private, public, partner.
  - Need for API - REduce manual efforts, Automates everything.

  ## Types of API
  - GET Request -  get something from server, use to read data.  
  - POST Request-  Create resource on the server.  
  - PUT Request -  Update existing resource on server.  
  - DELETE Request-  Used to delete resource from server.
 
## REST API  
-Client-server must be seperate
- Rest is stateless-  servier dont store any info of client- so need to send the details, useful for scalability, chaching.
- can be cached.
- Opaque in terms of layers.

## HTTP & HTTPS  
- HyperText Transafer protocol / security
- Both are protocals design to transfer hypertext across www.
- Operate on based on client-server model
- Stateless protocols.
- Tranfer data - HTML, XML,m Json, plain text.

## Status codes in API.  
- when API communicate they use status code as an acknowledgement.
- Classification of the status code
- First digit indicate class it falls
  - 1xx(Informational) → the request is received and process is in progress  
  - 2xx(Successful)  
  - 3xx(Redirectional) --> further action must be taken for the request you have sent.  
  - 4xx(Client Error) --> issues from client- bad syntax, invalid input.
  - 5xx-  server error.
     - 200 ok successful http request
     - 201 Resource Created by POST
     - 204 No Content
     - 301 Requested resource Moved permanantely
     - 400 bad request
     - 401 unauthorized- dont have credentails  
     - 403 forbidden
     - 404 not found
     - 500 intenal server error

  ## Resource, URI
  - A resource is any piece of info that can be named or identified on the web.
  - A resource is not limited to document or files.
  - ex- it could be profile photo, comment, post in social media.

  - URI (Uniform Resource Identifier) -  is a string of characters used to iderntify a resource on the internate either by location, name, or both.
  - It includes both URLs and URNs.

  # Popular web framework
  - Spring boot
  - Django
  - Flask
  - Express(javaScript)  
  - Ruby on Rails

## Key components of spring  
- Core spring frameework
- Spring Boot
- Spring Data
- Spring Security
- Spring Cloud

Use Cases:  
- Enterprise Application
- Microservices Archietechture
- Web Applications

## Tight coupling and tight coupling  
- Tight coupling --> soft component are highly dependent on each other.
- Where component are less dependent on each other.

Importance in soft design:  
- Flexibility and maintaibility
- Scalibility
- Testing

## Achieving loose coupling by:  
- Interfaces and Abstraction
- Dependency injection.
- Event driven Archietecture

