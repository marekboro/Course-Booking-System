# Build a simple course booking back-end: 
- Have a RESTful API that allows connected clients to create course bookings and find useful information about the bookings created.
- The API built from scratch with Spring using Spring Boot Initialiser.

# MVP
##Models
The course reservations API needs to be built with three models with the following properties:
- Course
- [x] name - the name of the course eg: Intro to Python
- [x] town - the town/city/village where the course is located. We will not bother with full address yet.
- [x] star rating - Out of 5, each course has a rating

- Booking
- [x] date - a string in the form "dd-mm-yy" for the booking date. Dates can be in the future or in the past

- Customer
- [x] name - string containing customer's name
- [x] town - a string containing the town where the customer lives. We will not record an address at this stage
- [x] age - the customers age. Useful for marketing purposes

### The relationships should be:

- [x] A Course has many Bookings
- [x] A Booking has a Course
- [x] A Customer has many bookings
- [x] A booking has a customer

#### Queries + Custom Routes
Write queries using the derived methods. Connect these to suitable RESTful endpoints and decide whether you should use a filter or not for all of:

- [ ] Get all courses with a given rating
- [ ] Get all customers for a given course
- [ ] Get all courses for a given customer
- [ ] Get all bookings for a given date
- [ ] Get all customers in a given town for a given course
- [ ] Get all customers over a certain age in a given town for a given course
- [ ] test these queries.

Other Extensions
Correctly handle case-insensitive routes with Spring RestController or the IgnoreCase in derived queries.
Tips / Reminders
Stick to the RESTful routes for each resource:

GET /resources
GET /resources/{id}
GET /resources?property=value
POST /resources
PUT /resources/{id}
DELETE /resources/{id}
You're allowd to create routes outside of this structure, but you need to be able to justify the design decision. We of course reccomend you stick with this RESTful way of doing things.

Clearly understand the relationships before coding. Draw it out.

Be careful with town property - consider how to handle caps.

Write tests for your queries.

Use a ddl-auto setting of create-drop when doing development. This means every time the app starts, the schema is created, and when the app stops the schema is destroyed.

Provide a data loader to seed some initial seed data

Reminder on which dependencies to use with spring Initialiser:

Web
JPA
H2
DevTools

![image](planning.png)